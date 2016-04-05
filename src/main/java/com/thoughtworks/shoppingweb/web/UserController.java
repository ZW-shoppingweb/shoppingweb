package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.service.ProductService;
import com.thoughtworks.shoppingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/loginAction", method = RequestMethod.POST)
    public ResponseEntity loginPage(@RequestBody UserParams userParams) {
        User user = new User();
        user.setUserName(userParams.getUserName());
        user.setPassword(userParams.getPassword());
        Map result = new HashMap();
        if (userService.validateUser(user)) {
            result.put("isLogin", "yes");
        } else {
            result.put("isLogin", "no");
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/registerAction", method = RequestMethod.POST)
    public ResponseEntity registerPage(@RequestBody UserParams userParams) {
        User user = new User();
        user.setUserName(userParams.getUserName());
        user.setPassword(userParams.getPassword());
        Map result = new HashMap();
        if (userService.addUser(user)) {
            result.put("isLogin", "yes");
        } else {
            result.put("isLogin", "no");
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/shopCartShow", method = RequestMethod.POST)
    public ResponseEntity loginPage(@RequestBody String userName) {
        Map result = new HashMap();
        List<Product> cartProduct = productService.cartProduct(userName);
        List<Product> allCartProduct = productService.allCartProduct(userName);
        result.put("cartProduct",cartProduct);
        result.put("allCartProduct",allCartProduct);

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
