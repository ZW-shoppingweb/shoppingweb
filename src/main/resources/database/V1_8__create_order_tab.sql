CREATE TABLE orders (
  orderId int(11) NOT NULL AUTO_INCREMENT,
  addressId int(11) NOT NULL,
  userName varchar(40) NOT NULL,
  productNum int(11) NOT NULL,
  totalPrice DOUBLE (11,2) NOT NULL,
  PRIMARY KEY (orderId),
  CONSTRAINT userNameInorder FOREIGN KEY (userName) REFERENCES user (userName) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT addressIddInOrder FOREIGN KEY (addressId) REFERENCES address (addressId) ON DELETE CASCADE ON UPDATE CASCADE
)