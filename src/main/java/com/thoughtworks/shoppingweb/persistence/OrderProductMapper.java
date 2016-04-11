package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.Orders;
import com.thoughtworks.shoppingweb.domain.OrdersProduct;

import java.util.List;

public interface OrderProductMapper {

    public int insertProductToOrder(OrdersProduct ordersProduct);
}






