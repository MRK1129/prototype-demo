package com.anicloud.interfaces.facade.service.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.application.service.device.DeviceService;
import com.anicloud.domain.model.device.DeviceLogicState;
import com.anicloud.interfaces.facade.adapter.DeviceDtoAdapter;
import com.anicloud.interfaces.facade.dto.device.DeviceDto;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MRK on 2016/3/30.
 */
public class DeviceServiceFacadeImpl implements DeviceServiceFacade {

    @Resource
    private DeviceService deviceService;

    @Override
    public DeviceDto get(String identificationCode) {
        if (identificationCode == "") {
            return null;
        }
        return DeviceDtoAdapter.toDto(deviceService.get(identificationCode));
    }

    @Override
    public List<DeviceDto> getAll() {
        return DeviceDtoAdapter.toDto(deviceService.getAll());
    }

    @Override
    public DeviceDto save(DeviceDto deviceDto) {
        return DeviceDtoAdapter.toDto(deviceService.save(DeviceDtoAdapter.toDomain(deviceDto)));
    }

    @Override
    public void saveAll(List<DeviceDto> deviceDtoList) {
        deviceService.saveAll(DeviceDtoAdapter.toDomain(deviceDtoList));
    }

    @Override
    public void remove(DeviceDto deviceDto) {
        deviceService.remove(DeviceDtoAdapter.toDomain(deviceDto));
    }

    @Override
    public void modifyDeviceState(DeviceDto deviceDto, DeviceState deviceState) {
        deviceService.modifyDeviceState(DeviceDtoAdapter.toDomain(deviceDto), deviceState);
    }

    @Override
    public void modifyDeviceLogicState(DeviceDto deviceDto, DeviceLogicState deviceLogicState) {
        deviceService.modifyDeviceLogicState(DeviceDtoAdapter.toDomain(deviceDto), deviceLogicState);
    }
}
