/*
Navicat MySQL Data Transfer

Source Server         : 192.168.10.151
Source Server Version : 50173
Source Host           : 192.168.10.151:3306
Source Database       : hxg

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-03-29 11:48:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `people`
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `name` varchar(30) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('张三', '11');
INSERT INTO `people` VALUES ('李四', '12');
INSERT INTO `people` VALUES ('王五', '13');
INSERT INTO `people` VALUES ('赵六', '14');
