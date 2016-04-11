package com.thoughtworks.shoppingweb.web;
import com.thoughtworks.shoppingweb.domain.Address;
import com.thoughtworks.shoppingweb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/submitAddress", method = RequestMethod.POST)
    public String productCart(@ModelAttribute Address address, Model model) {
        if(address.getAddressId()==null) {
            addressService.insertAddress(address);
            address.setAddressId(addressService.getCheckAddress().getAddressId());
        }
        System.out.println("==="+address.getAddressId());
        model.addAttribute("addressId",address.getAddressId());
        model.addAttribute("userName",address.getUserName());
        return "orderdetail";
    }
}