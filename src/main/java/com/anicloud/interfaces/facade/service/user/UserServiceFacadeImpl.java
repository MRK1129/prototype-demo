package com.anicloud.interfaces.facade.service.user;

import com.anicloud.application.service.user.UserService;
import com.anicloud.domain.model.user.User;
import com.anicloud.interfaces.facade.adapter.UserDtoAdapter;
import com.anicloud.interfaces.facade.dto.user.UserDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MRK on 2016/3/29.
 */
@Component
public class UserServiceFacadeImpl implements UserServiceFacade {

    @Resource
    private UserService userService;

    @Override
    public UserDto getUserById(Integer id) {
        User user = userService.getUserById(id);
        return UserDtoAdapter.toDto(user);
    }

    @Override
    public UserDto getUserByhashUserId(String hashUserId) {
        User user = userService.getUserByhashUserId(hashUserId);
        return UserDtoAdapter.toDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userService.getUserByEmail(email);
        return UserDtoAdapter.toDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        return UserDtoAdapter.toDto(userService.getAll());
    }

    @Override
    public UserDto save(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        userService.save(UserDtoAdapter.toDomain(userDto));
        return userDto;
    }

    @Override
    public UserDto modify(UserDto userDto) {
        if (userDto == null) {
            return null;
        }
        userService.modify(UserDtoAdapter.toDomain(userDto));
        return userDto;
    }

    @Override
    public void delete(UserDto userDto) {
        if (userDto == null) {
            return;
        }
        userService.delete(UserDtoAdapter.toDomain(userDto));
    }

    @Override
    public UserDto refreshUserToken(UserDto userDto) {
        userService.refreshUserToken(UserDtoAdapter.toDomain(userDto));
        return userDto;
    }

}
