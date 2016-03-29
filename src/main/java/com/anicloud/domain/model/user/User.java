package com.anicloud.domain.model.user;

import com.ani.octopus.service.agent.core.config.AnicelMeta;
import com.ani.octopus.service.agent.core.http.RestTemplateFactory;
import com.ani.octopus.service.agent.service.oauth.AniOAuthService;
import com.ani.octopus.service.agent.service.oauth.AniOAuthServiceImpl;
import com.ani.octopus.service.agent.service.oauth.dto.*;
import com.anicloud.domain.Adapter.UserDaoAdapter;
import com.anicloud.domain.model.device.Device;
import com.anicloud.infrastructure.persistence.domain.user.UserDao;
import com.anicloud.infrastructure.persistence.service.user.UserPersistenceService;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by MRK on 2016/3/25.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -2240705733205447514L;

    @Resource
    private UserPersistenceService userPersistenceService;

    public Integer id;
    public String hashUserId;
    public String email;
    public String screenName;

    public String accessToken;
    public String tokenType;
    public String refreshToken;
    public Long expiresIn;
    public String scope;
    public Long createTime;

    public Set<Device> deviceSet;

    public User() {
    }

    public User(Integer id, String hashUserId, String email, String screenName,
                String accessToken, String tokenType, String refreshToken,
                Long expiresIn, String scope, Long createTime, Set<Device> deviceSet) {
        this.id = id;
        this.hashUserId = hashUserId;
        this.email = email;
        this.screenName = screenName;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
        this.scope = scope;
        this.createTime = createTime;
        this.deviceSet = deviceSet;
    }

    public User getUserByhashUserId() {
        UserDao userDao = userPersistenceService.getUserDaoByhashUserId(this.hashUserId);
        return UserDaoAdapter.toDomain(userDao);
    }

    public User save() {
        UserDao userDao = userPersistenceService.save(UserDaoAdapter.toDao(this));
        return UserDaoAdapter.toDomain(userDao);
    }


    public User modify() {
        UserDao userDao = userPersistenceService.modify(UserDaoAdapter.toDao(this));
        return UserDaoAdapter.toDomain(userDao);
    }


    public void delete() {
        userPersistenceService.delete(UserDaoAdapter.toDao(this));
    }

    public User refreshUserAccessToeken() {
        AniOAuthService aniOAuthService = new AniOAuthServiceImpl(
                new AnicelMeta(),
                new RestTemplateFactory()
        );
        String clientId = "1058595963104900977";
        String clientSecret = "34d54214721d6077ae021ab5d8215258";
        String redirectUrl = "http://localhost:8080/sunny/redirect";

        AuthorizationCodeParameter authorizationCodeParameter = new AuthorizationCodeParameter(clientId, clientSecret,
                GrantType.AUTHORIZATION_CODE, redirectUrl,
                ResponseType.CODE, Scope.READ_WRITE
        );
        AniOAuthAccessToken accessToken = aniOAuthService.refreshAccessToken(this.refreshToken, authorizationCodeParameter);
        this.accessToken = accessToken.getAccessToken();
        this.tokenType = accessToken.getTokenType();
        this.refreshToken = accessToken.getRefreshToken();
        this.expiresIn = accessToken.getExpiresIn();
        this.scope = accessToken.getScope();
        userPersistenceService.modify(UserDaoAdapter.toDao(this));
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "hashUserId='" + hashUserId + '\'' +
                ", email='" + email + '\'' +
                ", screenName='" + screenName + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expiresIn=" + expiresIn +
                ", scope='" + scope + '\'' +
                ", createTime=" + createTime +
                ", deviceSet=" + deviceSet +
                '}';
    }
}
