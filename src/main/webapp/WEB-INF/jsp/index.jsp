<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Shopping</title>
  <link rel="StyleSheet" href="css/indexproject.css" type="text/css" media="screen"/>
  <link href="css/libs/bootstrap.min.css" rel="stylesheet"/>
  <link href="css/libs/bootstrap-theme.min.css" rel="stylesheet"/>
  <script type="application/javascript" src="js/jquery-2.2.1.min.js"></script>
  <script type="application/javascript" src="js/bootstrap.min.js"></script>
  <script type="application/javascript" src="js/angular.min.js"></script>
  <script type="application/javascript" src="scripts/index.js"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<style type="text/css">
  body{
    background-color: #EAEAEA;
  }
  .head_content{
    width: 90%;
    position: relative;
    height: 100px;
    top:20px;
    left: 5%;
    right: 5%;
    box-shadow: 0 0 1px 1px rgba(0,0,0,.2);
    background-color: white;
  }
  .search{
    left: 600px;
    width: 600px;
    height: 50px;
    margin-top:100px;
    display:block;
  }
  .search input {
    width: 400px;
    float: left;
  }
  .search button{
    width: 100px;
    float: left;
  }
  .allprojectlist{
    margin-left: 50px;
    margin-top:50px;

  }
  .indexproduct{
    text-align: left;
  }
  .indexproduct a{
    text-decoration:none;
  }
  .price{
    color: red;
    font-size: 19px;
  }
</style>
</head>

<body>
<div>
  <div class="head_content">
    <div class="search">
      <p><input placeholder="搜索商品" class="form-control"/><button class="btn btn-default">搜索</button></p>
    </div>
  </div>

  <div class="allprojectlist">

    <center>
    <c:if test="${!empty allproducts }">
      <c:forEach items="${allproducts }" var="pro">
        <div class="indexproduct"><a href="#">
          <%--gotodetails?product_id='"+${pro.product_id}+"'--%>
          <img  src="${pro.product_image }"><br>
            <p class="price">¥${pro.product_price}元---VIP${pro.product_vipprice}元</p>
            <p>${pro.product_name}</p>
          <br/></a>
        </div>
      </c:forEach>
    </c:if>
    </center>
  </div>
</div>
</body>
</html>