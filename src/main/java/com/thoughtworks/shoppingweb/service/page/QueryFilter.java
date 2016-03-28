package com.thoughtworks.shoppingweb.service.page;

import lombok.Data;

/**
 * Created by cxzhao on 3/28/16.
 */
@Data
public class QueryFilter {
    private String filterName;
    private String filterValue;

    public QueryFilter(String filterName, String filterValue) {
        this.filterName = filterName;
        this.filterValue = filterValue;
    }
}
