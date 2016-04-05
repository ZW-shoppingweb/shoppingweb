/**
 * Created by cxzhao on 3/30/16.
 */
proapp.config(['$locationProvider', function ($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}]);
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
                console.log("success devilery data", response);
            })
            .error(function (response, status, headers, config) {

            });
    }


}]);
proapp.controller('historyController', ['$scope', function ($scope) {
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
}]);