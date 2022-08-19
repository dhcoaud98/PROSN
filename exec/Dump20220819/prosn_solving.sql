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
-- Table structure for table `solving`
--

DROP TABLE IF EXISTS `solving`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `solving` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `first_is_right` varchar(255) NOT NULL,
  `is_right` varchar(255) NOT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKi970biyq1yri3j5qb1xbl4ici` (`post_id`),
  KEY `FKq1qc1shtcni54uqst7k71a87i` (`user_id`),
  CONSTRAINT `FKi970biyq1yri3j5qb1xbl4ici` FOREIGN KEY (`post_id`) REFERENCES `problem` (`id`),
  CONSTRAINT `FKq1qc1shtcni54uqst7k71a87i` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solving`
--

LOCK TABLES `solving` WRITE;
/*!40000 ALTER TABLE `solving` DISABLE KEYS */;
INSERT INTO `solving` VALUES (1,'2022-08-18 13:25:34','2022-08-18 13:25:34','Y','Y',3,4),(2,'2022-08-18 14:14:37','2022-08-18 14:14:37','Y','Y',2,1),(3,'2022-08-18 14:14:43','2022-08-18 14:14:43','Y','Y',3,1),(4,'2022-08-18 14:14:53','2022-08-18 14:14:53','Y','Y',5,1),(5,'2022-08-18 14:15:07','2022-08-18 14:15:07','Y','Y',6,1),(6,'2022-08-18 15:01:26','2022-08-18 15:01:26','N','N',5,3),(7,'2022-08-18 15:08:07','2022-08-18 15:08:07','Y','Y',6,3);
/*!40000 ALTER TABLE `solving` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-19  0:14:57
