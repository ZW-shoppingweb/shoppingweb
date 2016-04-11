package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

@Data
public class Orders {
    private int orderId;
    private int addressId;
    private String userName;
    private int productNum;
    private double totalPrice;
}
