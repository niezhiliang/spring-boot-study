/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost:3306
 Source Schema         : quartz

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : 65001

 Date: 04/06/2019 16:56:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for quartz_info
-- ----------------------------
DROP TABLE IF EXISTS `quartz_info`;
CREATE TABLE `quartz_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `groupId` varchar(55) COLLATE utf8_bin DEFAULT NULL COMMENT '调度分组',
  `jobName` varchar(55) COLLATE utf8_bin DEFAULT NULL COMMENT '调度任务名称',
  `className` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'Job类地址',
  `sendParams` text COLLATE utf8_bin COMMENT '传递的参数',
  `invokeAt` datetime DEFAULT NULL COMMENT '执行时间',
  `createAt` datetime DEFAULT NULL COMMENT '创建时间',
  `jobStatus` int(11) DEFAULT NULL COMMENT '任务状态：1.待执行 2.完成 3.暂停',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;
