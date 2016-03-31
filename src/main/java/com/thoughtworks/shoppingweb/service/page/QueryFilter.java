package com.thoughtworks.shoppingweb.service.page;

import lombok.Data;

/**
 * Created by cxzhao on 3/28/16.
 */

@Data
public class QueryFilter {
    private String productCategory;
    private String minPrice;
    private String maxPrice;
    private  String productName;
    private  String productPrice;

    public QueryFilter() {

    }

    public QueryFilter(String productCategory, String minPrice,
                       String maxPrice, String productName, String productPrice)
    {
        this.productCategory = productCategory;
        this.maxPrice=maxPrice;
        this.minPrice=minPrice;
        this.productName=productName;
        this.productPrice=productPrice;
    }
}
