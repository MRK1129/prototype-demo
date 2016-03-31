package com.anicloud.infrastructure.persistence.domain.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.domain.model.device.DeviceLogicState;
import com.anicloud.infrastructure.persistence.domain.user.UserDao;

import javax.persistence.*;

/**
 * Created by MRK on 2016/3/25.
 */
@Entity
@Table(name="t_device")
public class DeviceDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column
    public String identificationCode;       // id of device, consist of masterDeviceId and slaveDeviceId
    @Column
    public String name;
    @Column
    public DeviceState deviceState;
    // logic state
    @Column
    public DeviceLogicState logicState;
    @Column
    public String deviceType;
    @Column
    public String deviceGroup;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    public UserDao owner;

    public DeviceDao() {
    }

    public DeviceDao(String identificationCode, String name,
                     DeviceState deviceState, DeviceLogicState logicState,
                     String deviceType, String deviceGroup, UserDao owner) {
        this.identificationCode = identificationCode;
        this.name = name;
        this.deviceState = deviceState;
        this.logicState = logicState;
        this.deviceType = deviceType;
        this.deviceGroup = deviceGroup;
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeviceDao deviceDao = (DeviceDao) o;

        if (id != null ? !id.equals(deviceDao.id) : deviceDao.id != null) return false;
        return identificationCode != null ? identificationCode.equals(deviceDao.identificationCode) : deviceDao.identificationCode == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (identificationCode != null ? identificationCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DeviceDao{" +
                "id=" + id +
                ", identificationCode='" + identificationCode + '\'' +
                ", name='" + name + '\'' +
                ", deviceState=" + deviceState +
                ", logicState=" + logicState +
                ", deviceType='" + deviceType + '\'' +
                ", deviceGroup='" + deviceGroup + '\'' +
                ", owner=" + owner +
                '}';
    }
}
