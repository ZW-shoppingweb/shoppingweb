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
    if (storage["isSignIn"] === "yes") {
        $scope.userNameInHistory = storage["name"];
    }

}]);