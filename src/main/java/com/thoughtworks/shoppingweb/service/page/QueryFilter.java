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
    private String pageId;
    private  int start;
    private  int size;
}

