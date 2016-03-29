package com.thoughtworks.shoppingweb.web;
import com.thoughtworks.shoppingweb.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import  org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
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
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

    }
}