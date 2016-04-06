package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public ResponseEntity loginPage(@RequestBody UserParams userParams,HttpServletRequest request) {
        User user = new User();
        user.setUserName(userParams.getUserName());
        HttpSession session = request.getSession(true);
        session.setAttribute("memberName",userParams.getUserName());
        user.setPassword(userParams.getPassword());
        Map result = new HashMap();
        if (userService.validateUser(user)) {
            result.put("isLogin", "yes");
            result.put("name",userParams.getUserName());
        } else {
            result.put("isLogin", "no");
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/registerAction", method = RequestMethod.POST)
    public ResponseEntity registerPage(@RequestBody UserParams userParams,HttpServletRequest request) {
        User user = new User();
        user.setUserName(userParams.getUserName());
        user.setPassword(userParams.getPassword());
        HttpSession session = request.getSession(true);
        session.setAttribute("memberName",userParams.getUserName());
        Map result = new HashMap();
        if (userService.addUser(user)) {
            result.put("isLogin", "yes");
            result.put("name",userParams.getUserName());
        } else {
            result.put("isLogin", "no");
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/signOutAction", method = RequestMethod.GET)
    public ResponseEntity signOutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("memberName");
        Map result = new HashMap();
        result.put("isLogin", "no");
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
