package com.anicloud.interfaces.facade.service.device;

import com.anicloud.interfaces.facade.dto.DeviceFeatureDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

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
}