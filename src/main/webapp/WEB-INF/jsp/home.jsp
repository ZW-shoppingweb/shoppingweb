<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Shopping</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body ng-app="userApp">
<%@ include file="head.jsp" %>
<script type="application/javascript" src="<c:url value="/scripts/home.js"/>"></script>
<div ng-controller="HomeController as homeCtrl" class="home-category-list">
    <div class="category-list">
        <form action="/shoppingweb/productList" method="post" id="process">
            <ul class="home-category-nav">
                <input type="hidden" id="productCategoryInput" name="productCategory" ng-model="productCategory"
                       value="${productCategory}"/>
                <li ng-class={'activeStyle':active1} class="home-category-nav-item">
                    <a ng-click="category(1)" class="category-nav-link">女装</a>
                </li>
                <li ng-class={'activeStyle':active2} class="home-category-nav-item">
                    <a ng-click="category(2)" class="category-nav-link">男装</a>
                </li>
                <li ng-class={'activeStyle':active3} class="home-category-nav-item">
                    <a ng-click="category(3)" class="category-nav-link">家居家纺</a>

                </li>
                <li ng-class={'activeStyle':active4} class="home-category-nav-item">
                    <a ng-click="category(4)" class="category-nav-link">汽车用品</a>
                </li>
                <li ng-class={'activeStyle':active5} class="home-category-nav-item">
                    <a ng-click="category(5)" class="category-nav-link">玩具</a>
                </li>
                <li ng-class={'activeStyle':active6} class="home-category-nav-item">
                    <a ng-click="category('')" class="category-nav-link">全部</a>
                </li>
            </ul>
        </form>
    </div>
    <ul class="bxslider">
        <li class="bx-clone">
            <img src="<c:url value="http://bpic.pic138.com/13/61/75/44bOOOPIC46_1024.jpg!/fw/780/quality/90/unsharp/true/compress/true"/>"/>
        </li>
        <li class="bx-clone">
            <img src="<c:url value="/images/s2.jpg"/>"/>
        </li>
        <li class="bx-clone">
            <img src="<c:url value="http://bpic.pic138.com/11/31/58/39b1OOOPICee.jpg!/fw/780/quality/90/unsharp/true/compress/true"/>"/>
        </li>
    </ul>
</div>
<div class="newProducts">
    <h2>新品推荐</h2>
    <div class="newProductlist">
        <c:if test="${!empty newProduct }">
        <c:forEach items="${newProduct }" var="pro">
        <div class="oneNewProduct">
            <a  href="<c:url value="/product/${pro.productId}?userName=${memberName}"/>">
                <img src="${pro.productImage }"><br>
                <p>${pro.productName}</p>
                <p class="price">¥${pro.productPrice}元</p>
            </a>
        </div>
        </c:forEach>
        </c:if>
    </div>
    <br><br>
</div>
<div class="siteFooter">
    <div class="siteFooterService">
        <ul>
            <li class="serviceItem">
                <span class="serviceIcon"><img src="http://store.res.meizu.com/resources/php/store/static/common/widgets/site-footer/7.png"></span>
                <p class="serviceDesc"><span class="serviceDescNum">7天</span>&nbsp;<span class="serviceDescContent">无理由退货</span></p>
            </li>
            <li class="serviceSplitLine"><span></span></li>
            <li class="serviceItem">
                <span class="serviceIcon"><img src="http://store.res.meizu.com/resources/php/store/static/common/widgets/site-footer/15.png"></span>
                <p class="serviceDesc"><span class="serviceDescNum">15天</span>&nbsp;<span class="serviceDescContent">换货保障</span></p>
            </li>
            <li class="serviceSplitLine"><span></span></li>
            <li class="serviceItem">
                <span class="serviceIcon"><img src="http://store.res.meizu.com/resources/php/store/static/common/widgets/site-footer/speed.png"></span>
                <p class="serviceDesc"><span class="serviceDescNum">百城</span>&nbsp;<span class="serviceDescContent">速达</span></p>
            </li>
            <li class="serviceSplitLine"><span></span></li>
            <li class="serviceItem">
                <span class="serviceIcon"><img src="http://store.res.meizu.com/resources/php/store/static/common/widgets/site-footer/baoyou.png"></span>
                <p class="serviceDesc"><span class="serviceDescNum">全场</span>&nbsp;<span class="serviceDescContent">包邮</span></p>
            </li>
        </ul>
    </div>
    <div class="siteFooterNavs">
        <div class="footerNavItems">
           <h4>帮助说明</h4>
           <ul>
               <li>支付方式</li>
               <li>配送说明</li>
               <li>售后服务</li>
               <li>付款帮助</li>
           </ul> 
        </div>
        <div class="footerNavItems">
           <h4>Flyme OS</h4>
           <ul>
               <li>云服务</li>
               <li>App下载</li>
               <li>网上商店</li>
               <li>查找商品</li>
           </ul> 
        </div>
        <div class="footerNavItems">
           <h4>关于我们</h4>
           <ul>
               <li>关于购物</li>
               <li>加入我们</li>
               <li>联系我们</li>
               <li>法律声明</li>
           </ul> 
        </div>
        <div class="footerNavItems">
           <h4>关注我们</h4>
           <ul>
               <li>新浪微博</li>
               <li>腾讯微博</li>
               <li>QQ空间</li>
               <li>官方微信</li>
           </ul> 
        </div>
        <div class="footerNavItems">
           <h4>24小时全国服务热线</h4>
           <p class="serviceTel">400-788-3333</p>
           <p class="serviceCall">24小时在线客服</p>
        </div>
    </div>
    <div class="siteFooterEnd">
        <p>2016 Shopping Telecom Equipment Co.All rights reserverd.备案号：XXXXXXXXX 经营许可证编号：XXXXXXXX 营业执照</p>
    </div>
</div>

</body>
</html>