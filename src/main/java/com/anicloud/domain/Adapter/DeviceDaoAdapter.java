package com.anicloud.domain.Adapter;

import com.anicloud.domain.model.device.Device;
import com.anicloud.infrastructure.persistence.domain.device.DeviceDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MRK on 2016/3/30.
 */
public class DeviceDaoAdapter {

    public static Device toDomain(DeviceDao deviceDao) {
        if (deviceDao == null) {
            return null;
        }
        return new Device(deviceDao.identificationCode, deviceDao.name,
                deviceDao.deviceState, deviceDao.logicState,
                deviceDao.deviceType, deviceDao.deviceGroup,
                UserDaoAdapter.toDomain(deviceDao.owner)
        );
    }

    public static DeviceDao toDao(Device device) {
        if (device == null) {
            return null;
        }
        return new DeviceDao(device.identificationCode, device.name,
                device.deviceState, device.logicState,
                device.deviceType, device.deviceGroup,
                UserDaoAdapter.toDao(device.owner)
        );
    }

    public static List<Device> toDomain(List<DeviceDao> deviceDaos) {
        if (deviceDaos == null) {
            return null;
        }
        List<Device> devices = new ArrayList<>();
        for (DeviceDao deviceDao : deviceDaos) {
            devices.add(toDomain(deviceDao));
        }
        return devices;
    }

    public static List<DeviceDao> toDao(List<Device> devices) {
        if (devices == null) {
            return null;
        }
        List<DeviceDao> deviceDaos = new ArrayList<>();
        for (Device device : devices) {
            deviceDaos.add(toDao(device));
        }
        return deviceDaos;
    }

}
