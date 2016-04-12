package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

@Data
public class Address {
    private String addressId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userName;
    private String province;
    private String city;
    private String street;
    private String statsuOrder;
}
