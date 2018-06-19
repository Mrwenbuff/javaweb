/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50172
Source Host           : localhost:3306
Source Database       : hrm

Target Server Type    : MYSQL
Target Server Version : 50172
File Encoding         : 65001

Date: 2018-06-19 21:45:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `name` varchar(32) NOT NULL COMMENT '部门名称',
  `remark` varchar(256) DEFAULT NULL COMMENT '详细描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
INSERT INTO `t_dept` VALUES ('1', '技术部', '技术部');
INSERT INTO `t_dept` VALUES ('2', '运营部', '运营部');
INSERT INTO `t_dept` VALUES ('3', '财务部', '财务部');
INSERT INTO `t_dept` VALUES ('4', '中公办', '中公办');
INSERT INTO `t_dept` VALUES ('5', '市场部', '市场部');
INSERT INTO `t_dept` VALUES ('6', '教学部', '教学部');

-- ----------------------------
-- Table structure for t_document
-- ----------------------------
DROP TABLE IF EXISTS `t_document`;
CREATE TABLE `t_document` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '文件编号',
  `title` varchar(64) NOT NULL COMMENT '文档标题',
  `filename` varchar(64) NOT NULL COMMENT '文件名',
  `remark` varchar(256) DEFAULT NULL COMMENT '文件描述',
  `createTime` datetime NOT NULL,
  `userId` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_DOCUMENT_USER` (`userId`),
  CONSTRAINT `FK_DOCUMENT_USER` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_document
-- ----------------------------

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `createDate` datetime NOT NULL,
  `cardId` int(8) NOT NULL,
  `deptId` int(8) NOT NULL,
  `jobId` int(8) NOT NULL,
  `name` varchar(32) NOT NULL,
  `postCode` varchar(64) DEFAULT NULL,
  `address` varchar(256) DEFAULT NULL,
  `tel` varchar(16) DEFAULT NULL COMMENT '电话',
  `phone` varchar(16) NOT NULL COMMENT '手机号',
  `qq` varchar(16) DEFAULT NULL,
  `email` varchar(32) NOT NULL,
  `sex` int(8) NOT NULL DEFAULT '1',
  `party` varchar(16) DEFAULT NULL COMMENT '政治面貌',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `race` varchar(8) DEFAULT NULL COMMENT '民族',
  `education` varchar(16) DEFAULT NULL COMMENT '所学专业',
  `hobby` varchar(128) DEFAULT NULL COMMENT '爱好',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `speciality` varchar(32) DEFAULT NULL COMMENT '专业',
  PRIMARY KEY (`id`),
  KEY `FK_EMPLOYEE_DEPT` (`deptId`),
  KEY `FK_EMPLOYEE_JOB` (`jobId`),
  CONSTRAINT `FK_EMPLOYEE_DEPT` FOREIGN KEY (`deptId`) REFERENCES `t_dept` (`id`),
  CONSTRAINT `FK_EMPLOYEE_JOB` FOREIGN KEY (`jobId`) REFERENCES `t_job` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1', '2018-06-17 16:21:08', '1001', '1', '1', 'aa', '10001', 'somewhere', '123456', '123456', '123456', '1000000000@qq.com', '1', '党员', '2018-06-07 16:23:57', '汉', '高职高专', 'aa111', 'aaa111', '软件工程');
INSERT INTO `t_employee` VALUES ('2', '2018-06-17 16:24:57', '1002', '2', '2', 'bb', '10001', 'somewhere', '123', '123', '45613', '1000000000@qq.com', '2', '党员', '2018-06-22 16:26:39', '汉', '本科', 'bb22', 'bb22', '软件工程');

-- ----------------------------
-- Table structure for t_job
-- ----------------------------
DROP TABLE IF EXISTS `t_job`;
CREATE TABLE `t_job` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '职位编号',
  `name` varchar(32) NOT NULL COMMENT '职位名称',
  `remark` varchar(256) DEFAULT NULL COMMENT '职位描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_job
-- ----------------------------
INSERT INTO `t_job` VALUES ('1', '职员', '职员');
INSERT INTO `t_job` VALUES ('2', 'java工程师', 'java工程师');
INSERT INTO `t_job` VALUES ('3', 'java中级工程师', 'java中级工程师');
INSERT INTO `t_job` VALUES ('4', 'java高级工程师', 'java高级工程师');
INSERT INTO `t_job` VALUES ('5', '系统管理员', '系统管理员');
INSERT INTO `t_job` VALUES ('6', '架构师', '架构师');
INSERT INTO `t_job` VALUES ('7', '主管', '主管');
INSERT INTO `t_job` VALUES ('8', '经理', '经理');
INSERT INTO `t_job` VALUES ('9', '总经理', '总经理');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `title` varchar(64) NOT NULL COMMENT '公告标题',
  `content` text NOT NULL COMMENT '公告内容',
  `createTime` datetime NOT NULL,
  `userId` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_NOTICE_USER` (`userId`),
  CONSTRAINT `FK_NOTICE_USER` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('1', 'aa', 'aa', '2018-06-17 23:02:25', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `creatDate` datetime NOT NULL COMMENT '创建时间',
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `loginname` varchar(32) DEFAULT NULL COMMENT '登陆名',
  `password` varchar(64) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '用户状态',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2018-06-17 16:19:21', '1', 'admin', '123456', '2', '超级管理员');
