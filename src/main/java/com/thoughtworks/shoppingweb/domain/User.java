package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

@Data
public class User {
    public static final String DEFAULT_TOURIST_TYPE = "tourist";
    public static final String DEFAULT_PASSWORD = "123456";
    private String userName;
    private String password=DEFAULT_PASSWORD;
    private String userType=DEFAULT_TOURIST_TYPE;

}
