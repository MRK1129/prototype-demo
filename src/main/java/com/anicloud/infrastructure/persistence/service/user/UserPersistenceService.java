package com.anicloud.infrastructure.persistence.service.user;

import com.anicloud.infrastructure.persistence.domain.user.UserDao;

import java.util.List;

/**
 * Created by MRK on 2016/3/29.
 */
public interface UserPersistenceService {
    UserDao getUserDaoById(Integer id);
    UserDao getUserDaoByhashUserId(String hashUserId);
    UserDao getUserDaoByEmail(String email);
    List<UserDao> getAll();
    UserDao save(UserDao userDao);
    UserDao modify(UserDao userDao);
    void delete(UserDao userDao);
}
