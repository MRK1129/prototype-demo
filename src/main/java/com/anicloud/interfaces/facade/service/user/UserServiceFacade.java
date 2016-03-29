package com.anicloud.interfaces.facade.service.user;

import com.anicloud.interfaces.facade.dto.user.UserDto;

import java.util.List;

/**
 * Created by MRK on 2016/3/29.
 */
public interface UserServiceFacade {

    UserDto getUserById(Integer id);
    UserDto getUserByhashUserId(String hashUserId);
    UserDto getUserByEmail(String email);
    List<UserDto> getAll();
    UserDto save(UserDto userDto);
    UserDto modify(UserDto userDto);
    void delete(UserDto userDto);
    UserDto refreshUserToken(UserDto userDto);
}
