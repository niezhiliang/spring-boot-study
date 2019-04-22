/*
 Navicat Premium Data Transfer
 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost
 Source Database       : student
 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : utf-8
 Date: 03/16/2019 11:18:04 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL COMMENT '名字',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` tinyint(4) DEFAULT '1' COMMENT '1.男2.女',
  `address` varchar(255) DEFAULT '杭州市江干区白杨街道' COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('2', '苏雨', '22', '2', '太阳系'), ('3', '张三', '18', '2', '银河系'), ('4', '李四', '20', '1', '浙江杭州江干下沙'), ('5', '王五', '21', '2', '浙江杭州'), ('6', '赵柳', '19', '1', '浙江杭州滨江'), ('7', '前期', '18', '2', '浙江杭州西湖'), ('8', '王八', '19', '1', '浙江杭州上城'), ('9', '李九', '20', '2', '浙江杭州下城'), ('10', '聂大', '21', '1', '浙江杭州富阳'), ('11', '王宝强', '22', '2', '浙江杭州余杭'), ('12', '聂三', '23', '1', '江西宜春'), ('13', '赵四', '24', '2', '江西南昌进贤'), ('14', '艾比利', '23', '1', '江西南昌新建'), ('15', '爱美丽', '27', '2', '江西九江'), ('16', '大猪蹄子', '27', '1', '江西赣州'), ('17', '哈哈', '28', '2', '河南商丘'), ('18', '嘻嘻', '29', '1', '河南周口'), ('19', '哥哥', '19', '2', '北京朝阳'), ('20', '姐姐三', '26', '1', '上海虹桥'), ('21', '幺鸡', '20', '2', '上海浦东'), ('22', '幺妹', '23', '1', '上海杨浦');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;