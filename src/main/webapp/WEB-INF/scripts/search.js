/**
 * Created by cxzhao on 3/30/16.
 */
proapp.config(['$locationProvider', function ($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}]);
proapp.controller('SearchController', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    var _this = this;
    var query = {};
    _this.searchPrice = function () {
        query.filterName = $location.search().filterName;
        query.minPrice = $scope.minPrice;
        query.maxPrice = $scope.maxPrice;
        query.productName = $location.search().productName;
        query.productPrice = $location.search().productPrice;
        //console.log("==" + query.productCategory);
        $http({
            method: 'POST',
            data: query,
            url: "/shoppingweb/productList"
        })
            .success(function (response, status, headers, config) {
                //window.location.href = '/shoppingweb/productList';
                console.log("success devilery data",response);
            })
            .error(function (response, status, headers, config) {
//do  anything what you want;
                console.log("error devilery data");
            });
    }
}]);