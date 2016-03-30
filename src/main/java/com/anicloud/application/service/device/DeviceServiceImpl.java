package com.anicloud.application.service.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.domain.Adapter.DeviceDaoAdapter;
import com.anicloud.domain.model.device.Device;
import com.anicloud.infrastructure.persistence.service.device.DevicePersistenceService;
import com.anicloud.interfaces.facade.dto.device.DeviceDto;
import com.anicloud.domain.model.device.DeviceLogicState;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MRK on 2016/3/25.
 */
@Service
@Transactional
public class DeviceServiceImpl implements DeviceService {

    @Resource
    private DevicePersistenceService devicePersistenceService;

    @Override
    public Device get(String identificationCode) {
        return DeviceDaoAdapter.toDomain(devicePersistenceService.get(identificationCode));
    }

    @Override
    public List<Device> getAll() {
        return DeviceDaoAdapter.toDomain(devicePersistenceService.getAll());
    }

    @Override
    public Device save(Device device) {
        return DeviceDaoAdapter.toDomain(devicePersistenceService.save(DeviceDaoAdapter.toDao(device)));
    }

    @Override
    public void saveAll(List<Device> deviceList) {
        devicePersistenceService.saveAll(DeviceDaoAdapter.toDao(deviceList));
    }

    @Override
    public void remove(Device device) {
        devicePersistenceService.remove(DeviceDaoAdapter.toDao(device));
    }

    @Override
    public void modifyDeviceState(Device device, DeviceState deviceState) {
        devicePersistenceService.modifyDeviceState(DeviceDaoAdapter.toDao(device), deviceState);
    }

    @Override
    public void modifyDeviceLogicState(Device device, DeviceLogicState deviceLogicState) {
        devicePersistenceService.modifyDeviceLogicState(DeviceDaoAdapter.toDao(device), deviceLogicState);
    }
}
