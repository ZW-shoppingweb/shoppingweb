create table Address
(
    addressId int(11) NOT NULL AUTO_INCREMENT,
    firstName varchar(40) not null,
    lastName varchar(40) not null,
    emailAddress varchar(40) not null,
    userName varchar(40) not null,
    address varchar(40) not null,
    statusorder varchar(40) not null,
    primary key (addressId),
	constraint primaryname foreign key (userName) references USER (userName) ON DELETE CASCADE ON UPDATE CASCADE
);