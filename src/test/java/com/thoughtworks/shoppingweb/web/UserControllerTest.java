package com.thoughtworks.shoppingweb.web;

import com.sun.org.apache.xpath.internal.operations.String;
import com.thoughtworks.shoppingweb.domain.User;
import com.thoughtworks.shoppingweb.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


public class UserControllerTest {

    @InjectMocks
    UserController userController;
    @Mock
    UserService userService;
    @Mock
    HttpServletRequest request;
    @Mock
    private HttpSession session;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userController.userService = userService;
        Mockito.when(request.getSession(true)).thenReturn(session);
    }

    @Test
    public void shouldReturnUserNameWhenLoginSuccess() throws Exception {
        UserForm userForm = new UserForm();
        userForm.setPassword("123456");
        userForm.setUserName("wsz");
        Mockito.when(userService.validateUser(Matchers.<User>anyObject())).thenReturn(true);
        ResponseEntity responseEntity = userController.loginPage(userForm, request);
        Map map = new HashMap<String, Object>();
        map.put("isLogin", "yes");
        map.put("name", "wsz");
        ResponseEntity responseEntity1 = new ResponseEntity<Map>((Map<String, Object>) map, HttpStatus.OK);
        assertEquals(responseEntity1, responseEntity);
    }

    @Test
    public void shouldReturnNOLoginWhenLoginFail() throws Exception {
        UserForm userForm = new UserForm();
        userForm.setPassword("1234");
        userForm.setUserName("wsz");
        Mockito.when(userService.validateUser(Matchers.<User>anyObject())).thenReturn(false);
        ResponseEntity responseEntity = userController.loginPage(userForm, request);
        Map map = new HashMap<String, Object>();
        map.put("isLogin", "no");
        ResponseEntity responseEntity1 = new ResponseEntity<Map>((Map<String, Object>) map, HttpStatus.OK);
        assertEquals(responseEntity1, responseEntity);
    }

    @Test
    public void shouldReturnUserNameWhenRegisterSuccess() throws Exception {
        UserForm userForm = new UserForm();
        userForm.setPassword("123456");
        userForm.setUserName("zcx");
        Mockito.when(userService.addUser(Matchers.<User>anyObject())).thenReturn(true);
        ResponseEntity responseEntity = userController.registerPage(userForm, request);
        Map map = new HashMap<String, Object>();
        map.put("isLogin", "yes");
        map.put("name", "zcx");
        ResponseEntity responseEntity1 = new ResponseEntity<Map>((Map<String, Object>) map, HttpStatus.OK);
        assertEquals(responseEntity1, responseEntity);
    }

    @Test
    public void shouldReturnNotLoginWhenRegisterFail() throws Exception {
        UserForm userForm = new UserForm();
        userForm.setPassword("123456");
        userForm.setUserName("wsz");
        Mockito.when(userService.addUser(Matchers.<User>anyObject())).thenReturn(false);
        ResponseEntity responseEntity = userController.registerPage(userForm, request);
        Map map = new HashMap<String, Object>();
        map.put("isLogin", "no");
        ResponseEntity responseEntity1 = new ResponseEntity<Map>((Map<String, Object>) map, HttpStatus.OK);
        assertEquals(responseEntity1, responseEntity);
    }

    @Test
    public void shouldReturnNotLoginWhenSignOut() throws Exception {
        ResponseEntity responseEntity = userController.signOutAction(request);
        Map map = new HashMap<String, Object>();
        map.put("isLogin", "no");
        ResponseEntity responseEntity1 = new ResponseEntity<Map>((Map<String, Object>) map, HttpStatus.OK);
        assertEquals(responseEntity1, responseEntity);
    }
}