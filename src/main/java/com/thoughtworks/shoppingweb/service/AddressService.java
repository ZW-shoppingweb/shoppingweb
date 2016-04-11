package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.domain.Address;
import com.thoughtworks.shoppingweb.persistence.AddressMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cxzhao on 4/11/16.
 */
@Service
public class AddressService {
    @Autowired
    private AddressMapper addressMapper;
    private final static Logger logPrint = Logger.getLogger(ShopCartService.class);
    public List<Address>getaddresses(String username){
        return addressMapper.addresses(username);
    }
    public boolean insertAddress(Address address){
        address.setStatsuOrder("checkout");
        boolean insertResult;
        try {
            insertResult= (addressMapper.insertAddress(address)>0);
        }catch (Exception e) {
            logPrint.error(e);
            insertResult = false;
        }
        return insertResult;

    }
    public Address getCheckAddress(){return addressMapper.getCheckAddress();}

}
