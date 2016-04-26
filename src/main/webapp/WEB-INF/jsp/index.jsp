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
<div class="filterProduct" ng-controller="SearchController as searchCtrl">
    <div   class="filterRequest">
        <form method="post" id="processForm">
            <span class="sort" ng-click="showNewProduct()">新品</span>
            <!-- {{isNewProduct='yes'}} -->
            <span class="sort"><label class="sortPriceShow">价格</label>
                <ul class="sortPrice">
                    <li><input type="radio"  name="productPrice" id="price1" value="ASC" ng-click="filterProduct()"/>升序</li>
                    <li><input type="radio"  name="productPrice" id="price2" value="DESC" ng-click="filterProduct()"/>降序</li>
                    <li><input type="radio"  name="productPrice" checked="checked" value="" ng-click="filterProduct()"/>默认</li>
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
                    <li><input type="radio" name="productName" id="name1" value="ASC" ng-click="filterProduct()"/> 升序</li>
                    <li><input type="radio" name="productName" id="name2" value="DESC" ng-click="filterProduct()"/> 降序</li>
                    <li><input type="radio" name="productName" checked="checked" value="" ng-click="filterProduct()"/> 默认</li>
                    <a hidden>{{ productName='${query.productName}'}}</a>
                    <br>
                </ul>
            </span>
            <span class="sort"><button  ng-click="filterProduct()">筛选</button></span>
            <span class="sort stock"><button  ng-click="showStock()">仅显示有货</button></span>
            <br/>
        </form>
    </div>
    <div class="products">
        <div class="indexProduct" ng-repeat="item in items">
            <a  href="<c:url value="/product/{{item.productId}}?userName=${memberName}"/>">
            <img src="{{item.productImage}}"><br>
            <p class="price">¥{{item.productPrice}}元</p>
            <p>{{item.productName}}</p>
            <br/></a>
        </div>
        <div class="getProductList">
            <c:if test="${!empty pageData }">
            <c:forEach items="${pageData }" var="pro">
            <div class="indexProduct">
                <a  href="<c:url value="/product/${pro.productId}?userName=${memberName}"/>">
                <img src="${pro.productImage }"><br>
                <p class="price">¥${pro.productPrice}元</p>
                <p>${pro.productName}</p>
                <br/></a>
            </div>
            </c:forEach>
            </c:if>
            <a hidden>{{ productCategory='${pageInfo.queryFilter.productCategory}'}}</a>
        </div>
    </div>
    <br/><br>
    <%@ include file="paging.jsp" %>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>