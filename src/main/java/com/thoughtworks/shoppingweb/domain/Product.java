package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

/**
 * Created by szwang on 3/22/16.
 */
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
}
