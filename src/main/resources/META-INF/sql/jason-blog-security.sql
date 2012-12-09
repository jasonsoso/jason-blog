/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : jason-blog

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2012-12-02 00:01:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `security_authority`
-- ----------------------------
DROP TABLE IF EXISTS `security_authority`;
CREATE TABLE `security_authority` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `display_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of security_authority
-- ----------------------------
INSERT INTO `security_authority` VALUES ('4028831d2a83372c012a834fb6f70003', 'A_ADMIN', '访问后台');
INSERT INTO `security_authority` VALUES ('4028831d2a83372c012a83501c490004', 'A_SECURITY_USER_LIST', '查看用户');
INSERT INTO `security_authority` VALUES ('4028831d2a83372c012a8350839e0006', 'A_SECURITY_USER_EDIT', '编辑用户');
INSERT INTO `security_authority` VALUES ('4028831d2a83372c012a83521df5000a', 'A_SECURITY_RESOURCE_EDIT', '编辑资源');
INSERT INTO `security_authority` VALUES ('4028831d2a83372c012a8352fc00000d', 'A_SECURITY_RESOURCE_LIST', '查看资源');
INSERT INTO `security_authority` VALUES ('4028831d2a83372c012a835617f60013', 'A_SECURITY_ROLE_LIST', '查看角色');
INSERT INTO `security_authority` VALUES ('4028831d2a83372c012a835656760015', 'A_SECURITY_ROLE_EDIT', '编辑角色');
INSERT INTO `security_authority` VALUES ('4028831d2a83372c012a835740590018', 'A_SECURITY_AUTHORITY_EDIT', '编辑权限');
INSERT INTO `security_authority` VALUES ('4028833631dadfd50131db08241f0009', 'A_SECURITY_AUTHORITY_LIST', '查看权限');

-- ----------------------------
-- Table structure for `security_authority_resource`
-- ----------------------------
DROP TABLE IF EXISTS `security_authority_resource`;
CREATE TABLE `security_authority_resource` (
  `authority_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `resource_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`resource_id`,`authority_id`),
  KEY `FKBC7170E95D8BA230` (`authority_id`),
  KEY `FKBC7170E93EFFCD9B` (`resource_id`),
  CONSTRAINT `FKBC7170E93EFFCD9B` FOREIGN KEY (`resource_id`) REFERENCES `security_resource` (`id`),
  CONSTRAINT `FKBC7170E95D8BA230` FOREIGN KEY (`authority_id`) REFERENCES `security_authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of security_authority_resource
-- ----------------------------
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a834fb6f70003', '4028831d2a83372c012a835c66c5001a');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a83501c490004', '4028831d2a83372c012a835f511b0020');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a8350839e0006', '4028831d2a83372c012a835fab9f0021');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a8350839e0006', '4028831d2a83372c012a836020cf0022');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a8350839e0006', '4028831d2a83372c012a836050b90023');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a8350839e0006', '4028831d2a83372c012a8360a0fb0024');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a83521df5000a', '4028831d2a83372c012a8364dbcf0031');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a83521df5000a', '4028831d2a83372c012a836522ca0032');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a83521df5000a', '4028831d2a83372c012a83657c740033');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a83521df5000a', '4028831d2a83372c012a83665c440035');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a8352fc00000d', '4028831d2a83372c012a8363d6a3002f');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a835617f60013', '4028831d2a83372c012a836102170025');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a835656760015', '4028831d2a83372c012a836146c10026');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a835656760015', '4028831d2a83372c012a836184760027');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a835656760015', '4028831d2a83372c012a8361cd950028');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a835656760015', '4028831d2a83372c012a8362183a0029');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a835740590018', '4028831d2a83372c012a836296b1002b');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a835740590018', '4028831d2a83372c012a8362ea9d002c');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a835740590018', '4028831d2a83372c012a83630da6002d');
INSERT INTO `security_authority_resource` VALUES ('4028831d2a83372c012a835740590018', '4028831d2a83372c012a83639777002e');
INSERT INTO `security_authority_resource` VALUES ('4028833631dadfd50131db08241f0009', '4028831d2a83372c012a83625a63002a');

