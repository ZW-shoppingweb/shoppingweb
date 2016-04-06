/**
 * Created by cxzhao on 3/30/16.
 */
proapp.controller('priceController', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    $scope.productNum=1;
    var storage = window.localStorage;
    if (storage["isSignIn"] === "no") {
        $scope.noUsePrice = false;
    }
    else {
        $scope.noUsePrice = true;
    }
    $scope.addCart = function () {
        var storage = window.localStorage;
        $http({
            method: 'POST',
            data: {userName: storage["name"], productId: $scope.productId, productNum: $scope.productNum},
            url: "/shoppingweb/productCart"
        })
            .success(function (response, status, headers, config) {
                $("#cartShow").dropdown('toggle');
                console.log("success devilery data", response);
            })
            .error(function (response, status, headers, config) {

            });
        $http({
            method: 'POST',
            data: storage["name"],
            url: "/shoppingweb/shopCartShow"

        }).success(function (data, status, headers, config) {
                $("#productName1").html(data.cartProduct[0].product.productName);
                $("#productName2").html(data.cartProduct[1].product.productName);
                 var productTotalPrice=0;
                if(data.searchUser)
                {
                    for (var i=0;i<data.allCartProduct.length;i++)
                        productTotalPrice+=data.allCartProduct[i].product.productVipPrice*data.allCartProduct[i].productNum;
                    console.log(productTotalPrice);
                    $("#productTotalPrice").text("总价:"+productTotalPrice);
                }
                else
                {
                    for (var i=0;i<data.allCartProduct.length;i++)
                        productTotalPrice+=data.allCartProduct[i].product.productPrice*data.allCartProduct[i].productNum;
                    $("#productTotalPrice").text("总价:"+productTotalPrice);
                }

                console.log("success devilery data", data);
            })
            .error(function (response, status, headers, config) {

            });
    }


}]);
proapp.controller('historyController', ['$scope','$http', function ($scope,$http) {
    var storage = window.localStorage;
    $scope.userNameInHistory="";
    if (storage["name"] != undefined) {
        $scope.userNameInHistory = storage["name"];
    }
    setTimeout(function () {
        $scope.$apply(function () {
            storage["name"] = $scope.userNameInHistory;
        });
    }, 10);
    function notshow(){
        $scope.isnotVipAndNoChange=false;
        $scope.isVipAndNoChange=false;
        $scope.isnotVipAndChange=false;
        $scope.isVipAndChange=false;
    }
    if (storage["isSignIn"] === "no") {
        notshow();
        $scope.isnotVipAndNoChange=true;
    }
    else{
        notshow();
        $scope.isVipAndNoChange=true;
    }
    $scope.priceProductChange=function(productId){
        if (storage["isSignIn"] === "no") {
            notshow();
            $scope.isnotVipAndChange=true;
        }
        else{
            notshow();
            $scope.isVipAndChange=true;
        }
        console.log(angular.element(".number"+productId).val())
        var currentNumber=angular.element(".number"+productId).val();
        $http({
            method: 'POST',
            data: {userName: storage["name"], productId: productId, productNum: currentNumber},
            url: "/shoppingweb/productCart"
        }).success(function (response, status, headers, config) {
            console.log("success devilery data", response);
        });
        if(currentNumber == '0'){
            location.reload();
        }

    }
}]);