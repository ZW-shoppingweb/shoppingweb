<%--
  Created by IntelliJ IDEA.
  User: cxzhao
  Date: 4/11/16
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="addressForm" name="addressForm" ng-submit="historyCtrl.addressAction()">
    <div class="form-group">
        <label>收件人</label><br>
        <input type="text"  placeholder="名" ng-model="historyCtrl.firstName"
               required name="firstName">
        <input type="text" placeholder="姓" ng-model="historyCtrl.lastName"
               required name="lastName">
        <div class="form-group" ng-class="{'has-error':userForm.email.$touched && userForm.email.$invalid}">
            <label>邮箱</label><br>
            <input type="email" name="email"  placeholder="email"
                   ng-model="historyCtrl.email"
                   ng-minlength="5"
                   ng-maxlength="20" required/>
        </div>
        </div>
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
        <input type="submit" class="btn btn-primary" value="保存订单"/>
        <button type="button" class="btn btn-primary" ng-click="userCtrl.hideForm()">返回</button>
    </div>
</form>