<%--
  Created by IntelliJ IDEA.
  User: cxzhao
  Date: 4/11/16
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="addressTable">
<label>收货地址</label><br>
<c:if test="${!empty allAddresses}">
    <c:forEach items="${allAddresses}" var="address">
        <input type="radio" name="addressId" id="address" value="${address.addressId}"/>
        姓:${address.firstName}名:${address.lastName}邮箱:${address.emailAddress}地址:${address.province}<br>
    </c:forEach>
</c:if>
    <input type="radio" name="addressId" ng-click="addNewAddress()"/>添加新地址
<form class="addressForm" name="addressForm" action="/shoppingweb/submitOrder" method="post">
    <div class="form-group">
        <label>收件人</label><br>
        <input type="text"  placeholder="名" ng-model="historyCtrl.firstName"
               required name="firstName">
        <input type="text" placeholder="姓" ng-model="historyCtrl.lastName"
               required name="lastName">
        <div class="form-group" ng-class="{'has-error':userForm.email.$touched && userForm.email.$invalid}">
            <label>邮箱</label><br>
            <input type="email" name="emailAddress"  placeholder="email"
                   ng-model="historyCtrl.email"
                   ng-minlength="5"
                   ng-maxlength="20" required/>
        </div>
        </div>
    <input type="text" name="userName" value="${user}" hidden>
    <div class="form-group">
        <label>地址</label><br>
        <input type="text"  placeholder="省" ng-model="historyCtrl.province"
               required name="province">
        <input type="text" placeholder="市" ng-model="historyCtrl.city"
               required name="city">
        <input type="text"  placeholder="街道" ng-model="historyCtrl.street"
               required name="street">
    </div>
    <div ng-messages="addressForm.street.$error" role="alert" class="message">
        <div ng-messages-include="my-common-messages"></div>
    </div>
    <div class="center">
        <button type="submit" class="btn btn-primary">保存订单</button>
        <button type="button" class="btn btn-primary" ng-click="hideForm()">返回</button>
    </div>
</form>
    </div>