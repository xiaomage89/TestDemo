CREATE DATABASE `b2be`;

CREATE TABLE `adminuser` (
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `user` varchar(32) DEFAULT NULL COMMENT '用户',
  `password` varchar(32) DEFAULT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=' '

CREATE TABLE `goodstable` (
  `id` varchar(32) NOT NULL COMMENT '商品ID',
  `goodstype_id` varchar(32) DEFAULT NULL COMMENT '类型',
  `goodname` varchar(32) DEFAULT NULL COMMENT '商品名称',
  `goodoldprice` decimal(32,8) DEFAULT NULL COMMENT '原价',
  `goodnewprice` decimal(32,8) DEFAULT NULL COMMENT '现价',
  `goodstore` int DEFAULT NULL COMMENT '库存',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `goodimg` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品信息 '

CREATE TABLE `goodstype` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `typeName` varchar(32) DEFAULT NULL COMMENT '类型名称',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='商品类型 商品类型兴起'