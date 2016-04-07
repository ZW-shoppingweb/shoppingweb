var proapp = angular.module('userApp', ['ngMessages']);
proapp.controller('userController', ['$scope', '$http', function ($scope, $http) {
    var _this = this;
    angular.element(".loginForm").hide();
    angular.element(".registerForm").hide();
    _this.showNotSamePasswordTips = false;
    _this.showExistedUserTips = false;
    _this.showNotCorrectLoginTips = false;
    var storage = window.localStorage;
    setTimeout(function () {
        $scope.$apply(function () {
            storage["name"] = _this.currentUserName;
        });
    }, 10);
    console.log("11"+storage["name"]);
    if (storage["name"] === undefined || storage["name"] === "") {
        signOutInfo();
    }
    else {
        signInInfo();
    }
    _this.loginShow = function () {
        if (storage["isSignIn"] === "no") {
            angular.element(".loginForm").show();
        }
    }
    _this.registerShow = function () {
        if (storage["isSignIn"] === "no") {
            angular.element(".registerForm").show();
        }
    }
    _this.loginAction = function () {
        $http({
            method: 'POST',
            url: "/shoppingweb/loginAction",
            headers: {
                'Content-Type': 'application/json'
            },
            data: {
                userName: _this.userName,
                password: _this.password
            }
        }).success(function (data) {
            if (data.isLogin === "yes") {
                storage["name"] =data.name;
                storage["isSignIn"] = "yes";
                signInInfo();
                location.reload();
            }
            else {
                _this.showNotCorrectLoginTips = true;
            }
        });
    }
    _this.registerAction = function () {
        if (_this.passwordOnce == _this.passwordTwice && _this.passwordOnce != undefined) {
            $http({
                method: 'POST',
                data: {
                    userName: _this.userNameUnique,
                    password: _this.passwordOnce
                },
                url: "/shoppingweb/registerAction"
            }).success(function (data) {
                if (data.isLogin === "yes") {
                    storage["name"] =data.name;
                    storage["isSignIn"] = "yes";
                    signInInfo();
                    location.reload();
                    angular.element(".registerForm").hide();
                }
                else {
                    _this.showExistedUserTips = true;
                }
            });
        }
        else {
            _this.showNotSamePasswordTips = true;
        }

    }
    _this.signOut = function () {
        var url = '/shoppingweb/signOutAction';
        $http.get(url).success(function (data) {
            if (data.isLogin === "no") {
                signOutInfo();
            }
        });
        window.localStorage.removeItem("name");
    }
    _this.hideForm = function () {
        angular.element(".loginForm").hide();
        angular.element(".registerForm").hide();
    }
    function signInInfo() {
        _this.isSignIn = "欢迎!";
        _this.isSignOut = "退出登录";
        _this.isRegister = null;
        angular.element(".loginForm").hide();
    }

    function signOutInfo() {
        _this.isSignIn = "请登录";
        _this.isRegister = "免费注册";
        _this.isSignOut = null;
        storage["isSignIn"] = "no";
        angular.element("#userNameInNav").html("");
    }
    _this.shopCartShow = function (memberName) {
        showCart(memberName);
        signInInfo();
    }
    function showCart(memberName)
    {
        $http({
            method: 'POST',
            data: memberName,
            url: "/shoppingweb/shopCartShow"

        })
            .success(function (data, status, headers, config) {
                $scope.productName1 = data.cartProduct[0].product.productName;
                $scope.productName2 = data.cartProduct[1].product.productName;
                $scope.productNum1 = data.cartProduct[0].productNum;
                $scope.productNum2 = data.cartProduct[1].productNum;
                $scope.productTotalPrice = 0;
                if (data.searchUser) {
                    for (var i = 0; i < data.allCartProduct.length; i++)
                        $scope.productTotalPrice += data.allCartProduct[i].product.productVipPrice * data.allCartProduct[i].productNum;
                }
                else {
                    for (var i = 0; i < data.allCartProduct.length; i++)
                        $scope.productTotalPrice += data.allCartProduct[i].product.productPrice * data.allCartProduct[i].productNum;
                }

                console.log("success devilery data", data);
            })
            .error(function (response, status, headers, config) {

            });
    }

}]);
