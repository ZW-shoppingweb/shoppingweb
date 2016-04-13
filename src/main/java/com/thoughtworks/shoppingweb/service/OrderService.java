package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.domain.Orders;
import com.thoughtworks.shoppingweb.domain.OrdersProduct;
import com.thoughtworks.shoppingweb.domain.ShopCart;
import com.thoughtworks.shoppingweb.persistence.OrderMapper;
import com.thoughtworks.shoppingweb.persistence.OrderProductMapper;
import com.thoughtworks.shoppingweb.persistence.ShopCartMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ShopCartMapper shopCartMapper;
    @Autowired
    private OrderProductMapper orderProductMapper;
    private final static Logger logPrint = Logger.getLogger(OrderService.class);

    public OrderMapper getOrderMapper() {
        return orderMapper;
    }

    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public ShopCartMapper getShopCartMapper() {
        return shopCartMapper;
    }

    public void setShopCartMapper(ShopCartMapper shopCartMapper) {
        this.shopCartMapper = shopCartMapper;
    }

    public void setOrderProductMapper(OrderProductMapper orderProductMapper) {
        this.orderProductMapper = orderProductMapper;
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public boolean insertToOrder(Orders orders){
        boolean insertResult;
        try {
            int orderId=orderMapper.insertToOrder(orders);
            ShopCart shopCart=new ShopCart();
            shopCart.setUserName(orders.getUserName());
            List<ShopCart> shopCarts=shopCartMapper.allCartProduct(orders.getUserName());
            int num=0;
            for (ShopCart shopCart1:shopCarts){
                OrdersProduct ordersProduct=new OrdersProduct(orders.getOrderId(),shopCart1.getProduct().getProductId(),
                        Integer.parseInt(shopCart1.getProductNum()));
                num+=orderProductMapper.insertProductToOrder(ordersProduct);
            }
            int delete=shopCartMapper.deleteShopCartByUser(shopCart);
            return (orderId>0 && num == shopCarts.size() && delete>0);
        }catch (Exception e) {
            logPrint.error(e);
            insertResult = false;
        }
        return insertResult;

    }
    public List<Orders> selectOrderByUserName(String userName){
        return orderMapper.selectOrderByUserName(userName);
    }
}
