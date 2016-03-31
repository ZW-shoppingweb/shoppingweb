package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.persistence.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by szwang on 3/29/16.
 */
public class UserServiceTest {
    UserService userService;
    UserMapper userMapper;


    @Before
    public void setUp() throws Exception {
        userService=new UserService();
        userMapper= Mockito.mock(UserMapper.class);
        userService.setUserMapper(userMapper);
    }

    @Test
    public void getTrueWhenLoginWithCorrectUsernameAndPassword() throws Exception {
        User user=new User();
        user.setUserName("wsz");
        user.setPassword("123");
        Mockito.when(userMapper.findUserByName(user)).thenReturn(user);
        assertTrue(userService.validateUser(user));

    }
    @Test
    public void getFalseWhenLoginWithErrorUsernameOrPassword() throws Exception {
        User user=new User();
        user.setUserName("ws");
        user.setPassword("12344444");
        Mockito.when(userMapper.findUserByName(user)).thenReturn(null);
        assertFalse(userService.validateUser(user));
    }
    @Test
    public void getTrueWhenRegisterWithUniqueUsername() throws Exception {
        User user=new User();
        user.setUserName("wssasa");
        user.setPassword("123");
        Mockito.when(userMapper.insertUser(user)).thenReturn(1);
        assertTrue(userService.addUser(user));
    }
    @Test
    public void getFalseWhenRegisterWithExistedUsername() throws Exception {
        User user=new User();
        user.setUserName("wsz");
        user.setPassword("123");
        Mockito.when(userMapper.insertUser(user)).thenReturn(0);
        assertFalse(userService.addUser(user));
    }
}