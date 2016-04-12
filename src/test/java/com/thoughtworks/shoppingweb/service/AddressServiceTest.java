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
    public void testGetAddress() throws Exception {
        List<Address> mockedList = getAddresses();
        when(addressMapper.addresses("123456")).thenReturn(mockedList.subList(0,3));
        List<Address> address=addressService.getaddresses("123456");
        assertEquals(3,address.size());
    }

    @Test
    public void testGetCheckAddress() throws Exception {
        List<Address> mockedList = getAddresses();
        when(addressMapper.getCheckAddress()).thenReturn(mockedList.get(mockedList.size()-1));

        assertEquals(mockedList.get(mockedList.size()-1).getUserName(),addressService.getCheckAddress().getUserName());
    }

    @Test
    public void testInsertAddress() throws Exception {
        Address address=new Address();
       when(addressMapper.insertAddress(address)).thenReturn(1);
        assertEquals(true,addressService.insertAddress(address));
    }


    @Test
    public void testSelectAddressById() throws Exception {
        Address address=new Address();
        address.setUserName("11111");
        address.setAddressId("12");
        List<Address> mockedList = getAddresses();
        when(addressMapper.selectAddressById(address)).thenReturn(mockedList.get(mockedList.size()-1));
       Address address1=addressService.selectAddressById(address);
        assertEquals(mockedList.get(mockedList.size()-1).getUserName(),address1.getUserName());

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