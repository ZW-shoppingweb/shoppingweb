package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.service.ProductService;
import com.thoughtworks.shoppingweb.service.page.PaginationData;
import com.thoughtworks.shoppingweb.service.page.QueryFilter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;

/**
 * Created by cxzhao on 3/29/16.
 */
public class ProductControllerTest {
    ProductService productService;
    ProductController productController;

    @Before
    public void setup() {
        productController = new ProductController();
        productService = Mockito.mock(ProductService.class);
        productController.setProductService(productService);
    }

    @Test
    public void testProductList() throws Exception {
        List<Product> mokitoList = new ArrayList<Product>();
        QueryFilter queryFilter = getQueryFilter();
        PaginationData paginationData = new PaginationData();
        paginationData.setQueryFilter(queryFilter);
        int expectedPageNum = 1;
        paginationData.setCurrentPageNum(expectedPageNum);

        Mockito.when(productService.getProductPaginationData(Matchers.<PaginationData>anyObject())).thenReturn(paginationData);

        Model returnModel = new ExtendedModelMap();
        productController.productList(queryFilter, returnModel);

        PaginationData paginationDataReturn = (PaginationData) returnModel.asMap().get("indexPage");
        Mockito.verify(productService).getProductPaginationData(Matchers.<PaginationData>anyObject());
        assertThat(expectedPageNum, is(paginationDataReturn.getCurrentPageNum()));


    }

    private QueryFilter getQueryFilter() {
        QueryFilter queryFilter = new QueryFilter();
        queryFilter.setProductCategory("1");
        queryFilter.setMinPrice("0");
        queryFilter.setMaxPrice("500");
        queryFilter.setStart(0);
        queryFilter.setSize(16);
        return queryFilter;
    }
    @Test
    public void testGetCurrentPageNum() throws Exception {
        QueryFilter queryFilter=getQueryFilter();
        queryFilter.setPageId(null);
        Model returnModel = new ExtendedModelMap();
        productController.productList(queryFilter, returnModel);
        PaginationData paginationDataReturn = (PaginationData) returnModel.asMap().get("indexPage");

        assertEquals(1,paginationDataReturn.getCurrentPageNum());

    }
}