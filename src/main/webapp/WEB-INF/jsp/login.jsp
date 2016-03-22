<!DOCTYPE HTML>
<html>
<head>
    <title>Jigsaw</title>

    <link rel="StyleSheet" href="css/jpetstore.css" type="text/css" media="screen"/>
    <link href="css/libs/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/libs/bootstrap-theme.min.css" rel="stylesheet"/>

    <script type="application/javascript" src="js/jquery-2.2.1.min.js"></script>
    <script type="application/javascript" src="js/bootstrap.min.js"></script>
    <script type="application/javascript" src="js/angular.min.js"></script>
    <script type="application/javascript" src="scripts/index.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body ng-app="app">
<div ng-controller="UserController as userCtrl">
<div>Welcome:{{welcome}}</div>
<form action="loginaction" >
    <div class="form-group">
        <label>Tel</label>
        <input type="text" class="form-control" id="inputEmail1" placeholder="tel" name="username" >
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