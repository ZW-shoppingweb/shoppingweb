package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Product {

    private String productId;
    private String productName;
    private String productCity;
    private String productImage;
    private Double productPrice;
    private Double productVipPrice;
    private String productDetailsImg;
    private String productIntroduce;
    private String productCategory;
    private String productQuality;
    private Timestamp productTime;
    private int productNum;
}
