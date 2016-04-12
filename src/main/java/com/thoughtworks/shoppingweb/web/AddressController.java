package com.thoughtworks.shoppingweb.web;
import com.thoughtworks.shoppingweb.domain.Address;
import com.thoughtworks.shoppingweb.domain.ShopCart;
import com.thoughtworks.shoppingweb.service.AddressService;
import com.thoughtworks.shoppingweb.service.OrderService;
import com.thoughtworks.shoppingweb.service.ShopCartService;
import com.thoughtworks.shoppingweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    AddressService addressService;
    @Autowired
    ShopCartService shopCartService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @RequestMapping(value = "/submitAddress", method = RequestMethod.POST)
    public String productCart(@ModelAttribute Address address, Model model) {
        if(address.getAddressId()==null) {
            addressService.insertAddress(address);
            address.setAddressId(addressService.getCheckAddress().getAddressId());
        }
        model.addAttribute("address",addressService.selectAddressById(address));
        String userName=address.getUserName();
        selectOrderInfo(userName,model);
        return "orderdetail";
    }
    public void selectOrderInfo(String userName, Model model){
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
        model.addAttribute("orderList",orderService.selectOrderByUserName(userName));
    }
}