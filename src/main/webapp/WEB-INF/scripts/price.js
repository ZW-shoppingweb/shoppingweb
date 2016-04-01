proapp.controller('priceController', ['$scope', function ($scope) {
    var storage = window.localStorage;
    if (storage["isSignIn"] == "no") {
        $scope.noUsePrice = false;
    }
    else {
        $scope.noUsePrice = true;
    }
}]);