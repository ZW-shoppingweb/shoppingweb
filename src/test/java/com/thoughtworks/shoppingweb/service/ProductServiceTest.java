package com.thoughtworks.shoppingweb.service;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.persistence.ProductMapper;
import com.thoughtworks.shoppingweb.service.page.PaginationData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cxzhao on 3/25/16.
 */
public class ProductServiceTest {

    ProductService productService;
    ProductMapper productMapper;

    @Before
    public void setup() {
        productService = new ProductService();
        productMapper = Mockito.mock(ProductMapper.class);
        productService.setProductMapper(productMapper);
    }


    @Test
    public void testGetProductPaginationData() throws Exception {

        List<Product> mockedList = getProducts();
        Mockito.when(productMapper.getPaginationProductList("productCategory","1","0","500","productPrice","ASC",0, 16)).thenReturn(mockedList.subList(0, 12));
        Mockito.when(productMapper.getPaginationProductList("productCategory","1","0","500","productPrice","ASC",16, 16)).thenReturn(Collections.<Product>emptyList());

        PaginationData pd = new PaginationData();

        pd.setCurrentPageNum(1);
        pd.setPageSize(16);
        pd.createQueryFilter("productCategory","1","0","500","productPrice","ASC");

        pd.setMaxCount(mockedList.size());

        pd = productService.getProductPaginationData(pd);


        assertEquals(12, pd.getPageData().size());


        pd.setCurrentPageNum(2);

        pd = productService.getProductPaginationData(pd);

        assertEquals(0, pd.getPageData().size());

    }

    private List<Product> getProducts() {
        List<Product> mockedList = new ArrayList<Product>();
        for (int i = 0; i < 12; i++){
            Product product=new Product();
            product.setProductCategory("1");
            product.setProductPrice((double) 490);
            mockedList.add(product);
        }
        for (int i = 12; i < 28; i++) {
            mockedList.add(new Product());
        }
        return mockedList;

    }
}
