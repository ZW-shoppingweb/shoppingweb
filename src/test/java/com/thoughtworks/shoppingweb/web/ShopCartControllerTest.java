package com.thoughtworks.shoppingweb.web;

import com.sun.org.apache.xpath.internal.operations.String;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.service.ShopCartService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by szwang on 4/12/16.
 */
public class ShopCartControllerTest {
    @InjectMocks
    ShopCartController shopCartController;
    @Mock
    ShopCartService shopCartService;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        shopCartController.shopCartService = shopCartService;
    }

}