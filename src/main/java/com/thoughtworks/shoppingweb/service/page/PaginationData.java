package com.thoughtworks.shoppingweb.service.page;

import lombok.Data;

import java.util.List;
import java.util.Collection;

/**
 * Created by szwang on 3/23/16.
 */
@Data
public class PaginationData {
    private int currentPageNum;
    private int pageSize;
    private long maxCount;
    private List<?> pageData;
    private QueryFilter queryFilter;

//    private Collection<QueryFilter> filters;


    public int getPrevPageNum() {

        if(currentPageNum == 1){
            return currentPageNum;
        }
        return currentPageNum - 1;
    }

    public int getNextPageNum() {
        if (this.getCurrentPageNum() == this.getMaxPageNum()) {
            return this.getCurrentPageNum();
        }
        return currentPageNum + 1;
    }

    public long getMaxPageNum() {
        if (maxCount % pageSize > 0) {
            return maxCount / pageSize + 1;
        }
        return maxCount / pageSize;
    }

    public void createQueryFilter(String filterName, String filterValue,String minPrice,
                                  String maxPrice,String seqName,String sequence)
    {
        this.setQueryFilter(new QueryFilter(filterName, filterValue ,minPrice, maxPrice,seqName,sequence));
    }

}