package com.anicloud.application.service.init;

import com.anicloud.application.utils.DeviceFeatureJsonUtils;
import com.anicloud.domain.Adapter.DeviceFeatureDaoAdapter;
import com.anicloud.domain.model.device.DeviceFeature;
import com.anicloud.infrastructure.persistence.domain.device.DeviceFeatureDao;
import com.anicloud.infrastructure.persistence.repository.redis.RedisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by MRK on 2016/3/15.
 */
@Service
public class DeviceFeatureInitServiceImpl implements DeviceFeatureInitService {

    @Resource(name = "deviceFeatureRedisRepository")
    private RedisRepository<DeviceFeatureDao> redisRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(DeviceFeatureInitServiceImpl.class);
    private final static String OBJECT_KEY = "deviceFeatureList";

    public List<DeviceFeature> initDeviceFeature() throws IOException {
        List<DeviceFeature> deviceFeatureList = DeviceFeatureJsonUtils.getDeviceFeatureList();
        Long affactLine = redisRepository.put(OBJECT_KEY, DeviceFeatureDaoAdapter.toDao(deviceFeatureList));
        LOGGER.info("affectLine : " + affactLine);
        return deviceFeatureList;
    }

    public List<DeviceFeature> getAll() throws IOException {
        // read from redis
        List<DeviceFeatureDao> deviceFeatureDaoList = redisRepository.get(OBJECT_KEY);
        List<DeviceFeature> deviceFeatures = DeviceFeatureDaoAdapter.toDomain(deviceFeatureDaoList);
        // if null or affect line equal or less than 0 , read from json file
        if (deviceFeatures == null || deviceFeatures.size() <= 0) {
            List<DeviceFeature> deviceFeatureList = DeviceFeatureJsonUtils.getDeviceFeatureList();
            LOGGER.info("Redis not find data....");
            return deviceFeatureList;
        }
        return deviceFeatures;
    }

}
