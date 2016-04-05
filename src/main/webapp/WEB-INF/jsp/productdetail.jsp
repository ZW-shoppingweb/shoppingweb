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
<script type="application/javascript" src="<c:url value="/scripts/price.js"/>"></script>
<div ng-controller="historyController">
    <c:if test="${!empty history }">
        <c:forEach items="${history }" var="hy">
            <div class="indexProduct">
                <a href="<c:url value="/product/${hy.productId}/{{userNameInHistory}}"/>">
                    <%--<img src="${hy.product.productImage }"><br>--%>
                    <%--<p class="price">¥${pro.productPrice}元</p>--%>
                    <p>${hy.productId}</p>
                        <p>${hy.seeTime}</p>
                    <br/></a>
            </div>
        </c:forEach>
    </c:if>
</div>
<div class="contenText">
    <div class="titleDetail" ng-controller="priceController">
        <img class="productImg" src="${product.productImage}">
        <div class="rightDetail">
            <span class="productName">${product.productName}</span>
            <p class="price1" ng-class={'NotInCommonPrice':noUsePrice}>￥${product.productPrice}</p>
            <p class="price2"> ￥${product.productVipPrice}/for VIP</p>
            <p class="number">数目: <input type="number" value="1" min="1"/></p>
            <button class="buy btn btn-primary">立即购买</button>
            <button class="buy btn btn-primary">加入购物车</button>
            <br>
        </div>
    </div>
    <div>
        <div class="productDetail">
            <h3>商品详情</h3>
            <hr color=#Gray>
            <p class="detailInfo">city: ${product.productCity} &nbsp&nbsp&nbspintroduce: ${product.productIntroduce}
                &nbsp&nbsp&nbspcity: ${product.productCity}</p>
            <img class="detailImg" src="${product.productDetailsImg}">

        </div>
    </div>
</div>
</body>
</html>
