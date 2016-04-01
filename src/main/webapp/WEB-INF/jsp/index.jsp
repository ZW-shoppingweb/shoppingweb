<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Shopping</title>
    <link rel="StyleSheet" href="<c:url value="/css/indexProject.css"/>" type="text/css" media="screen"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body ng-app="userApp">
<%@ include file="head.jsp" %>
<div>
    <div class="products">
        <div class="allProjectList">

            <c:if test="${!empty indexPage.pageData }">
                <c:forEach items="${indexPage.pageData }" var="pro">
                    <div class="indexProduct">
                        <a href="<c:url value="/product/${pro.productId}"/>">
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
<%@ include file="paging.jsp" %>
<br/><br>
</body>
</html>