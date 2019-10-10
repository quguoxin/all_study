CREATE  TABLE IF NOT EXISTS phone (
id  INT AUTO_INCREMENT PRIMARY KEY COMMENT '编号（自增，主键）',
model VARCHAR(20) NOT NULL UNIQUE COMMENT '型号（手机型号不可相同）',
price DOUBLE  NOT NULL COMMENT '手机价格' ,
dayPrice   DOUBLE NOT NULL  COMMENT '日租价格',
store  INT  NOT NULL COMMENT '库存'
)COMMENT ='手机表' ENGINE=INNODB CHARSET=utf8;

INSERT INTO `phone` (`model`,`price`,`dayPrice`,`store`) VALUES 
('iPhone4S',2000,100,10),
('iPhone5S',3000,200,10),
('iPhone6S',4000,300,10),
('iPhone7S',5000,400,10),
('iPhone8S',6000,500,10);