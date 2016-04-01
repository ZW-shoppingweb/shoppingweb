<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="application/javascript" src="<c:url value="/scripts/paging.js"/>"></script>
<link rel="StyleSheet" href="<c:url value="/css/indexProject.css"/>" type="text/css" media="screen"/>

<div class="aStyle" ng-controller="myPagingCtrl">
  <form id="formp" action="/shoppingweb/productList" method="post">
    <input hidden name="productCategory" value="${indexPage.queryFilter.productCategory}"/>
    <input hidden name="minPrice" value="${indexPage.queryFilter.minPrice}"/>
    <input hidden name="maxPrice" value="${indexPage.queryFilter.maxPrice}"/>
    <input hidden name="productName" value="${indexPage.queryFilter.productName}"/>
    <input hidden name="productPrice" value="${indexPage.queryFilter.productPrice}"/>
    <input hidden  id ="nextPageId" name="pageId"/>
    <a href="" ng-class={'NoUseHrefClass':noUseHrefHome} ng-click="nextPage(1)">首页</a>
    <a href="" ng-class={'NoUseHrefClass':noUseHrefPre} ng-click="nextPage(${indexPage.prevPageNum})">上一页</a>
    <a class='NoUseHrefClass'>{{ currentPageNum='${indexPage.currentPageNum}'}}</a>
    <a href="" ng-class={'NoUseHrefClass':noUseHrefNext} ng-click="nextPage(${indexPage.nextPageNum})">下一页</a>
    <a href="" ng-class={'NoUseHrefClass':noUseHrefEnd} ng-click="nextPage(${indexPage.maxPageNum})">尾页</a>
  </form>
</div>