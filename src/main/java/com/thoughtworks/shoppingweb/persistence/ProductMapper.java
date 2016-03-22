package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {

    @Select("select * from product")
    public List<Product> getAllProduct();
}
