package com.thoughtworks.shoppingweb.web;

import com.thoughtworks.shoppingweb.domain.Address;
import com.thoughtworks.shoppingweb.domain.Orders;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.domain.ShopCart;
import com.thoughtworks.shoppingweb.service.AddressService;
import com.thoughtworks.shoppingweb.service.OrderService;
import com.thoughtworks.shoppingweb.service.ShopCartService;
import com.thoughtworks.shoppingweb.service.UserService;
import com.thoughtworks.shoppingweb.service.page.PaginationData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.intThat;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

/**
 * Created by cxzhao on 4/12/16.
 */
public class AddressControllerTest {
    @InjectMocks
    AddressController addressController;
    @Mock
    AddressService addressService;
    @Mock
    OrderService orderService;
    @Mock
    ShopCartService shopCartService;
    @Mock
    UserService userService;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        addressController.addressService=addressService;
        addressController.orderService=orderService;
        addressController.shopCartService=shopCartService;
        addressController.userService=userService;
    }

    @Test
    public void shouldInsertAddressSuccessWhenAddressIdIsNull() throws Exception {
        Address address=new Address();
        address.setUserName("12345");
        Mockito.when(addressService.insertAddress(Matchers.<Address>anyObject())).thenReturn(true);
        Mockito.when(addressService.getLastAddress()).thenReturn(address);
        Model returnModel = new ExtendedModelMap();
        addressController.productCart(address,returnModel);
        Address address1=(Address)returnModel.asMap().get("address");
       assertEquals(address.getUserName(),address1.getUserName());
    }
    @Test
    public void shouldNotInsertAddressSuccessWhenAddressIdIsNotNull() throws Exception {
        Address address=new Address();
        address.setAddressId("123");
        Mockito.when(addressService.selectAddressById(address)).thenReturn(address);
        Model returnModel = new ExtendedModelMap();
        addressController.productCart(address,returnModel);
        Address address1=(Address)returnModel.asMap().get("address");
        assertEquals(address.getAddressId(),address1.getAddressId());

    }
    @Test
    public void shouldGetOrderListFromModel() throws Exception {
        List<Orders> expectedorders=new ArrayList<Orders>();
       String userName="123456";
        Orders order=new Orders();
        expectedorders.add(order);
        Model returnModel = new ExtendedModelMap();
        when(orderService.selectOrderByUserName(userName)).thenReturn(expectedorders);
       addressController.selectOrderInfo(userName,returnModel);
        List<Orders> orders=(List<Orders>)returnModel.asMap().get("orderList");
        assertEquals(expectedorders.get(0),orders.get(0));
    }
    @Test
    public void shouldGetTotalNumFromModel() throws Exception {
        String userName="123456";
        List<ShopCart> shopCarts=getShopCarts();
        Model returnModel = new ExtendedModelMap();
        Mockito.when(shopCartService.allCartProduct(userName)).thenReturn(shopCarts);
        Mockito.when(userService.searchUser(userName)).thenReturn(true);
        addressController.selectOrderInfo(userName,returnModel);
       int totalNum=Integer.valueOf(String.valueOf(returnModel.asMap().get("totalNum"))).intValue();
        assertEquals(1,totalNum);
    }
    @Test
    public void shouldGetTotalPriceFromModel() throws Exception {
        String userName="123456";
        List<ShopCart> shopCarts=getShopCarts();
        Model returnModel = new ExtendedModelMap();
        Mockito.when(shopCartService.allCartProduct(userName)).thenReturn(shopCarts);
        Mockito.when(userService.searchUser(userName)).thenReturn(true);
        addressController.selectOrderInfo(userName,returnModel);
       Object totalPrice =returnModel.asMap().get("totalPrice");
        assertEquals(100.0,totalPrice);
    }
    public List<ShopCart> getShopCarts(){
        String userName="123456";
        List<ShopCart> shopCarts=new ArrayList<ShopCart>();
        ShopCart shopCart=new ShopCart();
            Product product=new Product();
            product.setProductId("1");
            product.setProductVipPrice(100.0);
            shopCart.setProductNum("1");
            shopCart.setUserName(userName);
            shopCart.setProductId(product.getProductId());
            shopCart.setProduct(product);
            shopCarts.add(shopCart);
        return shopCarts;
        }

}