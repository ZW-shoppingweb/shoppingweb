create table shopCart (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    userName varchar(40),
    `productId` varchar(32) NOT NULL,
     productNum INT NOT NULL ,
     `addProductTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
      constraint userName foreign key (userName) references USER (userName) ON DELETE CASCADE ON UPDATE CASCADE,
      constraint productId foreign key (productId) references product (productId) ON DELETE CASCADE ON UPDATE CASCADE,
    primary key (`id`)
);