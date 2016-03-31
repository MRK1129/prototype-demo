package com.anicloud.infrastructure.persistence.domain.device;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Mirkamil on 2016/3/31.
 */
@Entity
@Table(name = "t_device_input_arg")
public class DeviceFeatureInputArg implements Serializable {
    private static final long serialVersionUID = 919281458144704980L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 40)
    private String featureName;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "stubIdentityMapping_id", referencedColumnName = "id")
    private List<StubIdentityMapping> stubIdentityMappings;

    public DeviceFeatureInputArg() {
    }

    public DeviceFeatureInputArg(String featureName, List<StubIdentityMapping> stubIdentityMappings) {
        this.featureName = featureName;
        this.stubIdentityMappings = stubIdentityMappings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public List<StubIdentityMapping> getStubIdentityMappings() {
        return stubIdentityMappings;
    }

    public void setStubIdentityMappings(List<StubIdentityMapping> stubIdentityMappings) {
        this.stubIdentityMappings = stubIdentityMappings;
    }


}
