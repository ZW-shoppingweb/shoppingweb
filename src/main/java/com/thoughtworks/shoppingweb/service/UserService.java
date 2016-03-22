package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public boolean validateUser(User user) {
        System.out.println("+==============" + user.getPassword() + user.getUsername());
        User exitUser = userMapper.findUserByName("123456");

        return (user == null && user.getPassword().equals(user.getPassword()));
    }
}
