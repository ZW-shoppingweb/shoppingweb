<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="loginForm">
    <p class="center">欢迎!请登录</p>
    <div class="form-group">
        <label>用户名</label>
        <input type="text" class="form-control"  placeholder="User Name" ng-model="userCtrl.userName">
    </div>
    <div class="form-group">
        <label>密码</label>
        <input type="password" class="form-control"  placeholder="Password" ng-model="userCtrl.password">
    </div>
    <div class="center">
        <button type="button" class="btn btn-primary" ng-click="userCtrl.loginAction()">登陆</button>
        <button type="button" class="btn btn-primary" ng-click="userCtrl.hideForm()">返回</button>
    </div>
</div>