package com.anicloud.infrastructure.persistence.domain.device;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by MRK on 2016/3/23.
 */
public class DeviceFeatureDao implements Serializable{
    private static final long serialVersionUID = -2605834315350791947L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column(length = 20)
    public String name;
    @Column(length = 50)
    public String desc;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="inputArg_id",referencedColumnName ="id" )
    public Set<FeatureArgDao> inputArgs;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="stubIdentity_id",referencedColumnName ="id" )
    public List<StubIdentityDao> stubIdentityList;
    //TODO
    public Map<String, Map<StubIdentityDao, String>> inputArgMapping;

    public DeviceFeatureDao() {
    }

    public DeviceFeatureDao(Integer id, String name, String desc,
                            Set<FeatureArgDao> inputArgs,
                            List<StubIdentityDao> stubIdentityList,
                            Map<String, Map<StubIdentityDao, String>> inputArgMapping) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.inputArgs = inputArgs;
        this.stubIdentityList = stubIdentityList;
        this.inputArgMapping = inputArgMapping;
    }

    @Override
    public String toString() {
        return "DeviceFeatureDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", inputArgs=" + inputArgs +
                ", stubIdentityList=" + stubIdentityList +
                ", inputArgMapping=" + inputArgMapping +
                '}';
    }
}
