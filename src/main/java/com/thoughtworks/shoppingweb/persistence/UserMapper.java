package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.*;
public interface UserMapper {

   public User findUserByName(User user);
   public int insertUser(User user);
   public User searchUser(String userName);
}
