package com.thoughtworks.shoppingweb.service.page;

import lombok.Data;

/**
 * Created by cxzhao on 3/28/16.
 */
@Data
public class QueryFilter {
    private String filterName;
    private String filterValue;
<<<<<<< Updated upstream
    private String minPrice;
    private String maxPrice;
    private  String seqName;
    private  String sequence;

    public QueryFilter(String filterName, String filterValue,String minPrice,
                       String maxPrice,String seqName,String sequence)
    {
        this.filterName = filterName;
        this.filterValue = filterValue;
        this.maxPrice=maxPrice;
        this.minPrice=minPrice;
        this.seqName=seqName;
        this.sequence=sequence;
=======

    public QueryFilter(String filterName, String filterValue) {
        this.filterName = filterName;
        this.filterValue = filterValue;
>>>>>>> Stashed changes
    }
}
