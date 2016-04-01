/**
 * Created by cxzhao on 3/30/16.
 */
proapp.controller('SearchController', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    setTimeout(function () {
        $scope.$apply(function () {
            if ($scope.productPrice == "ASC")
                document.getElementById("price1").checked = "checked";
            if ($scope.productPrice == "DESC")
                document.getElementById("price2").checked = "checked";
            if ($scope.productName == "ASC")
                document.getElementById("name1").checked = "checked";
            if ($scope.productName == "DESC")
                document.getElementById("name2").checked = "checked";

            switch ($scope.productCategory) {
                case '1':
                    $scope.active1 = true;
                    break;
                case '2':
                    $scope.active2 = true;
                    break;
                case '3':
                    $scope.active3 = true;
                    break;
                case '4':
                    $scope.active4 = true;
                    break;
                case '5':
                    $scope.active5 = true;
                    break;
                default:
                    $scope.active6 = true;
            }
            document.getElementById("productCategoryInput").value = $scope.productCategory;
        });
    }, 0);


    $scope.category = function (id) {
        document.getElementById("productCategoryInput").value = id;
        document.getElementById("processForm").submit();
    }
}]);