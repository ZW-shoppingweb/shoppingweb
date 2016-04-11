CREATE TABLE ordersProduct (
  orderId int(11) NOT NULL,
  productId varchar(32) NOT NULL,
  productNum int(11) NOT NULL,
  CONSTRAINT orderIdInOrderProduct FOREIGN KEY (orderId) REFERENCES orders (orderId) ON DELETE CASCADE ON UPDATE CASCADE
)