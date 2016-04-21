package com.thoughtworks.shoppingweb.service;


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
        int rowCount = productMapper.getNumOfProducts(paginationData.getQueryFilter());
        paginationData.getQueryFilter().setStart((paginationData.getCurrentPageNum() - 1) * paginationData.getQueryFilter().getSize());
        paginationData.setMaxCount(rowCount);
        List<Product> productList = productMapper.getPaginationProductList(paginationData.getQueryFilter());
        paginationData.setPageData(productList);
        return paginationData;

    }
    public List<Product> getThreeNewProduct(){
        return productMapper.getThreeNewProduct();
    }
}

