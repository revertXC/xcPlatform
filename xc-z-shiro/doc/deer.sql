/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : deer

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-02-22 21:46:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1', '1', '2018-02-22 18:57:20');
INSERT INTO `sys_role_permission` VALUES ('2', '1', '2', '2018-02-22 18:57:24');
INSERT INTO `sys_role_permission` VALUES ('3', '1', '3', '2018-02-22 18:57:27');
INSERT INTO `sys_role_permission` VALUES ('4', '1', '4', '2018-02-22 18:57:31');

-- ----------------------------
-- Table structure for sys_t_operation
-- ----------------------------
DROP TABLE IF EXISTS `sys_t_operation`;
CREATE TABLE `sys_t_operation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '操作表',
  `code` varchar(255) DEFAULT NULL COMMENT '编码',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除 0否 1是',
  `update_by` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_t_operation
-- ----------------------------
INSERT INTO `sys_t_operation` VALUES ('1', 'create', '创建', '0', '1', '2018-02-21 22:31:17', '1', '2018-02-21 22:31:11');
INSERT INTO `sys_t_operation` VALUES ('2', 'update', '修改', '0', '1', '2018-02-21 22:31:41', '1', '2018-02-21 22:31:38');
INSERT INTO `sys_t_operation` VALUES ('3', 'delete', '删除', '0', '1', '2018-02-21 22:31:56', '1', '2018-02-21 22:31:59');
INSERT INTO `sys_t_operation` VALUES ('4', 'view', '查询', '0', '1', '2018-02-21 22:32:19', '1', '2018-02-21 22:32:22');

-- ----------------------------
-- Table structure for sys_t_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_t_permission`;
CREATE TABLE `sys_t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限表',
  `resource_id` bigint(20) DEFAULT NULL COMMENT ' 资源ID',
  `operation_id` bigint(20) DEFAULT NULL COMMENT '操作Id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除 0否 1是',
  `update_by` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_t_permission
-- ----------------------------
INSERT INTO `sys_t_permission` VALUES ('1', '1', '1', null, '0', '1', '2018-02-22 16:55:28', '1', '2018-02-22 16:56:01');
INSERT INTO `sys_t_permission` VALUES ('2', '1', '2', null, '0', '1', '2018-02-22 16:55:28', '1', '2018-02-22 16:56:01');
INSERT INTO `sys_t_permission` VALUES ('3', '1', '3', null, '0', '1', '2018-02-22 16:55:28', '1', '2018-02-22 16:56:01');
INSERT INTO `sys_t_permission` VALUES ('4', '1', '4', null, '0', '1', '2018-02-22 16:55:28', '1', '2018-02-22 16:56:01');

-- ----------------------------
-- Table structure for sys_t_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_t_resource`;
CREATE TABLE `sys_t_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `resource_type` int(2) DEFAULT '0' COMMENT '资源类型 0菜单 1按钮',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除 0否 1是',
  `update_by` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_t_resource
-- ----------------------------
INSERT INTO `sys_t_resource` VALUES ('1', 'test', '0', '测试权限1', '0', '1', '2018-02-22 16:54:42', '1', '2018-02-22 16:54:45');

-- ----------------------------
-- Table structure for sys_t_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_t_role`;
CREATE TABLE `sys_t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色表',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除 0否 1是',
  `update_by` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_t_role
-- ----------------------------
INSERT INTO `sys_t_role` VALUES ('1', 'admin', '管理员', '0', '1', '2018-02-22 16:54:11', '1', '2018-02-22 16:54:09');

-- ----------------------------
-- Table structure for sys_t_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_t_user`;
CREATE TABLE `sys_t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户表',
  `account` varchar(255) NOT NULL COMMENT '账号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除 0否 1是',
  `update_by` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_t_user
-- ----------------------------
INSERT INTO `sys_t_user` VALUES ('1', '123456', '123456', '谢聪', null, '0', null, '2018-02-21 11:27:50', null, '2018-02-21 11:51:29');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户对应角色表',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色Id',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `deleted` int(2) DEFAULT '0' COMMENT '是否删除 0否 1是',
  `update_by` bigint(20) DEFAULT NULL COMMENT '最后修改人',
  `update_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, '0', '1', '2018-02-22 19:00:14', '1', '2018-02-22 19:00:10');
