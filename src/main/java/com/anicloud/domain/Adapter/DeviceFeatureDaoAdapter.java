package com.anicloud.domain.Adapter;

import com.anicloud.domain.model.device.DeviceFeature;
import com.anicloud.domain.model.device.FeatureArg;
import com.anicloud.domain.model.device.StubIdentity;
import com.anicloud.infrastructure.persistence.domain.device.*;

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
                convertToDomain(deviceFeatureDao.inputArgMapping)
        );
    }

    public static DeviceFeatureDao toDao(DeviceFeature deviceFeature) {
        if (deviceFeature == null) {
            return null;
        }
        return new DeviceFeatureDao(deviceFeature.name, deviceFeature.desc,
                toDaoBySet(deviceFeature.inputArgs), toDaoByList(deviceFeature.stubIdentityList),
                convertToDao(deviceFeature.inputArgMapping)
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
        return new FeatureArgDao(featureArg.name,
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
        return new StubIdentity(stubIdentityDao.id, stubIdentityDao.groupId, stubIdentityDao.stubId);
    }

    public static StubIdentityDao toDao(StubIdentity stubIdentity) {
        if (stubIdentity == null) {
            return null;
        }
        return new StubIdentityDao(stubIdentity.groupId, stubIdentity.stubId);
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

    public static Map<String, Map<StubIdentity, String>> convertToDomain(List<DeviceFeatureInputArg> deviceFeatureInputArgs) {
        if (deviceFeatureInputArgs == null) {
            return null;
        }
        Map<String, Map<StubIdentity, String>> inputArg = new HashMap<>();
        for (DeviceFeatureInputArg deviceFeatureInputArg : deviceFeatureInputArgs) {
            List<StubIdentityMapping> stubMapping = deviceFeatureInputArg.getStubIdentityMappings();
            Map<StubIdentity, String> map = new HashMap<>();
            for (StubIdentityMapping stubIdentityMapping : stubMapping) {
                map.put(stubIdentityMapping.getStubIdentity(), stubIdentityMapping.getFeatureName());
            }
            inputArg.put(deviceFeatureInputArg.getFeatureName(), map);
        }
        return inputArg;
    }

    public static List<DeviceFeatureInputArg> convertToDao(Map<String, Map<StubIdentity, String>> inputArg) {
        if (inputArg == null) {
            return null;
        }
        List<DeviceFeatureInputArg> deviceFeatureInputArgList = new ArrayList<>();
        Iterator<Map.Entry<String, Map<StubIdentity, String>>> iterator = inputArg.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Map<StubIdentity, String>> entry = iterator.next();
            DeviceFeatureInputArg deviceFeatureInputArg = new DeviceFeatureInputArg();
            List<StubIdentityMapping> stubIdentityMappingList = convertToList(entry.getValue());
            deviceFeatureInputArg.setFeatureName(entry.getKey());
            deviceFeatureInputArg.setStubIdentityMappings(stubIdentityMappingList);
            deviceFeatureInputArgList.add(deviceFeatureInputArg);
        }
        return deviceFeatureInputArgList;
    }

    public static Map<StubIdentity, String> convertToMap(List<StubIdentityMapping> stubIdentityMapping) {
        if (stubIdentityMapping == null) {
            return null;
        }
        Map<StubIdentity, String> map = new HashMap<>();
        for (StubIdentityMapping stubIdentityMap : stubIdentityMapping) {
            map.put(stubIdentityMap.getStubIdentity(), stubIdentityMap.getFeatureName());
        }
        return map;
    }

    public static List<StubIdentityMapping> convertToList(Map<StubIdentity, String> map) {
        if (map == null) {
            return null;
        }
        List<StubIdentityMapping> stubIdentityMappingList = new ArrayList<>();
        Iterator<Map.Entry<StubIdentity, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<StubIdentity, String> entry = iterator.next();
            StubIdentityMapping stubIdentityMapping = new StubIdentityMapping(entry.getKey(), entry.getValue());
            stubIdentityMappingList.add(stubIdentityMapping);
        }
        return stubIdentityMappingList;
    }
}
