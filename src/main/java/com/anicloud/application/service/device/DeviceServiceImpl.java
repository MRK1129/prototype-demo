package com.anicloud.application.service.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.application.dto.device.DeviceDto;
import com.anicloud.domain.model.device.DeviceLogicState;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MRK on 2016/3/25.
 */
@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

    //TODO
    @Override
    public DeviceDto get(Integer id) {
        return null;
    }

    @Override
    public List<DeviceDto> getAll() {
        return null;
    }

    @Override
    public DeviceDto save(DeviceDto deviceDto) {
        return null;
    }

    @Override
    public void saveAll(List<DeviceDto> deviceDtos) {

    }

    @Override
    public void remove(DeviceDto deviceDto) {

    }

    @Override
    public void modifyDeviceState(DeviceDto deviceDto, DeviceState deviceState) {

    }

    @Override
    public void modifyDeviceLogicState(DeviceDto deviceDto, DeviceLogicState deviceLogicState) {

    }
}
