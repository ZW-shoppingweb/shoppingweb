package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

/**
 * Created by szwang on 4/11/16.
 */
@Data
public class Order {
    private int orderId;
    private int addressId;
    private String userName;
    private int productNum;
    private double totalPrice;
}
