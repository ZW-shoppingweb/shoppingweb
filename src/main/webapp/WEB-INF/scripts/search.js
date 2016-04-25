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
        });
    }, 0);
}]);
$(function(){
    $(".sortPrice").hide();
    $(".sortPriceShow").bind('hover', function(){  
        $(".sortPrice").show();  
    });
    $(".sortPrice").hover(function(){
         $(".sortPrice").show();  
    });
    $(".sortPriceShow").bind('mouseout',function(){ 
        $(".sortPrice").hide(); 
    });
　　$(".searchADSC").hide();
    $(".sortProductNameShow").bind('hover', function(){  
        $(".searchADSC").show();  
    });
    $(".searchADSC").hover(function(){
         $(".searchADSC").show();  
    });
    $(".sortProductNameShow").bind('mouseout',function(){ 
        $(".searchADSC").hide(); 
    });
   
    

})