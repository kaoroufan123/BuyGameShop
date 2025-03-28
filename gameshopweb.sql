/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - gameshopweb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gameshopweb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gameshopweb`;

/*Table structure for table `administor` */

DROP TABLE IF EXISTS `administor`;

CREATE TABLE `administor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `photo` varchar(512) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `regTime` datetime NOT NULL,
  `logTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `administor` */

insert  into `administor`(`id`,`name`,`photo`,`email`,`password`,`regTime`,`logTime`) values (1,'admin','null','kkk@qq.com','123456','2025-02-17 11:32:20','2025-02-17 11:32:23');

/*Table structure for table `gameevaluation` */

DROP TABLE IF EXISTS `gameevaluation`;

CREATE TABLE `gameevaluation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gameproduct_id` int(11) NOT NULL COMMENT '游戏商品id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `mark` decimal(2,1) NOT NULL DEFAULT '0.0' COMMENT '评分',
  `evaluate` text COMMENT '评价',
  `time` datetime NOT NULL COMMENT '评价时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='游戏评分评价表';

/*Data for the table `gameevaluation` */

/*Table structure for table `gameproduct` */

DROP TABLE IF EXISTS `gameproduct`;

CREATE TABLE `gameproduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `name` varchar(100) NOT NULL COMMENT '游戏名称',
  `gamephoto` varchar(512) DEFAULT NULL COMMENT '游戏头像',
  `publisher_id` int(11) NOT NULL COMMENT '发行方id',
  `tag` varchar(100) NOT NULL COMMENT '标签',
  `gameintro` text COMMENT '游戏介绍',
  `issuingDate` date NOT NULL COMMENT '发行时间',
  `price` double NOT NULL COMMENT '价格',
  `mark` double NOT NULL DEFAULT '0' COMMENT '游戏评分',
  `salesnum` int(11) NOT NULL DEFAULT '0' COMMENT '销量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='游戏商品表';

/*Data for the table `gameproduct` */

insert  into `gameproduct`(`id`,`name`,`gamephoto`,`publisher_id`,`tag`,`gameintro`,`issuingDate`,`price`,`mark`,`salesnum`) values (1,'Apex Legends™','img\\\\gameTx\\\\apex lengends\\\\apex header.jpg',1,'免费开玩 大逃杀 多人 第一人称射击','由Respawn Entertainment开发制作，屡获殊荣的《Apex Legends》，是一款免费大逃杀英雄射击游戏。在这款革命性的新一代大逃杀英雄射击游戏中，掌控日益丰富且拥有强大技能的传奇角色，深度体验战术小队玩法及创新游戏元素。','2020-11-05',0,0,0),(2,'《战地风云 5》','img\\\\gameTx\\\\battlefield v\\\\zdv.jpg',1,'第一人称射击 多人 射击 战争','这就是终极《战地风云 5》体验。用完整的武器、载具和配备武器库以及第 1 年和第 2 年最棒的自定义内容体验人类历史上规模最大的冲突。','2018-11-09',349,0,0),(3,'F1® 24','img\\\\gameTx\\\\f124\\\\header.jpg',3,'驾驶 汽车 多人','在 2024 赛季世界一级方程式锦标赛™官方电子游戏《EA SPORTS™ F1® 24》中投身赛场，成为二十精英之一，效仿传奇尽情驰骋。','2024-05-31',469,0,0),(4,'EA SPORTS™ WRC','img\\\\gameTx\\\\eawrc\\\\header.jpg',3,'驾驶 汽车 多人','通过新的地点、时刻、关卡、高性能载具、新涂装和持牌组员，体验拉力赛季的刺激。采用新涂装技术打造最新车型。做好准备，踏上继续的拉力之旅！','2023-11-03',399,0,0),(5,'Detroit Become Human','img\\\\gameTx\\\\DetroitBecomeHuman\\\\headerga.jpg',4,'剧情 独立 科幻','在《底特律：化身为人》中，人类和机器人的命运都将掌握在您的手中，您将走进一个不远的未来，一个机器人具有比人类更高智慧的时代。您将体验到史上最为复杂的分支故事——您所作出的每个选择都将影响游戏的结局。','2020-06-18',229.99,0,0),(6,'Far Cry® 5','img\\\\gameTx\\\\Far Cry  5\\\\header.jpg',5,'枪战 独立 生存 第一人称射击','欢迎来到蒙大拿州希望郡，一个充满自由与勇士的土地，同时也是名为“伊甸之门”著名毁灭日邪教的所在地。挺身对抗邪教领袖约瑟夫．席德、他的兄弟与使者，藉此燃起反抗的烽火并解放受陷的人民','2018-03-27',438,0,0),(7,'PUBG: BATTLEGROUNDS','img\\\\gameTx\\\\PUBG BATTLEGROUNDS\\\\header.jpg',6,'大逃杀 枪战 合作 免费开玩','免费游玩《PUBG绝地求生》。 选取最佳战略位置着陆，搜寻武器和补给，并成为最后的幸存者小队，屹立于千变万化的战场之上。 组队加入战场，体验原汁原味的战术竞技，尽在《PUBG绝地求生》。','2017-12-21',0,0,0),(8,'World of Warships','img\\\\gameTx\\\\World of Warships\\\\header.jpg',7,'合作 战争 战术 免费开玩','投身惊心动魄的海战，在超过600艘来自20世纪上半叶的战舰中组建您的舰队——从隐蔽的驱逐舰到巨型战列舰。变换您的战舰外观并选择适合您游戏风格的升级品，与其他玩家在战斗中并肩作战！','2017-11-15',0,0,0);

