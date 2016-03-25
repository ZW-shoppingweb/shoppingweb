package com.thoughtworks.shoppingweb.persistence;


/**
 * Created by cxzhao on 3/22/16.
 */
import com.thoughtworks.shoppingweb.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

import java.util.List;

public interface ProductMapper {
    @Select("select * from product where productId=#{productId}")
    public Product findProductById(String productId);
    @Select("select * from product")
    public List<Product> getAllProduct();

    @Select("select * from product limit ${start}, ${size}")
    public List<Product> getPaginationProductList(int start, int size);

    @Select("select count(1) from product")
    public long getNumOfProducts();
}





