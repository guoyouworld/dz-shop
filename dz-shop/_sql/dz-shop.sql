-- MySQL dump 10.13  Distrib 5.7.22, for Win64 (x86_64)
--
-- Host: localhost    Database: dz-shop
-- ------------------------------------------------------
-- Server version	5.7.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dz_image_category`
--

DROP TABLE IF EXISTS `dz_image_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dz_image_category` (
  `int_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(512) DEFAULT NULL,
  `category_info` varchar(512) DEFAULT NULL,
  `author` varchar(512) DEFAULT NULL,
  `category_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `stateflag` varchar(20) DEFAULT '0',
  PRIMARY KEY (`int_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dz_image_category`
--

LOCK TABLES `dz_image_category` WRITE;
/*!40000 ALTER TABLE `dz_image_category` DISABLE KEYS */;
INSERT INTO `dz_image_category` VALUES (1,'幻灯片','测试','root','2018-09-04 02:46:08','0');
/*!40000 ALTER TABLE `dz_image_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dz_image_main`
--

DROP TABLE IF EXISTS `dz_image_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dz_image_main` (
  `img_id` int(11) NOT NULL AUTO_INCREMENT,
  `img_name` varchar(512) DEFAULT NULL,
  `img_index` int(11) DEFAULT NULL,
  `img_hight` int(11) DEFAULT NULL,
  `img_width` int(11) DEFAULT NULL,
  `img_url` varchar(512) DEFAULT NULL,
  `author` varchar(512) DEFAULT NULL,
  `img_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `img_category` int(11) DEFAULT NULL,
  `stateflag` varchar(20) DEFAULT '0',
  PRIMARY KEY (`img_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dz_image_main`
--

LOCK TABLES `dz_image_main` WRITE;
/*!40000 ALTER TABLE `dz_image_main` DISABLE KEYS */;
INSERT INTO `dz_image_main` VALUES (1,'aa.png',1,800,500,'/upload/aa.png','root','2018-09-04 07:47:07',1,'0');
/*!40000 ALTER TABLE `dz_image_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dz_token`
--

DROP TABLE IF EXISTS `dz_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dz_token` (
  `user_id` bigint(20) NOT NULL,
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dz_token`
--

LOCK TABLES `dz_token` WRITE;
/*!40000 ALTER TABLE `dz_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `dz_token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dz_user`
--

DROP TABLE IF EXISTS `dz_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dz_user` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(60) NOT NULL DEFAULT '',
  `password` varchar(32) DEFAULT '',
  `gender` tinyint(1) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `last_login_ip` varchar(15) DEFAULT '',
  `user_level_id` tinyint(3) DEFAULT NULL,
  `nickname` varchar(60) DEFAULT '',
  `mobile` varchar(20) DEFAULT '',
  `register_ip` varchar(45) DEFAULT '',
  `avatar` varchar(255) DEFAULT '',
  `weixin_openid` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dz_user`
--

LOCK TABLES `dz_user` WRITE;
/*!40000 ALTER TABLE `dz_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `dz_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dz_user_level`
--

DROP TABLE IF EXISTS `dz_user_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dz_user_level` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL DEFAULT '',
  `description` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dz_user_level`
--

LOCK TABLES `dz_user_level` WRITE;
/*!40000 ALTER TABLE `dz_user_level` DISABLE KEYS */;
INSERT INTO `dz_user_level` VALUES (1,'普通用户','0'),(2,'vip','10000'),(4,'高级VIP','100000');
/*!40000 ALTER TABLE `dz_user_level` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-11 15:31:37
