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
INSERT INTO `dz_image_main` VALUES (1,'aa.png',1,800,500,'/upload/aa.png','root','2018-09-04 02:45:38',1,'0');
/*!40000 ALTER TABLE `dz_image_main` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-04 15:30:26
