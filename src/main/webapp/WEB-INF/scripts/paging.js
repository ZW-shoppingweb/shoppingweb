var app = angular.module('myPagingApp', []);
app.controller('myPagingCtrl', function($scope) {

    var curNum=angular.element("#currentPage").html();
    var lastNum=angular.element("#lastPage").attr("pageNum");
    if(curNum == 1) {
        //$("#prePage").removeAttr();
        angular.element("#prePage").removeAttr("href");
        angular.element("#firstPage").removeAttr("href");
    }
    if(lastNum == curNum){
        angular.element("#nextPage").removeAttr("href");
        angular.element("#lastPage").removeAttr("href");
    }
});