<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shopping</title>
    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css" media="screen"/>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body ng-app="userApp">
<%@ include file="head.jsp" %>
<script type="application/javascript" src="<c:url value="/scripts/home.js"/>"></script>
<div ng-controller="HomeController as homeCtrl" class="home-category-list">
<form action="/shoppingweb/productList" method="post" id="process">
    <div>
        <ul>
            <input type="hidden" id="productCategoryInput" name="productCategory" ng-model="productCategory" value="${productCategory}"/>
            <li ng-class={'activeStyle':active1}>
                <a ng-click="category(1)">女装</a>
            </li>
            <li ng-class={'activeStyle':active2}>
                <a ng-click="category(2)">男装</a>
            </li>
            <li ng-class={'activeStyle':active3}>
                <a ng-click="category(3)">家居家纺</a>

            </li>
            <li ng-class={'activeStyle':active4}>
                <a ng-click="category(4)">汽车用品</a>
            </li>
            <li ng-class={'activeStyle':active5}>
                <a ng-click="category(5)">玩具</a>
            </li>
            <li ng-class={'activeStyle':active6}>
                <a ng-click="category('')">全部</a>
            </li>
        </ul>
    </div>
</form>
    </div>
</body>
</html>