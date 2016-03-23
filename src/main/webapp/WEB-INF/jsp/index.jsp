<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Shopping</title>
  <link href="css/libs/bootstrap.min.css" rel="stylesheet"/>
  <link href="css/libs/bootstrap-theme.min.css" rel="stylesheet"/>
  <script type="application/javascript" src="js/jquery-2.2.1.min.js"></script>
  <script type="application/javascript" src="js/bootstrap.min.js"></script>
  <script type="application/javascript" src="js/angular.min.js"></script>
  <script type="application/javascript" src="scripts/index.js"></script>

  <link rel="StyleSheet" href="css/header.css" type="text/css" media="screen"/>
  <link rel="StyleSheet" href="css/indexproject.css" type="text/css" media="screen"/>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body>
<%@ include file="head.jsp" %>
<div>
  <div class="navtag">
    <ul class="nav nav-tabs nav-stacked">
      <li class="active"><a href="#section-1">女装</a></li>
      <li><a href="#section-2">男装</a></li>
      <li><a href="#section-3">家居家纺</a></li>
      <li><a href="#section-4">汽车用品</a></li>
      <li><a href="#section-5">玩具</a></li>
    </ul>
  </div>
  <div class="products">
    <div class="allprojectlist">
      <c:if test="${!empty allproducts }">
        <c:forEach items="${allproducts }" var="pro">
          <div class="indexproduct">
            <a href="gotodetails?product_id=${pro.product_id}">
              <img src="${pro.product_image }"><br>
              <p class="price">¥${pro.product_price}元</p>
              <p>${pro.product_name}</p>
              <br/></a>
          </div>
        </c:forEach>
      </c:if>
    </div>
  </div>
</div>
<br/><br>
<div class="astyle">
  <a href="page?pageid=1">${firstpage}</a>
  <a href="page?pageid=${indexpage.prepage}">${indexpage.pre}</a>
  <a href="page?pageid=${indexpage.nextpage}">${indexpage.next}</a>
  <a href="page?pageid=${indexpage.totalpage}">${lastpage}</a></div>
</div>
<br/><br>
</body>
</html>