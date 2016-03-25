<%@ paginationData contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Shopping</title>
  <link rel="StyleSheet" href="<c:url value="/css/indexProject.css"/>" type="text/css" media="screen"/>
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

            <a href="${pageContext.request.contextPath}/product/${pro.productId}">

              <img src="${pro.productImage }"><br>
              <p class="price">¥${pro.productPrice}元</p>
              <p>${pro.productName}</p>
              <br/></a>
          </div>
        </c:forEach>
      </c:if>
    </div>
  </div>
</div>
<br/><br>
<div class="aStyle">
  <a href="<c:url value="/productList?pageId=1"/>">${firstPage}</a>
  <a href="<c:url value="/productList?pageId=${indexPage.prePage}"/>">${indexPage.pre}</a>
  <a href="<c:url value="/productList?pageId=${indexPage.nextPage}"/>">${indexPage.next}</a>
  <a href="<c:url value="/productList?pageId=${indexPage.totalPage}"/>">${lastPage}</a></div>
</div>
<br/><br>
</body>
</html>