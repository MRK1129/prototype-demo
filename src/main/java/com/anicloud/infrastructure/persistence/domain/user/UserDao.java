package com.anicloud.infrastructure.persistence.domain.user;

import com.anicloud.domain.model.device.Device;
import com.anicloud.infrastructure.persistence.domain.device.DeviceDao;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by MRK on 2016/3/25.
 */
@Entity
@Table(name="t_user")
public class UserDao {

    @Column(length = 50)
    public String hashUserId;
    @Column(length = 30)
    public String email;
    @Column(length = 50)
    public String screenName;
    @Column
    public String accessToken;
    @Column(length = 20)
    public String tokenType;
    @Column
    public String refreshToken;
    @Column
    public Long expiresIn;
    @Column
    public String scope;
    @Column
    public Long createTime;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner",fetch = FetchType.LAZY)
    public Set<DeviceDao> deviceSet;

    public UserDao() {
    }

    public UserDao(String hashUserId, String email, String screenName,
                   String accessToken, String tokenType, String refreshToken,
                   Long expiresIn, String scope, Long createTime,
                   Set<DeviceDao> deviceSet) {

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

}
