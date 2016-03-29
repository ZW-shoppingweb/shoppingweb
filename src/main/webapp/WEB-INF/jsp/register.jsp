<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="registerForm">
    <p class="center">欢迎!请注册</p>
    <div class="form-group">
        <label>用户名</label>
        <input type="text" class="form-control" placeholder="User Name" ng-model="userCtrl.userNameUnique">
    </div>
    <div class="form-group">
        <label>密码</label>
        <input type="password" class="form-control" placeholder="Password" ng-model="userCtrl.passwordOnce">
    </div>
    <div class="form-group">
        <label>确认密码</label>
        <input type="password" class="form-control" placeholder="Same Password" ng-model="userCtrl.passwordTwice">
    </div>
    <div class="center">
        <button type="button" class="btn btn-primary" ng-click="userCtrl.registerAction()">注册</button>
        <button type="button" class="btn btn-primary" ng-click="userCtrl.hideForm()">返回</button>
    </div>
</div>