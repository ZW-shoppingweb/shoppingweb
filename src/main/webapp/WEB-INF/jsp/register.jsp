<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="registerForm forms" name="registerForm" ng-submit="userCtrl.registerAction()">
    <button type="button" class="close" ng-click="userCtrl.hideForm()">返回</button>
    <div class="formContent">
        <p class="center">欢迎!请注册</p>
        <br>
        <input type="text" class="formControl" placeholder="用户名" required
               ng-model="userCtrl.userNameUnique" name="userName">
        <div class="message">
            <div ng-messages="registerForm.userName.$error" role="alert">
                <div ng-messages-include="my-common-messages"></div>
            </div>
            <div  ng-show="userCtrl.showExistedUserTips" ng-cloak>用户名已存在,请修改用户名!</div>
        </div>
        <input type="password" class="formControl" placeholder="请输入6-16位密码" ng-model="userCtrl.passwordOnce"
               required minlength="6" maxlength="16" name="passwordOne">
        <div class="message">
            <div ng-messages="registerForm.passwordOne.$error" role="alert" >
                <div ng-messages-include="my-common-messages"></div>
                <div ng-messages-include="my-common-password-messages"></div>
            </div>
        </div>
        <input type="password" class="formControl" placeholder="请输入与上面一致的密码" ng-model="userCtrl.passwordTwice"
               required minlength="6" maxlength="16" name="passwordTwo">
        <div class="message">
            <div ng-messages="registerForm.passwordTwo.$error" role="alert">
                <div ng-messages-include="my-common-messages"></div>
                <div ng-messages-include="my-common-password-messages"></div>
            </div>
            <div ng-show="userCtrl.showNotSamePasswordTips" ng-cloak>两次密码不一致,或密码格式错误!</div>
        </div>
    </div>
    <br>
    <input type="submit" class="btnPrimary" value="注册"/>
</form>