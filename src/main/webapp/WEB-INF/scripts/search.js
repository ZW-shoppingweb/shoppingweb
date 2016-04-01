/**
 * Created by cxzhao on 3/30/16.
 */
proapp.controller('SearchController', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    setTimeout(function () {
        $scope.$apply(function () {
            if($scope.productPrice=="ASC")
                document.getElementById("price1").checked="checked";
            if($scope.productPrice=="DESC")
                document.getElementById("price2").checked="checked";
            if($scope.productName=="ASC")
                document.getElementById("name1").checked="checked";
            if($scope.productName=="DESC")
                document.getElementById("name2").checked="checked";

        });
    }, 0);


$scope.category= function (id) {

    document.getElementById("check"+id).checked="checked";
    document.getElementById("processForm").submit();

}
}]);