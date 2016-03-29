package com.anicloud.domain.Adapter;

import com.anicloud.domain.model.device.Device;
import com.anicloud.domain.model.user.User;
import com.anicloud.infrastructure.persistence.domain.device.DeviceDao;
import com.anicloud.infrastructure.persistence.domain.user.UserDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by MRK on 2016/3/29.
 */
public class UserDaoAdapter {

    public static User toDomain(UserDao userDao){
        if(userDao == null){
            return null;
        }
        return new User(userDao.id,userDao.hashUserId,userDao.email,
                userDao.screenName,userDao.accessToken,userDao.tokenType,
                userDao.refreshToken,userDao.expiresIn,userDao.scope,
                userDao.createTime,toDomain(userDao.deviceSet)
        );
    }

    public static UserDao toDao(User user){
        if (user == null){
            return null;
        }
        return new UserDao(user.id,user.hashUserId,user.email,
                user.screenName,user.accessToken,user.tokenType,
                user.refreshToken,user.expiresIn,user.scope,
                user.createTime,toDao(user.deviceSet)
        );
    }

    public static List<User> toDomain(List<UserDao> userDaos){
        if(userDaos == null){
            return null;
        }
        List<User> userList = new ArrayList<>();
        for (UserDao userDao : userDaos) {
            userList.add(toDomain(userDao));
        }
        return userList;
    }

    public static List<UserDao> toDao(List<User> userList){
        if(userList == null){
            return null;
        }
        List<UserDao> userDaos = new ArrayList<>();
        for (User user : userList) {
            userDaos.add(toDao(user));
        }
        return userDaos;
    }

    public static Device toDomain(DeviceDao deviceDao){
        if(deviceDao == null){
            return null;
        }
        return new Device(deviceDao.id,deviceDao.identificationCode,
                deviceDao.name,deviceDao.deviceState,deviceDao.logicState,
                deviceDao.deviceType,deviceDao.deviceGroup,toDomain(deviceDao.owner)
        );
    }

    public static DeviceDao toDao(Device device){
        if(device == null){
            return null;
        }
        return new DeviceDao(device.id,device.identificationCode,device.name,
                device.deviceState,device.logicState,device.deviceType,
                device.deviceGroup,toDao(device.owner)
        );
    }

    public static Set<Device> toDomain(Set<DeviceDao> deviceDaos){
        if(deviceDaos == null){
            return null;
        }
        Set<Device> devices = new HashSet<>();
        for (DeviceDao deviceDao : deviceDaos) {
            devices.add(toDomain(deviceDao));
        }
        return devices;
    }

    public static Set<DeviceDao> toDao(Set<Device> devices){
        if(devices == null){
            return null;
        }
        Set<DeviceDao> deviceDaos = new HashSet<>();
        for (Device device : devices) {
            deviceDaos.add(toDao(device));
        }
        return deviceDaos;
    }

}
