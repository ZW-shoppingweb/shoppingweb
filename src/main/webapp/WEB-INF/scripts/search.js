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
            $scope.maxPageNum=$scope.maxPageNums;
        });
    }, 0);
    pageStyle(1);
    
    function productList(pagesId){
        $("#currentPageNum").html(pagesId);
        var productPrices=$("input[name='productPrice']:checked").val();
        var productNames=$("input[name='productName']:checked").val();
        if($scope.isNewProduct === "yes"){
            productPrices="";
            productNames="";
        }
        else{
            $scope.isNewProduct="no";
        }
        $http({
            method: 'POST',
            url: "/shoppingweb/productList",
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            data: {
                isNewProduct:$scope.isNewProduct,
                productCategory:$scope.productCategory,
                productPrice: productPrices,
                productName: productNames,
                minPrice: $("input[name='minPrice']").val(),
                maxPrice: $("input[name='maxPrice']").val(),
                productNum: $scope.productNum,
                pageId:pagesId,
                productTitle: $("#searchByName").val()
            }
        }).success(function (datas) {
            $(".getProductList").hide();
            $scope.maxPageNum=datas.indexPage.maxPageNum;
            pageStyle(pagesId);
            $scope.items=datas.indexPage.pageData;
        });
    }
    $scope.filterProduct = function () {
        console.log("**77");
        $scope.isNewProduct="no";
        $scope.productNum=0;
        productList(1);
    }
    $scope.showStock=function(){
        $scope.isNewProduct="no";
        $scope.productNum=1;
        productList(1);
    }
    $scope.showNewProduct=function(){
        $scope.isNewProduct="yes";
        $scope.productNum=0;
        productList(1);
    }
    $scope.nextPage=function(pagesId){
        if(pagesId=="pre"){
            pagesId=parseInt($("#currentPageNum").html())-1;
        }
        if(pagesId=="next"){
            pagesId=parseInt($("#currentPageNum").html())+1;
        }
        if(pagesId=="last"){
            pagesId=$scope.maxPageNum;
        }
        productList(pagesId);
        $("#currentPageNum").html(pagesId);
        $('html, body').animate({scrollTop: 0},0);
    }
    function pageStyle(curNum){
        $scope.noUseHrefHome=false;
        $scope.noUseHrefPre=false;
        $scope.noUseHrefNext=false;
        $scope.noUseHrefEnd=false;
        var lastNum =$scope.maxPageNum;
        if(curNum == "1") {
            $scope.noUseHrefHome=true;
            $scope.noUseHrefPre=true;
        }
        if(lastNum == curNum){
            $scope.noUseHrefNext=true;
            $scope.noUseHrefEnd=true;
       }
    }
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