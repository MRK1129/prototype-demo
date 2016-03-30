package com.anicloud.application.service.user;

import com.anicloud.domain.model.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by MRK on 2016/3/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext/applicationContext.xml"
})
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testGetUserById() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {

    }

    @Test
    public void testSave() throws Exception {
        User user = new User("stu01","mirkamil@anicloud.com",
                "Mirkamil","465asd894a6dsa","Code","12456asd231sad",1400L,"read",15464L,null);
        userService.save(user);
    }

    @Test
    public void testModify() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}