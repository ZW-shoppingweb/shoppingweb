<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type="application/javascript" src="<c:url value="/js/jquery.bxslider.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/angular.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/angular-messages.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/scripts/header.js"/>"></script>
<script type="application/javascript" src="<c:url value="/scripts/search.js"/>"></script>
<script type="application/javascript" src="<c:url value="/scripts/price.js"/>"></script>
<link rel="stylesheet/less" type="text/css" href='<c:url value="/css/headStyle.less"/>' />
<link rel="stylesheet/less" type="text/css" href='<c:url value="/css/home.less"/>' />

<script src="<c:url value="/js/less.js"/>" type="text/javascript"></script>

<div ng-controller="userController as userCtrl">
    <div class="headContent">
        <div class="imgLogo">
            <a href="<c:url value="/productList"/>"><img src="<c:url value="/images/logo.jpg"/>"/></a>
        </div>
        <div class="cartBtn" >
            <button id="cartShow" ng-click="userCtrl.shopCartShow('${memberName}')">
                <img src="<c:url value="/images/cart.jpg"/>"/>
                <span>购物车</span>
            </button>
            <div class="dropdownMenu">
                <p class="center">最新加入购物车的两件商品</p>
                <p id="productName1">名称: {{productName1}} 数目:{{productNum1}}</p>
                <p id="productName2">名称:{{productName2}} 数目:{{productNum2}}</p>
                <p id="productTotalPrice">总价:{{productTotalPrice}}</p>
                <hr>
                <p class="center"><a href="/shoppingweb/goToMyShopCart?userName=${memberName}">去我的购物车</a></p>
            </div>
        </div>
        <div class="loginAndRegister">
            <a href="javascript:void(0);" ng-click="userCtrl.loginShow()" ng-bind="userCtrl.isSignIn"></a>
            <a id="userNameInNav">${memberName}</a>
            <a href="javascript:void(0);" ng-click="userCtrl.registerShow()" ng-bind="userCtrl.isRegister"></a>
            <a href="javascript:void(0);" ng-click="userCtrl.signOut()" ng-bind="userCtrl.isSignOut"></a>
        </div>
       <div class="search">
            <input type="text" placeholder="搜索商品" class="formControl">
            <button class="btnPrimary">搜索</button>
        </div>
    </div>

    <script type="text/ng-template" id="my-common-messages">
        <div ng-message="required">*必填项,不能为空</div>
    </script>
    <script type="text/ng-template" id="my-common-password-messages">
        <div ng-message="minlength">密码长度不小于6</div>
        <div ng-message="maxlength">密码长度不大于16</div>
    </script>
    <%@ include file="login.jsp" %>
    <%@ include file="register.jsp" %>

</div>
