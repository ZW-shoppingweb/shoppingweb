package com.thoughtworks.shoppingweb.persistence;

import com.thoughtworks.shoppingweb.domain.Address;

import java.util.List;

public interface AddressMapper {
    public List<Address> addresses(String userName);
    public Address getCheckAddress();
    public int insertAddress(Address address);
    public Address selectAddressById(Address address);
}
