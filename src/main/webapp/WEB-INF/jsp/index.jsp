<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Shopping</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body>
<%@ include file="head.jsp" %>
<div>
  <div class="products">
    <div class="allProjectList">
      <c:if test="${!empty allProducts }">
        <c:forEach items="${allProducts }" var="pro">
          <div class="indexProduct">
            <a href="${pageContext.request.contextPath}/gotoDetails?productId=${pro.productId}">
              <img src="${pro.productImage }"><br>
              <p class="price">¥${pro.productPrice}元</p>
              <p>${pro.productName}kkkk</p>
              <br/></a>
          </div>
        </c:forEach>
      </c:if>
    </div>
  </div>
</div>
<br/><br>
<div class="aStyle">
  <a href="${pageContext.request.contextPath}/productList/1">${firstPage}</a>
  <a href="${pageContext.request.contextPath}/productList/${indexPage.prePage}">${indexPage.pre}</a>
  <a href="${pageContext.request.contextPath}/productList/${indexPage.nextPage}">${indexPage.next}</a>
  <a href="${pageContext.request.contextPath}/productList/${indexPage.totalPage}">${lastPage}</a></div>
</div>
<br/><br>
</body>
</html>