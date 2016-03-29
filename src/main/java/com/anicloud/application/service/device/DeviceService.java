package com.anicloud.application.service.device;

import com.ani.bus.service.commons.dto.anidevice.DeviceMasterObjInfoDto;
import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.interfaces.facade.dto.device.DeviceDto;
import com.anicloud.domain.model.device.DeviceLogicState;

import java.util.List;

/**
 * Created by MRK on 2016/3/25.
 */
public interface DeviceService {
    DeviceDto get(Integer id);
    List<DeviceDto> getAll();
    DeviceDto save(DeviceDto deviceDto);
    void saveAll(List<DeviceDto> deviceDtos);
    void remove(DeviceDto deviceDto);
    void modifyDeviceState(DeviceDto deviceDto, DeviceState deviceState);
    void modifyDeviceLogicState(DeviceDto deviceDto, DeviceLogicState deviceLogicState);
}
