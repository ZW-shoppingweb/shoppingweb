package com.thoughtworks.shoppingweb.persistence;


/**
 * Created by cxzhao on 3/22/16.
 */
import com.thoughtworks.shoppingweb.domain.Product;
import org.apache.ibatis.annotations.Param;
<<<<<<< Updated upstream
=======
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;
>>>>>>> Stashed changes

import java.util.List;

public interface ProductMapper {

<<<<<<< Updated upstream

    //@Select("select * from product where productId=#{productId}")
    public Product findProductById(String productId);

    //@Select("select * from product")
    public List<Product> getAllProduct();

    //@SelectProvider(type = ImplementProduct.class, method="getPaginationProductList")
    public List<Product> getPaginationProductList(@Param("filterName") String filterName,
                                                  @Param("filterValue") String filterValue,
                                                  @Param("minPrice") String minPrice,
                                                  @Param("maxPrice") String maxPrice,
                                                  @Param("seqName") String seqName,
                                                  @Param("sequence") String sequence,
                                                  @Param("start") int start,@Param("size") int size);


   // @SelectProvider(type = ImplementProduct.class, method="getNumOfProducts")
    public int getNumOfProducts(@Param("filterName") String filterName,
                                @Param("filterValue") String filterValue,
                                @Param("minPrice") String minPrice,
                                @Param("maxPrice") String maxPrice);
=======
    @Select("select * from product where productId=#{productId}")
    public Product findProductById(String productId);

    @Select("select * from product")
    public List<Product> getAllProduct();

    @SelectProvider(type = ImplementProduct.class,method="getPaginationProductList")
    public List<Product> getPaginationProductList(@Param("filterName")String filterName,@Param("filterValue")String filterValue,@Param("start")int start,@Param("size") int size);

    @SelectProvider(type = ImplementProduct.class,method="getNumOfProducts")
    public long getNumOfProducts(@Param("filterName")String filterName,@Param("filterValue")String filterValue);
>>>>>>> Stashed changes
}






