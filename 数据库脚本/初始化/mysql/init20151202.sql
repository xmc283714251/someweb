/*
Navicat MySQL Data Transfer

Source Server         : someweb
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : someweb

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2015-12-03 20:57:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `td_common_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `td_common_dictionary`;
CREATE TABLE `td_common_dictionary` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `zdlb` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '字典代码',
  `zdmc` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '字典名称',
  `dm` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '代码',
  `mc` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '名称',
  `parent_dm` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '父类代码',
  `descr` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '描述',
  `isvalid` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '是否有效表示 0：无效 1有效',
  `sn` int(4) DEFAULT NULL COMMENT '排序字段',
  `updatedate` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of td_common_dictionary
-- ----------------------------

-- ----------------------------
-- Table structure for `td_common_organization`
-- ----------------------------
DROP TABLE IF EXISTS `td_common_organization`;
CREATE TABLE `td_common_organization` (
  `orgid` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '机构ID',
  `orgcode` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '机构代码',
  `orgname` varchar(120) COLLATE utf8_unicode_ci NOT NULL COMMENT '机构名称',
  `parentid` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '父类机构ID',
  `orgjc` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '机构简称',
  PRIMARY KEY (`orgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of td_common_organization
-- ----------------------------

-- ----------------------------
-- Table structure for `td_common_orguser`
-- ----------------------------
DROP TABLE IF EXISTS `td_common_orguser`;
CREATE TABLE `td_common_orguser` (
  `userid` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户主键',
  `orgid` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '机构主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of td_common_orguser
-- ----------------------------

-- ----------------------------
-- Table structure for `td_common_parameter`
-- ----------------------------
DROP TABLE IF EXISTS `td_common_parameter`;
CREATE TABLE `td_common_parameter` (
  `id` int(4) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `prokey` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '键',
  `provalue` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '值',
  `descr` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of td_common_parameter
-- ----------------------------

-- ----------------------------
-- Table structure for `td_common_user`
-- ----------------------------
DROP TABLE IF EXISTS `td_common_user`;
CREATE TABLE `td_common_user` (
  `userid` varchar(10) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户主键',
  `username` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(60) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `realname` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(60) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话号码',
  `isvalid` varchar(1) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '有效性 0：无效，1:有效',
  `createdate` varchar(14) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '创建时间',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of td_common_user
-- ----------------------------
INSERT INTO `td_common_user` VALUES ('1', 'admin', '111111', '系统管理员', 'admin@someweb.com', '18711090603', '1', '20151202012034');
