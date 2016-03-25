<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="application/javascript" src="<c:url value="/js/angular.min.js"/>"></script>
<script type="application/javascript" src="<c:url value="/js/jquery-2.2.1.min.js"/>"></script>

<script type="application/javascript" src="<c:url value="/scripts/paging.js"/>"></script>

<link rel="StyleSheet" href="<c:url value="/css/indexProject.css"/>" type="text/css" media="screen"/>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<div class="aStyle" ng-app="myPagingApp" ng-controller="myPagingCtrl">
  <a href="<c:url value="/productList?pageId=1"/>" id="firstPage">首页</a>
  <a href="<c:url value="/productList?pageId=${indexPage.prevPageNum}"/>" id="prePage">上一页</a>
  <a  id="currentPage">${indexPage.currentPageNum}</a>
  <a href="<c:url value="/productList?pageId=${indexPage.nextPageNum}"/>" id="nextPage">下一页</a>
  <a href="<c:url value="/productList?pageId=${indexPage.maxPageNum}"/>" pageNum="${indexPage.maxPageNum}" id="lastPage">尾页</a></div>
</div>