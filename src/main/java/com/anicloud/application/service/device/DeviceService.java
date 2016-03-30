package com.anicloud.application.service.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.domain.model.device.Device;
import com.anicloud.domain.model.device.DeviceLogicState;

import java.util.List;

/**
 * Created by MRK on 2016/3/25.
 */
public interface DeviceService {
    Device get(String identificationCode);
    List<Device> getAll();
    Device save(Device device);
    void saveAll(List<Device> deviceList);
    void remove(Device device);
    void modifyDeviceState(Device device, DeviceState deviceState);
    void modifyDeviceLogicState(Device device, DeviceLogicState deviceLogicState);
}
