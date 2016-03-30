package com.anicloud.infrastructure.persistence.domain.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.domain.model.device.DeviceLogicState;
import com.anicloud.infrastructure.persistence.domain.user.UserDao;

import javax.persistence.*;

/**
 * Created by MRK on 2016/3/25.
 */
@Entity
@Table(name="t_device")
public class DeviceDao {

    @Column
    public String identificationCode;       // id of device, consist of masterDeviceId and slaveDeviceId
    @Column
    public String name;
    @Column
    public DeviceState deviceState;
    // logic state
    @Column
    public DeviceLogicState logicState;
    @Column
    public String deviceType;
    @Column
    public String deviceGroup;
    @ManyToOne(fetch = FetchType.EAGER)
    public UserDao owner;

    public DeviceDao() {
    }

    public DeviceDao(String identificationCode, String name,
                     DeviceState deviceState, DeviceLogicState logicState,
                     String deviceType, String deviceGroup, UserDao owner) {
        this.identificationCode = identificationCode;
        this.name = name;
        this.deviceState = deviceState;
        this.logicState = logicState;
        this.deviceType = deviceType;
        this.deviceGroup = deviceGroup;
        this.owner = owner;
    }
}