/*Table structure for table `gameproduct_verticalimg` */

DROP TABLE IF EXISTS `gameproduct_verticalimg`;

CREATE TABLE `gameproduct_verticalimg` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `gameproduct_id` bigint(20) NOT NULL COMMENT '游戏产品id',
  `verticalimage` varchar(512) NOT NULL COMMENT '树形图地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `gameproduct_verticalimg` */

insert  into `gameproduct_verticalimg`(`id`,`gameproduct_id`,`verticalimage`) values (1,1,'img\\\\gameTx\\\\apex lengends\\\\1549863074_759558.jpg'),(2,2,'img\\\\gameTx\\\\battlefield v\\\\1540795648_863737.jpg'),(3,3,'img\\\\gameTx\\\\f124\\\\f124 vertical.png'),(4,4,'img\\\\gameTx\\\\eawrc\\\\1694416925_619389.jpg'),(5,5,'img\\\\gameTx\\\\DetroitBecomeHuman\\\\1575526675_416833.jpg'),(6,6,'img\\\\gameTx\\\\Far Cry  5\\\\1531994778_281470.jpg'),(7,7,'img\\\\gameTx\\\\PUBG BATTLEGROUNDS\\\\pubg vertical.jpg'),(8,8,'img\\\\gameTx\\\\World of Warships\\\\1529631655_206226.jpg');

/*Table structure for table `gameverticalphoto` */

DROP TABLE IF EXISTS `gameverticalphoto`;

CREATE TABLE `gameverticalphoto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gameproduct_id` bigint(20) NOT NULL COMMENT '游戏商品表id',
  `verticalphoto` varchar(512) NOT NULL COMMENT '游戏垂直图地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='游戏垂直图';

/*Data for the table `gameverticalphoto` */

insert  into `gameverticalphoto`(`id`,`gameproduct_id`,`verticalphoto`) values (1,1,'img\\\\gameTx\\\\apex lengends\\\\1549863074_759558.jpg'),(2,2,'img\\\\gameTx\\\\battlefield v\\\\1540795648_863737.jpg'),(3,3,'img\\\\gameTx\\\\f124\\\\f124 vertical.png'),(4,4,'img\\\\gameTx\\\\eawrc\\\\1694416925_619389.jpg'),(5,5,'img\\\\gameTx\\\\DetroitBecomeHuman\\\\1575526675_416833.jpg'),(6,6,'img\\\\gameTx\\\\Far Cry  5\\\\1531994778_281470.jpg'),(7,7,'img\\\\gameTx\\\\PUBG BATTLEGROUNDS\\\\pubg vertical.jpg'),(8,8,'img\\\\gameTx\\\\World of Warships\\\\1529631655_206226.jpg');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `ordernumber` bigint(20) NOT NULL COMMENT '订单编号',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `gameproduct_id` int(11) NOT NULL COMMENT '游戏id',
  `payTime` datetime NOT NULL COMMENT '支付时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

/*Data for the table `orders` */

