/*
 Navicat Premium Data Transfer

 Source Server         : wnwn
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : utf-8

 Date: 07/27/2016 21:20:13 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `order_info`
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_name` varchar(255) DEFAULT NULL,
  `order_price` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `order_user` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `order_info`
-- ----------------------------
BEGIN;
INSERT INTO `order_info` VALUES ('1', '手机', '5000', '2'), ('2', '电脑', '8000', '2'), ('3', 'PAD', '3000', '2');
COMMIT;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_sex` enum('男','女') DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('1', '张三', '男'), ('2', '王五', '男'), ('3', 'nima', '女'), ('4', '阿萨德', '男'), ('6', 'asd', '男'), ('9', 'ssss', '女'), ('10', '我去', '女');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
