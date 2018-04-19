CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) DEFAULT NULL COMMENT '类目名称',
  `category_type` int(11) DEFAULT NULL COMMENT '类目编号',
  `create_time` datetime NOT NULL default current_timestamp  COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL default current_timestamp on update current_timestamp COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT  INTO  `product_category` (`category_id`,`category_name`,`category_type`,`create_time`,`update_time`)
VALUES (1,'热榜',11,'2017-04-19 23:04:52','2017-04-19 23:04:52'),
  (2,'好吃的',22,'2017-04-19 23:04:52','2017-04-19 23:04:52');


create table `product_info`(
  `product_id` VARCHAR(32) not null,
  `product_name` VARCHAR(64) not null comment '商品名称',
  `product_price` DECIMAL(8,2) not null comment '单价',
  `product_stock` int not null comment '库存',
  `product_description` VARCHAR(64) comment '描述',
  `product_icon` varchar(512) comment '小图',
  `product_status` tinyint(3) DEFAULT 0 comment '商品状态，0-正常，1-下架',
  `category_type` int not null comment '类目编号',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
	`update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	PRIMARY key (`product_id`)
);


insert into `product_info` (`product_id`,`product_name`,`product_price`,
`product_stock`,`product_description`,`product_icon`,`product_status`,
`category_type`,`create_time`,`update_time`)
VALUES
('adf12','皮蛋粥',12,39,'好吃的皮蛋粥','',0,1,'2017-04-19 23:16:52','2017-04-19 23:16:52'),
('adadfdsf12','慕斯蛋糕',12,23,'美味爽口','',0,2,'2017-04-19 23:16:52','2017-04-19 23:16:52'),
('adf1123ds2','蜜汁鸡翅',22,231,'好吃','',0,2,'2017-04-19 23:16:52','2017-04-19 23:16:52')

