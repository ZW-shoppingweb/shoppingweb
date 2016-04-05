proapp.controller('priceController', ['$scope', function ($scope) {
    var storage = window.localStorage;
    if (storage["isSignIn"] === "no") {
        $scope.noUsePrice = false;
    }
    else {
        $scope.noUsePrice = true;
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