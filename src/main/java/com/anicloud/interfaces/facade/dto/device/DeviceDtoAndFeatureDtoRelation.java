package com.anicloud.interfaces.facade.dto.device;

import java.io.Serializable;
import java.util.List;

/**
 * Created by MRK on 2016/3/25.
 */
public class DeviceDtoAndFeatureDtoRelation implements Serializable {
    private static final long serialVersionUID = -7767572100822489560L;

    private Integer id;
    private DeviceDto deviceDto;
    private List<DeviceFeatureDto> deviceFeatureDtos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DeviceDto getDeviceDto() {
        return deviceDto;
    }

    public void setDeviceDto(DeviceDto deviceDto) {
        this.deviceDto = deviceDto;
    }

    public List<DeviceFeatureDto> getDeviceFeatureDtos() {
        return deviceFeatureDtos;
    }

    public void setDeviceFeatureDtos(List<DeviceFeatureDto> deviceFeatureDtos) {
        this.deviceFeatureDtos = deviceFeatureDtos;
    }

    public DeviceDtoAndFeatureDtoRelation() {
    }

    public DeviceDtoAndFeatureDtoRelation(DeviceDto deviceDto,
                                          List<DeviceFeatureDto> deviceFeatureDtos) {
        this.deviceDto = deviceDto;
        this.deviceFeatureDtos = deviceFeatureDtos;
    }

}
