package com.anicloud.interfaces.web.controller;

import com.ani.octopus.service.agent.core.config.AnicelMeta;
import com.ani.octopus.service.agent.core.http.RestTemplateFactory;
import com.ani.octopus.service.agent.service.oauth.AniOAuthService;
import com.ani.octopus.service.agent.service.oauth.AniOAuthServiceImpl;
import com.ani.octopus.service.agent.service.oauth.dto.*;
import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by MRK on 2016/3/28.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String Login(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String validataAccess(@RequestParam(value = "username")String username){
        System.out.println(username);
        //TODO
        //检查用户有没有授权
        //没有授权返回到授权页面
        return "authPage";
    }

    @RequestMapping(value = "/redirect",method = RequestMethod.GET)
    public String getAccsessToken(@RequestParam(value = "code")String code,@RequestParam(value = "request")HttpServletRequest request){

        AnicelMeta anicelMeta = new AnicelMeta();
        RestTemplateFactory templateFactory = new RestTemplateFactory();

        AniOAuthService aniOAuthService = new AniOAuthServiceImpl(
                anicelMeta,
                templateFactory
        );
        String clientId ="1058595963104900977";
        String clientSecret = "34d54214721d6077ae021ab5d8215258"; String redirectUrl = "http://localhost:8080/sunny/redirect";


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
        request.setAttribute("token",accessToken.toString());
        return "index";
    }

}
