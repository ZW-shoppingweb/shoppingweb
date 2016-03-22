CREATE TABLE `product` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_city` varchar(30) NOT NULL,
  `product_image` varchar(1000) NOT NULL,
  `product_details_img` varchar(1000) DEFAULT NULL,
  `product_price` double(20,2) NOT NULL,
  `product_vipprice` double(20,2) NOT NULL,
  `product_introduce` varchar(4000) DEFAULT NULL,
  `product_category` varchar(1000) NOT NULL,
  PRIMARY KEY (`product_id`)
)