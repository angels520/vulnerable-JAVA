/*
 Navicat Premium Data Transfer

 Source Server         : 5.6
 Source Server Type    : MySQL
 Source Server Version : 50529
 Source Host           : localhost:3306
 Source Schema         : shop

 Target Server Type    : MySQL
 Target Server Version : 50529
 File Encoding         : 65001

 Date: 23/05/2020 19:28:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(2) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(255) NULL DEFAULT 0,
  `cartname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cartprice` bigint(255) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shopimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES (1625948757, '草莓', 49, 'nihao', 'upload/9236793a-c251-48b5-8e72-7ff5d21f9fcc.jpg');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int(255) NULL DEFAULT 0,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `question` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `message` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '4', '4', '4', '4', '4');
INSERT INTO `message` VALUES (693039696, ' admin', 'admin@qq.com', 'asdasdsa', 'adsadasd', 'asdasdasdasd');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `shopid` int(255) NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1760723784, 'aa', 'aa', 'aa', 'aa');
INSERT INTO `order` VALUES (654174541, 'aa', 'aa', 'aa', 'aa');
INSERT INTO `order` VALUES (1737539805, 'aa', 'aa', 'aa', 'aa');
INSERT INTO `order` VALUES (2137445311, 'aa', 'aa', 'aa', 'aa');
INSERT INTO `order` VALUES (945941492, 'aa', 'aa', 'aa', 'aa');
INSERT INTO `order` VALUES (681087780, ' nihao', 'aaaaaaa@qq.com', '1285739121', '北京');
INSERT INTO `order` VALUES (1962616559, ' nihao', 'aaaaaaa@qq.com', '1285739121', '北京');
INSERT INTO `order` VALUES (1962616559, 'aa', '11', 'aaaaaa', '啊啊啊啊啊啊啊啊啊啊啊啊');
INSERT INTO `order` VALUES (1962616559, ' nihao', 'aaaaaaa@qq.com', '啊啊啊啊啊啊啊啊', '啊啊啊啊啊啊啊啊啊啊啊啊');
INSERT INTO `order` VALUES (1962616559, 'aa', 'aa', 'aa', 'aa');
INSERT INTO `order` VALUES (1962616559, 'asd', 'asdas', 'asdasd', 'dasd');
INSERT INTO `order` VALUES (1541738688, 'nihao', 'nihao@qq.com', '18975648275', '北京朝阳区');
INSERT INTO `order` VALUES (1854441848, 'nihao', 'nihao@qq.com', '18975648275', '北京朝阳区');

-- ----------------------------
-- Table structure for shangpin
-- ----------------------------
DROP TABLE IF EXISTS `shangpin`;
CREATE TABLE `shangpin`  (
  `shopid` int(255) NOT NULL,
  `shopname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shopimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `shopdetail` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shangpin
-- ----------------------------
INSERT INTO `shangpin` VALUES (898424364, '桃', 'upload/fca79748-1f8e-4172-a6df-09db7d384df5.jpg', '当我们的肝处于负状态时，身体可能会分泌一种物质，对肝脏的损害是非常非常大的，也有的人定期喝酒，健康的肝脏。');
INSERT INTO `shangpin` VALUES (1688120921, '西瓜', 'upload/173e7e54-4c65-4441-a6ab-3b38fccab7a8.jpg', '可以大量补充人体所需要的水分，在天气炎热的时候，多吃西瓜或西瓜汁可以排出体内多余的热量和毒素，去热解暑');
INSERT INTO `shangpin` VALUES (697706306, '椰子', 'upload/3d11eb43-0c96-443c-9e58-65dc24240cb6.jpg', '椰子汁含有丰富的钾、镁等矿物质，其成分与细胞内液相似，可纠正脱水和电解质紊乱，达到利尿消肿之效。');
INSERT INTO `shangpin` VALUES (2022161199, '梨', 'upload/dd320bb9-8295-462e-adbb-f758081dc70e.jpg', '吃梨子时舌头会有粗糙的感觉。这是因为木质及纤维等石细胞汇集而成，可刺激肠管，消除便秘。');
INSERT INTO `shangpin` VALUES (169028333, '草莓', 'upload/9236793a-c251-48b5-8e72-7ff5d21f9fcc.jpg', '食草莓对积食胀痛、胃口不佳、营养不良或病后体弱消瘦，是极为有益的。草莓中含有的果胶及纤维素，可促进胃肠蠕动，改善便秘。');
INSERT INTO `shangpin` VALUES (1524313635, '葡萄', 'upload/44bb116d-f5f5-41a7-bb2c-fde89d92665b.jpg', '长期吸烟者可多吃葡萄。葡萄既可帮助肺部细胞排毒，又具有祛痰作用，可缓解吸烟引起的呼吸道发炎、痒痛等症状。');
INSERT INTO `shangpin` VALUES (54274136, '香蕉', 'upload/d2baa36a-41cd-4068-9a5c-a8f4915e58b6.jpg', '香蕉中特殊的化学有机物可以促进人体脑部产生羟色胺，减轻疼痛和忧郁等情绪，使人心情变得愉悦、放松，所以香蕉也称为“快乐果”。');
INSERT INTO `shangpin` VALUES (1576903322, '苹果', 'upload/f8a4a6b4-0960-4a81-9b86-078c2993747e.jpg', '吃苹果可以减少血液中胆固醇含量，增加胆汁分泌和胆汁酸功能，因而可避免胆固醇沉淀在胆汁中形成胆结石。');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(255) UNSIGNED NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `islock` int(2) NULL DEFAULT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (33303091, 'lisi', 'c3cb6d12c40908943b64bc0681af47db', 'lisi@qq.com', 0);
INSERT INTO `user` VALUES (323496145, 'nihao', '7036317bfa74b871c8687f0d6bf412f8', 'nihao@qq.com', 0);
INSERT INTO `user` VALUES (1487361281, ' zhangsan', '1d7f40760960e7bd9443513f22ab9af', 'zhangsan@qq.com', 0);

SET FOREIGN_KEY_CHECKS = 1;