/*Table structure for table `publisher` */

DROP TABLE IF EXISTS `publisher`;

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `name` varchar(100) NOT NULL COMMENT '发行商名称',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `photo` varchar(512) NOT NULL COMMENT '发行商头像',
  `establishdate` date NOT NULL COMMENT '成立时间',
  `intro` text COMMENT '发行商介绍',
  `balance` double NOT NULL DEFAULT '0' COMMENT '账户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='发行商表';

/*Data for the table `publisher` */

insert  into `publisher`(`id`,`name`,`email`,`password`,`photo`,`establishdate`,`intro`,`balance`) values (1,'Electronic Arts','electronicarts@gmail.com','123456','img\\\\publisherTx\\\\ea\\\\ea.jpg','1982-05-28','挑战一切',0),(2,'深圳市腾讯计算机系统有限公司','ADPM@tencent.com','123123','img\\\\publisherTx\\\\default.jpeg','1998-11-11','一切以用户价值为依归',0),(3,'Codemasters','custservice@codemasters.com','114514','img\\\\publisherTx\\\\codemasters\\\\codemasters.jpg','1986-10-12','我们制作赛车游戏！Codemasters是GRID， DIRT和f1™官方游戏的家园。',0),(4,'Quantic Dream','qd@email.com','123546987','img\\\\publisherTx\\\\Quantic Dream\\\\baf1dce75db2d5bfb0f5e14dd2183c4cb61911f7_full.jpg','1997-05-02','Quantic Dream是一家屡获殊荣的法国视频游戏开发商和发行商，致力于创造专注于情感，互动故事叙述和叙事创新的AAA游戏。',0),(5,'Ubisoft','ubisoft@email.com','15151818','img\\\\publisherTx\\\\Ubisoft\\\\2b2486ae5a70d69c55f020ce8384d04646ddba4e_full.jpg','1986-03-28','“育碧”（Ubisoft），是一家总部设于法国圣芒代[6]的电子游戏开发商和发行商，1986年成立。育碧在全世界拥有23间游戏开发工作室，是2008年欧洲第三大独立游戏开发商、北美第四大独立游戏出版商。',0),(6,'Krafton','krafton@email.com','12346','img\\\\publisherTx\\\\Krafton\\\\3848e679856a3f1e68b27bda1f22f9f8dbacf4df_full.jpg','2007-03-01','成为游戏制作的大师',0),(7,'wargaming','wargaming@email.com','112233','img\\\\publisherTx\\\\Wargaming\\\\wg.jpg','1998-01-21','一个屡获殊荣的在线游戏开发商和发行商。作为免费MMO市场的领导者之一，该公司在PC，主机和手机平台上提供真实的游戏体验和服务。',0);

/*Table structure for table `screenshot` */

DROP TABLE IF EXISTS `screenshot`;

CREATE TABLE `screenshot` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `gameproduct_id` int(11) NOT NULL COMMENT '游戏商品id',
  `screenshot` varchar(512) DEFAULT NULL COMMENT '实机截图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='游戏实机表';

/*Data for the table `screenshot` */

