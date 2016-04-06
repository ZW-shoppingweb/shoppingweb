package com.thoughtworks.shoppingweb.service;


/**
 * Created by cxzhao on 3/22/16.
 */

import com.thoughtworks.shoppingweb.domain.ShopCart;
import com.thoughtworks.shoppingweb.persistence.ShopCartMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCartService {

    @Autowired
    private ShopCartMapper shopCartMapper;
    private final static Logger logPrint = Logger.getLogger(ShopCartService.class);
    public ShopCartMapper getShopCartMapper() {
        return shopCartMapper;
    }

    public void setShopCartMapper(ShopCartMapper shopCartMapper) {
        this.shopCartMapper = shopCartMapper;
    }

    public boolean insertToCart(ShopCart shopCart){
        if(shopCartMapper.findExistedShopCart(shopCart) !=null){
           return (shopCartMapper.updateShopCart(shopCart))>0;
        }
        else {
            boolean insertResult;
            try {
                insertResult= (shopCartMapper.insertToCart(shopCart)>0);
            }catch (Exception e) {
                logPrint.error(e);
                insertResult = false;
            }
            return insertResult;
        }
    }
    public List<ShopCart> cartProduct(String userName){
        return shopCartMapper.cartProduct(userName);
    }
    public  List<ShopCart>allCartProduct(String userName){return shopCartMapper.allCartProduct(userName);}
}
