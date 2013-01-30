/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : jason-blog

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2013-01-30 19:36:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `blog_article`
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `content` longtext COLLATE utf8_unicode_ci NOT NULL,
  `view_count` bigint(20) NOT NULL DEFAULT '0',
  `comment_count` bigint(20) NOT NULL DEFAULT '0',
  `priority` int(11) NOT NULL DEFAULT '0',
  `on_top` bit(1) NOT NULL DEFAULT b'0',
  `status` int(11) NOT NULL DEFAULT '0',
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB6C5E159158FB49B` (`user_id`),
  CONSTRAINT `FKB6C5E159158FB49B` FOREIGN KEY (`user_id`) REFERENCES `security_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES ('2', '記錄Oracle常用SQL', '<ol style=\"list-style-type :decimal ;\"><li><p>添加字段</p><pre class=\"brush:html;toolbar:false;\">ALTER TABLE RECEIPT \r\nadd (\r\nAPP_ID VARCHAR2(20 BYTE),\r\nAPP_NAME VARCHAR2(20 BYTE),\r\nAPP_TEL VARCHAR2(20 BYTE),\r\nAPP_ADD VARCHAR2(50 BYTE)\r\n);</pre><p><br /></p></li><li><p>修改表的數據類型</p><pre class=\"brush:html;toolbar:false;\">ALTER TABLE RECEIPT_NO  \r\nMODIFY (STATUS NUMBER(11, 0) )</pre><p><br /></p></li><li><p>其他<br /></p></li></ol>', '0', '0', '0', '', '0', '2013-01-27 11:31:59', '2013-01-27 11:31:59', '3');
