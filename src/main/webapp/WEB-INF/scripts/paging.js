proapp.controller('myPagingCtrl', ['$scope','$http',function ($scope,$http) {

console.log(this.namess);
    var curNum=angular.element("#currentPage").html();
    var lastNum=angular.element("#lastPage").attr("pageNum");
    $scope.noUseHrefHome=false;
    $scope.noUseHrefPre=false;
    $scope.noUseHrefNext=false;
    $scope.noUseHrefEnd=false;
    //$scope.lastPages="";
    if(curNum == "1") {
        $scope.noUseHrefHome=true;
        $scope.noUseHrefPre=true;
        angular.element("#prePage").removeAttr("href");
        angular.element("#firstPage").removeAttr("href");
    }
    if(lastNum == curNum){
        $scope.noUseHrefNext=true;
        $scope.noUseHrefEnd=true;
        //$scope.lastPages="";
        angular.element("#nextPage").removeAttr("href");
        angular.element("#lastPage").removeAttr("href");
    }
}]);