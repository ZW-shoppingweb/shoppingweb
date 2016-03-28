<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/libs/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="/css/libs/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<script type="application/javascript" src="<c:url value="/js/jquery-2.2.1.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/angular.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/scripts/header.js"/>"></script>
<link rel="StyleSheet" href="<c:url value="/css/headStyle.css"/>" type="text/css" media="screen"/>

<div  ng-controller="userController as userCtrl">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">购物网站</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/productList"/>">首页</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">我的购物车</a></li>
                <li><a href="javascript:void(0);" ng-click="userCtrl.loginShow()" ng-model="userCtrl.isSignInFlag">{{userCtrl.isSignIn}}</a></li>
                <li><a>{{userCtrl.userNameInNav}}</a></li>
                <li><a href="#" >{{userCtrl.isRegister}}</a></li>
                <li><a href="javascript:void(0);" ng-click="userCtrl.signOut()">{{userCtrl.isSignOut}}</a></li>
            </ul>
        </div>
    </nav>
    <div class="loginForm">
        <p class="center">欢迎!请登录</p>
        <div class="form-group">
            <label>用户名</label>
            <input type="text" class="form-control" id="inputEmail1" placeholder="User Name" ng-model="userCtrl.userName">
        </div>
        <div class="form-group">
            <label for="inputPassword1">密码</label>
            <input type="password" class="form-control" id="inputPassword1" placeholder="Password" ng-model="userCtrl.password">
        </div>
        <div class="center">
            <button type="button" class="btn btn-primary" ng-click="userCtrl.loginAction()">登陆</button>
            <button type="button" class="btn btn-primary" ng-click="userCtrl.hideLoginAction()">返回</button>
        </div>
    </div>

</div>

<div class="headContent">
    <div class="imgLogo">
        <img src="<c:url value="/images/logo.jpg"/>"/>
    </div>
    <div class="search">
        <div class="input-group">
            <input type="text" placeholder="搜索商品" class="form-control">
               <span class="input-group-btn">
                  <button class="btn btn-primary">搜索</button>
               </span>
        </div>
    </div>
</div>

<div class="navTag">
    <ul class="nav nav-tabs nav-stacked">
        <li class="active"><a href="#section-1">女装</a></li>
        <li><a href="#section-2">男装</a></li>
        <li><a href="#section-3">家居家纺</a></li>
        <li><a href="#section-4">汽车用品</a></li>
        <li><a href="#section-5">玩具</a></li>
    </ul>
</div>