-- ----------------------------
-- Table structure for `security_resource`
-- ----------------------------
DROP TABLE IF EXISTS `security_resource`;
CREATE TABLE `security_resource` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `value` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `priority` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `value` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of security_resource
-- ----------------------------
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a835c66c5001a', '查看后台', '/admin**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a835f511b0020', '查看用户', '/security/user/list**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a835fab9f0021', '新增用户', '/security/user/create**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a836020cf0022', '修改用户', '/security/user/*/edit**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a836050b90023', '删除用户', '/security/user/*/delete**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a8360a0fb0024', '批量删除用户', '/security/user/delete**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a836102170025', '查看角色', '/security/role/list**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a836146c10026', '新增角色', '/security/role/create**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a836184760027', '修改角色', '/security/role/*/edit**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a8361cd950028', '删除角色', '/security/role/*/delete**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a8362183a0029', '批量删除角色', '/security/role/delete**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a83625a63002a', '查看权限', '/security/authority/list**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a836296b1002b', '新增权限', '/security/authority/create**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a8362ea9d002c', '修改权限', '/security/authority/*/edit**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a83630da6002d', '删除权限', '/security/authority/*/delete**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a83639777002e', '批量删除权限', '/security/authority/delete**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a8363d6a3002f', '查看资源', '/security/resource/list**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a8364dbcf0031', '新增资源', '/security/resource/create**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a836522ca0032', '修改资源', '/security/resource/*/edit**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a83657c740033', '删除资源', '/security/resource/*/delete**', '0');
INSERT INTO `security_resource` VALUES ('4028831d2a83372c012a83665c440035', '批量删除资源', '/security/resource/delete**', '0');

-- ----------------------------
-- Table structure for `security_role`
-- ----------------------------
DROP TABLE IF EXISTS `security_role`;
CREATE TABLE `security_role` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `descr` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of security_role
-- ----------------------------
INSERT INTO `security_role` VALUES ('4028831d2a83372c012a8366fde30036', '系统管理员', '系统管理员');
INSERT INTO `security_role` VALUES ('4028831d2a83853e012a83aacda10002', '普通用户', '普通用户');

-- ----------------------------
-- Table structure for `security_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `security_role_authority`;
CREATE TABLE `security_role_authority` (
  `role_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `authority_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`role_id`,`authority_id`),
  KEY `FKD82975991D4D8A33` (`role_id`),
  KEY `FKD82975995D8BA230` (`authority_id`),
  CONSTRAINT `FKD82975995D8BA230` FOREIGN KEY (`authority_id`) REFERENCES `security_authority` (`id`),
  CONSTRAINT `FKD82975991D4D8A33` FOREIGN KEY (`role_id`) REFERENCES `security_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of security_role_authority
-- ----------------------------
INSERT INTO `security_role_authority` VALUES ('4028831d2a83372c012a8366fde30036', '4028831d2a83372c012a834fb6f70003');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83372c012a8366fde30036', '4028831d2a83372c012a83501c490004');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83372c012a8366fde30036', '4028831d2a83372c012a8350839e0006');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83372c012a8366fde30036', '4028831d2a83372c012a83521df5000a');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83372c012a8366fde30036', '4028831d2a83372c012a8352fc00000d');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83372c012a8366fde30036', '4028831d2a83372c012a835617f60013');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83372c012a8366fde30036', '4028831d2a83372c012a835656760015');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83372c012a8366fde30036', '4028831d2a83372c012a835740590018');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83372c012a8366fde30036', '4028833631dadfd50131db08241f0009');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83853e012a83aacda10002', '4028831d2a83372c012a834fb6f70003');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83853e012a83aacda10002', '4028831d2a83372c012a83501c490004');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83853e012a83aacda10002', '4028831d2a83372c012a8352fc00000d');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83853e012a83aacda10002', '4028831d2a83372c012a835617f60013');
INSERT INTO `security_role_authority` VALUES ('4028831d2a83853e012a83aacda10002', '4028833631dadfd50131db08241f0009');

-- ----------------------------
-- Table structure for `security_user`
-- ----------------------------
DROP TABLE IF EXISTS `security_user`;
CREATE TABLE `security_user` (
  `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `truename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of security_user
-- ----------------------------
INSERT INTO `security_user` VALUES ('4028831d2a83853e012a83c969140003', 'admin', 'admin', 'ceb4f32325eda6142bd65215f4c0f371', 'admin@jasonsoso.com', null, '', '', '', '');
INSERT INTO `security_user` VALUES ('4028831d2a83853e012a83c9a1b80004', 'test', 'test', '889255f1c9c8f12a353be255f78a848b', 'test@jasonsoso.com', null, '', '', '', '');

-- ----------------------------
-- Table structure for `security_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `security_user_role`;
CREATE TABLE `security_user_role` (
  `role_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK6DD3562B1D4D8A33` (`role_id`),
  KEY `FK6DD3562B64ED092C` (`user_id`),
  CONSTRAINT `FK6DD3562B64ED092C` FOREIGN KEY (`user_id`) REFERENCES `security_user` (`id`),
  CONSTRAINT `FK6DD3562B1D4D8A33` FOREIGN KEY (`role_id`) REFERENCES `security_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of security_user_role
-- ----------------------------
INSERT INTO `security_user_role` VALUES ('4028831d2a83372c012a8366fde30036', '4028831d2a83853e012a83c969140003');
INSERT INTO `security_user_role` VALUES ('4028831d2a83853e012a83aacda10002', '4028831d2a83853e012a83c9a1b80004');
