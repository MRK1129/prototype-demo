package com.anicloud.application.dto.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.application.dto.user.UserDto;
import com.anicloud.domain.model.device.DeviceLogicState;

import java.io.Serializable;

/**
 * Created by MRK on 2016/3/25.
 */
public class DeviceDto implements Serializable {
    private static final long serialVersionUID = -1558928420483081354L;

    public Integer id;
    public String identificationCode;       // id of device, consist of masterDeviceId and slaveDeviceId
    public String name;
    public DeviceState deviceState;
    // logic state
    public DeviceLogicState logicState;
    public String deviceType;
    public String deviceGroup;

    public UserDto owner;

    public DeviceDto() {
    }

    public DeviceDto(Integer id, String identificationCode, String name,
                     DeviceState deviceState, DeviceLogicState logicState,
                     String deviceType, String deviceGroup, UserDto owner) {
        this.id = id;
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
        return "DeviceDto{" +
                "id=" + id +
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
