<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<%@ include file="head.jsp" %>
<img id="leftimg" src="images/left.png">
<div id="contenttext">
    <div id="titledetail">
        <img id="productimg" src="${product.product_image}">
        <div id="rightdetail">
            <h1 id="productname">${product.product_name}</h1>
            <h2 id="price1">￥${product.product_price}</h2>
            <h4 id="price2"> ￥${product.product_vipprice}/for VIP</h4>
            <p id="number">数目: <input type="number" min="1"/></p>
            <button>立即购买</button>
            <button id="buy">加入购物车</button>
        </div>
        <img id="righttopimg" src="images/right-top.png">
    </div>
    <div>
        <div id="productdetail">
            <h3>商品详情</h3>
            <hr color=#Gray>
            <p id="detailinfo">city: ${product.product_city} &nbsp&nbsp&nbspintroduce: ${product.product_introduce}
                &nbsp&nbsp&nbspcity: ${product.product_city}</p>
            <img id="detailimg" src="${product.product_details_img}">
            <img id="rightimg2" src="images/right2.png">
            <img id="rightimg3" src="images/right3.png">
        </div>
    </div>
</div>

</body>
</html>
