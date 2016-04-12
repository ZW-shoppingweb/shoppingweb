package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.Orders;
import com.thoughtworks.shoppingweb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class OrderController {

    @Autowired
    OrderService orderService;


    @RequestMapping(value = "/submitOrder", method = RequestMethod.POST)
    public ResponseEntity productCart(@RequestBody Orders orders) {

        return new ResponseEntity(orderService.insertToOrder(orders), HttpStatus.OK);
    }
}