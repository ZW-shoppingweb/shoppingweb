package com.thoughtworks.shoppingweb.service;


/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.domain.Order;
import com.thoughtworks.shoppingweb.domain.ShopCart;
import com.thoughtworks.shoppingweb.persistence.OrderMapper;
import com.thoughtworks.shoppingweb.persistence.ShopCartMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ShopCartMapper shopCartMapper;
    private final static Logger logPrint = Logger.getLogger(OrderService.class);

    public OrderMapper getOrderMapper() {
        return orderMapper;
    }

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public boolean insertToOrder(Order order){
        boolean insertResult;
        try {
            int orderId=orderMapper.insertToOrder(order);
            ShopCart shopCart=new ShopCart();
            shopCart.setUserName(order.getUserName());
            shopCart.setOrderId(orderId);
            insertResult= (shopCartMapper.addShopCartToOrder(shopCart)>0 && orderId>0);
        }catch (Exception e) {
            logPrint.error(e);
            insertResult = false;
        }
        return insertResult;

    }
}
