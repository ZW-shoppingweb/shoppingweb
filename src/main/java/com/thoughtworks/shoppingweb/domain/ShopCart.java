package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

/**
 * Created by cxzhao on 4/5/16.
 */
@Data
public class ShopCart {
    private String userName;
    private String productId;
    private String productNum;
    private Product product;
}
