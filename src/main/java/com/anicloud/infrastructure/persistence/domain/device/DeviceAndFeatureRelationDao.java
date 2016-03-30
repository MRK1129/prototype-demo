package com.anicloud.infrastructure.persistence.domain.device;

import com.anicloud.domain.model.device.Device;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by MRK on 2016/3/29.
 */
@Entity
@Table(name = "t_relation")
public class DeviceAndFeatureRelationDao implements Serializable {
    private static final long serialVersionUID = 3854015421387292641L;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    public Device device;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_device_and_feature_relation", inverseJoinColumns = @JoinColumn(name = "device_feature_id"), joinColumns = @JoinColumn(name = "relation_id"))
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
