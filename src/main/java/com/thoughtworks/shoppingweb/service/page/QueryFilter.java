package com.thoughtworks.shoppingweb.service.page;

import lombok.Data;

/**
 * Created by cxzhao on 3/28/16.
 */

@Data
public class QueryFilter {
    public static final int DEFAULT_PAGE_SIZE = 16;
    private String productCategory;
    private String minPrice;
    private String maxPrice;
    private  String productName;
    private  String productPrice;
    private String pageId;
    private  int start;
    private  int size = DEFAULT_PAGE_SIZE;
}

