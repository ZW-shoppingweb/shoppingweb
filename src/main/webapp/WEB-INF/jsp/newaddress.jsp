<%--
  Created by IntelliJ IDEA.
  User: cxzhao
  Date: 4/11/16
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="addressForm" name="addressForm" action="/shoppingweb/submitAddress" method="post">
        <div class="form-group">
            <label>收件人</label><br>
            <input type="text"  placeholder="名" id="firstName" ng-model="firstName"
                   required name="firstName">
            <input type="text" placeholder="姓" id="lastName"
                   required name="lastName">
            <div class="form-group" ng-class="{'has-error':userForm.email.$touched && userForm.email.$invalid}">
                <label>邮箱</label><br>
                <input type="email" name="emailAddress"  placeholder="email"
                       id="email"
                       ng-minlength="5"
                       ng-maxlength="20" required/>
            </div>
        </div>
        <input type="text" name="userName" value="${user}" hidden>
        <div class="form-group">
            <label>地址</label><br>
            <input type="text"  placeholder="省" id="province"
                   required name="province">
            <input type="text" placeholder="市" id="city"
                   required name="city">
            <input type="text"  placeholder="街道" id="street"
                   required name="street">
        </div>
        <div ng-messages="addressForm.street.$error" role="alert" class="message">
            <div ng-messages-include="my-common-messages"></div>
        </div>
    <div class="center">
        <button class="btn btn-primary" ng-click="checkOrder()">保存订单</button>
        <button type="button" class="btn btn-primary" ng-click="hideForm()">返回</button>
    </div>
</form>
