package com.thoughtworks.shoppingweb.persistence;


/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.domain.ShopCart;

import java.util.List;

public interface ShopCartMapper {

    public int insertToCart(ShopCart shopCart);
    public List<ShopCart> cartProduct(String userName);
    public List<ShopCart>allCartProduct(String userName);
    public int updateShopCart(ShopCart shopCart);
    public ShopCart findExistedShopCart(ShopCart shopCart);
}






