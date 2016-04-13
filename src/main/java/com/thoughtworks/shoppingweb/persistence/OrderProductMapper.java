package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.Orders;
import com.thoughtworks.shoppingweb.domain.OrdersProduct;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderProductMapper {
    @Transactional
    public int insertProductToOrder(OrdersProduct ordersProduct);
}






