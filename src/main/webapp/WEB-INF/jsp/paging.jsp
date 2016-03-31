<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="application/javascript" src="<c:url value="/scripts/paging.js"/>"></script>
<link rel="StyleSheet" href="<c:url value="/css/indexProject.css"/>" type="text/css" media="screen"/>

<div class="aStyle" ng-controller="myPagingCtrl as ctrl">
  <a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}&pageId=1"/>" id="firstPage">首页</a>
  <a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}&pageId=${indexPage.prevPageNum}"/>" id="prePage">上一页</a>
  <a id="currentPage">${indexPage.currentPageNum}</a>
  <a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}&pageId=${indexPage.nextPageNum}"/>" id="nextPage">下一页</a>
  <a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}&pageId=${indexPage.maxPageNum}"/>" pageNum="${indexPage.maxPageNum}" id="lastPage">尾页</a></div>
</div>