insert  into `screenshot`(`id`,`gameproduct_id`,`screenshot`) values (1,1,'img\\\\gameTx\\\\apex lengends\\\\screenshot\\\\ss_0c84b409e174ee9175ee45b3cc9e700f3ed5482a.600x338.jpg'),(2,1,'img\\\\gameTx\\\\apex lengends\\\\screenshot\\\\ss_ff24ec583c28a400e654447e6e6c617a098bb9e4.600x338.jpg'),(3,1,'img\\\\gameTx\\\\apex lengends\\\\screenshot\\\\ss_c154ccd7e643d7ba9f9fbdfbb731f6a012be5c7b.600x338.jpg'),(4,1,'img\\\\gameTx\\\\apex lengends\\\\screenshot\\\\ss_ca3f21580db789f2b4fadf7e7853cf7792d5c827.600x338.jpg'),(5,2,'img\\\\gameTx\\\\battlefield v\\\\screenshot\\\\ss_0c20c45d2e00feae5b9edfb6526662cc3c669164.600x338.jpg'),(6,2,'img\\\\gameTx\\\\battlefield v\\\\screenshot\\\\ss_73a21e43ec44cac9aab41d122a284582d194d352.600x338.jpg'),(7,2,'img\\\\gameTx\\\\battlefield v\\\\screenshot\\\\ss_0569f81cafd8b18870d6d5bc296ad557f5576067.600x338.jpg'),(8,3,'img\\\\gameTx\\\\f124\\\\screenshot\\\\ss_4dd9549590afca99a530fac48bc25891243352db.600x338.jpg'),(9,3,'img\\\\gameTx\\\\f124\\\\screenshot\\\\ss_9c5fdd75cebda0ef432cfaa08e4d71bf425325c9.600x338.jpg'),(10,3,'img\\\\gameTx\\\\f124\\\\screenshot\\\\ss_84d89fe24443ceb89aeac048a8047d0852a74212.600x338.jpg'),(11,3,'img\\\\gameTx\\\\f124\\\\screenshot\\\\ss_fdd8ef6ba735ff768f1c022950773b287794a601.600x338.jpg'),(12,4,'img\\\\gameTx\\\\eawrc\\\\screenshot\\\\ss_2d514f3fc659cfeb3ae67486ecea344c608d55b9.600x338.jpg'),(13,4,'img\\\\gameTx\\\\eawrc\\\\screenshot\\\\ss_5897337d3eb055326fae7f5ebb97a90d53a91719.600x338.jpg'),(14,4,'img\\\\gameTx\\\\eawrc\\\\screenshot\\\\ss_b8199d821b8d45abffa2c8f23b83c8cc8721e81f.600x338.jpg'),(15,4,'img\\\\gameTx\\\\eawrc\\\\screenshot\\\\ss_cc6ba56413fb0f83e982f038ad618a4a23e72c5c.600x338.jpg'),(16,5,'img\\\\gameTx\\\\DetroitBecomeHuman\\\\screenshot\\\\ss_9c900def2b1d9a003b7d3e202ea2a7556a36e081.600x338.jpg'),(17,5,'img\\\\gameTx\\\\DetroitBecomeHuman\\\\screenshot\\\\ss_9e6c271b6d11b1d0f35da336fb57b35fed0079d1.600x338.jpg'),(18,5,'img\\\\gameTx\\\\DetroitBecomeHuman\\\\screenshot\\\\ss_3011c05e404043e3bfed1f6de7fe12ffd58ddc9b.600x338.jpg'),(19,5,'img\\\\gameTx\\\\DetroitBecomeHuman\\\\screenshot\\\\ss_b1e2a185bea13cccfc662e1286912bcd6f4ee798.600x338.jpg'),(20,6,'img\\\\gameTx\\\\Far Cry  5\\\\screenshot\\\\ss_8f826d6b68fc53c48f1f52f9d5188ba998b23534.600x338.jpg'),(21,6,'img\\\\gameTx\\\\Far Cry  5\\\\screenshot\\\\ss_54e115519104798a3a2dc55e6de3d4974e144b77.600x338.jpg'),(22,6,'img\\\\gameTx\\Far Cry  5\\\\screenshot\\\\ss_c6f08b3d2e156f705205f882504d3cd96f78cca1.600x338.jpg'),(23,6,'img\\\\gameTx\\\\Far Cry  5\\\\screenshot\\\\ss_c26333a1e53aad3d6a8cc0a347e9ac5e0dd98587.600x338.jpg'),(24,7,'img\\\\gameTx\\\\PUBG BATTLEGROUNDS\\\\screenshot\\\\ss_1fc0cca99883a1dbaeaadfffc1492f81e4e77d32.600x338.jpg'),(25,7,'img\\\\gameTx\\\\PUBG BATTLEGROUNDS\\\\screenshot\\\\ss_2da334ea597d9588aaa8c716d71b3c2e60a69853.600x338.jpg'),(26,7,'img\\\\gameTx\\\\PUBG BATTLEGROUNDS\\\\screenshot\\\\ss_66e156cf716e72096c15c132c3443e774cb2f9a5.600x338.jpg'),(27,7,'img\\\\gameTx\\\\PUBG BATTLEGROUNDS\\\\screenshot\\\\ss_fe5340f8ea6e0d2f3899ef1e7d2ebdfc07e32f67.600x338.jpg'),(28,8,'img\\\\gameTx\\\\World of Warships\\\\screenshot\\\\ss_3cbbcca4cde5bdc11e2146b3b3fde1301a03adb8.600x338.jpg'),(29,8,'img\\\\gameTx\\\\World of Warships\\\\screenshot\\\\ss_439c330d90acf785bb4ada495b5fab83fa28df41.600x338.jpg'),(30,8,'img\\\\gameTx\\\\World of Warships\\\\screenshot\\\\ss_099100a53d7ba3a139c3e84fc8874f55a50254ff.600x338.jpg'),(31,8,'img\\\\gameTx\\\\World of Warships\\\\screenshot\\\\ss_cc4aeb5aee3f2fbe0eadf109c7886a9bec92dc59.600x338.jpg');

