<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="application/javascript" src="<c:url value="/scripts/paging.js"/>"></script>
<link rel="StyleSheet" href="<c:url value="/css/indexProject.css"/>" type="text/css" media="screen"/>

<div class="aStyle" ng-controller="myPagingCtrl">
  <a href="<c:url value="/productList?productCategory=${indexPage.queryFilter.productCategory}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&productName=${indexPage.queryFilter.productName}&productPrice=${indexPage.queryFilter.productPrice}&pageId=1"/>"
     id="firstPage" ng-class={'NoUseHrefClass':noUseHrefHome} >首页</a>
  <a href="<c:url value="/productList?productCategory=${indexPage.queryFilter.productCategory}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&productName=${indexPage.queryFilter.productName}&productPrice=${indexPage.queryFilter.productPrice}&pageId=${indexPage.prevPageNum}"/>"
     id="prePage"  ng-class={'NoUseHrefClass':noUseHrefPre}>上一页</a>
  <a  id="currentPage" class='NoUseHrefClass'>${indexPage.currentPageNum}</a>
  <a href="<c:url value="/productList?productCategory=${indexPage.queryFilter.productCategory}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&productName=${indexPage.queryFilter.productName}&productPrice=${indexPage.queryFilter.productPrice}&pageId=${indexPage.nextPageNum}"/>"
     id="nextPage" ng-class={'NoUseHrefClass':noUseHrefNext}>下一页</a>
  <a href="<c:url value="/productList?productCategory=${indexPage.queryFilter.productCategory}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&productName=${indexPage.queryFilter.productName}&productPrice=${indexPage.queryFilter.productPrice}&pageId=${indexPage.maxPageNum}"/>" pageNum="${indexPage.maxPageNum}"
     id="lastPage" ng-class={'NoUseHrefClass':noUseHrefEnd}>尾页</a></div>
</div>