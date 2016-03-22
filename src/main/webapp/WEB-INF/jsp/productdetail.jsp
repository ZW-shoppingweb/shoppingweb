<%--
  Created by IntelliJ IDEA.
  User: cxzhao
  Date: 3/22/16
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <script type="application/javascript" src="js/angular.min.js"></script>
    <script type="application/javascript" src="js/bootstrap.min.js"></script>
    <%--<link href="css/libs/detail.css" rel="stylesheet"/>--%>
</head>
<body>
<div id="titledetail">
<img src="${product.product_image}">
    <div id="rightdetail">
<h1 id="productname">${product.product_name}</h1>
<p id="city">city:${product.product_city}</p>
<p>price:${product.product_price}元</p>
<p>vipprice:${product.product_vipprice}元</p>
<p>introduce:${product.product_introduce}</p>
<p>city:${product.product_city}</p>
        </div>
    </div>
<img src="${product.product_details_img}">
</body>
</html>
