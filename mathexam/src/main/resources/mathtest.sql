/*
Navicat MySQL Data Transfer

Source Server         : ruangong_root
Source Server Version : 50722
Source Host           : 119.29.9.243:3306
Source Database       : mathtest

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-10-07 14:05:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `question_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目id',
  `unit_id` int(11) NOT NULL COMMENT '单元id',
  `content` text COMMENT '题干',
  `options` text,
  `answer` char(1) DEFAULT NULL COMMENT '正确答案',
  `urls` text,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('17', '1', '方程1', '{\"A\":\"-0.1\",\"B\":\"-0.2\",\"C\":\"-0.3\",\"D\":\"-0.4\"}', 'B', '[\"http://cdn.ruanjiangongcheng2.xyz/mathexam/unit1_0.jpg\"]');
INSERT INTO `question` VALUES ('18', '1', '方程2', '{\"A\":\"1\",\"B\":\"2\",\"C\":\"3\",\"D\":\"4\"}', 'B', '[\"http://cdn.ruanjiangongcheng2.xyz/mathexam/unit1_1.jpg\"]');
INSERT INTO `question` VALUES ('19', '1', '方程3', '{\"A\":\"43\",\"B\":\"45\",\"C\":\"47\",\"D\":\"49\"}', 'B', '[\"http://cdn.ruanjiangongcheng2.xyz/mathexam/unit1_2.jpg\"]');
INSERT INTO `question` VALUES ('20', '1', '方程4', '{\"A\":\"-2\",\"B\":\"-3\",\"C\":\"-4\",\"D\":\"-5\"}', 'A', '[\"http://cdn.ruanjiangongcheng2.xyz/mathexam/unit1_3.jpg\"]');
INSERT INTO `question` VALUES ('21', '2', '一个直角三角形的两条直角边分别是9和12，斜边长15，这个三角形的面积是()', '{\"A\":\"54\",\"B\":\"45\",\"C\":\"2333\"}', 'A', null);
INSERT INTO `question` VALUES ('22', '2', '下图中阴影部分的面积是8，平行四边形的面积是', '{\"A\":\"5\",\"B\":\"6\",\"C\":\"7\",\"D\":\"8\"}', 'D', '[\"http://cdn.ruanjiangongcheng2.xyz/mathexam/unit2_1.jpg\"]');
INSERT INTO `question` VALUES ('23', '2', '已知平行四边形的底是6，高4，求阴影部分的面积', '{\"A\":\"24\",\"B\":\"12\"}', 'A', '[\"http://cdn.ruanjiangongcheng2.xyz/mathexam/unit2_2.jpg\"]');
INSERT INTO `question` VALUES ('24', '2', '有一块三角形的玉米地，底是48米，高是底的2倍，如果每平方米可收玉米4.5千克，\r\n这块玉米地一共可以收玉米多少千克', '{\"A\":\"20736\",\"B\":\"20737\",\"C\":\"20738\",\"D\":\"20739\",\"E\":\"20740\"}', 'A', null);
INSERT INTO `question` VALUES ('25', '0', '1, 4, 9, 16, ()', '{\"A\":\"1110\",\"B\":\"10\",\"C\":\"12\",\"D\":\"20\",\"E\":\"25\",\"F\":\"36\"}', 'E', null);
INSERT INTO `question` VALUES ('26', '0', '1, 3, 6, 10, ()', '{\"A\":\"15\",\"B\":\"16\",\"C\":\"17\"}', 'A', null);
INSERT INTO `question` VALUES ('27', '0', '1, 2, 6, 24, 120, ()', '{\"A\":\"660\",\"B\":\"720\",\"C\":\"800\"}', 'B', null);
INSERT INTO `question` VALUES ('28', '0', '23, 232, 2321, 3232, ()', '{\"A\":\"1233\",\"B\":\"1234\",\"C\":\"3000\",\"D\":\"22345\"}', 'D', null);

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '单元id',
  `theme` varchar(20) NOT NULL COMMENT '单元主题',
  `percent` float NOT NULL COMMENT '该单元占总分数的比重',
  `max_score` int(11) DEFAULT NULL COMMENT '该单元最高成绩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of unit
-- ----------------------------
INSERT INTO `unit` VALUES ('0', '找规律', '0.3', '50');
INSERT INTO `unit` VALUES ('1', '列方程', '0.4', '75');
INSERT INTO `unit` VALUES ('2', '图形', '0.4', '100');
