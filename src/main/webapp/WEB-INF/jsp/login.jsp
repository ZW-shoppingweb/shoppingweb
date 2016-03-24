<!DOCTYPE HTML>
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body ng-app="app">
<div ng-controller="UserController as userCtrl">
<div>Welcome:{{welcome}}</div>
<form action="loginAction" >
    <div class="form-group">
        <label>Tel</label>
        <input type="text" class="form-control" id="inputEmail1" placeholder="tel" name="userName" >
    </div>
    <div class="form-group">
        <label for="inputPassword1">Password</label>
        <input type="password" class="form-control" id="inputPassword1" placeholder="Password" name="password">
    </div>
    <input type="submit" value="Submit"/>
    <%--<button type="button" class="btn btn-default" ng-click="userCtrl.login()">Submit</button>--%>
</form>
    </div>
</body>
</html>