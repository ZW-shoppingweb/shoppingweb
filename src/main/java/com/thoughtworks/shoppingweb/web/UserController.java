package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/loginaction")
    public String loginPage(String username,String password) {
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        //System.out.println("===================="+user.getUsername()+user.getPassword());
        boolean a=userService.validateUser(user);
        return "home";
    }
    @RequestMapping(method = RequestMethod.GET,  value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/index")
    public String ss() {
        return "home";
    }
}
