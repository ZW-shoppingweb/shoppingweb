package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.User;

public interface UserMapper {

    public User findUserByName(User user);

    public int insertUser(User user);

    public User searchUser(String userName);
}
