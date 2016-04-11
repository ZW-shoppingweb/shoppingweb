package com.thoughtworks.shoppingweb.web;

/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.domain.Order;
import com.thoughtworks.shoppingweb.domain.ShopCart;
import com.thoughtworks.shoppingweb.service.OrderService;
import com.thoughtworks.shoppingweb.service.ShopCartService;
import com.thoughtworks.shoppingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    ShopCartService shopCartService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/submitOrder", method = RequestMethod.POST)
    public ResponseEntity productCart(@RequestBody Order order) {

        return new ResponseEntity(orderService.insertToOrder(order), HttpStatus.OK);
    }
    @RequestMapping(value = "/goToSumitOrderPage", method = RequestMethod.GET)
    public String goToMyShopCart(@RequestParam(value="userName",
            defaultValue = "", required = false) String userName, Model model) {
        List<ShopCart> shopCarts=shopCartService.allCartProduct(userName);
        int totalNum=0;
        double totalPrice=0.00;
        for(ShopCart shopCart:shopCarts){
            int productNum=Integer.parseInt(shopCart.getProductNum());
            totalNum+=productNum;
            if(userService.searchUser(userName)){
                totalPrice+=(productNum*shopCart.getProduct().getProductVipPrice());
            }
            else{
                totalPrice+=(productNum*shopCart.getProduct().getProductPrice());
            }
        }
        model.addAttribute("totalNum",totalNum);
        model.addAttribute("totalPrice",totalPrice);
        model.addAttribute("allCartProduct",shopCarts);
        return "orderdetail";
    }
}