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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "device_id", referencedColumnName = "identificationCode")
    public DeviceDao deviceDao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "t_device_and_feature_relation", inverseJoinColumns = @JoinColumn(name = "id"), joinColumns = @JoinColumn(name = "relation_id"))
    public List<DeviceFeatureDao> deviceFeatureDaoList;

    public DeviceAndFeatureRelationDao() {
    }

    public DeviceAndFeatureRelationDao(DeviceDao deviceDao, List<DeviceFeatureDao> deviceFeatureDaoList) {
        this.deviceDao = deviceDao;
        this.deviceFeatureDaoList = deviceFeatureDaoList;
    }

    @Override
    public String toString() {
        return "DeviceAndFeatureRelationDao{" +
                "id=" + id +
                ", deviceDao=" + deviceDao +
                ", deviceFeatureDaoList=" + deviceFeatureDaoList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceAndFeatureRelationDao that = (DeviceAndFeatureRelationDao) o;

        return id != null ? id.equals(that.id) : that.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
