<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="loginForm forms" name="loginForm" ng-submit="userCtrl.loginAction()">
    <button type="button" class="close" ng-click="userCtrl.hideForm()">关闭</button>
    <div class="formContent">
        <p class="center">欢迎!请登录</p>
        <br>
        <input type="text" class="formControl" placeholder="用户名" ng-model="userCtrl.userName"
               required name="userName">
        <div class="message">
            <div ng-messages="loginForm.userName.$error" role="alert" >
                <div ng-messages-include="my-common-messages"></div>
            </div>
            <div ng-show="userCtrl.showNotCorrectLoginTips" ng-cloak>用户名或密码错误!</div>
        </div>
        <input type="password" class="formControl" placeholder="密码" ng-model="userCtrl.password"
               required minlength="6" maxlength="16" name="password">
        <div class="message">
            <div ng-messages="loginForm.password.$error" role="alert" >
                <div ng-messages-include="my-common-messages"></div>
                <div ng-messages-include="my-common-password-messages"></div>
            </div>
        </div>
    </div>
    <input type="submit" class="btnPrimary" value="登陆"/>

</form>