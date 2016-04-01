<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/libs/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="/css/libs/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<script type="application/javascript" src="<c:url value="/js/jquery-2.2.1.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/angular.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/angular-messages.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/scripts/header.js"/>"></script>
<script type="application/javascript" src="<c:url value="/scripts/price.js"/>"></script>
<script type="application/javascript" src="<c:url value="/scripts/search.js"/>"></script>
<link rel="StyleSheet" href='<c:url value="/css/headStyle.css"/>' type="text/css" media="screen"/>

<div ng-controller="userController as userCtrl">
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
                <li><a href="javascript:void(0);" ng-click="userCtrl.loginShow()" ng-bind="userCtrl.isSignIn"></a></li>
                <li><a ng-bind="userCtrl.userNameInNav"></a></li>
                <li><a href="javascript:void(0);" ng-click="userCtrl.registerShow()" ng-bind="userCtrl.isRegister"></a></li>
                <li><a href="javascript:void(0);" ng-click="userCtrl.signOut()" ng-bind="userCtrl.isSignOut"></a></li>
            </ul>
        </div>
    </nav>
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

<div class="headContent" ng-controller="SearchController as searchCtrl">
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
    <form action="/shoppingweb/productList" method="post" id="processForm">
        <div class="searchPrice">
            <label>价格区间</label>
            <input type="number" placeholder="最小" name="minPrice">
            <input type="number" placeholder="最大" name="maxPrice">
            <button type="submit" class="btn btn-primary">筛选</button>
        </div>
        <div class="row">

            <div class="searchADSC">
                <label>按价格筛选</label>
                <input type="radio" ng-model="priceA" name="productPrice" id="price1" value="ASC"/> ASC
                <input type="radio" ng-model="priceA"name="productPrice" id="price2" value="DESC"/> DESC
                <input type="radio" name="productPrice" checked="checked" value=""/> Default
                <a hidden>{{ productPrice='${query.productPrice}'}}</a>
                <br>
                <label>按姓名筛选</label>
                <input type="radio" name="productName"  id="name1" value="ASC"/> ASC
                <input type="radio" name="productName"  id="name2" value="DESC"/> DESC
                <input type="radio" name="productName" checked="checked" value=""/> Default
                <a hidden>{{ productName='${query.productName}'}}</a>
            </div>
        </div>
        <br/>
        <div class="navTag">
            <ul class="nav nav-tabs nav-stacked">
                <li ng-class={'activeStyle':active1}>
                    <a ng-click="category(1)">女装</a>
                    <input type="radio" name="productCategory" id="check1" value="1" hidden/>
                </li>
                <li ng-class={'activeStyle':active2}>
                    <a ng-click="category(2)">男装</a>
                    <input type="radio" name="productCategory" id="check2" value="2" hidden/>
                </li>
                <li ng-class={'activeStyle':active3}>
                    <a ng-click="category(3)">家居家纺</a>
                    <input type="radio" name="productCategory" id="check3" value="3" hidden/>

                </li>
                <li ng-class={'activeStyle':active4}>
                    <a ng-click="category(4)">汽车用品</a>
                    <input type="radio" name="productCategory" id="check4" value="4" hidden/>

                </li>
                <li ng-class={'activeStyle':active5}>
                    <a ng-click="category(5)">玩具</a>
                    <input type="radio" name="productCategory" id="check5" value="5" hidden/>
                </li>
                <a hidden>{{ productCategory='${query.productCategory}'}}</a>
            </ul>
        </div>
    </form>
</div>