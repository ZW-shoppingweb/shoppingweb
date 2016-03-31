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
                <li><a href="javascript:void(0);" ng-click="userCtrl.loginShow()">{{userCtrl.isSignIn}}</a></li>
                <li><a>{{userCtrl.userNameInNav}}</a></li>
                <li><a href="javascript:void(0);" ng-click="userCtrl.registerShow()">{{userCtrl.isRegister}}</a></li>
                <li><a href="javascript:void(0);" ng-click="userCtrl.signOut()">{{userCtrl.isSignOut}}</a></li>
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
    <form action="/shoppingweb/productList" method="post">
    <div class="searchPrice">
        <label>价格区间</label>
        <input type="number" placeholder="最小" name="minPrice">
        <input type="number" placeholder="最大" name="maxPrice">
        <button type="submit" class="btn btn-primary">筛选</button>


        <%--<a href="<c:url value="/productList?productCategory=${indexPage.queryFilter.productCategory}&filterValue=${indexPage.queryFilter.filterValue}&minPrice={{minPrice}}&maxPrice={{maxPrice}}&seqName=${indexPage.queryFilter.seqName}&productPrice=${indexPage.queryFilter.productPrice}"/>">筛选</a>--%>
    </div>
    <div class="row">

            <div class="searchADSC">
            <label>按价格筛选</label>
            <input type="radio" id="q128" name="productPrice" value="ASC"/> ASC
            <input type="radio" id="q129" name="productPrice" value="DESC"/> DESC
            <button type="submit">筛选</button>
                <br>
            <label>按价格筛选</label>
            <input type="radio" name="productName" value="ASC"/> ASC
            <input type="radio" name="productName" value="DESC"/> DESC
            <button type="submit">筛选</button>
    </div>


    </div>
    </form>
    <br/>
<%--<form action="/shoppingweb/productList" method="post">--%>
    <%--<div class="navTag">--%>
        <%--<ul class="nav nav-tabs nav-stacked">--%>
            <%--<li class="active">--%>
                <%--<label>--%>
                    <%--<input type="radio" name="productCategory" value="1"/> 女装--%>
                <%--</label>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<label>--%>
                    <%--<input type="radio" name="productCategory" value="2"/> 男装--%>
                <%--</label>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<label>--%>
                    <%--<input type="radio" name="productCategory" value="3"/>家具家纺--%>
                <%--</label>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<label>--%>
                    <%--<input type="radio" name="productCategory" value="4"/>汽车用品--%>
                <%--</label>--%>
            <%--</li>--%>
            <%--<li>--%>
                <%--<label>--%>
                    <%--<input type="radio" name="productCategory" value="5"/>玩具--%>
                <%--</label>--%>
            <%--</li>--%>
        <%--</ul>--%>
        <%--<button type="submit" class="btn btn-primary">筛选</button>--%>
    <%--</div>--%>
<%--</form>--%>

    <div class="navTag">
        <ul class="nav nav-tabs nav-stacked">
            <li class="active">
                <a
                        href="<c:url value="/productList?productCategory=productCategory&filterValue=1&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&productName=${indexPage.queryFilter.productName}&productPrice=${indexPage.queryFilter.productPrice}"/>">女装</a>
            </li>
            <li>
                <a href="<c:url value="/productList?productCategory=productCategory&filterValue=2&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&productName=${indexPage.queryFilter.productName}&productPrice=${indexPage.queryFilter.productPrice}"/>">男装</a>
            </li>
            <li>
                <a href="<c:url value="/productList?productCategory=productCategory&filterValue=3&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&productName=${indexPage.queryFilter.productName}&productPrice=${indexPage.queryFilter.productPrice}"/>">家居家纺</a>
            </li>
            <li>
                <a href="<c:url value="/productList?productCategory=productCategory&filterValue=4&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&productName=${indexPage.queryFilter.productName}&productPrice=${indexPage.queryFilter.productPrice}"/>">汽车用品</a>
            </li>
            <li>
                <a href="<c:url value="/productList?productCategory=productCategory&filterValue=5&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&productName=${indexPage.queryFilter.productName}&productPrice=${indexPage.queryFilter.productPrice}"/>">玩具</a>
            </li>
        </ul>
    </div>

