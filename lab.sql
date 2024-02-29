/*
 Navicat Premium Data Transfer

 Source Server         : hyperV_dev
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : 172.19.135.49:3306
 Source Schema         : lab

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 29/02/2024 12:26:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appoint
-- ----------------------------
DROP TABLE IF EXISTS `appoint`;
CREATE TABLE `appoint`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户',
  `lab_id` int NULL DEFAULT NULL COMMENT '实验室',
  `status` int NOT NULL COMMENT '状态',
  `appoint_day` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '日期',
  `time` int NULL DEFAULT NULL COMMENT '时间段',
  `create_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
  `update_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '预约' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appoint
-- ----------------------------
INSERT INTO `appoint` VALUES (20, 17, 17, 1, '2024-02-29', 3, '2024-02-26 21:56:04', '2024-02-26 21:56:04');

-- ----------------------------
-- Table structure for archives
-- ----------------------------
DROP TABLE IF EXISTS `archives`;
CREATE TABLE `archives`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `title` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '攻略标题',
  `summary` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '攻略简介',
  `sort_id` int NULL DEFAULT NULL COMMENT '分类',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '详细内容',
  `address` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '所在城市',
  `is_banner` int NULL DEFAULT NULL COMMENT '是否推荐',
  `image_url` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '图片',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `type` int NULL DEFAULT NULL COMMENT '状态',
  `create_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
  `update_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新时间',
  `read_count` int NULL DEFAULT NULL,
  `document_url` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL,
  `score` double(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '攻略' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of archives
-- ----------------------------
INSERT INTO `archives` VALUES (24, '实验室人员要求', 'CNAS CL01-2018《检测和校准实验室能力认可准则》中对实验室人员的专业、学历、工作经历、培训情况、能力确认和人员授权等方面都有相应的要求，为了能够清晰、系统地展示实验室人员是否符合认可标准及其专业领域应用说明的要求，实验室一般都会建立每个员工的人员业务档案，那么人员业务档案中包括哪些内容是符合CNAS CL01-2018《检测和校准实验室能力认可准则》要求呢？', 11, '### 一、人员的基本信息材料\n包括人员履历表、身份证复印件、学历证书复印件、学位证书复印件或结业证书的复印件。实验室人员在工作中进行了继续教育，所取得学位证书等材料也应及时归入人员业务档案。\n### 二、工作经历资料\n实验室有些人员在进入实验室工作前具有其他工作背景，如果之前从事的是和目前相同的本专业工作，实验室在向他们收取资料时，应有相应的工作经历证明材料，如工作履历、聘书、各级专业技术资格(职称)证书、就职实验室的书面证明等材料。\n\n对于工作起点就在本实验室的人员，实验室也应有相应文件或记录表格来及时更新这些人员的工作年限。这是由于CNAS CL01-2018《检测和校准实验室能力认可准则》及其应用说明中对于不同领域的实验室关键岗位人员的学历不满足要求时，可以用一定时间的专业工作经历、职称水平来弥补。如关键技术人员、授权签字人等。在实验室评审或授权相应岗位人员时，人员的业务档案起到查询的关键作用\n![trosdtrspaceimg_340571ec1f3df3ab18d884ae9bb0e816.jpg_r_1360x1360x95_b0316735.jpg](https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2024-01-08//653d4086-f295-4b19-8b95-d6440fef9a5b)\n### 三、培训材料\n培训材料可以分为人员上岗前的培训材料和工作中的在岗培训材料。检验检测人员是实验室的主体，检验检测人员的能力直接影响检验检测结果的质量。不论是应届毕业生还是有工作经历的人员，或者是轮岗及重新上岗的人员，在进入具体的检验检测岗位前必须经过上岗培训。因此，所有检验检测人员的业务档案中一定要包括人员上岗前的培训材料，一般实验室是以培训记录表格的形式记载人员的培训过程。\n\n在实验室人员工作的过程中，为了使自身水平能够满足不断更新的检验检测方法、检验检测技术的需要，实验室会组织内部培训，或让检验检测人员参加外部专项培训。这些培训都应有相应的记录和培训证明，并在培训后归入个人的业务档案中。在归档时确认培训记录是否填写了培训效果的评价，并且有相应的人员签字。', NULL, 2, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2024-01-08//3b8d17a2-90d6-43bf-8653-4190151f1f85_u=4132783540,2204210902&fm=253&fmt=auto&app=120&f=JPEG.webp', 6, 1, '2024-01-08 20:35:35', '2024-01-08 20:35:45', 4, '对实验结果报告与记录进行核查：对应的能力确认文件可能涉及到理论考试笔试答卷、对盲样或质控样品、留样、实验室间比对样品等的检验检测原始记录、检验检测报告、人员监督记录表、实验室对某一实验操作过程的考评标准、人员完成情况等记录。', 0.00);
INSERT INTO `archives` VALUES (25, '实验室档案内容及管理', ' 实验室建立资料档案管理系统，把实验室的各项管理工作的进展情况及结果如实记录在册，为组织考核提供依据，同时也为实验室向量化管理发展创造条件。实验室资料档案管理系统包括实验仪器设备进账、说明书和技术资料、实验通知单、规章制度、各项管理工作记录、实验教学年报表和工作总结等资料。', 10, '### 实验室档案管理的定义\n 实验室建立资料档案管理系统，把实验室的各项管理工作的进展情况及结果如实记录在册，为组织考核提供依据，同时也为实验室向量化管理发展创造条件。实验室资料档案管理系统包括实验仪器设备进账、说明书和技术资料、实验通知单、规章制度、各项管理工作记录、实验教学年报表和工作总结等资料。\n### 建立实验室档案的目的\n（1）实验室在运行过程中会产生大量的原始信息和资料，这些信息资料直接反映实验室能力水平，对于追溯实验过程中的客观性、真实性方面发挥着越来越重要的作用，没有这些信息资料就失去了实验室应有的意义。\n\n（2）实验室档案是实验工作的真实记录，具有原始性，凭证性，是原始的技术凭证和法律证是展调查研究的重要依据。\n\n（3）能客现地反映实验室的管理水平和教研质量；能增强领导决策的科学性；可以提高实总之，实验室档案管理系统首先是日常工作的溯源凭证:其次是实验室资质认定时的鉴定材料:第三是实验教学和科学研究的信息资源。', NULL, 2, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2024-01-08//606bc1d7-25a3-444f-8cf8-bc1d82ad3f5d_u=4228201995,1759712828&fm=253&fmt=auto&app=138&f=JPEG.webp', 6, 2, '2024-01-08 20:37:17', '2024-01-08 20:37:17', 2, '202401084321200605_baojin.mp3', 0.00);
INSERT INTO `archives` VALUES (26, '测试档案', '1111', 8, '### 1111\n测试', NULL, 1, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2024-01-08//bab843ee-8dc9-4693-8b9d-e04f59df77fa_1 (5).webp', 6, 3, '2024-01-08 20:38:04', '2024-01-08 20:38:04', 1, '202401084811431529_u=1340303006,2445575422&fm=253&fmt=auto&app=138&f=JPEG.webp', 0.00);
INSERT INTO `archives` VALUES (30, '测试', '111', 7, '11', NULL, 1, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2024-01-08//a7e78538-f14d-4463-8353-f6110082ad0b_1.png', 8, 1, '2024-01-08 20:45:59', '2024-01-08 20:45:59', 1, '111', 0.00);
INSERT INTO `archives` VALUES (32, '2', '2', 9, '2', NULL, 1, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2024-01-08//d686842b-068d-4a11-8aea-0e490488e73d_1.png', 6, 1, '2024-01-08 20:50:08', '2024-01-08 20:50:08', 1, '2', 0.00);
INSERT INTO `archives` VALUES (33, '视频测试', '视频测试', 8, '111', NULL, 1, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2024-01-08//cbef433a-2a7a-49e5-811f-583d159216d9_1.png', 6, 4, '2024-01-08 20:52:36', '2024-01-08 20:52:36', 2, '202401083532960252_1.mp4', 7.50);

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int NULL DEFAULT NULL COMMENT '收藏人',
  `archives_id` int NULL DEFAULT NULL COMMENT '攻略',
  `create_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
  `update_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '收藏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (13, 12, 22, '2024-01-08 15:32:31', '2024-01-08 15:32:31');
INSERT INTO `collect` VALUES (14, 12, 21, '2024-01-08 15:32:32', '2024-01-08 15:32:32');
INSERT INTO `collect` VALUES (16, 10, 24, '2024-01-08 20:46:55', '2024-01-08 20:46:55');
INSERT INTO `collect` VALUES (17, 10, 25, '2024-01-08 20:46:59', '2024-01-08 20:46:59');
INSERT INTO `collect` VALUES (18, 14, 25, '2024-01-08 20:48:20', '2024-01-08 20:48:20');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `pid` int NOT NULL COMMENT '父id',
  `comment` varchar(330) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论信息',
  `user_id` int NOT NULL COMMENT '发布人',
  `reply_user_id` int NULL DEFAULT NULL COMMENT '回复人',
  `create_time` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '评论时间',
  `archives_id` int NULL DEFAULT NULL,
  `browser_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `browser_version` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `system_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `system_version` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `ip_address` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for lab
-- ----------------------------
DROP TABLE IF EXISTS `lab`;
CREATE TABLE `lab`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `lab_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '实验室名',
  `sort_id` int NULL DEFAULT NULL COMMENT '分类',
  `location` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '位置',
  `desc` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '简介',
  `content` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '内容',
  `status` int NOT NULL COMMENT '状态',
  `image_url` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '图片',
  `is_banner` int NOT NULL COMMENT '是否推荐',
  `create_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
  `update_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '实验室' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lab
-- ----------------------------
INSERT INTO `lab` VALUES (17, '超级计算节点1', 14, '11-3-402', 'CPU1队列', '2020年6月建成，包含CPU计算节点62个，每个节点配置2颗intel Xeon Gold 6248 CPU，合计2480核，双精度浮点计算性能198.4Tflops；GPU节点有31个，其中4卡节点29个，8卡节点2个，GPU卡合计132个，均为NVIDIA Tesla V100，双精度浮点计算能力924Tflops。\n浪潮NF5468M5 * 33\n浪潮NF5280M5 * 29', 1, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2024-02-24//2d211198-4eb9-4b18-8f44-e8b04d5756a1_08673c00-709e-4e30-b73c-29d7402ade75.png', 2, '2024-02-24 01:46:59', '2024-02-26 21:40:10');
INSERT INTO `lab` VALUES (18, '先进液压与机电控制实验室', 16, '13-1-102', '联系方式：\n江苏省南京市御道街29号\n南京航空航天大学机电学院\n347信箱\n邮编：210016\n电话: 025-84896786  \n邮箱: meeyczhu@nuaa.edu.cn\n联系人：朱玉川教授', '先进液压与机电控制实验室与研究课题组自2007年1月成立以来，面向我国航空航天高性能电液作动与控制相关技术需求，主要开展了智能材料高频电-机与电液转换器、智能材料驱动射流伺服阀、喷嘴挡板伺服阀、集成式电静液作动器以及高频开关阀的相关基础与应用基础研究。', 1, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2024-02-24//57add1e8-fc9b-49a8-851c-51d09fc61dd2_f983a5d4-64ce-416c-a091-7b252103ba80.jpg', 2, '2024-02-24 02:07:30', '2024-02-24 02:07:30');
INSERT INTO `lab` VALUES (20, '空间核技术应用与辐射防护工业和信息化部重点实验室', 15, '13-4-505', '空间核技术应用与辐射防护工业和信息化部重点实验室主要依托南京航空航天大学核科学与技术系建立。由南京航空航天大学核科学与技术学科汤晓斌教授担任实验室主任，中国工程院欧阳晓平院士担任实验室学术委员会主任。实验室旨在面向空间探测和载人航天等国家重大工程，围绕“航天+核”交叉融合创新的发展思路，组建跨学科、跨院系、跨领域的联合研究团队，开展前沿性、颠覆性关键技术的基础研究和集成创新，探索出一套高效的多学科人才合作研究新机制。', '实验室将重点开展：1）材料辐射效应与器件抗辐加固：空间辐射环境研究与模拟、航天器敏感材料辐射效应与防护、电子元器件与系统抗辐加固技术、空间辐射屏蔽材料与防护技术；2）空间辐射生物效应与安全防护：航天员生理效应监测与防护、空间辐射生物学效应与应用、航天员辐射剂量监测与评估；3）空间反应堆动力与同位素电源：空间反应堆电源技术、空间核热/核电/离子推进技术、空间同位素电源技术；4）辐射探测分析技术与航天应用：空间粒子探测技术与载荷、星表物质核分析技术与载荷、空间X射线通信技术及应用等研究工作，努力拓展空间核技术应用与辐射防护领域新的技术应用和研究方向。\n\n', 1, 'https://gulimall-psw.oss-cn-hangzhou.aliyuncs.com/2024-02-24//46d92016-d574-4835-8ade-71428893bc8e_1a4a9072-05c2-4b1f-b5e6-b5bc64c31db1.png', 2, '2024-02-24 02:11:55', '2024-02-24 02:11:55');
INSERT INTO `lab` VALUES (22, '机房', 17, '科学馆403', '继续教育学院-机房1', '# 机房简介\n1. 配置：AMD_7980FX\n	DDR3_4G\n	WD500G\n	共60台 ', 1, 'https://lab-sys.oss-cn-hangzhou.aliyuncs.com/2024-02-26//2bcb618b-15ce-46ec-89ff-be2eda912448_VCG41N1133575303.jpg', 2, '2024-02-26 21:45:08', '2024-02-26 21:45:08');
INSERT INTO `lab` VALUES (23, '力学实验中心1', 13, '11-115A', '省级力学项目-实验中心', '# 设备环境\n115A	力学实验中心	04202417	电子万能试验机	CSS-44200\n115A	力学实验中心	04202418	电子万能试验机	CSS-44200\n115A	力学实验中心	04202419	电子万能试验机	CSS-44200\n115A	力学实验中心	04202420	电子万能试验机	CSS-44200\n115A	力学实验中心	04205104	10通道数字动态应变仪	DRA-101C\n115A	力学实验中心	07024217	电子万能试验机	DNS200/200KN\n115A	力学实验中心	04202421	电子万能试验机	CSS-44020\n115A	力学实验中心	04209014	多功能激光干涉系统	MLI-1', 1, 'https://lab-sys.oss-cn-hangzhou.aliyuncs.com/2024-02-26//b0f601ba-a7d8-4b4e-8ccb-828b3767c4d9_8D011074C795D64537F5604ECF6_A7500446_280DB.png', 2, '2024-02-26 21:50:03', '2024-02-26 21:50:03');
INSERT INTO `lab` VALUES (24, '复合材料与工艺实验室', 13, '11-115B', '省物理力学实验组-复合材料与工艺实验室', '1155	复合材料与工艺实验室	88190633	扭矩拉扭材料试验机	MTS809	250KN\n1155	复合材料与工艺实验室	06243462	\"热压罐	\"	φ1000*2000/1.0MPa	最低温250度	1	603000.00\n1155	复合材料与工艺实验室	06245419	\"计算机控制缠绕机	\"	4FW500	计算机控制	1	378000.00\n1155	复合材料与工艺实验室	90190077	树脂传递模塑成型机	RTM	玻璃钢成型	1	40641.75', 1, 'https://lab-sys.oss-cn-hangzhou.aliyuncs.com/2024-02-26//0ed2b6bf-422c-4ba6-8cfe-25084298bdfb_4960E053BE4A6D5A56C10204B8C_49E9DA12_943B4.png', 2, '2024-02-26 21:52:24', '2024-02-26 21:52:24');

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户',
  `archives_id` int NULL DEFAULT NULL COMMENT '新闻',
  `create_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
  `update_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '点赞' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of like
-- ----------------------------
INSERT INTO `like` VALUES (37, 10, 24, '2024-01-08 20:46:46', '2024-01-08 20:46:46');
INSERT INTO `like` VALUES (38, 14, 24, '2024-01-08 20:48:55', '2024-01-08 20:48:55');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `title` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '详情',
  `user_id` int NULL DEFAULT NULL,
  `create_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  `update_time` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (2, '测试2', '22223', 17, '2024-02-24 01:45:52', '2024-02-27 13:08:26');
INSERT INTO `notice` VALUES (3, '测试3', '# 一级标题111', 1, '2024-02-27 13:14:19', '2024-02-27 13:14:19');
INSERT INTO `notice` VALUES (4, 'test', '1', 18, '2024-02-27 13:42:42', '2024-02-27 13:42:42');
INSERT INTO `notice` VALUES (5, '111', '11', 18, '2024-02-27 13:44:12', '2024-02-27 13:44:12');

-- ----------------------------
-- Table structure for plan
-- ----------------------------
DROP TABLE IF EXISTS `plan`;
CREATE TABLE `plan`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `appoint_day` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '日期',
  `time` int NULL DEFAULT NULL COMMENT '时间段',
  `remark` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '备注',
  `lab_id` int NULL DEFAULT NULL COMMENT '实验室',
  `create_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
  `update_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '计划' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plan
-- ----------------------------
INSERT INTO `plan` VALUES (8, '2024-02-29', 1, 'CZ042313015上课时间', 22, '2024-02-26 22:00:44', '2024-02-26 22:00:44');

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户',
  `lab_id` int NULL DEFAULT NULL COMMENT '实验室',
  `remark` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '报修信息',
  `repair_person` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '检修人',
  `repair_dept` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '检修单位',
  `repair_time` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '检修时间',
  `repair_remark` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '报修说明',
  `create_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
  `update_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '报修' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repair
-- ----------------------------
INSERT INTO `repair` VALUES (9, 17, 17, '超算平台报修，Linux系统故障', '李诚安', '计算机中心', '2024-02-27 06:07:00', '已解决', '2024-02-26 01:02:15', '2024-02-26 22:01:33');

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `sort_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '分类',
  `create_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
  `update_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES (13, '物理实验室', '2024-02-24 01:45:52', '2024-02-24 01:45:52');
INSERT INTO `sort` VALUES (14, '超算平台', '2024-02-24 01:46:00', '2024-02-24 01:46:00');
INSERT INTO `sort` VALUES (15, '化学实验室', '2024-02-24 01:46:06', '2024-02-24 01:46:06');
INSERT INTO `sort` VALUES (16, '机电实验室', '2024-02-24 01:46:13', '2024-02-24 01:46:13');
INSERT INTO `sort` VALUES (17, '计算机机房', '2024-02-26 21:38:16', '2024-02-26 21:38:16');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  `real_name` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` int NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `user_type` int NULL DEFAULT NULL COMMENT '用户类型',
  `image_url` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '图片',
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `create_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建时间',
  `update_time` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (17, 'lchnan', 'lichengan0717', '李诚安', 1, '13776806511', 2, 'https://lab-sys.oss-cn-hangzhou.aliyuncs.com/2024-02-25//25ecfcd6-2d0b-48a8-8d8f-980f44b2ebb4_logo_b.png', 'yanchu17@outlook.com', '2024-02-25 00:07:57', '2024-02-25 00:07:57');
INSERT INTO `user` VALUES (18, 'lcaadmin', '123456', '李诚安_超管', 1, '18651971709', 1, 'https://lab-sys.oss-cn-hangzhou.aliyuncs.com/2024-02-26//b8776228-8957-4776-8538-aa5aabf5ec08_logo.png', 'admin@lchnan.cn', '2024-02-26 01:05:04', '2024-02-26 01:06:31');

SET FOREIGN_KEY_CHECKS = 1;
