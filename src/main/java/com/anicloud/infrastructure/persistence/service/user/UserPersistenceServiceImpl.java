package com.anicloud.infrastructure.persistence.service.user;

import com.anicloud.infrastructure.persistence.domain.user.UserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by MRK on 2016/3/29.
 */
@Component
public class UserPersistenceServiceImpl implements UserPersistenceService {

    @PersistenceContext
    public EntityManager em;

    @Override
    public UserDao getUserDaoByhashUserId(String hashUserId) {
        String jpql="SELECT entity FROM UserDao as entity WHERE entity.hashUserId=?1";
        TypedQuery<UserDao> query = em.createQuery(jpql,UserDao.class);
        query.setParameter(1,hashUserId);
        if(query.getResultList().size()<=0){
            return null;
        }
        return query.getSingleResult();
    }

    @Override
    public UserDao getUserDaoByEmail(String email) {
        String jpql="SELECT entity FROM UserDao as entity WHERE entity.email=?1";
        TypedQuery<UserDao> query = em.createQuery(jpql,UserDao.class);
        query.setParameter(1,email);
        if(query.getResultList().size()<=0){
            return null;
        }
        return query.getSingleResult();
    }

    @Override
    public List<UserDao> getAll() {
        String jpql = "SELECT entity FROM UserDao as entity";
        TypedQuery<UserDao> query = em.createQuery(jpql,UserDao.class);
        if(query.getResultList().size()<=0){
            return null;
        }
        return query.getResultList();
    }

    @Override
    public UserDao save(UserDao userDao) {
        em.persist(userDao);
        return userDao;
    }

    @Override
    public UserDao modify(UserDao userDao) {
        em.merge(userDao);
        return userDao;
    }

    @Override
    public void delete(UserDao userDao) {
        em.remove(userDao);
    }
}
