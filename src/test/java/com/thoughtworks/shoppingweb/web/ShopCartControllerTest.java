package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.Address;
import com.thoughtworks.shoppingweb.domain.ShopCart;
import com.thoughtworks.shoppingweb.service.AddressService;
import com.thoughtworks.shoppingweb.service.ShopCartService;
import com.thoughtworks.shoppingweb.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by szwang on 4/12/16.
 */
public class ShopCartControllerTest {
    @InjectMocks
    ShopCartController shopCartController;
    @Mock
    ShopCartService shopCartService;
    @Mock
    UserService userService;
    @Mock
    AddressService addressService;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        shopCartController.shopCartService = shopCartService;
        shopCartController.userService=userService;
        shopCartController.addressService=addressService;
    }
    @Test
    public void shouldReturnTrueWhenInsertShopCartSuccess() throws Exception {
        ShopCart shopCart=new ShopCart();
        Mockito.when(shopCartService.insertToCart(shopCart)).thenReturn(true);
        ResponseEntity responseEntity=shopCartController.productCart(shopCart);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(true,responseEntity.getBody());
    }
    @Test
    public void shouldReturnFalseWhenInsertShopCartFail() throws Exception {
        ShopCart shopCart=new ShopCart();
        Mockito.when(shopCartService.insertToCart(shopCart)).thenReturn(false);
        ResponseEntity responseEntity=shopCartController.productCart(shopCart);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(false,responseEntity.getBody());
    }
    @Test
    public void shouldReturnNotNullWhenSelectShopCartSuccess() throws Exception {
        String userName="wsz";
        Mockito.when(shopCartService.cartProduct(userName)).thenReturn(new ArrayList<ShopCart>());
        Mockito.when(shopCartService.allCartProduct(userName)).thenReturn(new ArrayList<ShopCart>());
        Mockito.when(userService.searchUser(userName)).thenReturn(true);

        ResponseEntity responseEntity=shopCartController.shopCartShow(userName);
        Map map=new HashMap<String, Object>();
        map.put("cartProduct",new ArrayList<ShopCart>());
        map.put("allCartProduct",new ArrayList<ShopCart>());
        map.put("searchUser",true);
        ResponseEntity responseEntity1= new ResponseEntity<Map>((Map<String, Object>) map, HttpStatus.OK);
        assertEquals(responseEntity1,responseEntity);
    }
    @Test
    public void shouldReturnNotNullWhenGoToMySHopCartSuccess() throws Exception {
        String userName="wsz";
        List<ShopCart> shopCarts=new ArrayList<ShopCart>();
        List<Address> addresses=new ArrayList<Address>();
        Mockito.when(shopCartService.allCartProduct(userName)).thenReturn(shopCarts);
        Mockito.when(addressService.getaddresses(userName)).thenReturn(addresses);
        Model returnModel = new ExtendedModelMap();
        shopCartController.goToMyShopCart(userName,returnModel);
        List<ShopCart> shopCarts1 = (List<ShopCart>) returnModel.asMap().get("allCartProduct");
        assertEquals(shopCarts, shopCarts1);
        List<Address> addresses1 = (List<Address>) returnModel.asMap().get("allAddresses");
        assertEquals(addresses, addresses1);
    }
}