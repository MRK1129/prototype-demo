package com.anicloud.infrastructure.persistence.service.device;

import com.ani.cel.service.manager.agent.core.share.DeviceState;
import com.anicloud.domain.model.device.Device;
import com.anicloud.domain.model.device.DeviceLogicState;
import com.anicloud.infrastructure.persistence.domain.device.DeviceDao;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by MRK on 2016/3/25.
 */
@Component
public class DevicePersistenceServiceImpl implements DevicePersistenceService{

    @PersistenceContext
    private EntityManager em;
    private final String jpql="SELECT entity FROM DeviceDao entity WHERE entity.id=?1 ";
    @Override
    public DeviceDao get(Integer id) {
        TypedQuery<DeviceDao> query = em.createQuery(jpql,DeviceDao.class);
        query.setParameter(1,id);
        return query.getSingleResult();
    }

    @Override
    public List<DeviceDao> getAll() {
        TypedQuery<DeviceDao> query = em.createQuery("SELECT entity FROM DeviceDao entity",DeviceDao.class);
        return query.getResultList();
    }

    @Override
    public DeviceDao save(DeviceDao deviceDao) {
        em.persist(deviceDao);
        return deviceDao;
    }

    @Override
    public void saveAll(List<DeviceDao> deviceDaos) {
        for (DeviceDao deviceDao : deviceDaos) {
            em.persist(deviceDao);
        }
    }

    @Override
    public void remove(DeviceDao deviceDao) {
        em.remove(deviceDao);
    }

    @Override
    public void modifyDeviceState(DeviceDao deviceDao, DeviceState deviceState) {
        //TODO
    }

    @Override
    public void modifyDeviceLogicState(DeviceDao deviceDao, DeviceLogicState deviceLogicState) {
        //TODO
    }
}
