package com.anicloud.infrastructure.persistence.domain.device;

import com.anicloud.domain.model.device.Device;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * Created by MRK on 2016/3/29.
 */
@Entity
@Table(name = "t_device_feature_relation")
public class DeviceAndFeatureRelationDao implements Serializable {
    private static final long serialVersionUID = 3854015421387292641L;

    @OneToOne
    public Device device;
    public List<DeviceFeatureDao> deviceFeatureDaoList;

    public DeviceAndFeatureRelationDao() {
    }

    public DeviceAndFeatureRelationDao(Device device, List<DeviceFeatureDao> deviceFeatureDaoList) {
        this.device = device;
        this.deviceFeatureDaoList = deviceFeatureDaoList;
    }

    @Override
    public String toString() {
        return "DeviceAndFeatureRelationDao{" +
                "device=" + device +
                ", deviceFeatureDaoList=" + deviceFeatureDaoList +
                '}';
    }
}
