package com.thoughtworks.shoppingweb.persistence;


/**
 * Created by cxzhao on 3/22/16.
 */
import com.thoughtworks.shoppingweb.domain.Product;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ProductMapper {


    //@Select("select * from product where productId=#{productId}")
    public Product findProductById(String productId);

    //@Select("select * from product")
    public List<Product> getAllProduct(@Param("start") int start,@Param("size") int size);

    //@SelectProvider(type = ImplementProduct.class, method="getPaginationProductList")
    public List<Product> getPaginationProductList(@Param("productCategory") String filterName,
                                                  @Param("minPrice") String minPrice,
                                                  @Param("maxPrice") String maxPrice,
                                                  @Param("productPrice") String productPrice,
                                                  @Param("productName") String productName,
                                                  @Param("start") int start,@Param("size") int size);


   // @SelectProvider(type = ImplementProduct.class, method="getNumOfProducts")
    public int getNumOfProducts(@Param("productCategory") String productCategory,
                                @Param("minPrice") String minPrice,
                                @Param("maxPrice") String maxPrice);

}






