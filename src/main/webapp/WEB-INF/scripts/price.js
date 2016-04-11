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
    $scope.addCart = function (memberName) {
        $http({
            method: 'POST',
            data: {userName: memberName, productId: $scope.productId, productNum: $scope.productNum},
            url: "/shoppingweb/productCart"
        })
            .success(function (response, status, headers, config) {
                showCart(memberName);
                console.log("success devilery data", response);
            })
            .error(function (response, status, headers, config) {

            });

    }
    function showCart(memberName) {
        $("#cartShow").dropdown('toggle');
        $http({
            method: 'POST',
            data: memberName,
            url: "/shoppingweb/shopCartShow"

        }).success(function (data, status, headers, config) {
                $("#productName1").html("名称:"+data.cartProduct[0].product.productName + "数目:" + data.cartProduct[0].productNum);
                var productTotalPrice = 0;
                if (data.searchUser) {
                    for (var i = 0; i < data.allCartProduct.length; i++)
                        productTotalPrice += data.allCartProduct[i].product.productVipPrice * data.allCartProduct[i].productNum;
                    $("#productTotalPrice").text("总价:" + productTotalPrice);
                }
                else {
                    for (var i = 0; i < data.allCartProduct.length; i++)
                        productTotalPrice += data.allCartProduct[i].product.productPrice * data.allCartProduct[i].productNum;
                    $("#productTotalPrice").text("总价:" + productTotalPrice);
                }
                $("#productName2").html("名称:"+data.cartProduct[1].product.productName + "数目:" + data.cartProduct[1].productNum);
                console.log("success devilery data", data);
            })
            .error(function (response, status, headers, config) {

            });

    }


}]);
proapp.controller('historyController', ['$scope','$http', function ($scope,$http) {
    angular.element(".addressTable").hide();
    angular.element(".addressForm").hide();
    angular.element(".addNewAddress").hide();
    var storage = window.localStorage;
    var nowProductId;
    var nowPrice;
    $scope.currentPrice=function (productId,price,vipPrice,currentNum) {
        nowProductId=productId;
        if (storage["isSignIn"] === "no") {
            nowPrice=price;
        }
        else {
            nowPrice=vipPrice;
        }
        angular.element(".priceOf" + productId).html("价格:"+currentNum*nowPrice);
    }
    $scope.addNewAddress=function(){
        angular.element(".addressForm").show();
        angular.element(".submitOldAddress").hide();
    }
    $scope.checkout=function(member){
        angular.element(".addressTable").show();
        angular.element(".btncheck").hide();
        }
    $scope.hideMessage=function(){
        angular.element(".messageOfEmptyOrder").hide();
    }
    $scope.hideForm=function(){
        angular.element(".addressTable").hide();
        angular.element(".btncheck").show();
    }
    $scope.submitOrder=function (memberName,totalNum,totalPrice) {
        if(totalNum <= 0){
            angular.element(".messageOfEmptyOrder").show();
        }
        else {
            angular.element(".messageOfEmptyOrder").hide();
            $http({
                method: 'POST',
                data: {addressId:1,userName: memberName,productNum:totalNum,totalPrice:totalPrice},
                url: "/shoppingweb/submitOrder"
            }).success(function () {
                alert("成功提交订单");
                location.reload();
            });
        }
    }
}]);

function priceProductChange(memberName,productId,price,vipPrice){
    var storage = window.localStorage;
    var nowProductId=productId;
    var nowPrice;
    var currentNumber = $(".number" + nowProductId).val();
    if (storage["isSignIn"] === "no") {
        nowPrice=price;
    }
    else {
        nowPrice=vipPrice;
    }
    $(".priceOf" + nowProductId).html("价格:"+currentNumber*nowPrice);
    var datas={userName: memberName, productId: nowProductId, productNum: currentNumber};
    $.ajax({
        type: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        data: JSON.stringify(datas),
        dataType: 'json',
        url: "/shoppingweb/productCart"
    });
    if(currentNumber === '0'){
        location.reload();
    }
}