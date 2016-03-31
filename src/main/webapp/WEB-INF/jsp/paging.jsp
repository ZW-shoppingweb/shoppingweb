<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="application/javascript" src="<c:url value="/scripts/paging.js"/>"></script>
<link rel="StyleSheet" href="<c:url value="/css/indexProject.css"/>" type="text/css" media="screen"/>

<div class="aStyle" ng-controller="myPagingCtrl as ctrl">
  <a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}&pageId=1"/>"
     id="firstPage" ng-class={'NoUseHrefClass':noUseHrefHome}>首页</a>
  <a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}&pageId=${indexPage.prevPageNum}"/>"
     id="prePage" ng-class={'NoUseHrefClass':noUseHrefPre}>上一页</a>
<%--<input ng-model="name1" value="${indexPage.currentPageNum}"/>--%>
  <%--{{ namess = '${indexPage.currentPageNum}' }}--%>
  <%--{{"============================="}}--%>
  <%--{{namess}}--%>
  <a id="currentPage" class='NoUseHrefClass'>${indexPage.currentPageNum}</a>
  <a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}&pageId=${indexPage.nextPageNum}"/>"
     id="nextPage" ng-class={'NoUseHrefClass':noUseHrefNext}>下一页</a>
  <a href="<c:url value="/productList?filterName=${indexPage.queryFilter.filterName}&filterValue=${indexPage.queryFilter.filterValue}&minPrice=${indexPage.queryFilter.minPrice}&maxPrice=${indexPage.queryFilter.maxPrice}&seqName=${indexPage.queryFilter.seqName}&sequence=${indexPage.queryFilter.sequence}&pageId=${indexPage.maxPageNum}"/>"
     pageNum="${indexPage.maxPageNum}" id="lastPage" ng-class={'NoUseHrefClass':noUseHrefEnd} ng-href="{{lastPages}}">尾页</a></div>
</div>