package com.thoughtworks.shoppingweb.service.page;

import lombok.Data;

import java.util.List;

/**
 * Created by szwang on 3/23/16.
 */
@Data
public class PaginationData {
    private int currentPageNum;
    private int pageSize;
    private long maxCount;
    private List<?> pageData;


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
}