<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Shopping</title>
    <link rel="StyleSheet" href="<c:url value="/css/indexProject.css"/>" type="text/css" media="screen"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body ng-app="userApp">
<%@ include file="home.jsp" %>

<div  ng-controller="SearchController as searchCtrl">
    <form action="/shoppingweb/productList" method="post" id="processForm">
        <div class="searchPrice">
            <label>价格区间</label>
            <input type="number" placeholder="最小" name="minPrice">
            <input type="number" placeholder="最大" name="maxPrice">
            <button type="submit" class="btn btn-primary">筛选</button>
        </div>
        <div class="row">
            <div class="searchADSC">
                <label>按价格筛选</label>
                <input type="radio" ng-model="priceA" name="productPrice" id="price1" value="ASC"/>升序
                <input type="radio" ng-model="priceA" name="productPrice" id="price2" value="DESC"/>降序
                <input type="radio" name="productPrice" checked="checked" value=""/>默认
                <a hidden>{{ productPrice='${query.productPrice}'}}</a>
                <br>
                <label>按姓名筛选</label>
                <input type="radio" name="productName" id="name1" value="ASC"/> 升序
                <input type="radio" name="productName" id="name2" value="DESC"/> 降序
                <input type="radio" name="productName" checked="checked" value=""/> 默认
                <a hidden>{{ productName='${query.productName}'}}</a>
            </div>
        </div>
        <br/>
    </form>
</div>
<div>
    <div class="products">
        <div class="allProjectList" ng-controller="historyController">
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
</div>
<br/><br>
<%@ include file="paging.jsp" %>
<br/><br>
</body>
</html>