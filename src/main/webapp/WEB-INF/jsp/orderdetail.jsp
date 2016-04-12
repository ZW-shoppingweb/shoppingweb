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
    <p>收货人:<br>
        姓:${address.firstName}
        名:${address.lastName}
        邮箱:${address.emailAddress}</p>
    <p>收货地址:${address.province}省${address.city}市${address.street}街<br></p>
    <button class="btn btn-primary" ng-click="submitOrder('${memberName}',${totalNum},${totalPrice},${address.addressId})">提交订单</button>
    <div class="messageOfEmptyOrder">
        <p>订单为空,是否去添加商品?</p>
        <a class="btn btn-primary" href="/shoppingweb/productList">确定</a>
        <button class="btn btn-primary" ng-click="hideMessage()">取消</button>
    </div>
</div>
<div class="orderListStyle">
    <h3>我的订单列表</h3>
    <c:if test="${!empty orderList }">
        <c:forEach items="${orderList }" var="order">
            <div>
                <span>${order.orderId}</span>
                数量:<span>${order.productNum}</span>
                总价:<span>${order.totalPrice}</span>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
