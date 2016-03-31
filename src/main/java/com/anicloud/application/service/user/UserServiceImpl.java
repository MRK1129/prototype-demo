package com.anicloud.application.service.user;

import com.anicloud.domain.Adapter.UserDaoAdapter;
import com.anicloud.domain.model.user.User;
import com.anicloud.infrastructure.persistence.domain.user.UserDao;
import com.anicloud.infrastructure.persistence.service.user.UserPersistenceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MRK on 2016/3/28.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserPersistenceService userPersistenceService;

    @Override
    public User getUserByhashUserId(String hashUserId) {
        UserDao userDao = userPersistenceService.getUserDaoByhashUserId(hashUserId);
        return UserDaoAdapter.toDomain(userDao);
    }

    @Override
    public User getUserByEmail(String email) {
        UserDao userDao = userPersistenceService.getUserDaoByEmail(email);
        return UserDaoAdapter.toDomain(userDao);
    }

    @Override
    public List<User> getAll() {
        List<UserDao> userDaos = userPersistenceService.getAll();
        return UserDaoAdapter.toDomain(userDaos);
    }

    @Override
    public User save(User user) {
        return user.save();
    }

    @Override
    public User modify(User user) {
        return user.modify();
    }

    @Override
    public void delete(User user) {
        user.delete();
    }

    @Override
    public User refreshUserToken(User user) {
        return user.refreshUserAccessToeken();
    }
}
