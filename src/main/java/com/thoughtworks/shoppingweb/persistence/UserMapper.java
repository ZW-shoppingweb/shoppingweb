package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.*;
public interface UserMapper {

    @Select("select * from user where userName=#{userName} and password=#{password}")
    public User findUserByName(@Param("userName")String userName, @Param("password")String password);
}
