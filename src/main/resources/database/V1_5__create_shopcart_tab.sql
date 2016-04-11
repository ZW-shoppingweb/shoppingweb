CREATE table shopCart (
    id int(11) NOT NULL AUTO_INCREMENT,
    userName varchar(40),
    productId varchar(32) NOT NULL,
    productNum INT NOT NULL ,
    addProductTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT userNameInShopCart FOREIGN KEY (userName) REFERENCES USER (userName) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT productIdInShopCart FOREIGN KEY (productId) REFERENCES product (productId) ON DELETE CASCADE ON UPDATE CASCADE,
    primary key (id)
);