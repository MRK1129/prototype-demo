package com.anicloud.interfaces.web.controller;

import com.ani.octopus.service.agent.core.config.AnicelMeta;
import com.ani.octopus.service.agent.core.http.RestTemplateFactory;
import com.ani.octopus.service.agent.service.oauth.AniOAuthService;
import com.ani.octopus.service.agent.service.oauth.AniOAuthServiceImpl;
import com.ani.octopus.service.agent.service.oauth.dto.*;
import com.anicloud.interfaces.facade.dto.user.UserDto;
import com.anicloud.interfaces.facade.service.user.UserServiceFacade;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by MRK on 2016/3/28.
 */
@Controller
public class UserController {

    @Resource
    private UserServiceFacade userServiceFacade;

    public final static Long TOKEN_REFRESH_TIME_INTERVAL_IN_SECONDS = 1 * 60 * 60L;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String validataAccess(@RequestParam String username, HttpServletRequest request) {
        UserDto userDto = userServiceFacade.getUserByhashUserId(username);
        if (userDto != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userDto);
            if (userDto.accessToken != null && userDto.accessToken != "") {
                Long currentTime = System.currentTimeMillis();
                if (userDto.expiresIn - (currentTime - userDto.createTime) / 1000 < TOKEN_REFRESH_TIME_INTERVAL_IN_SECONDS) {
                    userServiceFacade.refreshUserToken(userDto);
                    return "home";
                }
            }
        }
        return "authPage";
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String getAccsessToken(@RequestParam String code, HttpServletRequest request) {
        AnicelMeta anicelMeta = new AnicelMeta();
        RestTemplateFactory templateFactory = new RestTemplateFactory();
        AniOAuthService aniOAuthService = new AniOAuthServiceImpl(
                anicelMeta,
                templateFactory
        );
        String clientId = "1058595963104900977";
        String clientSecret = "34d54214721d6077ae021ab5d8215258";
        String redirectUrl = "http://localhost:8080/sunny/redirect";
        AuthorizationCodeParameter authorizationCodeParameter =
                new AuthorizationCodeParameter(
                        clientId,
                        clientSecret,
                        GrantType.AUTHORIZATION_CODE,
                        redirectUrl,
                        ResponseType.CODE,
                        Scope.READ_WRITE
                );
        AniOAuthAccessToken accessToken = aniOAuthService.getOAuth2AccessToken(code, authorizationCodeParameter);
        System.out.println(accessToken.toString());
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        userDto.accessToken = accessToken.getAccessToken();
        userDto.refreshToken = accessToken.getRefreshToken();
        userDto.expiresIn = accessToken.getExpiresIn();
        userDto.tokenType = accessToken.getTokenType();
        userDto.scope = accessToken.getScope();
        userServiceFacade.modify(userDto);
        return "index";
    }
}
