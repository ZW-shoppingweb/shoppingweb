package com.thoughtworks.shoppingweb.web;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.service.ProductService;
import com.thoughtworks.shoppingweb.service.page.PaginationData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cxzhao on 3/29/16.
 */
public class ProductControllerTest {
    ProductService productService;
    ProductController productController;
@Before
public void setup(){
    productController=new ProductController();
    productService= Mockito.mock(ProductService.class);
    productController.setProductService(productService);
  }

    @Test
    public void testProductList() throws Exception {
        List<Product> mokitoList=new ArrayList<Product>();
        //productController.productList("productCategory","1",1,"0","500","price","ASC",0,16,mokitoList);
        PaginationData pd = new PaginationData();

    }
}