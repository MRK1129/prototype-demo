package com.anicloud.domain.Adapter;

import com.anicloud.domain.model.device.DeviceFeature;
import com.anicloud.domain.model.device.FeatureArg;
import com.anicloud.domain.model.device.StubIdentity;
import com.anicloud.infrastructure.persistence.domain.device.DeviceFeatureDao;
import com.anicloud.infrastructure.persistence.domain.device.FeatureArgDao;
import com.anicloud.infrastructure.persistence.domain.device.StubIdentityDao;

import java.util.*;

/**
 * Created by MRK on 2016/3/23.
 */
public class DeviceFeatureDaoAdapter {

    public static DeviceFeature toDomain(DeviceFeatureDao deviceFeatureDao) {
        if (deviceFeatureDao == null) {
            return null;
        }
        return new DeviceFeature(deviceFeatureDao.id, deviceFeatureDao.name,
                deviceFeatureDao.desc, toDomainBySet(deviceFeatureDao.inputArgs),
                toDomainByList(deviceFeatureDao.stubIdentityList),
                toDomain(deviceFeatureDao.inputArgMapping)
        );
    }

    public static DeviceFeatureDao toDao(DeviceFeature deviceFeature) {
        if (deviceFeature == null) {
            return null;
        }
        return new DeviceFeatureDao(deviceFeature.id, deviceFeature.name, deviceFeature.desc,
                toDaoBySet(deviceFeature.inputArgs), toDaoByList(deviceFeature.stubIdentityList),
                toDao(deviceFeature.inputArgMapping)
        );
    }

    public static List<DeviceFeature> toDomain(List<DeviceFeatureDao> deviceFeatureDaos) {
        if (deviceFeatureDaos == null) {
            return null;
        }
        List<DeviceFeature> deviceFeatures = new ArrayList<>();
        for (DeviceFeatureDao deviceFeatureDao : deviceFeatureDaos) {
            deviceFeatures.add(toDomain(deviceFeatureDao));
        }
        return deviceFeatures;
    }

    public static List<DeviceFeatureDao> toDao(List<DeviceFeature> deviceFeatures) {
        if (deviceFeatures == null) {
            return null;
        }
        List<DeviceFeatureDao> deviceFeatureDaos = new ArrayList<>();
        for (DeviceFeature deviceFeature : deviceFeatures) {
            deviceFeatureDaos.add(toDao(deviceFeature));
        }
        return deviceFeatureDaos;
    }

    public static FeatureArg toDomain(FeatureArgDao featureArgDao) {
        if (featureArgDao == null) {
            return null;
        }
        return new FeatureArg(featureArgDao.id, featureArgDao.name,
                featureArgDao.dataType, featureArgDao.screenName
        );
    }

    public static FeatureArgDao toDao(FeatureArg featureArg) {
        if (featureArg == null) {
            return null;
        }
        return new FeatureArgDao(featureArg.id, featureArg.name,
                featureArg.dataType, featureArg.screenName
        );
    }

    public static Set<FeatureArg> toDomainBySet(Set<FeatureArgDao> featureArgDaos) {
        if (featureArgDaos == null) {
            return null;
        }
        Set<FeatureArg> featureArgSet = new HashSet<>();
        for (FeatureArgDao featureArgDao : featureArgDaos) {
            featureArgSet.add(toDomain(featureArgDao));
        }
        return featureArgSet;
    }

    public static Set<FeatureArgDao> toDaoBySet(Set<FeatureArg> featureArgs) {
        if (featureArgs == null) {
            return null;
        }
        Set<FeatureArgDao> featureArgDaoSet = new HashSet<>();
        for (FeatureArg featureArg : featureArgs) {
            featureArgDaoSet.add(toDao(featureArg));
        }
        return featureArgDaoSet;
    }

    public static StubIdentity toDomain(StubIdentityDao stubIdentityDao) {
        if (stubIdentityDao == null) {
            return null;
        }
        return new StubIdentity(stubIdentityDao.id,stubIdentityDao.groupId, stubIdentityDao.stubId);
    }

    public static StubIdentityDao toDao(StubIdentity stubIdentity) {
        if (stubIdentity == null) {
            return null;
        }
        return new StubIdentityDao(stubIdentity.id,stubIdentity.groupId, stubIdentity.stubId);
    }

    public static List<StubIdentity> toDomainByList(List<StubIdentityDao> stubIdentityDaos) {
        if (stubIdentityDaos == null) {
            return null;
        }
        List<StubIdentity> stubIdentities = new ArrayList<>();
        for (StubIdentityDao stubIdentityDao : stubIdentityDaos) {
            stubIdentities.add(toDomain(stubIdentityDao));
        }
        return stubIdentities;
    }

    public static List<StubIdentityDao> toDaoByList(List<StubIdentity> stubIdentities) {
        if (stubIdentities == null) {
            return null;
        }
        List<StubIdentityDao> stubIdentityDaos = new ArrayList<>();
        for (StubIdentity stubIdentity : stubIdentities) {
            stubIdentityDaos.add(toDao(stubIdentity));
        }
        return stubIdentityDaos;
    }

    public static Map<String, Map<StubIdentity, String>> toDomain(Map<String, Map<StubIdentityDao, String>> inputArgDaoMapping) {
        if (inputArgDaoMapping == null) {
            return null;
        }
        Map<String, Map<StubIdentity, String>> inputArgMapping = new HashMap<>();
        Iterator<Map.Entry<String, Map<StubIdentityDao, String>>> iterator = inputArgDaoMapping.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Map<StubIdentityDao, String>> entry = iterator.next();
            inputArgMapping.put(entry.getKey(), toDomainByMap(entry.getValue()));
        }
        return inputArgMapping;
    }

    public static Map<String, Map<StubIdentityDao, String>> toDao(Map<String, Map<StubIdentity, String>> inputArgMapping) {
        if (inputArgMapping == null) {
            return null;
        }
        Map<String, Map<StubIdentityDao, String>> inputArgDaomapping = new HashMap<>();
        Iterator<Map.Entry<String, Map<StubIdentity, String>>> iterator = inputArgMapping.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Map<StubIdentity, String>> entry = iterator.next();
            inputArgDaomapping.put(entry.getKey(), toDaoByMap(entry.getValue()));
        }
        return inputArgDaomapping;
    }

    public static Map<StubIdentity, String> toDomainByMap(Map<StubIdentityDao, String> inputArgDaoMapping) {
        if (inputArgDaoMapping == null) {
            return null;
        }
        Map<StubIdentity, String> inputArgMapping = new HashMap<>();
        Iterator<Map.Entry<StubIdentityDao, String>> iterator = inputArgDaoMapping.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<StubIdentityDao, String> entry = iterator.next();
            inputArgMapping.put(toDomain(entry.getKey()), entry.getValue());
        }
        return inputArgMapping;
    }

    public static Map<StubIdentityDao, String> toDaoByMap(Map<StubIdentity, String> inputArgMapping) {
        if (inputArgMapping == null) {
            return null;
        }
        Map<StubIdentityDao, String> inputArgDaoMapping = new HashMap<>();
        Iterator<Map.Entry<StubIdentity, String>> iterator = inputArgMapping.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<StubIdentity, String> entry = iterator.next();
            inputArgDaoMapping.put(toDao(entry.getKey()), entry.getValue());
        }
        return inputArgDaoMapping;
    }
}
