package com.anicloud.interfaces.facade.service.user;

import com.anicloud.interfaces.facade.dto.user.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by MRK on 2016/3/29.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext/applicationContext.xml"
})
public class UserServiceFacadeTest {

    @Resource
    private UserServiceFacade userServiceFacade;

    public static final Logger LOGGER = LoggerFactory.getLogger(UserServiceFacade.class);

    @Test
    public void testGetUserById() throws Exception {
        UserDto userDto = userServiceFacade.getUserById(1);
        System.out.println(userDto);
    }

    @Test
    public void testGetAll() throws Exception {
        List<UserDto> userDtos = userServiceFacade.getAll();
        LOGGER.info("获取到的数据数量：" + userDtos.size());
    }

    @Test
    public void testSave() throws Exception {
        UserDto userDto = new UserDto(1, "stu01", "mirkamil@anicloud.com",
                "Mirkamil", "465asd894a6dsa", "Code", "12456asd231sad", 1400L, "read", 15464L, null);
        userServiceFacade.save(userDto);
    }

    @Test
    public void testModify() throws Exception {
        UserDto userDto = new UserDto(1, "anicloud001", "mirkamil@anicloud.com",
                "Mirkamil", "465asd894a6dsa", "Code", "12456asd231sad", 1400L, "read", 15464L, null);
        userServiceFacade.modify(userDto);
    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGetUserByhashUserId() throws Exception {
        UserDto userDto = userServiceFacade.getUserByhashUserId("anicloud001");
        System.out.println(userDto);
    }
}