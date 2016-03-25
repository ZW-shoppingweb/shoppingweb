package com.thoughtworks.shoppingweb.service;


/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.persistence.ProductMapper;
import com.thoughtworks.shoppingweb.persistence.UserMapper;
import com.thoughtworks.shoppingweb.service.page.PaginationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product getProduct(String productId) {
        return productMapper.findProductById(productId);
    }

    public ProductMapper getProductMapper() {
        return productMapper;
    }

    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public List<Product> getAllProduct() {
        return productMapper.getAllProduct();

    }

    public PaginationData getProductPaginationData(PaginationData paginationData) {
        long rowCount = productMapper.getNumOfProducts();
        paginationData.setMaxCount(rowCount);
        List<Product> productList = productMapper.getPaginationProductList(
                (paginationData.getCurrentPageNum() - 1) * paginationData.getPageSize(),
                paginationData.getPageSize());
        paginationData.setPageData(productList);
        return paginationData;


    }
}
