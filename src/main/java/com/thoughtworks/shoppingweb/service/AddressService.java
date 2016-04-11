package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.domain.Address;
import com.thoughtworks.shoppingweb.persistence.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cxzhao on 4/11/16.
 */
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;
    public List<Address>getaddresses(String username){
        return addressMapper.addresses(username);
    }
}
