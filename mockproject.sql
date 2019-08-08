-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: mockproject
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `IDUser` int(200) NOT NULL AUTO_INCREMENT,
  `IDRole` int(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `FullName` varchar(100) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `DateBirth` timestamp NULL DEFAULT NULL,
  `DateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DateUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UserCreate` varchar(100) NOT NULL,
  `UserUpdate` varchar(100) NOT NULL,
  `LastTimeLogin` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`IDUser`),
  KEY `IDRole` (`IDRole`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`IDRole`) REFERENCES `role` (`IDRole`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (4,1,'nhdlklk','123','','','2019-08-05 04:17:46','2019-08-01 17:00:00','2019-08-01 17:00:00','nhdlklk','nhdlklk','2019-08-02 09:35:46'),(5,3,'tin','123','','','2019-08-05 04:17:46','2019-08-04 17:00:00','2019-08-04 17:00:00','nhdlklk','nhdlklk','2019-08-04 17:00:00'),(6,1,'sinh','123','','','2019-08-05 04:17:46','2019-08-04 17:00:00','2019-08-04 17:00:00','nhdlklk','nhdlklk','2019-08-04 17:00:00'),(7,1,'dat','123','','','2019-08-05 04:17:46','2019-08-04 17:00:00','2019-08-04 17:00:00','sinh','sinh','2019-08-04 17:00:00'),(8,1,'tin123','123','','','2019-08-05 04:17:46','2019-08-04 17:00:00','2019-08-04 17:00:00','dat','dat','2019-08-04 17:00:00'),(9,2,'customer','123','','','2019-08-05 04:17:46','2019-08-04 17:00:00','2019-08-04 17:00:00','tin','dat','2019-08-05 17:00:00'),(10,3,'seller','123','','','2019-08-05 04:17:46','2019-08-04 17:00:00','2019-08-04 17:00:00','dat','tin','2019-08-04 17:00:00');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bus`
--

DROP TABLE IF EXISTS `bus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bus` (
  `IDBus` int(100) NOT NULL AUTO_INCREMENT,
  `LicensePlate` varchar(100) NOT NULL,
  `TimeStart` timestamp NULL DEFAULT NULL,
  `TimeEnd` timestamp NULL DEFAULT NULL,
  `PlaceStart` varchar(100) NOT NULL,
  `PlaceEnd` varchar(100) NOT NULL,
  `DateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DateUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UserCreate` varchar(100) NOT NULL,
  `UserUpdate` varchar(100) NOT NULL,
  PRIMARY KEY (`IDBus`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bus`
--

LOCK TABLES `bus` WRITE;
/*!40000 ALTER TABLE `bus` DISABLE KEYS */;
INSERT INTO `bus` VALUES (1,'60A-91919','2019-08-01 17:00:00','2019-08-01 17:00:00','HCM','HN','2019-08-01 17:00:00','2019-08-01 17:00:00','nhdlklk','nhdlklk'),(2,'72B-61617','2019-08-06 17:00:00','2019-08-09 17:00:00','HCM','DN','2019-08-03 17:00:00','2019-08-05 02:03:20','nhdlklk','nhdlklk'),(3,'80A-76789','2019-08-04 17:00:00','2019-08-08 17:00:00','HCM','SaPa','2019-08-03 17:00:00','2019-08-05 02:03:49','nhdlklk','nhdlklk'),(10,'79-h2',NULL,NULL,'HCM','Khanh hoa','2019-08-06 04:13:49','2019-08-06 04:15:51','sada','e2312321'),(11,'79h2',NULL,NULL,'khanh hoa','hcm','2019-08-06 13:13:29','2019-08-06 13:13:29','userHienTai','userHienTai'),(15,'90-a1','1970-01-01 00:25:02','1970-01-01 00:30:02','ninh hoa','ha noi','2019-08-07 01:46:47','2019-08-07 01:46:47','userHienTai','userHienTai'),(19,'90-a1','1970-01-01 00:25:02','1970-01-01 00:30:02','ninh hoa','ha noi','2019-08-07 16:46:10','2019-08-07 16:46:10','userHienTai','userHienTai'),(20,'90-a1','1970-01-01 00:25:02','1970-01-01 00:30:02','ninh hoa','ha noi','2019-08-08 01:00:50','2019-08-08 01:00:50','userHienTai','userHienTai'),(21,'90-a1','1970-01-01 00:25:02','1970-01-01 00:30:02','ninh hoa','ha noi','2019-08-08 01:58:33','2019-08-08 01:58:33','userHienTai','userHienTai');
/*!40000 ALTER TABLE `bus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `IDRole` int(200) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `DateCreate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `DateUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `UserCreate` varchar(100) NOT NULL,
  `UserUpdate` varchar(100) NOT NULL,
  PRIMARY KEY (`IDRole`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','2019-08-01 17:00:00','2019-08-01 17:00:00','nhdlklk','nhdlklk'),(2,'customer','2019-08-02 09:32:07','2019-08-02 09:32:48','nhdlklk','nhdlklk'),(3,'employee','2019-08-04 17:00:00','2019-08-04 17:00:00','nhdlklk','nhdlklk');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `seat` (
  `IDSeat` int(100) NOT NULL AUTO_INCREMENT,
  `IDBus` int(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Status` tinyint(1) NOT NULL,
  `DateCreate` timestamp NULL DEFAULT NULL,
  `DateUpdate` timestamp NULL DEFAULT NULL,
  `UserCreate` varchar(100) DEFAULT NULL,
  `UserUpdate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IDSeat`),
  KEY `IDBus` (`IDBus`),
  CONSTRAINT `seat_ibfk_1` FOREIGN KEY (`IDBus`) REFERENCES `bus` (`IDBus`)
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,1,'Normal',0,NULL,NULL,NULL,NULL),(2,1,'Normal',0,NULL,NULL,NULL,NULL),(3,1,'Normal',0,NULL,NULL,NULL,NULL),(4,1,'Vip',0,NULL,NULL,NULL,NULL),(5,1,'Vip',0,NULL,NULL,NULL,NULL),(6,1,'Normal',0,NULL,NULL,NULL,NULL),(7,1,'Normal',0,NULL,NULL,NULL,NULL),(8,1,'Vip',0,NULL,NULL,NULL,NULL),(9,1,'Normal',0,NULL,NULL,NULL,NULL),(10,1,'Vip',0,NULL,NULL,NULL,NULL),(11,1,'Normal',0,NULL,NULL,NULL,NULL),(12,1,'Normal',0,NULL,NULL,NULL,NULL),(13,1,'Normal',0,NULL,NULL,NULL,NULL),(14,1,'Vip',0,NULL,NULL,NULL,NULL),(15,1,'Normal',0,NULL,NULL,NULL,NULL),(16,1,'Normal',0,NULL,NULL,NULL,NULL),(17,1,'Normal',0,NULL,NULL,NULL,NULL),(18,1,'Normal',0,NULL,NULL,NULL,NULL),(19,1,'Vip',0,NULL,NULL,NULL,NULL),(20,1,'Normal',0,NULL,NULL,NULL,NULL),(21,1,'Normal',0,NULL,NULL,NULL,NULL),(22,1,'Normal',0,NULL,NULL,NULL,NULL),(23,1,'Normal',0,NULL,NULL,NULL,NULL),(24,1,'Vip',0,NULL,NULL,NULL,NULL),(25,1,'Normal',0,NULL,NULL,NULL,NULL),(26,1,'Normal',0,NULL,NULL,NULL,NULL),(27,1,'Normal',0,NULL,NULL,NULL,NULL),(28,1,'Normal',0,NULL,NULL,NULL,NULL),(29,1,'Normal',0,NULL,NULL,NULL,NULL),(30,1,'Normal',0,NULL,NULL,NULL,NULL),(31,1,'Normal',0,NULL,NULL,NULL,NULL),(32,1,'Normal',0,NULL,NULL,NULL,NULL),(33,1,'Normal',0,NULL,NULL,NULL,NULL),(34,1,'Normal',0,NULL,NULL,NULL,NULL),(35,1,'Normal',0,NULL,NULL,NULL,NULL),(36,1,'Vip',0,NULL,NULL,NULL,NULL),(37,1,'Normal',0,NULL,NULL,NULL,NULL),(38,1,'Normal',0,NULL,NULL,NULL,NULL),(39,1,'Normal',0,NULL,NULL,NULL,NULL),(40,1,'Normal',0,NULL,NULL,NULL,NULL),(41,2,'Normal',0,NULL,NULL,NULL,NULL),(42,2,'Normal',0,NULL,NULL,NULL,NULL),(43,2,'Vip',0,NULL,NULL,NULL,NULL),(44,2,'Normal',0,NULL,NULL,NULL,NULL),(45,2,'Normal',0,NULL,NULL,NULL,NULL),(46,2,'Normal',0,NULL,NULL,NULL,NULL),(47,2,'Normal',0,NULL,NULL,NULL,NULL),(48,2,'Normal',0,NULL,NULL,NULL,NULL),(49,2,'Vip',0,NULL,NULL,NULL,NULL),(50,2,'Normal',0,NULL,NULL,NULL,NULL),(51,2,'Vip',0,NULL,NULL,NULL,NULL),(52,2,'Normal',0,NULL,NULL,NULL,NULL),(53,2,'Normal',0,NULL,NULL,NULL,NULL),(54,2,'Normal',0,NULL,NULL,NULL,NULL),(55,2,'Normal',0,NULL,NULL,NULL,NULL),(56,2,'Vip',0,NULL,NULL,NULL,NULL),(57,2,'Normal',0,NULL,NULL,NULL,NULL),(58,2,'Vip',0,NULL,NULL,NULL,NULL),(59,2,'Normal',0,NULL,NULL,NULL,NULL),(60,2,'Normal',0,NULL,NULL,NULL,NULL),(61,2,'Vip',0,NULL,NULL,NULL,NULL),(62,2,'Normal',0,NULL,NULL,NULL,NULL),(63,2,'Vip',0,NULL,NULL,NULL,NULL),(64,2,'Normal',0,NULL,NULL,NULL,NULL),(65,2,'Normal',0,NULL,NULL,NULL,NULL),(66,2,'Normal',0,NULL,NULL,NULL,NULL),(67,2,'Normal',0,NULL,NULL,NULL,NULL),(68,2,'Normal',0,NULL,NULL,NULL,NULL),(69,2,'Vip',0,NULL,NULL,NULL,NULL),(70,2,'Normal',0,NULL,NULL,NULL,NULL),(71,2,'Normal',0,NULL,NULL,NULL,NULL),(72,2,'Normal',0,NULL,NULL,NULL,NULL),(73,2,'Vip',0,NULL,NULL,NULL,NULL),(74,2,'Normal',0,NULL,NULL,NULL,NULL),(75,2,'Normal',0,NULL,NULL,NULL,NULL),(76,2,'Normal',0,NULL,NULL,NULL,NULL),(77,2,'Vip',0,NULL,NULL,NULL,NULL),(78,2,'Normal',0,NULL,NULL,NULL,NULL),(79,2,'Normal',0,NULL,NULL,NULL,NULL),(80,2,'Normal',0,NULL,NULL,NULL,NULL),(81,2,'Normal',0,NULL,NULL,NULL,NULL),(82,2,'Normal',0,NULL,NULL,NULL,NULL),(83,2,'Normal',0,NULL,NULL,NULL,NULL),(84,2,'Normal',0,NULL,NULL,NULL,NULL),(85,2,'Normal',0,NULL,NULL,NULL,NULL),(86,3,'Normal',0,NULL,NULL,NULL,NULL),(87,3,'Normal',0,NULL,NULL,NULL,NULL),(88,3,'Normal',0,NULL,NULL,NULL,NULL),(89,3,'Vip',0,NULL,NULL,NULL,NULL),(90,3,'Normal',0,NULL,NULL,NULL,NULL),(91,3,'Vip',0,NULL,NULL,NULL,NULL),(92,3,'Normal',0,NULL,NULL,NULL,NULL),(93,3,'Vip',0,NULL,NULL,NULL,NULL),(94,3,'Normal',0,NULL,NULL,NULL,NULL),(95,3,'Vip',0,NULL,NULL,NULL,NULL),(96,3,'Normal',0,NULL,NULL,NULL,NULL),(97,3,'Vip',0,NULL,NULL,NULL,NULL),(98,3,'Normal',0,NULL,NULL,NULL,NULL),(99,3,'Normal',0,NULL,NULL,NULL,NULL),(100,3,'Normal',0,NULL,NULL,NULL,NULL),(101,3,'Normal',0,NULL,NULL,NULL,NULL),(102,3,'Normal',0,NULL,NULL,NULL,NULL),(103,3,'Vip',0,NULL,NULL,NULL,NULL),(104,3,'Normal',0,NULL,NULL,NULL,NULL),(105,3,'Normal',0,NULL,NULL,NULL,NULL),(106,3,'Normal',0,NULL,NULL,NULL,NULL),(107,3,'Normal',0,NULL,NULL,NULL,NULL),(108,3,'Normal',0,NULL,NULL,NULL,NULL),(109,3,'Normal',0,NULL,NULL,NULL,NULL),(110,3,'Normal',0,NULL,NULL,NULL,NULL),(111,3,'Vip',0,NULL,NULL,NULL,NULL),(112,3,'Normal',0,NULL,NULL,NULL,NULL),(113,3,'Normal',0,NULL,NULL,NULL,NULL),(114,3,'Normal',0,NULL,NULL,NULL,NULL),(115,3,'Normal',0,NULL,NULL,NULL,NULL),(116,3,'Normal',0,NULL,NULL,NULL,NULL),(117,3,'Normal',0,NULL,NULL,NULL,NULL),(118,3,'Normal',0,NULL,NULL,NULL,NULL),(119,3,'Normal',0,NULL,NULL,NULL,NULL),(120,3,'Normal',0,NULL,NULL,NULL,NULL),(121,3,'Vip',0,NULL,NULL,NULL,NULL),(122,3,'Normal',0,NULL,NULL,NULL,NULL),(123,3,'Normal',0,NULL,NULL,NULL,NULL),(124,3,'Vip',0,NULL,NULL,NULL,NULL),(125,3,'Normal',0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticket` (
  `IDTicket` int(100) NOT NULL AUTO_INCREMENT,
  `IDBus` int(100) NOT NULL,
  `IDSeat` int(100) NOT NULL,
  `IDUser` int(100) NOT NULL,
  `Status` tinyint(1) NOT NULL,
  `Price` varchar(100) NOT NULL,
  `DateCreate` timestamp NULL DEFAULT NULL,
  `DateUpdate` timestamp NULL DEFAULT NULL,
  `UserCreate` varchar(100) DEFAULT NULL,
  `UserUpdate` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IDTicket`),
  KEY `IDBus` (`IDBus`,`IDUser`),
  KEY `IDUser` (`IDUser`),
  KEY `IDSeat` (`IDSeat`),
  CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`IDBus`) REFERENCES `bus` (`IDBus`),
  CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`IDUser`) REFERENCES `account` (`IDUser`),
  CONSTRAINT `ticket_ibfk_3` FOREIGN KEY (`IDSeat`) REFERENCES `seat` (`IDSeat`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (6,1,1,9,0,'10000',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-08 10:22:54
