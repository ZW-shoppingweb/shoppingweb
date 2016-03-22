package com.thoughtworks.shoppingweb.persistence;


/**
 * Created by cxzhao on 3/22/16.
 */
import com.thoughtworks.shoppingweb.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import java.util.*;

import java.util.List;
public interface ProductMapper {
    @Select("select * from product where product_id=#{product_id}")
    public Product findProductbyId(String product_id);
    @Select("select * from product")
    public List<Product> getAllProduct();
}





