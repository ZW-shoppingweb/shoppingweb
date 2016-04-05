package com.thoughtworks.shoppingweb.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by szwang on 3/22/16.
 */
@Data
public class History {
    private int historyId;
    private String userName;
    private String productId;
    private Timestamp seeTime;

    private Product product;
}
