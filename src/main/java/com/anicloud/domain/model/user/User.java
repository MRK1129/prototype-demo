package com.anicloud.domain.model.user;

import com.anicloud.domain.model.device.Device;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by MRK on 2016/3/25.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -2240705733205447514L;

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

    public User(String hashUserId, String email, String screenName,
                String accessToken, String tokenType, String refreshToken,
                Long expiresIn, String scope, Long createTime, Set<Device> deviceSet) {
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
