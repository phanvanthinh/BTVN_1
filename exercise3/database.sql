create TABLE user (
  id int(11) NOT NULL,
  userName varchar(50) NOT NULL,
  fullName varchar(50) DEFAULT NULL,
  phone varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
)


INSERT INTO user VALUES (1,'nvA','NgueynVanA','12345');
INSERT INTO user VALUES (2,'nvB','NgueynVanB','12345');
INSERT INTO user VALUES (3,'nvC','NgueynVanC','12345');