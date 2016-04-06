package com.thoughtworks.shoppingweb.service;


/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.persistence.ProductMapper;
import com.thoughtworks.shoppingweb.service.page.PaginationData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;
    private final static Logger logPrint = Logger.getLogger(ProductService.class);

    public Product getProduct(String productId) {
        return productMapper.findProductById(productId);
    }

    public ProductMapper getProductMapper() {
        return productMapper;
    }

    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> getAllProduct(int start, int size) {
        return productMapper.getAllProduct(start, size);
    }

    public PaginationData getProductPaginationData(PaginationData paginationData) {
        String productCategory = paginationData.getQueryFilter().getProductCategory();
        String minPrice = paginationData.getQueryFilter().getMinPrice();
        String maxPrice = paginationData.getQueryFilter().getMaxPrice();
        int rowCount = productMapper.getNumOfProducts(productCategory, minPrice, maxPrice);
        paginationData.getQueryFilter().setStart((paginationData.getCurrentPageNum() - 1) * paginationData.getPageSize());
        paginationData.getQueryFilter().setSize(paginationData.getPageSize());
        paginationData.setMaxCount(rowCount);
        List<Product> productList = productMapper.getPaginationProductList(paginationData.getQueryFilter());
        paginationData.setPageData(productList);
        return paginationData;

    }
}

