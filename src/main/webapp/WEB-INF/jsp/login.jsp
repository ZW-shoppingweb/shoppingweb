<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="loginForm" name="loginForm">
    <p class="center">欢迎!请登录</p>
    <div class="form-group">
        <label>用户名</label>
        <input type="text" class="form-control"  placeholder="用户名" ng-model="userCtrl.userName"
               required  name="userName">
    </div>
    <div ng-messages="loginForm.userName.$error" role="alert" class="message">
        <div ng-messages-include="my-common-messages"></div>
    </div>
    <div class="form-group">
        <label>密码</label>
        <input type="password" class="form-control"  placeholder="请输入6-16位密码" ng-model="userCtrl.password"
               required minlength="6" maxlength="16" name="password" >
    </div>
    <div ng-messages="loginForm.password.$error" role="alert" class="message">
        <div ng-messages-include="my-common-messages"></div>
        <div ng-messages-include="my-common-password-messages"></div>
    </div>
    <div class="message" ng-show="userCtrl.showNotCorrectLoginTips" ng-cloak>用户名或密码错误!</div>
    <br><br>
    <div class="center">
        <button type="button" class="btn btn-primary" ng-click="userCtrl.loginAction()">登陆</button>
        <button type="button" class="btn btn-primary" ng-click="userCtrl.hideForm()">返回</button>
    </div>
</form>