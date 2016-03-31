package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = "/loginAction", method=RequestMethod.POST)
    public ResponseEntity loginPage(@RequestBody Map<String, String> requestParams) {
        User user = new User();
        user.setUserName(requestParams.get("userName"));
        user.setPassword(requestParams.get("password"));
        Map result = new HashMap();
        if(userService.validateUser(user)){
            result.put("isLogin","yes");
        }
        else{
            result.put("isLogin","no");
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/registerAction", method=RequestMethod.POST)
    public ResponseEntity registerPage(@RequestBody Map<String, String> requestParams) {
        User user = new User();
        user.setUserName(requestParams.get("userName"));
        user.setPassword(requestParams.get("password"));
        Map result = new HashMap();
        if(userService.addUser(user)){
            result.put("isLogin","yes");
        }
        else{
            result.put("isLogin","no");
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
