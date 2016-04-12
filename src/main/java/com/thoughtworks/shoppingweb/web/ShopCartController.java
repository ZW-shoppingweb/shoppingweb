package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.Address;
import com.thoughtworks.shoppingweb.domain.ShopCart;
import com.thoughtworks.shoppingweb.service.AddressService;
import com.thoughtworks.shoppingweb.service.ShopCartService;
import com.thoughtworks.shoppingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShopCartController {

    @Autowired
    ShopCartService shopCartService;
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;


    @RequestMapping(value = "/productCart", method = RequestMethod.POST)
    public ResponseEntity productCart(@RequestBody ShopCart shopCart) {
        return new ResponseEntity(shopCartService.insertToCart(shopCart), HttpStatus.OK);
    }
    @RequestMapping(value = "/shopCartShow", method = RequestMethod.POST)
    public ResponseEntity shopCartShow(@RequestBody String userName) {
        Map result = new HashMap();
        List<ShopCart> cartProduct = shopCartService.cartProduct(userName);
        List<ShopCart> allCartProduct = shopCartService.allCartProduct(userName);
        result.put("cartProduct",cartProduct);
        result.put("allCartProduct",allCartProduct);
        result.put("searchUser",userService.searchUser(userName));
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @RequestMapping(value = "/goToMyShopCart", method = RequestMethod.GET)
    public String goToMyShopCart(@RequestParam(value="userName",
            defaultValue = "", required = false) String userName, Model model) {
        model.addAttribute("allCartProduct",shopCartService.allCartProduct(userName));
        List<Address> getAllAddresses=addressService.getaddresses(userName);
        model.addAttribute("allAddresses",getAllAddresses);
        return "shopcartdetail";
    }
}