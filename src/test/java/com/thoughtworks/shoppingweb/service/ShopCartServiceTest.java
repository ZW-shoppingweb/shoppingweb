package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.domain.Address;
import com.thoughtworks.shoppingweb.domain.ShopCart;
import com.thoughtworks.shoppingweb.persistence.AddressMapper;
import com.thoughtworks.shoppingweb.persistence.ShopCartMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

/**
 * Created by cxzhao on 4/12/16.
 */

public class ShopCartServiceTest {

    ShopCartService shopCartService;
    ShopCartMapper shopCartMapper;
    public static String userName="123456";
    @Before
    public void setup() {
        shopCartService=new ShopCartService();
        shopCartMapper= Mockito.mock(ShopCartMapper.class);
        shopCartService.setShopCartMapper(shopCartMapper);
    }

    @Test
    public void ShouldGetTrueWhenInsertShopcartSuccess() throws Exception {
        ShopCart shopCart=new ShopCart();
        when(shopCartMapper.insertToCart(shopCart)).thenReturn(1);
        assertEquals(true,shopCartService.insertToCart(shopCart));

    }

    @Test
    public void shouldGetShopCartByUserNameLimit2() throws Exception {
        List<ShopCart> mockedList=getShopcarts();
        ShopCart shopCart=new ShopCart();
        shopCart.setUserName(userName);
        when(shopCartMapper.cartProduct(userName)).thenReturn(mockedList.subList(1,3));
        assertEquals(2,shopCartService.cartProduct(userName).size());

    }
    @Test
    public void shouldGetShopCartByUserName() throws Exception {
        List<ShopCart> mockedList=getShopcarts();
        ShopCart shopCart=new ShopCart();
        shopCart.setUserName(userName);
        when(shopCartMapper.cartProduct(userName)).thenReturn(mockedList.subList(0,3));
        assertEquals(3,shopCartService.cartProduct(userName).size());
    }



    private List<ShopCart> getShopcarts() {
        List<ShopCart> mockedList = new ArrayList<ShopCart>();
        for (int i = 0; i < 3; i++){
            ShopCart shopCart=new ShopCart();
            shopCart.setUserName(userName);
            mockedList.add(shopCart);
        }
        for (int i = 3; i < 4; i++) {
            ShopCart shopCart=new ShopCart();
            shopCart.setUserName("11111");
            mockedList.add(shopCart);
        }

        return mockedList;

    }



}