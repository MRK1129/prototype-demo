package com.anicloud.infrastructure.persistence.domain.device;

import com.anicloud.domain.model.device.StubIdentity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mirkamil on 2016/3/31.
 */
@Entity
@Table(name = "t_stub_identity_mapping")
public class StubIdentityMapping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stubIdentity_id", referencedColumnName = "id")
    private StubIdentity stubIdentity;
    @Column(length = 40)
    private String featureName;

    public StubIdentityMapping() {
    }

    public StubIdentity getStubIdentity() {
        return stubIdentity;
    }

    public void setStubIdentity(StubIdentity stubIdentity) {
        this.stubIdentity = stubIdentity;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }


    public StubIdentityMapping(StubIdentity stubIdentity, String featureName) {
        this.stubIdentity = stubIdentity;
        this.featureName = featureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StubIdentityMapping that = (StubIdentityMapping) o;

        if (stubIdentity != null ? !stubIdentity.equals(that.stubIdentity) : that.stubIdentity != null) return false;
        return featureName != null ? featureName.equals(that.featureName) : that.featureName == null;

    }

    @Override
    public int hashCode() {
        int result = stubIdentity != null ? stubIdentity.hashCode() : 0;
        result = 31 * result + (featureName != null ? featureName.hashCode() : 0);
        return result;
    }
}
