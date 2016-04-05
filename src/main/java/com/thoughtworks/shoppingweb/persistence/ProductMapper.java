package com.thoughtworks.shoppingweb.persistence;


/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.service.page.QueryFilter;
import com.thoughtworks.shoppingweb.web.ShopCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {


    public Product findProductById(String productId);

    public List<Product> getAllProduct(@Param("start") int start, @Param("size") int size);

    public List<Product> getPaginationProductList(QueryFilter queryFilter);

    public int getNumOfProducts(@Param("productCategory") String productCategory,
                                @Param("minPrice") String minPrice,
                                @Param("maxPrice") String maxPrice);

    public int insertToCart(ShopCart shopCart);
    public List<Product> cartProduct();

}






