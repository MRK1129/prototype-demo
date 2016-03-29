package com.anicloud.interfaces.facade.adapter;

import com.anicloud.domain.model.device.Device;
import com.anicloud.domain.model.user.User;
import com.anicloud.interfaces.facade.dto.device.DeviceDto;
import com.anicloud.interfaces.facade.dto.user.UserDto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by MRK on 2016/3/29.
 */
public class UserDtoAdapter {

    public static User toDomain(UserDto userDto){
        if(userDto == null){
            return null;
        }
        return new User(userDto.id,userDto.hashUserId,userDto.email,
                userDto.screenName,userDto.accessToken,userDto.tokenType,
                userDto.refreshToken,userDto.expiresIn,userDto.scope,
                userDto.createTime,toDomain(userDto.deviceSet)
        );
    }

    public static UserDto toDto(User user){
        if (user == null){
            return null;
        }
        return new UserDto(user.id,user.hashUserId,user.email,
                user.screenName,user.accessToken,user.tokenType,
                user.refreshToken,user.expiresIn,user.scope,
                user.createTime,toDto(user.deviceSet)
        );
    }

    public static List<User> toDomain(List<UserDto> userDtos){
        if(userDtos == null){
            return null;
        }
        List<User> userList = new ArrayList<>();
        for (UserDto userDao : userDtos) {
            userList.add(toDomain(userDao));
        }
        return userList;
    }

    public static List<UserDto> toDto(List<User> userList){
        if(userList == null){
            return null;
        }
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : userList) {
            userDtos.add(toDto(user));
        }
        return userDtos;
    }

    public static Device toDomain(DeviceDto deviceDto){
        if(deviceDto == null){
            return null;
        }
        return new Device(deviceDto.id,deviceDto.identificationCode,
                deviceDto.name,deviceDto.deviceState,deviceDto.logicState,
                deviceDto.deviceType,deviceDto.deviceGroup,toDomain(deviceDto.owner)
        );
    }

    public static DeviceDto toDto(Device device){
        if(device == null){
            return null;
        }
        return new DeviceDto(device.id,device.identificationCode,device.name,
                device.deviceState,device.logicState,device.deviceType,
                device.deviceGroup,toDto(device.owner)
        );
    }

    public static Set<Device> toDomain(Set<DeviceDto> deviceDtos){
        if(deviceDtos == null){
            return null;
        }
        Set<Device> devices = new HashSet<>();
        for (DeviceDto deviceDto : deviceDtos) {
            devices.add(toDomain(deviceDto));
        }
        return devices;
    }

    public static Set<DeviceDto> toDto(Set<Device> devices){
        if(devices == null){
            return null;
        }
        Set<DeviceDto> deviceDaos = new HashSet<>();
        for (Device device : devices) {
            deviceDaos.add(toDto(device));
        }
        return deviceDaos;
    }
}