INSERT INTO `blog_article` VALUES ('3', 'Ubuntu 12.4 环境搭建', '<p>unbunt 12.4安装环境 记之！</p><p><img id=\"5F398D55EC90B0E5EC2F15F8B13CB1FD\" src=\"http://m3.img.libdd.com/farm5/2012/1108/13/5F398D55EC90B0E5EC2F15F8B13CB1FD8DCB66283FE94_500_323.jpg\" /><br /></p><ol style=\"list-style-type :decimal ;\"><li><p>nginx</p><p>安装：</p><pre class=\"brush:html;toolbar:false;\">sudo apt-get install nginx</pre><p>常用命令：</p><pre class=\"brush:html;toolbar:false;\">sudo /etc/init.d/nginx start //启动\r\nsudo /etc/init.d/nginx reload //重载\r\nsudo /etc/init.d/nginx stop //停止\r\nsudo /etc/init.d/nginx restart //重启</pre><p>访问测试：</p><pre class=\"brush:html;toolbar:false;\">http://localhost/ 或者 你的IP</pre><p><img id=\"DFB67031103F17AC202C706A11EC5EEB\" src=\"http://m3.img.libdd.com/farm5/2012/1108/12/DFB67031103F17AC202C706A11EC5EEB4B4F94C4AEA34_500_183.jpg\" /> <br /></p></li><li><p>java</p><p>安装：<br /></p><pre class=\"brush:html;toolbar:false;\">vi /etc/apt/sources.list  //添加以下源 找你真辛苦\r\ndeb http://us.archive.ubuntu.com/ubuntu/ hardy multiverse\r\n                                                                        \r\nsudo apt-get update //更新apt源\r\n                                                                        \r\nsudo apt-get install sun-java6-jdk //安装\r\n                                                                        \r\n提示：安装过程中需要你回答是否同意使用协议（终端中红蓝色的提示界面），此时按tab键至OK，再按回车即可正常安装</pre><p>测试是否搞定:</p><p><img id=\"A1455D08DFFD58C44BD201864C9C5457\" src=\"http://m2.img.libdd.com/farm4/2012/1108/12/A1455D08DFFD58C44BD201864C9C545794DFF0310D32B_500_54.jpg\" /><br /></p></li><li><p>mysql</p><p>安装：</p><pre class=\"brush:html;toolbar:false;\">sudo apt-get install php5-cli php5-cgi mysql-server php5-mysql</pre><p>测试：</p><p><img id=\"4B3AC89140312B22258EAFA5B9D0C374\" src=\"http://m3.img.libdd.com/farm5/2012/1108/12/4B3AC89140312B22258EAFA5B9D0C3745DB11EC65A38F_500_157.jpg\" /><br /></p></li><li><p>git</p><p>安装：</p><pre class=\"brush:html;toolbar:false;\">sudo apt-get install git</pre><p><img id=\"1B0FD690D66E3AFF80AE5F4C5BDB3CA5\" src=\"http://m3.img.libdd.com/farm5/2012/1108/12/1B0FD690D66E3AFF80AE5F4C5BDB3CA52E2BFC270257B_500_229.jpg\" /></p><p><br /></p></li><li><p>maven</p><p>安装：</p><pre class=\"brush:html;toolbar:false;\">sudo apt-get install  maven</pre><p>测试：</p><p><img id=\"4D513AF9C30048688800D15E0AF3A778\" src=\"http://m3.img.libdd.com/farm5/2012/1108/13/4D513AF9C30048688800D15E0AF3A778BC78ADD5E920E_500_74.jpg\" /><br /></p></li><li><p>mongodb</p><p>安装：</p><pre class=\"brush:html;toolbar:false;\">sudo apt-get install mongodb</pre><p>检验：</p><p><img id=\"8FC94607E2B2F0A6135CA63FE7678AEF\" src=\"http://m3.img.libdd.com/farm5/2012/1108/14/8FC94607E2B2F0A6135CA63FE7678AEF90B15F6D17FCD_500_113.jpg\" /><br /></p></li><li><p>其他<br /></p></li></ol>', '0', '0', '0', '', '0', '2013-01-27 11:32:52', '2013-01-27 11:32:52', '3');
INSERT INTO `blog_article` VALUES ('4', '2012-10-29', '<p>今天是第一天上班！感觉有点空虚！有点累！真不知道为什么？<br /><br />离开了向日葵后，我的心有点不够踏实！因为有点不舍得，不舍得里面的人，有k哥，r哥，v哥！在这里大半年，我接触很多新的技术和东西！这里的环境确实喜欢！遗憾的是就是。。。！我懂的！<br /><br />这个决定确实够勇敢了！离开了奋斗两年的广州！上社是我的革命根据地，天河公园是我唯一喜欢的一块地！无聊的，心情不好的，心情很好的，都往天河公园跑去！谢谢天，谢谢地！有真的好的地方！<br /><br />漂来了珠海！环境确实比广州好很多！空气非常的好！新鲜凉爽！绿化一片！每一次逛海边都很舒服！<br /><br />来到了新公司，感觉没有我想象的好！不知道以后会怎样呢？无聊就玩玩cms！希望一切顺利！越做越好！</p>', '0', '0', '0', '', '0', '2013-01-27 11:33:39', '2013-01-27 11:33:39', '3');
INSERT INTO `blog_article` VALUES ('5', '我为何而生', '<p>我之所以追寻爱情，</p><p>首先，爱情使人心醉神迷，如此美妙的感觉，以致使我时常为了体验几小时爱的喜悦，而宁愿献出生命中其它一切；</p><p>其次，爱情可以解除孤独，身历那种可怕孤寂的人的战栗意识，会穿过世界的边缘，直入冰冷死寂的无底深渊；</p><p>最后，置身于爱的结合，我在一个神秘缩影中看到了圣贤与诗人们所预想的天堂。</p><p>这正是我所追寻的，尽管它对于人类的生活或许太过美好，却是我的最终发现。<br /></p><p style=\"text-align :right ;\"><br /></p><p style=\"text-align :right ;\"> 来自罗素的《我为何而生》</p><p style=\"text-align :right ;\">记于2012-10-17</p>', '0', '0', '0', '', '0', '2013-01-27 11:34:47', '2013-01-27 11:34:47', '3');
INSERT INTO `blog_article` VALUES ('6', 'for Sublime Text2', '<ul style=\"list-style-type :disc ;\"><li><p>Zen Coding</p></li></ul><ol style=\"list-style-type :decimal ;\"><li><p>安装 Package Control <a href=\"http://wbond.net/sublime_packages/package_control/installation\"></a><a href=\"http://wbond.net/sublime_packages/package_control/installation\">http://wbond.net/sublime_packages/package_control/installation</a></p></li><li><p>快捷键（ctrl+shift+p）弹出输入框，输入install package，马上弹出另一个输入框，输入你想要的安装软件ZenCoding，</p></li><li><p>Enter安装，重启SB软件，OK</p></li><li><p>用用吧！亲！</p></li><li><pre class=\"brush:html;toolbar:false;\">div#page&gt;div#logo.logo+ul#navigation&gt;li*5&gt;a\r\n        &lt;div id=\"page\"&gt;\r\n            &lt;div id=\"logo\" class=\"logo\"&gt;&lt;/div&gt;\r\n            &lt;ul id=\"navigation\"&gt;\r\n                &lt;li&gt;&lt;a href=\"\"&gt;&lt;/a&gt;&lt;/li&gt;\r\n                &lt;li&gt;&lt;a href=\"\"&gt;&lt;/a&gt;&lt;/li&gt;\r\n                &lt;li&gt;&lt;a href=\"\"&gt;&lt;/a&gt;&lt;/li&gt;\r\n                &lt;li&gt;&lt;a href=\"\"&gt;&lt;/a&gt;&lt;/li&gt;\r\n                &lt;li&gt;&lt;a href=\"\"&gt;&lt;/a&gt;&lt;/li&gt;\r\n            &lt;/ul&gt;\r\n        &lt;/div&gt;</pre><p><a href=\"http://www.qianduan.net/zen-coding-a-new-way-to-write-html-code.html\" target=\"_blank\">Zen Coding</a> 还不知道ZenCoding的同学强烈推荐去看一下</p><p><br /></p></li></ol><ul style=\"list-style-type :disc ;\"><li><p>Git</p></li></ul><ol style=\"list-style-type :decimal ;\"><li><p><a href=\"https://github.com/kemayo/sublime-text-2-git/wiki\"></a><a href=\"https://github.com/kemayo/sublime-text-2-git/wiki\"></a><a href=\"https://github.com/kemayo/sublime-text-2-git/wiki\">https://github.com/kemayo/sublime-text-2-git/wiki</a></p></li><li><p>查询wiki，使用之！</p></li></ol>', '0', '0', '0', '', '0', '2013-01-27 11:36:14', '2013-01-27 11:36:14', '3');
INSERT INTO `blog_article` VALUES ('7', 'MongoDB学习(五、所谓的高级更新)', '<p><img id=\"42037843171AD66F8DCEA322DE587A5D\" src=\"http://m3.img.libdd.com/farm5/2012/0909/00/42037843171AD66F8DCEA322DE587A5D14970A05049E_300_100.PNG\" /><br /></p><p><br /></p><p>这就是所谓的高级？</p><p><img id=\"E0C6A0FA29F03FB4DFB2282EF02C3A9C\" src=\"http://m3.img.libdd.com/farm5/2012/0909/00/E0C6A0FA29F03FB4DFB2282EF02C3A9CE46EBB8D7D8E_500_146.jpg\" /><br /></p><p><img id=\"6D1E216D6761E9A2990CD6073FF8DDE8\" src=\"http://m3.img.libdd.com/farm4/2012/0909/00/6D1E216D6761E9A2990CD6073FF8DDE8D3CFB78D7D8E_500_96.jpg\" /><br /></p><p><img id=\"C8502922A490058ADD73983D48082F99\" src=\"http://m3.img.libdd.com/farm5/2012/0909/00/C8502922A490058ADD73983D48082F99A8D49D8D7D8E_500_108.jpg\" /><br /></p><p><img id=\"E35D93CC20142A3192978FFC823697B6\" src=\"http://m3.img.libdd.com/farm4/2012/0909/00/E35D93CC20142A3192978FFC823697B67CE49C8D7D8E_500_86.jpg\" /><br /></p><p><img id=\"31414D555C2577FB063E3758F056F986\" src=\"http://m2.img.libdd.com/farm5/2012/0909/00/31414D555C2577FB063E3758F056F98616A2258D7D8E_500_115.jpg\" /> <br /></p><p><img id=\"C684D83F548FB25358965412463B88AF\" src=\"http://m3.img.libdd.com/farm4/2012/0909/00/C684D83F548FB25358965412463B88AF565CF68D7D8E_500_76.jpg\" /><br /></p>', '0', '0', '0', '', '0', '2013-01-27 11:36:51', '2013-01-27 11:36:51', '3');

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
  CONSTRAINT `FKD82975991D4D8A33` FOREIGN KEY (`role_id`) REFERENCES `security_role` (`id`),
  CONSTRAINT `FKD82975995D8BA230` FOREIGN KEY (`authority_id`) REFERENCES `security_authority` (`id`)
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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `truename` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of security_user
-- ----------------------------
INSERT INTO `security_user` VALUES ('1', 'admin123', 'admin123', '193b7c943276f1a33bac84dbda65e076', 'admin123@jasonsoso.com', null, '', '', '', '');
INSERT INTO `security_user` VALUES ('2', 'testtest', 'testtest', '50c8e8684eb3c812795af5cc8f4ed2fb', 'testtest@jasonsoso.com', null, '', '', '', '');
INSERT INTO `security_user` VALUES ('3', 'jasonsoso', 'jasonsoso', '12ef62d8d2528b1f73563b8b6fcc1011', 'jasonsoso@jasonsoso.com', null, '', '', '', '');

-- ----------------------------
-- Table structure for `security_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `security_user_role`;
CREATE TABLE `security_user_role` (
  `role_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK6DD3562BCF354522` (`role_id`),
  KEY `FK6DD3562B158FB49B` (`user_id`),
  CONSTRAINT `FK6DD3562B158FB49B` FOREIGN KEY (`user_id`) REFERENCES `security_user` (`id`),
  CONSTRAINT `FK6DD3562BCF354522` FOREIGN KEY (`role_id`) REFERENCES `security_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of security_user_role
-- ----------------------------
INSERT INTO `security_user_role` VALUES ('4028831d2a83372c012a8366fde30036', '1');
INSERT INTO `security_user_role` VALUES ('4028831d2a83853e012a83aacda10002', '2');
INSERT INTO `security_user_role` VALUES ('4028831d2a83372c012a8366fde30036', '3');
