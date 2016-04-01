proapp.controller('myPagingCtrl', ['$scope','$http',function ($scope,$http) {
    $scope.noUseHrefHome=false;
    $scope.noUseHrefPre=false;
    $scope.noUseHrefNext=false;
    $scope.noUseHrefEnd=false;
    setTimeout(function () {
        $scope.$apply(function () {
            var curNum =$scope.currentPageNum;
            var lastNum =$scope.maxPageNum;
            if(curNum === "1") {
                $scope.noUseHrefHome=true;
                $scope.noUseHrefPre=true;
            }
            if(lastNum === curNum){
                $scope.noUseHrefNext=true;
                $scope.noUseHrefEnd=true;
            }
        });
    }, 0);
    $scope.nextPage=function(pageId){
        console.log("**"+pageId);
        $scope.nextPageId=pageId;
        $("#formp").submit();
    }
}]);