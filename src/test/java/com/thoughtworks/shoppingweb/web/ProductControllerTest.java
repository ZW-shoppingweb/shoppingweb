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
import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by cxzhao on 3/29/16.
 */
public class ProductControllerTest {
    @InjectMocks
    ProductController productController;
    @Mock
    ProductService productService;
    @Mock
    HttpServletRequest request;
    @Mock
    HistoryService historyService;
    @Mock
    private HttpSession session;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(request.getSession(true)).thenReturn(session);
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
        productController.getProduct("123456",user.getUserName(),returnModel,request);
        Product product=(Product) returnModel.asMap().get("product");
        assertEquals(productdetail.getProductId(),product.getProductId());

    }

    @Test
    public void createHistory() throws Exception {
        List<History> historys=new ArrayList<History>();
        History history=new History();
        User user=new User();
        user.setUserName("1");
        historys.add(history);
        Mockito.when(historyService.insertHistory(user,history)).thenReturn(true);
        Mockito.when(historyService.getHistoryByUser(user.getUserName())).thenReturn(historys);
        Model returnModel = new ExtendedModelMap();
        productController.createHistory(user,"1",returnModel);
        List<History> acturHistorys=(List<History>)returnModel.asMap().get("history");
        assertEquals(historys,acturHistorys);
    }

    @Test
    public void createUserWhenUserNameIsNotNull() throws Exception {
        User user=new User();
        user.setUserName("1");
       User user1= productController.createUser(user.getUserName(),request);
      assertEquals(user.getUserName(),user1.getUserName());
    }
    @Test
    public void createUserWhenUserNameIsNull() throws Exception {
        User user=new User();
        User user1= productController.createUser(user.getUserName(),request);
       assertNotNull(user1.getUserName());
    }
}