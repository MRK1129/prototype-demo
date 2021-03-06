package com.anicloud.interfaces.facade.dto.device;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by MRK on 2016/3/18.
 */
public class StubIdentityDto implements Serializable {
    private static final long serialVersionUID = -7561790604261831728L;
    public Integer id;
    public Long groupId;
    public Integer stubId;

    public StubIdentityDto() {
    }

    public StubIdentityDto(Long groupId, Integer stubId) {
        this.groupId = groupId;
        this.stubId = stubId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StubIdentityDto that = (StubIdentityDto) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (groupId != null ? !groupId.equals(that.groupId) : that.groupId != null) return false;
        return stubId != null ? stubId.equals(that.stubId) : that.stubId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
        result = 31 * result + (stubId != null ? stubId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StubIdentityDto{" +
                "id=" + id +
                ", groupId=" + groupId +
                ", stubId=" + stubId +
                '}';
    }
}
