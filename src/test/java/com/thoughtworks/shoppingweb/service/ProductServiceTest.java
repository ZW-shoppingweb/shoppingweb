//package com.thoughtworks.shoppingweb.service;
//
//import com.thoughtworks.shoppingweb.domain.Product;
//import com.thoughtworks.shoppingweb.persistence.ProductMapper;
//import com.thoughtworks.shoppingweb.service.page.PaginationData;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Created by cxzhao on 3/25/16.
// */
//public class ProductServiceTest {
//
//    ProductService productService;
//    ProductMapper productMapper;
//
//    @Before
//    public void setup() {
//        productService = new ProductService();
//        productMapper = Mockito.mock(ProductMapper.class);
//        productService.setProductMapper(productMapper);
//    }
//
//
//    @Test
//    public void testGetProductPaginationData() throws Exception {
//        List<Product> mockedList = new ArrayList<Product>();
//        for (int i = 0; i < 28; i++) {
//            mockedList.add(new Product());
//        }
//        Mockito.when(productMapper.getPaginationProductList(0, 16)).thenReturn(mockedList.subList(0, 16));
//        Mockito.when(productMapper.getPaginationProductList(16, 16)).thenReturn(
//                mockedList.subList(16, mockedList.size()));
//        PaginationData pd = new PaginationData();
//
//        pd.setCurrentPageNum(1);
//        pd.setPageSize(16);
//        pd.setMaxCount(mockedList.size());
//
//        pd = productService.getProductPaginationData(pd);
//
//        assertEquals(16, pd.getPageData().size());
//
//        pd.setCurrentPageNum(2);
//
//        pd = productService.getProductPaginationData(pd);
//
//        assertEquals(12, pd.getPageData().size());
//
//    }
//}
>>>>>>> Stashed changes
