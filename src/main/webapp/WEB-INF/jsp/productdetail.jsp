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
<div class="contenText" ng-controller="priceController">
    <div class="titleDetail">
        <a hidden>{{productId='${product.productId}'}}</a>
        <a hidden>{{productPrice= ${product.productPrice} }}</a>
        <a hidden>{{productVipPrice= ${product.productVipPrice} }}</a>
        <img class="productImg" src="${product.productImage}">
        <div class="rightDetail">
            <span class="productName">${product.productName}</span>
            <p>价格</p>
            <p ng-class={'NotInCommonPrice':noUsePrice} class="price" >￥${product.productPrice}</p>
            <p>会员价</P>
            <p class="price"> ￥${product.productVipPrice}/for VIP</p>
            <p>数量</P>
            <p class="number">
                <span class="numberSpan" ng-click="DecreaseProductNum(${product.productVipPrice},${product.productPrice})"><a href="">-</a></span>
                <input type="number" name="productNum" ng-model="productNum" max="10" min="1" />
                <span class="numberSpan" ng-click="IncreaseProductNum(${product.productVipPrice},${product.productPrice})"><a href="">+</a></span>
            </p>
            <p>
                <button class="buy btnPrimary" >立即购买</button>
                <button class="buy btnPrimary" ng-click="addCart('${memberName}')">加入购物车</button>
            </p><br>
        </div>
    </div>
    <div class="detailTab">
            <div><span class="detailTabActive" id="detailTabImg">商品详情</span><span id="detailTabInfo">规格参数</span></div>
            <div class="detailTabShortCart">
                <span class="productName">${product.productName}</span>
                <span>总计：</span><span class="price" id="totalPriceInSelect"></span>
                <button class="buy btnPrimary" ng-click="addCartStraight('${memberName}')">加入购物车</button>
            </div>
    </div>
    <div class="detailInfo">
        <table border="0" cellpadding="0" cellspacing="0" class="detailInfoTable"> 
            <tr><td class="detailInfoTitle">商品名</td><td>${product.productName}</td></tr>
            <tr><td class="detailInfoTitle">生产地</td><td>${product.productCity}</td></tr>
            <tr><td class="detailInfoTitle">商品介绍</td><td>${product.productIntroduce}</td></tr>
            <tr><td class="detailInfoTitle">库存数量</td><td>${product.productNum}</td></tr>
            <tr><td class="detailInfoTitle">商品质量</td><td>${product.productQuality}</td></tr>
        </table>
        <img class="detailImg" src="${product.productDetailsImg}">
    </div>
    
</div>
<div ng-controller="historyController" class="historyList">
    <h3>我的足迹</h3>
    <c:if test="${!empty history }">
        <c:forEach items="${history }" var="hy">
            <div class="historyListItems">
                <a href="<c:url value="/product/${hy.product.productId}?userName=${memberName}"/>">
                    <img src="${hy.product.productImage }"><br>
                    <p>${hy.product.productName}</p>
                        <%--<p>${hy.seeTime}</p>--%>
                    <br/></a>
            </div>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
