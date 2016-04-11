package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.Address;

import java.util.List;

/**
 * Created by cxzhao on 4/11/16.
 */
public interface AddressMapper {
    public List<Address> addresses(String userName);
}
