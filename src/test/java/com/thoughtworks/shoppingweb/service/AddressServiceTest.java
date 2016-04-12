package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.domain.Address;
import com.thoughtworks.shoppingweb.domain.Product;
import com.thoughtworks.shoppingweb.persistence.AddressMapper;
import com.thoughtworks.shoppingweb.persistence.ProductMapper;
import javafx.beans.binding.When;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

/**
 * Created by cxzhao on 4/12/16.
 */
public class AddressServiceTest {
    AddressService addressService;
    AddressMapper  addressMapper;
    @Before
    public void setup() {
        addressService=new AddressService();
        addressMapper= Mockito.mock(AddressMapper.class);
        addressService.setAddressMapper(addressMapper);
    }

    @Test
    public void shouldGetAddressWhenSelectByUserName() throws Exception {
        List<Address> mockedList = getAddresses();
        String userName="123456";
        when(addressMapper.addresses(userName)).thenReturn(mockedList.subList(0,3));
        List<Address> address=addressService.getaddresses(userName);
        assertEquals(3,address.size());
    }
    @Test
    public void shouldGetAddressWhenSelectNotByUserName() throws Exception {
        List<Address> mockedList = getAddresses();
        String userName="1";
        when(addressMapper.addresses(userName)).thenReturn(Collections.<Address>emptyList());
        List<Address> address=addressService.getaddresses(userName);
        assertEquals(0,address.size());
    }


    @Test
    public void shouldGetLastAddressWhenUseLastAddressFunction() throws Exception {
        List<Address> mockedList = getAddresses();
        when(addressMapper.getLastAddress()).thenReturn(mockedList.get(mockedList.size()-1));
        assertEquals(mockedList.get(mockedList.size()-1).getUserName(),addressService.getLastAddress().getUserName());
    }
    @Test
    public void ShouldGetTrueWhenInsertAddressSuccess() throws Exception {
        Address address=new Address();
       when(addressMapper.insertAddress(address)).thenReturn(1);
        assertEquals(true,addressService.insertAddress(address));
    }
    @Test
    public void ShouldGetFalseWhenInsertAddressFailed() throws Exception {
        Address address=new Address();
        when(addressMapper.insertAddress(address)).thenReturn(0);
        assertEquals(false,addressService.insertAddress(address));
    }


    @Test
    public void shouldGetAddressByAddressId() throws Exception {
        Address address=new Address();
        address.setUserName("11111");
        address.setAddressId("12");
        List<Address> mockedList = getAddresses();
        when(addressMapper.selectAddressById(address)).thenReturn(mockedList.get(mockedList.size()-1));
       Address address1=addressService.selectAddressById(address);
        assertEquals(mockedList.get(mockedList.size()-1).getUserName(),address1.getUserName());

    }

    @Test
    public void shouldNotGetAddressNotByAddressId() throws Exception {
        Address address=new Address();
        address.setUserName("11111");
        address.setAddressId("1");
        List<Address> mockedList = getAddresses();
        when(addressMapper.selectAddressById(address)).thenReturn(new Address());
        Address address1=addressService.selectAddressById(address);
        assertEquals(null,address1.getUserName());

    }

    private List<Address> getAddresses() {
        List<Address> mockedList = new ArrayList<Address>();
        for (int i = 0; i < 3; i++){
            Address address=new Address();
            address.setUserName("123456");
            mockedList.add(address);
        }
        for (int i = 3; i < 4; i++) {
            Address address=new Address();
            address.setUserName("11111");
            address.setAddressId("12");
            mockedList.add(address);
        }

        return mockedList;

    }

}