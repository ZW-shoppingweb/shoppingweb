<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Shopping</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body ng-app="userApp">
<%@ include file="head.jsp" %>
<script type="application/javascript" src="<c:url value="/scripts/home.js"/>"></script>
<div ng-controller="HomeController as homeCtrl" class="home-category-list">
    <div class="category-list">
        <form action="/shoppingweb/productList" method="post" id="process">
            <ul class="home-category-nav">
                <input type="hidden" id="productCategoryInput" name="productCategory" ng-model="productCategory"
                       value="${productCategory}"/>
                <li ng-class={'activeStyle':active1} class="home-category-nav-item">
                    <a ng-click="category(1)" class="category-nav-link">女装</a>
                </li>
                <li ng-class={'activeStyle':active2} class="home-category-nav-item">
                    <a ng-click="category(2)" class="category-nav-link">男装</a>
                </li>
                <li ng-class={'activeStyle':active3} class="home-category-nav-item">
                    <a ng-click="category(3)" class="category-nav-link">家居家纺</a>

                </li>
                <li ng-class={'activeStyle':active4} class="home-category-nav-item">
                    <a ng-click="category(4)" class="category-nav-link">汽车用品</a>
                </li>
                <li ng-class={'activeStyle':active5} class="home-category-nav-item">
                    <a ng-click="category(5)" class="category-nav-link">玩具</a>
                </li>
                <li ng-class={'activeStyle':active6} class="home-category-nav-item">
                    <a ng-click="category('')" class="category-nav-link">全部</a>
                </li>
            </ul>
        </form>
    </div>
    <ul class="bxslider">
        <li class="bx-clone">
            <img src="<c:url value="http://bpic.pic138.com/13/61/75/44bOOOPIC46_1024.jpg!/fw/780/quality/90/unsharp/true/compress/true"/>"/>
        </li>
        <li class="bx-clone">
            <img src="<c:url value="/images/s2.jpg"/>"/>
        </li>
        <li class="bx-clone">
            <img src="<c:url value="http://bpic.pic138.com/11/31/58/39b1OOOPICee.jpg!/fw/780/quality/90/unsharp/true/compress/true"/>"/>
        </li>
    </ul>
</div>
</body>
</html>