package com.thoughtworks.shoppingweb.service;


/**
 * Created by cxzhao on 3/22/16.
 */
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.persistence.ProductMapper;
import com.thoughtworks.shoppingweb.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired

    private ProductMapper productmapper ;
    public Product getProduct(String product_id) {
        return productmapper.findProductbyId(product_id);
    }

    public ProductMapper getProductMapper() {
        return productmapper;
    }

    public void setProductMapper(ProductMapper productMapper) {
        this.productmapper = productMapper;
    }

    public List<Product> getAllProduct(){
        return productmapper.getAllProduct();

    }
}
