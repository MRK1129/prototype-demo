package com.anicloud.interfaces.facade.service.device;

import com.ani.bus.service.commons.dto.anidevice.stub.DataType;
import com.anicloud.application.dto.device.DeviceFeatureDto;
import com.anicloud.application.dto.device.FeatureArgDto;
import com.anicloud.application.dto.device.StubIdentityDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.*;

/**
 * Created by MRK on 2016/3/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext/applicationContext.xml"
})

public class DeviceFeatureServiceFacadeTest {

    @Resource
    private DeviceFeatureServiceFacade deviceFeatureServiceFacade;
    private final static Logger LOGGER = LoggerFactory.getLogger(DeviceFeatureServiceFacade.class);

    @Test
    public void testGetAll() throws Exception {
        List<DeviceFeatureDto> deviceFeatureDtos = deviceFeatureServiceFacade.getAll();
        LOGGER.info("获取到的数据数量为："+deviceFeatureDtos.size());
    }

    @Test
    public void testClearAll() throws Exception {
        deviceFeatureServiceFacade.clearAll();
    }

    @Test
    public void testSave() throws Exception{
        DeviceFeatureDto deviceFeatureDto = new DeviceFeatureDto(5,"MRK-PowerOn","power on the light",null,null,null);
        deviceFeatureServiceFacade.save(deviceFeatureDto);
    }

    @Test
    public void testSaveAll() throws Exception{
        DeviceFeatureDto deviceFeatureDto1 = new DeviceFeatureDto(1,"Light-PowerOn","power on the light",null,null,null);
        DeviceFeatureDto deviceFeatureDto2 = new DeviceFeatureDto(2,"Light-Poweroff","power off the light",null,null,null);
        FeatureArgDto featureArgDto = new FeatureArgDto(1,"brightness", DataType.INTEGER,"Adjust Brightness");
        Set<FeatureArgDto> inputArg = new HashSet<>();
        inputArg.add(featureArgDto);
        StubIdentityDto stubIdentityDto1 = new StubIdentityDto(1L,1);
        StubIdentityDto stubIdentityDto2 = new StubIdentityDto(1L,3);
        List<StubIdentityDto> stubIdentityDtos = new ArrayList<>();
        stubIdentityDtos.add(stubIdentityDto1);
        stubIdentityDtos.add(stubIdentityDto2);
        Map<String,Map<StubIdentityDto,String>> inputArgMapping = new HashMap<>();
        Map<StubIdentityDto,String> stubIdentityDtoStringMap = new HashMap<>();
        stubIdentityDtoStringMap.put(new StubIdentityDto(1L,3),"brightness");
        inputArgMapping.put("brightness",stubIdentityDtoStringMap);
        DeviceFeatureDto deviceFeatureDto3 = new DeviceFeatureDto(3,"Light-setBrightness",
                "set the brightness of the light",inputArg,stubIdentityDtos,inputArgMapping
        );
        List<DeviceFeatureDto> deviceFeatureDtoList = new ArrayList<>();
        deviceFeatureDtoList.add(deviceFeatureDto1);
        deviceFeatureDtoList.add(deviceFeatureDto2);
        deviceFeatureDtoList.add(deviceFeatureDto3);
        deviceFeatureServiceFacade.saveAll(deviceFeatureDtoList);
        LOGGER.info("------保存成功------");
    }


}