<%--
  Created by IntelliJ IDEA.
  User: cxzhao
  Date: 3/28/16
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="StyleSheet" href="<c:url value="/css/headStyle.css"/>" type="text/css" media="screen"/>
<script type="application/javascript" src="<c:url value="/js/angular.min.js"/>"></script>
<div class="navTag">
    <ul class="nav nav-tabs nav-stacked">
        <li class="active"><a href="<c:url value="/productList?filterName=productCategory&filterValue=1"/>">女装</a></li>
        <li><a href="<c:url value="/productList?filterName=productCategory&filterValue=2"/>">男装</a></li>
        <li><a href="<c:url value="/productList?category=家居家纺"/>">家居家纺</a></li>
        <li><a href="<c:url value="/productList?category=汽车用品"/>">汽车用品</a></li>
        <li><a href="<c:url value="/productList?category=玩具"/>">玩具</a></li>
    </ul>
</div>