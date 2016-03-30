package com.anicloud.interfaces.facade.service.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.domain.model.device.DeviceLogicState;
import com.anicloud.interfaces.facade.dto.device.DeviceDto;

import java.util.List;

/**
 * Created by MRK on 2016/3/30.
 */
public interface DeviceServiceFacade {
    DeviceDto get(String identificationCode);
    List<DeviceDto> getAll();
    DeviceDto save(DeviceDto deviceDto);
    void saveAll(List<DeviceDto> deviceDtoList);
    void remove(DeviceDto deviceDto);
    void modifyDeviceState(DeviceDto deviceDto, DeviceState deviceState);
    void modifyDeviceLogicState(DeviceDto deviceDto, DeviceLogicState deviceLogicState);
}
