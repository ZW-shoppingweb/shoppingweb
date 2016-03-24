CREATE TABLE `product` (
  `productId` varchar(32) NOT NULL,
  `productName` varchar(100) NOT NULL,
  `productCity` varchar(30) NOT NULL,
  `productImage` varchar(1000) NOT NULL,
  `productDetailsImg` varchar(1000) DEFAULT NULL,
  `productPrice` double(20,2) NOT NULL,
  `productVipPrice` double(20,2) NOT NULL,
  `productIntroduce` varchar(4000) DEFAULT NULL,
  `productCategory` varchar(1000) NOT NULL,
  PRIMARY KEY (`productId`)
)