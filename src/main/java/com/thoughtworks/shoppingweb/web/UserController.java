package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.Page;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.service.ProductService;
import com.thoughtworks.shoppingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/loginaction")
    public String loginPage(String userName,String passWord,Model model) {
        User user=new User();
        user.setUserName(userName);
        user.setPassWord(passWord);
        boolean a=userService.validateUser(user);
        List<Product> products = productService.getAllProduct();
        Page page=new Page();
        page.apartPage(1,products.size(),16);
        model.addAttribute("indexPage",page);
        model.addAttribute("lastPage","尾页");
        model.addAttribute("allProducts", products.subList(0,page.getPageSize()));
        return "index";
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