/*Table structure for table `shoppingcar` */

DROP TABLE IF EXISTS `shoppingcar`;

CREATE TABLE `shoppingcar` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL COMMENT '用户表id',
  `gameproduct_id` int(11) NOT NULL COMMENT '游戏商品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';

/*Data for the table `shoppingcar` */

/*Table structure for table `tag` */

DROP TABLE IF EXISTS `tag`;

CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `tagname` varchar(100) NOT NULL COMMENT 'tag名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='标签';

/*Data for the table `tag` */

insert  into `tag`(`id`,`tagname`) values (1,'开放世界'),(2,'枪战'),(3,'生存'),(4,'解密'),(5,'剧情'),(6,'回合制'),(7,'二次元'),(8,'科幻'),(9,'合作'),(10,'驾驶'),(11,'空战'),(12,'汽车'),(13,'太空'),(14,'现代'),(15,'战争'),(16,'独立'),(17,'大逃杀'),(18,'免费开完'),(19,'第一人称射击'),(20,'多人'),(21,'战术');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `NAME` varchar(100) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(100) NOT NULL COMMENT '密码',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `photo` varchar(512) DEFAULT NULL COMMENT '头像',
  `sex` int(11) NOT NULL COMMENT '性别',
  `birthdate` date NOT NULL COMMENT '出生年月',
  `phone` bigint(20) NOT NULL COMMENT '电话',
  `regtime` datetime NOT NULL COMMENT '注册时间',
  `logtime` datetime NOT NULL COMMENT '上次登录时间',
  `signature` text COMMENT '个性签名',
  `balance` double NOT NULL DEFAULT '0' COMMENT '余额',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '账户状态',
  `salt` varchar(100) NOT NULL COMMENT '盐值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`NAME`,`PASSWORD`,`email`,`photo`,`sex`,`birthdate`,`phone`,`regtime`,`logtime`,`signature`,`balance`,`STATUS`,`salt`) values (1,'烤肉饭','9b64c5f00039ea6a14db871ba330cd4d','857932817@qq.com','static/upload/3cf0c247d58649ca97948d5552c1270f.png',1,'2005-07-09',15195544353,'2025-02-16 20:24:00','2025-03-28 08:36:19','你所热爱的就是你的生活',0,0,'61f7400676fe3696f7e082efedacdf03'),(2,'殇痕之墨','24c83356f89923d30b9aa5f4c917ec7e','114514@qq.com','img\\\\userTx\\\\default.jpeg',2,'2000-01-01',17546894175,'2025-02-22 07:31:29','2000-01-01 00:00:00','无',0,0,'a65ddcbca74cd0dbeae5cb561634a055'),(3,'XIXI','2eedfaec87b6668896341e46f0bd9c4e','1919810@163.com','img\\\\userTx\\\\default.jpeg',2,'2000-01-01',15195544353,'2025-02-22 10:56:53','2000-01-01 00:00:00','无',0,0,'0bdfd88e7c65a5a70c96d836b8c02e96');

/*Table structure for table `userwarehouse` */

DROP TABLE IF EXISTS `userwarehouse`;

CREATE TABLE `userwarehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `gameproduct_id` int(11) NOT NULL COMMENT '游戏商品id',
  `addtime` date NOT NULL COMMENT '入库时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='用户游戏库';

/*Data for the table `userwarehouse` */

insert  into `userwarehouse`(`id`,`user_id`,`gameproduct_id`,`addtime`) values (1,1,1,'2025-01-01'),(2,1,2,'2025-01-03'),(3,1,3,'2025-01-04'),(4,1,4,'2025-01-11'),(5,1,5,'2025-01-12');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
