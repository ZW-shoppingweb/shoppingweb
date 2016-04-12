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
    private long maxCount;
    private List<?> pageData;
    private QueryFilter queryFilter;


    public int getPrevPageNum() {

        if (currentPageNum == 1) {
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
        if (maxCount % queryFilter.getSize() > 0) {
            return maxCount / queryFilter.getSize() + 1;
        }
        return maxCount / queryFilter.getSize();
    }

}