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
-- Table structure for table `like_dislike`
--

DROP TABLE IF EXISTS `like_dislike`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `like_dislike` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `type` bit(1) NOT NULL,
  `post_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsm96eh7udkbrbvlj4nsxmyr9e` (`post_id`),
  KEY `FK6xhbchneohj3puylx0cwje448` (`user_id`),
  CONSTRAINT `FK6xhbchneohj3puylx0cwje448` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKsm96eh7udkbrbvlj4nsxmyr9e` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like_dislike`
--

LOCK TABLES `like_dislike` WRITE;
/*!40000 ALTER TABLE `like_dislike` DISABLE KEYS */;
INSERT INTO `like_dislike` VALUES (2,'2022-08-18 13:37:26','2022-08-18 13:37:26',_binary '',3,4),(3,'2022-08-18 14:14:36','2022-08-18 14:14:36',_binary '\0',2,1),(4,'2022-08-18 14:14:44','2022-08-18 14:14:44',_binary '',3,1),(5,'2022-08-18 14:14:52','2022-08-18 14:14:52',_binary '',5,1),(6,'2022-08-18 14:15:06','2022-08-18 14:15:06',_binary '',6,1),(7,'2022-08-18 15:00:07','2022-08-18 15:00:07',_binary '',5,3),(9,'2022-08-18 15:00:40','2022-08-18 15:00:40',_binary '',7,3),(15,'2022-08-18 15:08:14','2022-08-18 15:08:14',_binary '\0',6,3),(16,'2022-08-18 15:08:14','2022-08-18 15:08:14',_binary '',6,3);
/*!40000 ALTER TABLE `like_dislike` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-19  0:14:52
