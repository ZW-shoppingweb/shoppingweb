<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Product</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body ng-app="userApp">
<%@ include file="head.jsp" %>
<div  class="contenText" ng-controller="historyController">
    <h3>我的购物车</h3>
    <c:if test="${!empty allCartProduct }">
        <c:forEach items="${allCartProduct }" var="cart">
            <div class="cartProduct" ng-init="currentPrice(${cart.product.productId},${cart.product.productPrice},${cart.product.productVipPrice},${cart.productNum})">
                <a hidden>{{ userNameInHistory='${memberName}'}}</a>
                <a href="<c:url value="/product/${cart.product.productId}?userName=${memberName}"/>">
                    <img src="${cart.product.productImage }"><br>
                    <p>${cart.product.productName}</p>
                </a>
                <a hidden>{{ price${cart.product.productId} = '${cart.productNum}'}}</a>
                <p>数量:
                    <input value="${cart.productNum}" type="number" max="10" min="0" step="1"
                           class="number${cart.product.productId}"
                           onchange="priceProductChange('${memberName}',${cart.product.productId},${cart.product.productPrice},${cart.product.productVipPrice})"/>
                </p>
                <p class="priceOf${cart.product.productId}" ></p>
                <br><br><br>
            </div>
        </c:forEach>
    </c:if>
    <button class="btn btn-primary btncheck" ng-click="checkout()">确定订单</button>
    <%@ include file="address.jsp" %>
</div>
</body>
</html>
