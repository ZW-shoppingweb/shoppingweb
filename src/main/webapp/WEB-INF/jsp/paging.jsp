<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- <script type="application/javascript" src="<c:url value="/scripts/paging.js"/>"></script> -->
<link rel="stylesheet/less" type="text/css" href='<c:url value="/css/indexProject.less"/>' />
    
<div class="aStyle" >
    <a href="" ng-class={'NoUseHrefClass':noUseHrefHome} ng-click="nextPage(1)">首页</a>
    <a href="" ng-class={'NoUseHrefClass':noUseHrefPre} ng-click="nextPage('pre')">上一页</a>
    <a class='NoUseHrefClass' id="currentPageNum">${pageInfo.currentPageNum}</a>
    <a href="" ng-class={'NoUseHrefClass':noUseHrefNext} ng-click="nextPage('next')">下一页</a>
    <a hidden>{{ maxPageNums='${pageInfo.maxPageNum}'}}</a>
    <a href="" ng-class={'NoUseHrefClass':noUseHrefEnd} ng-click="nextPage('last')">尾页</a>
  
</div>