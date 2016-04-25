<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Shopping</title>
    <link rel="stylesheet/less" type="text/css" href='<c:url value="/css/indexProject.less"/>' />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body ng-app="userApp">
<%@ include file="head.jsp" %>
<div class="filterProduct">
    <div  ng-controller="SearchController as searchCtrl" class="filterRequest">
        <form action="/shoppingweb/productList" method="post" id="processForm">
            <span class="sort">新品</span>
            <span class="sort"><label class="sortPriceShow">价格</label>
                <ul class="sortPrice">
                    <li><input type="radio" ng-model="priceA" name="productPrice" id="price1" value="ASC"/>升序</li>
                    <li><input type="radio" ng-model="priceA" name="productPrice" id="price2" value="DESC"/>降序</li>
                    <li><input type="radio" name="productPrice" checked="checked" value=""/>默认</li>
                    <a hidden>{{ productPrice='${query.productPrice}'}}</a>
                    <br>
                </ul>
            </span>
            <span class="searchPrice sort">
                <input type="number" placeholder="￥" name="minPrice">-
                <input type="number" placeholder="￥" name="maxPrice">
            </span>
            <span class="sort"><label class="sortProductNameShow">商品名</label>
                <ul class="searchADSC">
                    <li><input type="radio" name="productName" id="name1" value="ASC"/> 升序</li>
                    <li><input type="radio" name="productName" id="name2" value="DESC"/> 降序</li>
                    <li><input type="radio" name="productName" checked="checked" value=""/> 默认</li>
                    <a hidden>{{ productName='${query.productName}'}}</a>
                    <br>
                </ul>
            </span>
            <span class="sort"><button type="submit" class="btn btn-primary">筛选</button></span>
            <br/>
        </form>
    </div>
    <div class="products">
        <div ng-controller="historyController">
            <c:if test="${!empty indexPage.pageData }">
            <c:forEach items="${indexPage.pageData }" var="pro">
            <div class="indexProduct">
                <a  href="<c:url value="/product/${pro.productId}?userName=${memberName}"/>">
                <img src="${pro.productImage }"><br>
                <p class="price">¥${pro.productPrice}元</p>
                <p>${pro.productName}</p>
                <br/></a>
            </div>
            </c:forEach>
            </c:if>
        </div>
    </div>
    <br/><br>
</div>
<%@ include file="paging.jsp" %>
<%@ include file="footer.jsp" %>
</body>
</html>