package com.hxg.simpledemo.service.impl;

import com.hxg.simpledemo.SimpleDemoApplicationTests;
import com.hxg.simpledemo.bean.User;
import com.hxg.simpledemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@Slf4j
public class UserServiceImplTest extends SimpleDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void saveBatch() {

        List<User> users = userService.saveBatch();

        log.info("users: {}", users);

        Assert.assertTrue(users.size() > 0);
    }
}