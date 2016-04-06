create table shopCart (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    userName varchar(40),
    `productId` varchar(32) NOT NULL,
     productNum INT NOT NULL ,
      constraint userName foreign key (userName) references USER (userName),
      constraint productId foreign key (productId) references product (productId),
    primary key (id);
);