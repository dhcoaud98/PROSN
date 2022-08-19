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
-- Table structure for table `problem`
--

DROP TABLE IF EXISTS `problem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `problem` (
  `answer` varchar(255) DEFAULT NULL,
  `example1` varchar(255) DEFAULT NULL,
  `example2` varchar(255) DEFAULT NULL,
  `example3` varchar(255) DEFAULT NULL,
  `example4` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKj2itd14e2vrlj9xr8yx3vcu06` FOREIGN KEY (`id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problem`
--

LOCK TABLES `problem` WRITE;
/*!40000 ALTER TABLE `problem` DISABLE KEYS */;
INSERT INTO `problem` VALUES ('update','update','get','put','delete',2),('루트 노드가 있다.','루트 노드가 있다.','노드와 간선으로 이루어져 있다.','간선이 없을 수도 있다.','사이클이 가능하다.',3),('결정자가 후보키가 아닌 함수 종속 제거','결정자가 후보키가 아닌 함수 종속 제거','원자 값이 아닌 도메인을 분해','부분 함수 종속 제거','이행 함수 종속 제거',5),('1NF를 만족하고 키가 아닌 모든 속성이 기본키에 대하여 완전 함수적 종속 관계를 만족해야 한다.','1NF를 만족하고 키가 아닌 모든 속성이 기본키에 대하여 완전 함수적 종속 관계를 만족해야 한다.','1NF를 만족하고 모든 도메인이 원자 값이어야 한다.','1NF를 만족하고 키가 아닌 모든 애트리뷰트들이 기본키에 이행적으로 함수 종속되지 않아야 한다.','1NF를 만족하고 다치 종속이 제거되어야 한다.',6),('중복을 배제하여 삽입, 삭제, 갱신 이상의 발생을 야기한다','중복을 배제하여 삽입, 삭제, 갱신 이상의 발생을 야기한다','효과적인 검색 알고리즘을 생성할 수 있다.','어떠한 릴레이션이라도 데이터베이스 내에서 표현 가능하게 만든다','데이터 삽입 시 릴레이션을 재구성할 필요성을 줄인다.',7),('간결성','간결성','완전성','무결성','통합성',8),('재귀적으로 동작한다.','재귀적으로 동작한다.','큐를 사용한다.','Prim, Dijkstra 알고리즘과 유사하다.','어떤 노드를 방문했었는지 여부를 반드시 검사해야 한다.',10);
/*!40000 ALTER TABLE `problem` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-19  0:14:54
