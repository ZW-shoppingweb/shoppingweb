<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/libs/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="/css/libs/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<script type="application/javascript" src="<c:url value="/js/jquery-2.2.1.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/angular.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/scripts/header.js"/>"></script>
<link rel="StyleSheet" href='<c:url value="/css/headStyle.css"/>' type="text/css" media="screen"/>

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
                <li><a href="javascript:void(0);" ng-click="userCtrl.registerShow()">{{userCtrl.isRegister}}</a></li>
                <li><a href="javascript:void(0);" ng-click="userCtrl.signOut()">{{userCtrl.isSignOut}}</a></li>
            </ul>
        </div>
    </nav>
    <%@ include file="login.jsp" %>
    <%@ include file="register.jsp" %>

</div>

<div class="headContent">
    <div class="imgLogo">
        <img src="<c:url value="/images/logo.jpg"/>"/>
    </div>
    <div class="search" >
        <div class="input-group">
            <input type="text" placeholder="搜索商品" class="form-control">
               <span class="input-group-btn">
                  <button class="btn btn-primary">搜索</button>
               </span>
        </div>
    </div>
    <div class="searchPrice">
        <label>价格区间</label>
        <input type="number"  placeholder="最小"  ng-model="minPrice">
        <input type="number"  placeholder="最大"  ng-model="maxPrice">
        <a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice={{minPrice}}&maxPrice={{maxPrice}}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}"/>">筛选</a>
    </div>
    <div class="collapse navbar-collapse searchAD">
        <ul class="nav navbar-nav navbar-middle">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">按价格筛选 <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=productPrice&sequence=ASC"/>">从低到高</a></li>
                    <li><a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=productPrice&sequence=DESC"/>">从高到低</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-middle">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">按名字筛选 <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=productName&sequence=ASC"/>">从A到Z</a></li>
                    <li><a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=productName&sequence=DESC"/>">从Z到A</a></li>
                </ul>
            </li>
        </ul>

    </div>

</div>
<div class="navTag">
    <ul class="nav nav-tabs nav-stacked">
        <li class="active"><a href="<c:url value="/productList?filterName=productCategory&filterValue=1&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}"/>">女装</a></li>
        <li><a href="<c:url value="/productList?filterName=productCategory&filterValue=2&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}"/>">男装</a></li>
        <li><a href="<c:url value="/productList?category=家居家纺"/>">家居家纺</a></li>
        <li><a href="<c:url value="/productList?category=汽车用品"/>">汽车用品</a></li>
        <li><a href="<c:url value="/productList?category=玩具"/>">玩具</a></li>
    </ul>
</div>
