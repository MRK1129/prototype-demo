package com.anicloud.interfaces.facade.dto.user;

import com.anicloud.interfaces.facade.dto.device.DeviceDto;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by MRK on 2016/3/25.
 */
public class UserDto implements Serializable {
    private static final long serialVersionUID = 3910975546944201608L;

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

    public Set<DeviceDto> deviceSet;

    public UserDto() {
    }

    public UserDto(Integer id,String hashUserId, String email, String screenName,
                   String accessToken, String tokenType, String refreshToken,
                   Long expiresIn, String scope, Long createTime,
                   Set<DeviceDto> deviceSet) {
        this.id=id;
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
        return "UserDto{" +
                "id=" + id +
                ", hashUserId='" + hashUserId + '\'' +
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
