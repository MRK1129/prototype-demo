package com.anicloud.application.service.user;

import com.anicloud.domain.model.user.User;

import java.util.List;

/**
 * Created by MRK on 2016/3/28.
 */
public interface UserService {
    User getUserByhashUserId(String hashUserId);
    User getUserByEmail(String email);
    List<User> getAll();
    User save(User user);
    User modify(User user);
    void delete(User user);
    User refreshUserToken(User user);
}
