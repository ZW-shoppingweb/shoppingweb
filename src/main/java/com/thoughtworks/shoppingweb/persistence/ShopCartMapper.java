package com.thoughtworks.shoppingweb.persistence;


import com.thoughtworks.shoppingweb.domain.ShopCart;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShopCartMapper {

    public int insertToCart(ShopCart shopCart);

    public List<ShopCart> cartProduct(String userName);

    public List<ShopCart> allCartProduct(String userName);

    public int updateShopCart(ShopCart shopCart);

    public int addShopCartToOrder(ShopCart shopCart);

    public ShopCart findExistedShopCart(ShopCart shopCart);

    public int deleteShopCartByUser(ShopCart shopCart);
//    public int getAllProductNumOfUser(String userName);
}






