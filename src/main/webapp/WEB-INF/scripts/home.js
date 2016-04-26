proapp.controller('HomeController', ['$scope', '$location', '$http', function ($scope, $location, $http) {
    $scope.category = function (id) {
        document.getElementById("productCategoryInput").value = id;
        //document.getElementById("process").submit();
    }
    $(function(){
        $('.bxslider').bxSlider({
            auto: true,
            autoControls: true
        });
    });
}]);