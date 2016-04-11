package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

@Data
public class OrdersProduct {
    private int orderId;
    private String productId;
    private int productNum;
    public OrdersProduct(){

    }
    public OrdersProduct(int orderId,String productId,int productNum){
        this.orderId=orderId;
        this.productId=productId;
        this.productNum=productNum;
    }
}
