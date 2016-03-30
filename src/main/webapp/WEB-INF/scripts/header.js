var proapp = angular.module('userApp', ['ngMessages']);
proapp.controller('userController', ['$scope', '$http','$location',function ($scope, $http, $location) {
    _this=this;
    angular.element(".loginForm").hide();
    angular.element(".registerForm").hide();
    _this.showNotSamePasswordTips=false;
    _this.showExistedUserTips=false;
    _this.showNotCorrectLoginTips=false;
    var storage = window.localStorage;
    _this.isSignInFlag=storage["isSignIn"];
    if(_this.isSignInFlag == "no"){
        signOutInfo();
    }
    else{
        signInInfo();
    }
    _this.loginShow=function(){
           if(_this.isSignInFlag == "no"){
               angular.element(".loginForm").show();
        }
    }
    _this.registerShow=function(){
        if(_this.isSignInFlag == "no"){
            angular.element(".registerForm").show();
        }
    }
    _this.loginAction=function(){
        $http.post("/shoppingweb/loginAction?userName="+_this.userName+"&password="+_this.password).success( function(data) {
            if(data.isLogin === "yes"){
                storage["name"] = _this.userName;
                storage["isSignIn"]="yes";
                signInInfo();
            }
            else{
                _this.showNotCorrectLoginTips=true;
            }
        });
    }
    _this.registerAction=function(){
        if(_this.passwordOnce == _this.passwordTwice){
            $http.post("/shoppingweb/registerAction?userName="+_this.userNameUnique+"&password="+_this.passwordOnce).success( function(data) {
                if(data.isLogin === "yes"){
                    storage["name"] = _this.userNameUnique;
                    storage["isSignIn"]="yes";
                    signInInfo();
                    angular.element(".registerForm").hide();
                }
                else{
                    _this.showExistedUserTips=true;
                }
            });
        }
        else{
            _this.showNotSamePasswordTips=true;
        }

    }
    _this.signOut=function(){
        signOutInfo();
    }
    _this.hideForm=function(){
        angular.element(".loginForm").hide();
        angular.element(".registerForm").hide();
    }
    function signInInfo(){
        _this.userNameInNav=storage["name"];
        _this.isSignIn="欢迎!";
        _this.isSignOut="退出登录";
        _this.isRegister=null;
        angular.element(".loginForm").hide();
    }
    function signOutInfo(){
        _this.isSignIn="请登录";
        _this.isRegister="免费注册";
        _this.isSignOut=null;
        _this.userNameInNav=null;
        storage["isSignIn"]="no";
        storage["name"]=null;
        _this.isSignInFlag=storage["isSignIn"];
    }


}]);