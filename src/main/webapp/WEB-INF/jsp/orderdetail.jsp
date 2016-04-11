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
    <h3>我的订单</h3>
    <p>一共购买${totalNum}件商品,总价${totalPrice}</p>
    <c:if test="${!empty allCartProduct }">
        <c:forEach items="${allCartProduct }" var="cart">
            <div class="orderProduct" ng-init="currentPrice(${cart.product.productId},${cart.product.productPrice},${cart.product.productVipPrice},${cart.productNum})">
                <a href="<c:url value="/product/${cart.product.productId}?userName=${memberName}"/>">
                    <p>${cart.product.productName}</p>
                </a>
                <p>数量:${cart.productNum}</p>
                <p class="priceOf${cart.product.productId}" ></p>
                <br><br><br>
            </div>
        </c:forEach>
    </c:if>
    <button class="btn btn-primary" ng-click="submitOrder('${memberName}',${totalNum},${totalPrice})">提交订单</button>
    <div class="messageOfEmptyOrder">
        <p>订单为空,是否去添加商品?</p>
        <a class="btn btn-primary" href="/shoppingweb/productList">确定</a>
        <button class="btn btn-primary" ng-click="hideMessage()">取消</button>
    </div>
</div>
</body>
</html>
