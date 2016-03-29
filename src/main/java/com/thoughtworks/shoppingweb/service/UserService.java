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
        User exitUser = userMapper.findUserByName(user);
        return (exitUser != null && exitUser.getPassword().equals(user.getPassword()));
    }
    public boolean addUser(User user){
        if(userMapper.findUserByName(user) != null){
            return false;
        }
        int insertResult=userMapper.insertUser(user);
        return (insertResult > 0);
    }
}
