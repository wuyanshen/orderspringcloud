/*
 Navicat Premium Data Transfer

 Source Server         : mac_docker_mysql5728
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : orderspringcloud

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 07/02/2020 16:37:46
*/
USE orderspringcloud;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
BEGIN;
INSERT INTO `t_admin` VALUES (1, 'admin1', '123123');
COMMIT;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `flavor` varchar(11) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`),
  CONSTRAINT `t_menu_ibfk_1` FOREIGN KEY (`tid`) REFERENCES `t_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_menu` VALUES (1, '香酥鸡', 39, '五香', 1);
INSERT INTO `t_menu` VALUES (2, '烧椒扣肉', 46, '微辣', 1);
INSERT INTO `t_menu` VALUES (3, '栗子三杯鸡', 56, '五香', 1);
INSERT INTO `t_menu` VALUES (4, '毛血旺', 50, '麻辣', 1);
INSERT INTO `t_menu` VALUES (5, '菠菜拌粉丝', 22, '五香', 2);
INSERT INTO `t_menu` VALUES (6, '凉拌豆腐皮', 19, '微辣', 2);
INSERT INTO `t_menu` VALUES (7, '酱牛肉', 36, '麻辣', 2);
INSERT INTO `t_menu` VALUES (8, '鱼头豆腐汤', 32, '五香', 3);
INSERT INTO `t_menu` VALUES (9, '瘦肉鸡蛋白菜汤', 30, '五香', 3);
INSERT INTO `t_menu` VALUES (10, '西葫芦虾仁蒸饺', 26, '五香', 4);
INSERT INTO `t_menu` VALUES (11, '蛋炒饭', 18, '五香', 4);
INSERT INTO `t_menu` VALUES (12, '酥粒椰蓉面包', 12, '香甜', 5);
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `aid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `mid` (`mid`),
  KEY `aid` (`aid`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `t_order_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `t_menu` (`id`),
  CONSTRAINT `t_order_ibfk_3` FOREIGN KEY (`aid`) REFERENCES `t_admin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES (1, 1, 7, 1, '2019-02-06', 1);
INSERT INTO `t_order` VALUES (2, 1, 2, 1, '2019-02-06', 1);
INSERT INTO `t_order` VALUES (5, 1, 5, 1, '2019-02-06', 1);
INSERT INTO `t_order` VALUES (6, 1, 9, 1, '2019-02-06', 1);
INSERT INTO `t_order` VALUES (10, 1, 10, 1, '2019-02-06', 1);
INSERT INTO `t_order` VALUES (11, 1, 10, NULL, '2019-02-06', 0);
INSERT INTO `t_order` VALUES (12, 1, 10, 1, '2019-02-06', 1);
INSERT INTO `t_order` VALUES (14, 1, 6, 1, '2019-02-06', 1);
INSERT INTO `t_order` VALUES (16, 1, 10, 1, '2019-02-06', 1);
INSERT INTO `t_order` VALUES (19, 1, 7, 1, '2019-02-07', 1);
INSERT INTO `t_order` VALUES (26, 2, 8, NULL, '2019-02-08', 0);
INSERT INTO `t_order` VALUES (27, 2, 12, NULL, '2019-02-08', 0);
COMMIT;

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_type
-- ----------------------------
BEGIN;
INSERT INTO `t_type` VALUES (1, '热菜');
INSERT INTO `t_type` VALUES (2, '凉菜');
INSERT INTO `t_type` VALUES (3, '汤羹');
INSERT INTO `t_type` VALUES (4, '主食');
INSERT INTO `t_type` VALUES (5, '烘焙');
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `nickname` varchar(11) DEFAULT NULL,
  `gender` varchar(2) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `registerdate` date DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'zhangsan', '123123', '张三', '男', '13576765678', '2019-02-03', '科技路');
INSERT INTO `t_user` VALUES (2, 'lisi', '123123', '李四', '女', '18678987676', '2019-02-03', '科技路');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
