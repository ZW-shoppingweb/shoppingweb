<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="addressTable" name="addressForm" action="/shoppingweb/submitAddress" method="post">
    <label>收货地址</label><br>
    <c:if test="${!empty allAddresses}">
        <c:forEach items="${allAddresses}" var="address">
            <input type="radio" name="addressId" id="address" value="${address.addressId}"/>
            姓:${address.firstName}名:${address.lastName}邮箱:${address.emailAddress}地址:${address.province}${address.city}${address.street}<br>
        </c:forEach>
    </c:if>
    <input type="text" name="userName" value="${user}" hidden>
    <input type="radio" name="addressId" ng-click="addNewAddress()"/>添加新地址
    <div class="center">
        <button class="btn btn-primary" ng-click="checkOrder()">保存订单</button>
        <button type="button" class="btn btn-primary" ng-click="hideForm()">返回</button>
    </div>
</form>
    <%@ include file="newaddress.jsp" %>


