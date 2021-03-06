package com.anicloud.domain.model.device;

import com.ani.bus.service.commons.dto.anidevice.stub.DataType;

import java.io.Serializable;

/**
 * Created by MRK on 2016/3/15.
 */
public class FeatureArg implements Serializable {
    private static final long serialVersionUID = -7173554213669230649L;

    public Integer id;
    public String name;
    public DataType dataType;
    public String screenName;

    public FeatureArg() {
    }

    public FeatureArg(Integer id,String name, DataType dataType, String screenName) {
        this.id=id;
        this.name = name;
        this.dataType = dataType;
        this.screenName = screenName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeatureArg that = (FeatureArg) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FeatureArg{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dataType=" + dataType +
                ", screenName='" + screenName + '\'' +
                '}';
    }
}
