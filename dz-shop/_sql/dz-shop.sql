/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : dz-shop

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-04-29 08:50:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dz_image_category
-- ----------------------------
DROP TABLE IF EXISTS `dz_image_category`;
CREATE TABLE `dz_image_category` (
  `int_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(512) DEFAULT NULL,
  `category_info` varchar(512) DEFAULT NULL,
  `author` varchar(512) DEFAULT NULL,
  `category_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `stateflag` varchar(20) DEFAULT '0',
  PRIMARY KEY (`int_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dz_image_category
-- ----------------------------
INSERT INTO `dz_image_category` VALUES ('1', '幻灯片', '测试', 'root', '2018-09-04 10:46:08', '0');

-- ----------------------------
-- Table structure for dz_image_host
-- ----------------------------
DROP TABLE IF EXISTS `dz_image_host`;
CREATE TABLE `dz_image_host` (
  `host_id` int(11) NOT NULL AUTO_INCREMENT,
  `host_name` varchar(512) DEFAULT NULL,
  `host_url` varchar(512) DEFAULT NULL,
  `author` varchar(512) DEFAULT NULL,
  `host_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `stateflag` varchar(20) DEFAULT '0',
  PRIMARY KEY (`host_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dz_image_host
-- ----------------------------
INSERT INTO `dz_image_host` VALUES ('1', '1号图片服务器', '127.0.0.1:8521', 'root', '2018-09-27 15:54:54', '0');

-- ----------------------------
-- Table structure for dz_image_main
-- ----------------------------
DROP TABLE IF EXISTS `dz_image_main`;
CREATE TABLE `dz_image_main` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `img_name` varchar(512) DEFAULT NULL,
  `img_index` int(11) DEFAULT NULL,
  `img_hight` int(11) DEFAULT NULL,
  `img_width` int(11) DEFAULT NULL,
  `img_url` varchar(512) DEFAULT NULL,
  `author` varchar(512) DEFAULT NULL,
  `img_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `img_category` int(11) DEFAULT NULL,
  `stateflag` varchar(20) DEFAULT '0',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dz_image_main
-- ----------------------------
INSERT INTO `dz_image_main` VALUES ('1', 'aa.png', '1', '800', '500', '/upload/aa.png', 'root', '2018-09-04 15:47:07', '1', '0');
INSERT INTO `dz_image_main` VALUES ('2', '0.png', '2', '800', '500', '/upload/0.png', 'root', '2018-10-12 15:39:13', '1', '0');

-- ----------------------------
-- Table structure for dz_token
-- ----------------------------
DROP TABLE IF EXISTS `dz_token`;
CREATE TABLE `dz_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ----------------------------
-- Records of dz_token
-- ----------------------------
INSERT INTO `dz_token` VALUES ('24', '27rt0tmtk33oux8hdcndu398rifvg8nl', '2018-09-12 04:07:59', '2018-09-11 16:07:59');

-- ----------------------------
-- Table structure for dz_user
-- ----------------------------
DROP TABLE IF EXISTS `dz_user`;
CREATE TABLE `dz_user` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL DEFAULT '',
  `password` varchar(32) DEFAULT '',
  `gender` tinyint(1) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `last_login_ip` varchar(15) DEFAULT '',
  `user_level_id` tinyint(3) DEFAULT NULL,
  `nickname` varchar(60) DEFAULT '',
  `mobile` varchar(20) DEFAULT '',
  `register_ip` varchar(45) DEFAULT '',
  `avatar` varchar(255) DEFAULT '',
  `weixin_openid` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dz_user
-- ----------------------------
INSERT INTO `dz_user` VALUES ('24', '微信用户xcq1kgamkk7z', 'oHI4Q5WejuAdpGIc8LcyOQc9h7Y4', '1', null, '2018-09-11 16:07:58', '2018-09-11 16:07:58', '8.8.8.8', null, '海孟eynolds', null, '8.8.8.8', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83eouXZBJkWG5Ycnomiba4Nagu2w4eXX0OvxQUs3C78rHvQUOfxp4JCBRMRQexUsFXz6XFMOicXDjM13g/132', 'oHI4Q5WejuAdpGIc8LcyOQc9h7Y4');

-- ----------------------------
-- Table structure for dz_user_level
-- ----------------------------
DROP TABLE IF EXISTS `dz_user_level`;
CREATE TABLE `dz_user_level` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL DEFAULT '',
  `description` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dz_user_level
-- ----------------------------
INSERT INTO `dz_user_level` VALUES ('1', '普通用户', '0');
INSERT INTO `dz_user_level` VALUES ('2', 'vip', '10000');
INSERT INTO `dz_user_level` VALUES ('4', '高级VIP', '100000');
