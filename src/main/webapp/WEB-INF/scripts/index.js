var module = angular.module("app", []);
module.controller('UserController', ['$scope', '$http',function ($scope, $http) {
    _this=this;
    $scope.welcome = "Welcome!";
    //_this.login=function(){
    //    $http.get("/loginaction").success( function(response) {
    //
    //        // alert("***" + JSON.stringify(response));
    //        _this.list_office = response;
    //    });
    //}

}]);