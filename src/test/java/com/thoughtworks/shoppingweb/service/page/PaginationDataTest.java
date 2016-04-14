package com.thoughtworks.shoppingweb.service.page;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xjzhou on 3/25/16.
 */
public class PaginationDataTest {

    PaginationData paginationData;

    @Before
    public void setUp() throws Exception {

        paginationData = new PaginationData();
    }

    @Test
    public void testGetCurrentPageNum(){
        paginationData.setCurrentPageNum(1);
        assertEquals(1, paginationData.getCurrentPageNum());
    }

    @Test
    public void testPrevPageNum(){
        paginationData.setMaxCount(3);
        paginationData.setCurrentPageNum(2);
        assertEquals(1, paginationData.getPrevPageNum());
    }

    @Test
    public void testNextPageNum() {
        QueryFilter queryFilter=new QueryFilter();
        paginationData.setQueryFilter(queryFilter);
        paginationData.setMaxCount(33);
        paginationData.getMaxPageNum();
        paginationData.setCurrentPageNum(2);
        assertEquals(3, paginationData.getNextPageNum());
    }

    @Test
    public void testNextPageNumWhenAtLastPage() {
        QueryFilter queryFilter=new QueryFilter();
        paginationData.setQueryFilter(queryFilter);
        paginationData.setMaxCount(32);
        paginationData.setCurrentPageNum(2);
        assertEquals(2, paginationData.getNextPageNum());

        paginationData.setMaxCount(33);
        assertEquals(3, paginationData.getNextPageNum());
    }


}