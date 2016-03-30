package com.anicloud.infrastructure.persistence.service.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.domain.model.device.DeviceLogicState;
import com.anicloud.infrastructure.persistence.domain.device.DeviceDao;

import java.util.List;

/**
 * Created by MRK on 2016/3/25.
 */
public interface DevicePersistenceService {
    DeviceDao get(String identificationCode);
    List<DeviceDao> getAll();
    DeviceDao save(DeviceDao deviceDto);
    void saveAll(List<DeviceDao> deviceDaos);
    void remove(DeviceDao deviceDao);
    void modifyDeviceState(DeviceDao deviceDao, DeviceState deviceState);
    void modifyDeviceLogicState(DeviceDao deviceDao, DeviceLogicState deviceLogicState);
}
