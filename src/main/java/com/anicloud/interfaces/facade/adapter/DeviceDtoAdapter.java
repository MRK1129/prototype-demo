package com.anicloud.interfaces.facade.adapter;

import com.anicloud.domain.Adapter.UserDaoAdapter;
import com.anicloud.domain.model.device.Device;
import com.anicloud.interfaces.facade.dto.device.DeviceDto;
import com.anicloud.interfaces.facade.dto.user.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MRK on 2016/3/30.
 */
public class DeviceDtoAdapter {

    public static Device toDomain(DeviceDto deviceDto) {
        if (deviceDto == null) {
            return null;
        }
        return new Device(deviceDto.identificationCode, deviceDto.deviceGroup,
                deviceDto.deviceState, deviceDto.logicState,
                deviceDto.deviceType, deviceDto.deviceGroup,
                UserDtoAdapter.toDomain(deviceDto.owner)
        );
    }

    public static DeviceDto toDto(Device device) {
        if (device == null) {
            return null;
        }
        return new DeviceDto(device.identificationCode, device.name,
                device.deviceState, device.logicState,
                device.deviceType, device.deviceGroup,
                UserDtoAdapter.toDto(device.owner)
        );
    }

    public static List<Device> toDomain(List<DeviceDto> deviceDtos) {
        if (deviceDtos == null) {
            return null;
        }
        List<Device> devices = new ArrayList<>();
        for (DeviceDto deviceDto : deviceDtos) {
            devices.add(DeviceDtoAdapter.toDomain(deviceDto));
        }
        return devices;
    }

    public static List<DeviceDto> toDto(List<Device> devices) {
        if (devices == null) {
            return null;
        }
        List<DeviceDto> deviceDtos = new ArrayList<>();
        for (Device device : devices) {
            deviceDtos.add(DeviceDtoAdapter.toDto(device));
        }
        return deviceDtos;
    }
}
