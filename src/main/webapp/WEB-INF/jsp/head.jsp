<%@ paginationData contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="<c:url value="/css/libs/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="/css/libs/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<script type="application/javascript" src="<c:url value="/js/jquery-2.2.1.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/bootstrap.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/angular.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/scripts/index.js"/>"></script>
<link rel="StyleSheet" href="<c:url value="/css/headStyle.css"/>" type="text/css" media="screen"/>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">购物网站</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li><a href="<c:url value="/productList?pageId=1"/>">首页</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#">我的购物车</a></li>
            <li><a href="login">请登录</a></li>
            <li><a href="#">免费注册</a></li>
            <li><a href="#"></a></li>
        </ul>
    </div>
</nav>
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

