package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.persistence.HistoryMapper;
import com.thoughtworks.shoppingweb.persistence.UserMapper;
import org.junit.Before;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by szwang on 4/6/16.
 */
public class HistoryServiceTest {
    HistoryService historyService;
    HistoryMapper historyMapper;


    @Before
    public void setUp() throws Exception {
        historyService=new HistoryService();
        historyMapper= Mockito.mock(HistoryMapper.class);
        historyService.setHistoryMapper(historyMapper);
    }

}