package com.thoughtworks.shoppingweb.service;

import com.thoughtworks.shoppingweb.domain.History;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.persistence.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Timestamp;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class HistoryServiceTest {

    @InjectMocks
    HistoryService historyService;
    @Mock
    UserMapper userMapper;
    @Mock
    HistoryMapper historyMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        historyService.userMapper = userMapper;
        historyService.historyMapper = historyMapper;
    }

    @Test
    public void shouldReturnTrueWhenGivenTheUserIsNotNullAndHistoryIsExisted() throws Exception {
        User user = new User();
        user.setUserName("wsz");

        History history = new History();
        history.setProductId("1");
        history.setUserName("wsz");

        History history1 = new History();
        history1.setProductId("1");
        history1.setUserName("wsz");
        history1.setSeeTime(new Timestamp(System.currentTimeMillis()));

        when(userMapper.findUserByName(user)).thenReturn(user);
        when(historyMapper.findHistory(history)).thenReturn(history1);
        when(historyMapper.updateTime(history)).thenReturn(1);

        assertEquals(true, historyService.insertHistory(user,history));
    }

    @Test
    public void updateHistorySuccessWhenUserExistedAndHistoryNotExisted() throws Exception {
        User user = new User();
        user.setUserName("wsz");

        History history = new History();
        history.setProductId("4");
        history.setUserName("wsz");

        when(userMapper.findUserByName(user)).thenReturn(user);
        when(historyMapper.findHistory(history)).thenReturn(null);
        when(historyMapper.insertHistory(history)).thenReturn(1);
        assertEquals(true, historyService.insertHistory(user,history));
    }
    @Test
    public void updateHistorySuccessWhenUserIsNotExisted() throws Exception {
        User user = new User();
        user.setUserName("wszz");

        History history = new History();
        history.setProductId("1");
        history.setUserName("wszz");

        when(userMapper.findUserByName(user)).thenReturn(null);
        when(userMapper.insertUser(user)).thenReturn(1);
        when(historyMapper.insertHistory(history)).thenReturn(1);
        assertEquals(true, historyService.insertHistory(user,history));
    }
    @Test
    public void updateHistoryFailWhenUserExistedAndHistoryExisted() throws Exception {

        User user =new User();
        user.setUserName("wsz");

        History history = new History();
        history.setUserName("wsz");
        history.setProductId("1");

        when(userMapper.findUserByName(user)).thenReturn(user);
        when(historyMapper.findHistory(history)).thenReturn(history);
        when(historyMapper.updateTime(history)).thenReturn(0);

        assertEquals(false,historyService.insertHistory(user,history));
    }
    @Test
    public void insertHistoryFailWhenUserExistedAndHistoryNotExisted() throws Exception {
        User user =new User();
        user.setUserName("wsz");

        History history = new History();
        history.setUserName("wsz");
        history.setProductId("1");

        when(userMapper.findUserByName(user)).thenReturn(user);
        when(historyMapper.findHistory(history)).thenReturn(null);
        when(historyMapper.insertHistory(history)).thenReturn(0);

        assertEquals(false,historyService.insertHistory(user,history));
    }
    @Test
    public void insertHistoryFailWhenUserNotExisted() throws Exception {
        User user =new User();
        user.setUserName("312312");

        History history = new History();
        history.setUserName("312312");
        history.setProductId("1");

        when(userMapper.findUserByName(user)).thenReturn(null);
        when(userMapper.insertUser(user)).thenReturn(1);
        when(historyMapper.insertHistory(history)).thenReturn(0);

        assertEquals(false,historyService.insertHistory(user,history));
    }
    @Test
    public void shouldNotNullWhenHistoryExisted() throws Exception {
        String userName="wsz";
        when(historyMapper.getHistoryByUser(userName)).thenReturn(new ArrayList<History>());
        assertNotNull(historyMapper.getHistoryByUser(userName));
    }
    @Test
    public void shouldBeNullWhenOrderNotExistedInOrder() throws Exception {
        String userName="123";
        when(historyMapper.getHistoryByUser(userName)).thenReturn(null);
        assertNull(historyMapper.getHistoryByUser(userName));
    }
}