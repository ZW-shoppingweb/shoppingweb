<html>
<head>
  <title>Shopping</title>
  <link rel="StyleSheet" href="css/jpetstore.css" type="text/css" media="screen"/>
  <link href="css/libs/bootstrap.min.css" rel="stylesheet"/>
  <link href="css/libs/bootstrap-theme.min.css" rel="stylesheet"/>

  <script type="application/javascript" src="js/jquery-2.2.1.min.js"></script>
  <script type="application/javascript" src="js/bootstrap.min.js"></script>
  <script type="application/javascript" src="js/angular.min.js"></script>
  <script type="application/javascript" src="scripts/index.js"></script>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body>
<div ng-app="app">
  <div ng-controller="UserController">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
     <h1><a href="indexofshoppingweb">Welcome to ShoppingMall</a></h1>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Option <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="login">Login</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
  </div>
</div>
</body>
</html>