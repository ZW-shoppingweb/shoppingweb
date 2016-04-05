proapp.controller('priceController', ['$scope', function ($scope) {
    var storage = window.localStorage;
    if (storage["isSignIn"] === "no") {
        $scope.noUsePrice = false;
    }
    else {
        $scope.noUsePrice = true;
    }
    //setTimeout(function () {
    //    $scope.$apply(function () {
    //        var storage = window.localStorage;
    //        document.getElementById("userName").value = storage["name"];
    //    })
    //})
    $scope.addCart=function(){
        var storage = window.localStorage;
       // document.getElementById("userName").value = storage["name"];
        $http({
            method: 'POST',
            data: {userName:storage["name"],productId:$scope.productId,productName:$scope.productName} ,
            url: "/shoppingweb/productCart"
        })
            .success(function (data, status, headers, config) {

                console.log("success devilery data",data);
            })
            .error(function (response, status, headers, config) {

            });}

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