package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.service.page.PaginationData;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.service.ProductService;
import com.thoughtworks.shoppingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;


    @RequestMapping(value = "/loginAction/{userName}/{password}")
    public ResponseEntity loginPage(@PathVariable("userName")String userName,
                                           @PathVariable("password")String password, Model model) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        Map result = new HashMap();
        if(userService.validateUser(user)){
            result.put("isLogin","yes");
            result.put("userName",userName);

        }
        else{
            result.put("isLogin","no");
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/index")
    public String home() {
        return "home";
    }
}
