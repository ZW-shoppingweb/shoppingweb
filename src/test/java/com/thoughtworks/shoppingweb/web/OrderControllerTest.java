package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.Orders;
import com.thoughtworks.shoppingweb.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.*;

public class OrderControllerTest {
    OrderService orderService;
    OrderController orderController;
    @Before
    public void setup() {
        orderController = new OrderController();
        orderService = Mockito.mock(OrderService.class);
        orderController.setOrderService(orderService);
    }
    @Test
    public void shouldBeTrueWhenInsertOrderSuccess() throws Exception {
        Orders orders=new Orders();
        Mockito.when(orderService.insertToOrder(Matchers.<Orders>anyObject())).thenReturn(true);
        ResponseEntity responseEntity=orderController.productToOrder(orders);
        Mockito.verify(orderService).insertToOrder(Matchers.<Orders>anyObject());
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(true,responseEntity.getBody());

    }
    @Test
    public void shouldBeFalseWhenInsertOrderFail() throws Exception {
        Orders orders=new Orders();
        Mockito.when(orderService.insertToOrder(Matchers.<Orders>anyObject())).thenReturn(false);
        ResponseEntity responseEntity=orderController.productToOrder(orders);
        Mockito.verify(orderService).insertToOrder(Matchers.<Orders>anyObject());
        assertEquals(false,responseEntity.getBody());

    }

}