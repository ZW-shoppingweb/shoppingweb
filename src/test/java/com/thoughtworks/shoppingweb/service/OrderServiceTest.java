package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.domain.Orders;
import com.thoughtworks.shoppingweb.domain.OrdersProduct;
import com.thoughtworks.shoppingweb.domain.ShopCart;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.persistence.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService orderService;
    OrderMapper orderMapper;
    ShopCartMapper shopCartMapper;
    OrderProductMapper orderProductMapper;
    @Before
    public void setUp() throws Exception {
        shopCartMapper = Mockito.mock(ShopCartMapper.class);
        orderMapper= Mockito.mock(OrderMapper.class);
        orderProductMapper=Mockito.mock(OrderProductMapper.class);
        orderService=new OrderService();
        orderService.setOrderMapper(orderMapper);
        orderService.setShopCartMapper(shopCartMapper);
        orderService.setOrderProductMapper(orderProductMapper);

    }
    @Test
    public void getTrueWhenInsertOrderSuccess() throws Exception {
        Orders orders=new Orders();
        orders.setUserName("wsz");
        orders.setAddressId(1);
        orders.setProductNum(1);
        orders.setTotalPrice(100);
        ShopCart shopCart=new ShopCart();
        shopCart.setUserName(orders.getUserName());
        Mockito.when(orderMapper.insertToOrder(orders)).thenReturn(1);
        OrdersProduct ordersProduct=new OrdersProduct(1,"1", 1);
        Mockito.when(orderProductMapper.insertProductToOrder(ordersProduct)).thenReturn(1);
        Mockito.when(shopCartMapper.deleteShopCartByUser(shopCart)).thenReturn(1);
        assertTrue(orderService.insertToOrder(orders));

    }
    @Test
    public void getFalseWhenInsertOrderfail() throws Exception {
        Orders orders=new Orders();
        orders.setUserName("wsz");
        orders.setAddressId(1);
        orders.setProductNum(0);
        Mockito.when(orderMapper.insertToOrder(orders)).thenReturn(0);
        assertFalse(orderService.insertToOrder(orders));
    }
    @Test
    public void getFalseWhenInsertOrderProductFail() throws Exception {
        Orders orders=new Orders();
        OrdersProduct ordersProduct=new OrdersProduct(orders.getOrderId(),"1", 1);
        Mockito.when(orderProductMapper.insertProductToOrder(ordersProduct)).thenReturn(0);
        assertFalse(orderService.insertToOrder(orders));
    }
    @Test
    public void getFalseWhenDeleteShopCartFail() throws Exception {
        Orders orders=new Orders();
        ShopCart shopCart=new ShopCart();
        shopCart.setUserName(orders.getUserName());
        Mockito.when(shopCartMapper.deleteShopCartByUser(shopCart)).thenReturn(0);
        assertFalse(orderService.insertToOrder(orders));
    }
    @Test
    public void shouldNotNullWhenOrderExistedInOrder() throws Exception {
        Orders orders=new Orders();
        String userName="wsz";
        orders.setUserName(userName);
        orders.setAddressId(1);
        orders.setProductNum(1);
        orders.setTotalPrice(100);
        Mockito.when(orderMapper.insertToOrder(orders)).thenReturn(1);
        Mockito.when(orderMapper.selectOrderByUserName(userName)).thenReturn(new ArrayList<Orders>());
        assertNotNull(orderService.selectOrderByUserName(userName));
    }
    @Test
    public void shouldBeNullWhenOrderNotExistedInOrder() throws Exception {
        String userName="123";
        Mockito.when(orderMapper.selectOrderByUserName(userName)).thenReturn(null);
        assertNull(orderService.selectOrderByUserName(userName));
    }

}