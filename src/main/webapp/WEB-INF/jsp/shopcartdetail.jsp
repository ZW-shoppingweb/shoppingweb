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
    <button class="btn btn-primary btncheck" ng-click="checkout('${memberName}')">确认</button>
    <%@ include file="address.jsp" %>
</div>
</body>
</html>
