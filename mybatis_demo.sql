/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : mybatis_demo

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2015-12-03 10:27:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `sex` varchar(255) default NULL,
  `birthday` date default NULL,
  `address` varchar(255) default NULL,
  `detail` varchar(255) default NULL,
  `score` float(11,0) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'jelly', '女', null, '深圳', null, '12');
