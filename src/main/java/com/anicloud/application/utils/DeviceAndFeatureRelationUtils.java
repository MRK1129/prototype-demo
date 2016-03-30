package com.anicloud.application.utils;

import com.ani.bus.service.commons.dto.anidevice.DeviceMasterObjInfoDto;
import com.ani.octopus.service.agent.service.deviceobj.DeviceObjService;
import com.anicloud.domain.model.device.Device;
import com.anicloud.domain.model.device.DeviceAndFeatureRelation;
import com.anicloud.domain.model.device.DeviceFeature;
import com.anicloud.interfaces.facade.dto.device.DeviceFeatureDto;
import com.anicloud.interfaces.facade.service.device.DeviceFeatureServiceFacade;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by MRK on 2016/3/29.
 */
@Component
public class DeviceAndFeatureRelationUtils {
    @Resource
    private DeviceObjService deviceObjService;
    @Resource
    private DeviceFeatureServiceFacade deviceFeatureServiceFacade;
    private static List<DeviceFeature> deviceFeatures;

    static{
        try {
            deviceFeatures = DeviceFeatureJsonUtils.getDeviceFeatureList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<DeviceAndFeatureRelation> getRelation(Long accountId) throws Exception {
        List<DeviceMasterObjInfoDto> stubInfo =deviceObjService.getDeviceObjInfo(accountId,true);
        for (DeviceMasterObjInfoDto dto : stubInfo) {
            Device device = new Device();
        }
        return null;
    }

}
