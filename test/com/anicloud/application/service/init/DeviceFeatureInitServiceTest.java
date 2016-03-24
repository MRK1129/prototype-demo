package com.anicloud.application.service.init;

import com.anicloud.domain.model.device.DeviceFeature;
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
public class DeviceFeatureInitServiceTest {

    @Resource
    private DeviceFeatureInitService deviceFeatureInitService;
    private final static Logger LOGGER = LoggerFactory.getLogger(DeviceFeatureInitService.class);

    @Test
    public void testInitDeviceFeature() throws Exception {
        List<DeviceFeature> deviceFeatures = deviceFeatureInitService.initDeviceFeature();
        LOGGER.info("Data size :"+deviceFeatures.size());
    }

    @Test
    public void testGetAll() throws Exception {
        List<DeviceFeature> deviceFeatures = deviceFeatureInitService.getAll();
        LOGGER.info("Data size :"+deviceFeatures.size());
    }
}