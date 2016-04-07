<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>

    <link rel="StyleSheet" href="<c:url value="/css/detail.css"/>" type="text/css" media="screen"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body ng-app="userApp">
<%@ include file="head.jsp" %>
<div  class="contenText" ng-controller="historyController">
    <h3>我的购物车</h3>
    <c:if test="${!empty allCartProduct }">
        <c:forEach items="${allCartProduct }" var="cart">
            <div class="cartProduct">
                <a hidden>{{ userNameInHistory='${memberName}'}}</a>
                <a href="<c:url value="/product/${cart.product.productId}?userName=${memberName}"/>">
                    <img src="${cart.product.productImage }"><br>
                    <p>${cart.product.productName}</p>
                </a>
                <p>当前数量:${cart.productNum}</p>
                <p>
                    <input ng-model="priceInput${cart.product.productId}" class="number${cart.product.productId}" type="number" max="10" min="0" ng-change="priceProductChange('${cart.product.productId}')"/>
                </p>
                <p ng-show="isnotVipAndNoChange">价格:{{ ${cart.productNum}*'${cart.product.productPrice}'}}</p>
                <p ng-show="isVipAndNoChange">价格:{{ ${cart.productNum}*'${cart.product.productVipPrice}'}}</p>
                <p ng-show="isnotVipAndChange">价格:{{ priceInput${cart.product.productId}*'${cart.product.productPrice}'}}</p>
                <P ng-show="isVipAndChange">价格:{{ priceInput${cart.product.productId}*'${cart.product.productVipPrice}'}}</P>
                <br><br><br>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
