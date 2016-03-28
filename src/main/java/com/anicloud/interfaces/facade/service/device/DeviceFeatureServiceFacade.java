package com.anicloud.interfaces.facade.service.device;


import com.anicloud.application.dto.device.DeviceFeatureDto;

import java.util.List;

/**
 * Created by MRK on 2016/3/18.
 */
public interface DeviceFeatureServiceFacade {

    List<DeviceFeatureDto> getAll();
    void delete(DeviceFeatureDto deviceFeatureDto);
    void clearAll();
    void save(DeviceFeatureDto deviceFeatureDto);
    void saveAll(List<DeviceFeatureDto> deviceFeatureDtos);
}
