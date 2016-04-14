package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.History;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.service.HistoryService;
import com.thoughtworks.shoppingweb.service.ProductService;
import com.thoughtworks.shoppingweb.service.page.PaginationData;
import com.thoughtworks.shoppingweb.service.page.QueryFilter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
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
    @InjectMocks
    ProductController productController;
    @Mock
    ProductService productService;
    @Mock
    HistoryService historyService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productController.productService=productService;
        productController.historyService=historyService;

    }

    @Test
    public void shouldGetCurrentPageNumWhenPageIdIsOne() throws Exception {
        List<Product> mokitoList = new ArrayList<Product>();
        QueryFilter queryFilter = getQueryFilter();
        int expectedPageNum = 1;
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
    public void shouldGetCurrentPageWhenPageIdIsNull() throws Exception {
        QueryFilter queryFilter=getQueryFilter();
        queryFilter.setPageId(null);
        Model returnModel = new ExtendedModelMap();
        productController.productList(queryFilter, returnModel);
        PaginationData paginationDataReturn = (PaginationData) returnModel.asMap().get("indexPage");

        assertEquals(1,paginationDataReturn.getCurrentPageNum());
    }

    @Test
    public void shouldGetDetailProductWhenInputProductId() throws Exception {
        Product productdetail=new Product();
        History history=new History();
        User user=new User();
        user.setUserName("1");
        productdetail.setProductId("123456");
        Mockito.when(productService.getProduct("123456")).thenReturn(productdetail);
        Mockito.when(historyService.insertHistory(user,history)).thenReturn(true);
        Model returnModel = new ExtendedModelMap();
        MockHttpServletRequest request = new MockHttpServletRequest();
        productController.getProduct("123456",user.getUserName(),returnModel,request);
        Product product=(Product) returnModel.asMap().get("product");
        assertEquals(productdetail.getProductId(),product.getProductId());

    }
}