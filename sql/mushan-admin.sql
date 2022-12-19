/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : 192.168.150.131:3306
 Source Schema         : mushan-admin

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 19/12/2022 14:56:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(11) NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int(11) NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int(11) NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2013 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 1, '', NULL, '', 1, 0, 'M', '0', '0', '', 'Setting', 'admin', '2022-08-10 20:49:43', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '用户管理', 1, 0, 'user', 'views/sys/user', NULL, 1, 0, 'C', '0', '0', 'system:sysUser:list', 'User', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (3, '获取路由', 4, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:menu:getRouters', '#', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (4, '菜单管理', 1, 0, 'menu', 'views/sys/menu', NULL, 1, 0, 'C', '0', '0', 'system:sysMenu:list', 'Position', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (5, '角色管理', 1, 0, 'role', 'views/sys/role', NULL, 1, 0, 'C', '0', '0', 'system:sysRole:list', 'ChatDotSquare', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (6, '代码生成', 0, 1, '', '', '', 1, 0, 'M', '0', '0', '', 'EditPen', 'admin', '2022-08-10 20:49:43', '', NULL, '系统管理目录');
INSERT INTO `sys_menu` VALUES (7, '添加', 2, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:sysUser:add', '#', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (8, '修改', 2, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:sysUser:edit', '#', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (9, '删除', 2, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:sysUser:remove', '#', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (10, '添加', 4, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:sysMenu:add', '#', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (2004, '修改', 4, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:sysMenu:edit', NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (2005, '删除', 4, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:sysMenu:remove', NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (2006, '添加', 5, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:sysRole:add', NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (2007, '查询', 5, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:sysRole:query', NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (2008, '修改', 5, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:sysRole:edit', NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (2009, '删除', 5, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'system:sysRole:remove', NULL, '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (2012, '数据列表', 6, 0, 'generate', 'views/generate/index', NULL, 1, 0, 'C', '0', '0', 'generate:list', 'Refresh', '', NULL, '', NULL, '');
INSERT INTO `sys_menu` VALUES (2013, '生成代码', 2012, 0, '', NULL, NULL, 1, 0, 'F', '0', '0', 'generate:code', NULL, '', NULL, '', NULL, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色权限字符串',
  `role_sort` int(11) NULL DEFAULT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 134 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2022-08-10 20:49:43', '', NULL, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 2, '2', 1, 1, '0', '0', 'admin', '2022-08-10 20:49:43', '', NULL, '普通角色');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NULL DEFAULT NULL COMMENT '菜单ID',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 264 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (133, 1, 115);
INSERT INTO `sys_role_menu` VALUES (133, 2, 116);
INSERT INTO `sys_role_menu` VALUES (133, 7, 117);
INSERT INTO `sys_role_menu` VALUES (133, 8, 118);
INSERT INTO `sys_role_menu` VALUES (133, 9, 119);
INSERT INTO `sys_role_menu` VALUES (133, 4, 120);
INSERT INTO `sys_role_menu` VALUES (133, 3, 121);
INSERT INTO `sys_role_menu` VALUES (133, 10, 122);
INSERT INTO `sys_role_menu` VALUES (133, 2004, 123);
INSERT INTO `sys_role_menu` VALUES (133, 2005, 124);
INSERT INTO `sys_role_menu` VALUES (1, 1, 247);
INSERT INTO `sys_role_menu` VALUES (1, 2, 248);
INSERT INTO `sys_role_menu` VALUES (1, 7, 249);
INSERT INTO `sys_role_menu` VALUES (1, 8, 250);
INSERT INTO `sys_role_menu` VALUES (1, 9, 251);
INSERT INTO `sys_role_menu` VALUES (1, 4, 252);
INSERT INTO `sys_role_menu` VALUES (1, 3, 253);
INSERT INTO `sys_role_menu` VALUES (1, 10, 254);
INSERT INTO `sys_role_menu` VALUES (1, 2004, 255);
INSERT INTO `sys_role_menu` VALUES (1, 2005, 256);
INSERT INTO `sys_role_menu` VALUES (1, 5, 257);
INSERT INTO `sys_role_menu` VALUES (1, 2006, 258);
INSERT INTO `sys_role_menu` VALUES (1, 2007, 259);
INSERT INTO `sys_role_menu` VALUES (1, 2008, 260);
INSERT INTO `sys_role_menu` VALUES (1, 2009, 261);
INSERT INTO `sys_role_menu` VALUES (1, 6, 262);
INSERT INTO `sys_role_menu` VALUES (1, 2012, 263);
INSERT INTO `sys_role_menu` VALUES (1, 2013, 264);
INSERT INTO `sys_role_menu` VALUES (2, 1, 281);
INSERT INTO `sys_role_menu` VALUES (2, 2, 282);
INSERT INTO `sys_role_menu` VALUES (2, 7, 283);
INSERT INTO `sys_role_menu` VALUES (2, 8, 284);
INSERT INTO `sys_role_menu` VALUES (2, 9, 285);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 131 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 103, 'admin', '22233', '00', '123@qq.com', '122223', '1', '', '$2a$10$wYElKbRfmL.iVFfekufeWOE0feihr0jzw2hfiTl/MP0pr6TfP3TnW', '0', '0', '127.0.0.1', '2022-08-10 20:49:43', 'admin', '2022-08-10 20:49:43', '', NULL, '管理员');
INSERT INTO `sys_user` VALUES (126, NULL, 'test1', '22222111', '00', '22333', '1222', '0', '', '$2a$10$wYElKbRfmL.iVFfekufeWOE0feihr0jzw2hfiTl/MP0pr6TfP3TnW', '0', '0', '', NULL, '', NULL, '', NULL, NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色ID',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (125, 1, 3);
INSERT INTO `sys_user_role` VALUES (126, 2, 4);
INSERT INTO `sys_user_role` VALUES (127, 1, 5);
INSERT INTO `sys_user_role` VALUES (NULL, 2, 6);

-- ----------------------------
-- Table structure for undo_log
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime(0) NOT NULL,
  `log_modified` datetime(0) NOT NULL,
  `ext` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ux_undo_log`(`xid`, `branch_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
