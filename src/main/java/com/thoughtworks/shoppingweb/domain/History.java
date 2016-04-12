package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class History {
    private int historyId;
    private String userName;
    private String productId;
    private Timestamp seeTime;

    private Product product;

}
