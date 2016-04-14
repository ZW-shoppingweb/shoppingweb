package com.thoughtworks.shoppingweb.service.page;

import org.junit.Before;
import org.junit.Test;

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

    //@Test
    public void testGetCurrentPageNum(){
        paginationData.setCurrentPageNum(1);
        assertEquals(1, paginationData.getCurrentPageNum());
    }

    //@Test
    public void testPrevPageNum(){
        paginationData.getQueryFilter().setSize(1);
        paginationData.setMaxCount(3);
        paginationData.setCurrentPageNum(2);

        assertEquals(1, paginationData.getPrevPageNum());
    }

    //@Test
    public void testNextPageNum() {
        paginationData.getQueryFilter().setSize(10);
        paginationData.setMaxCount(90);
        paginationData.setCurrentPageNum(8);
        assertEquals(9, paginationData.getNextPageNum());
    }

    //@Test
    public void testNextPageNumWhenAtLastPage() {
        paginationData.getQueryFilter().setSize(10);
        paginationData.setMaxCount(90);
        paginationData.setCurrentPageNum(9);
        assertEquals(9, paginationData.getNextPageNum());

        paginationData.setMaxCount(98);
        assertEquals(10, paginationData.getNextPageNum());
    }


}