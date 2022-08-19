-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: prosn
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `problem_workbook`
--

DROP TABLE IF EXISTS `problem_workbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problem_workbook` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `problem_id` bigint(20) DEFAULT NULL,
  `workbook_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4bvntm51b0xo5l4wksgrtuv4v` (`problem_id`),
  KEY `FKjatp2g00c542m3b6ad2gonvi5` (`workbook_id`),
  CONSTRAINT `FK4bvntm51b0xo5l4wksgrtuv4v` FOREIGN KEY (`problem_id`) REFERENCES `problem` (`id`),
  CONSTRAINT `FKjatp2g00c542m3b6ad2gonvi5` FOREIGN KEY (`workbook_id`) REFERENCES `workbook` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problem_workbook`
--

LOCK TABLES `problem_workbook` WRITE;
/*!40000 ALTER TABLE `problem_workbook` DISABLE KEYS */;
INSERT INTO `problem_workbook` VALUES (1,'2022-08-18 15:01:07','2022-08-18 15:01:07',5,11),(2,'2022-08-18 15:01:07','2022-08-18 15:01:07',6,11),(3,'2022-08-18 15:01:07','2022-08-18 15:01:07',7,11);
/*!40000 ALTER TABLE `problem_workbook` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-19  0:14:53
