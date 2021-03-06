package com.anicloud.application.service.device;


import com.anicloud.domain.model.device.DeviceFeature;

import java.util.List;

/**
 * Created by MRK on 2016/3/18.
 */
public interface DeviceFeatureService {
    List<DeviceFeature> getAll();
    void delete(DeviceFeature deviceFeature);
    void clearAll();
    void save(DeviceFeature deviceFeature);
    void saveAll(List<DeviceFeature> deviceFeatures);
}
