package com.anicloud.domain.model.device;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MRK on 2016/3/25.
 */
public class DeviceAndFeatureRelation implements Serializable {
    private static final long serialVersionUID = -4911503291890444941L;

    private Device device;
    private List<DeviceFeature> deviceFeatures;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public List<DeviceFeature> getDeviceFeatures() {
        return deviceFeatures;
    }

    public void setDeviceFeatures(List<DeviceFeature> deviceFeatures) {
        this.deviceFeatures = deviceFeatures;
    }

    public DeviceAndFeatureRelation() {
    }

    public DeviceAndFeatureRelation(Device device, List<DeviceFeature> deviceFeatures) {
        this.device = device;
        this.deviceFeatures = deviceFeatures;
    }

}
