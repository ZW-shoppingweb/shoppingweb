package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.*;
public interface UserMapper {

    @Select("select * from user where username=#{username}")
    public User findUserByName(String username);
}
