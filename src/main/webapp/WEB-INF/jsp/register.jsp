<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="registerForm" name="registerForm">
    <p class="center">欢迎!请注册</p>
    <div class="form-group">
        <label>用户名</label>
        <input type="text" class="form-control" placeholder="用户名" required
               ng-model="userCtrl.userNameUnique" name="userName">
    </div>
    <div ng-messages="registerForm.userName.$error" role="alert" class="message">
        <div ng-messages-include="my-common-messages"></div>
    </div>
    <div class="message" ng-show="userCtrl.showExistedUserTips" ng-cloak>用户名已存在,请修改用户名!</div>
    <div class="form-group">
        <label>密码</label>
        <input type="password" class="form-control" placeholder="请输入6-16位密码" ng-model="userCtrl.passwordOnce"
               required minlength="6" maxlength="16" name="passwordOne">
    </div>
    <div ng-messages="registerForm.passwordOne.$error" role="alert" class="message">
        <div ng-messages-include="my-common-messages"></div>
        <div ng-messages-include="my-common-password-messages"></div>
    </div>
    <div class="form-group">
        <label>确认密码</label>
        <input type="password" class="form-control" placeholder="请输入与上面一致的密码" ng-model="userCtrl.passwordTwice"
               required minlength="6" maxlength="16" name="passwordTwo">
    </div>
    <div ng-messages="registerForm.passwordTwo.$error" role="alert" class="message">
        <div ng-messages-include="my-common-messages"></div>
        <div ng-messages-include="my-common-password-messages"></div>
    </div>
    <div class="message" ng-show="userCtrl.showNotSamePasswordTips" ng-cloak>两次密码不一致!</div>
    <div class="center">
        <button type="button" class="btn btn-primary" ng-click="userCtrl.registerAction()">注册</button>
        <button type="button" class="btn btn-primary" ng-click="userCtrl.hideForm()">返回</button>
    </div>


</form>