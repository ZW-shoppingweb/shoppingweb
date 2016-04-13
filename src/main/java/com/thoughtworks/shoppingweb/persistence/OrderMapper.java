package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderMapper {

    public int insertToOrder(Orders orders);
    public List<Orders> selectOrderByUserName(String userName);
}






