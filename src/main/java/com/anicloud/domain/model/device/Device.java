package com.anicloud.domain.model.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.domain.model.user.User;

import java.io.Serializable;

/**
 * Created by MRK on 2016/3/25.
 */
public class Device implements Serializable {
    private static final long serialVersionUID = 770683175237083245L;

    public String identificationCode;       // id of device, consist of masterDeviceId and slaveDeviceId
    public String name;
    public DeviceState deviceState;
    // logic state
    public DeviceLogicState logicState;
    public String deviceType;
    public String deviceGroup;

    public User owner;

    public Device() {
    }

    public Device(String identificationCode, String name,
                  DeviceState deviceState, DeviceLogicState logicState,
                  String deviceType, String deviceGroup, User owner) {
        this.identificationCode = identificationCode;
        this.name = name;
        this.deviceState = deviceState;
        this.logicState = logicState;
        this.deviceType = deviceType;
        this.deviceGroup = deviceGroup;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Device{" +
                ", identificationCode='" + identificationCode + '\'' +
                ", name='" + name + '\'' +
                ", deviceState=" + deviceState +
                ", logicState=" + logicState +
                ", deviceType='" + deviceType + '\'' +
                ", deviceGroup='" + deviceGroup + '\'' +
                ", owner=" + owner +
                '}';
    }
}
