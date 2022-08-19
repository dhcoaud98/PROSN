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
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `ptype` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `is_deleted` varchar(255) NOT NULL,
  `main_text` varchar(255) DEFAULT NULL,
  `num_of_dislikes` bigint(20) DEFAULT '0',
  `num_of_likes` bigint(20) DEFAULT '0',
  `title` varchar(255) DEFAULT NULL,
  `views` int(11) DEFAULT '0',
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ky67sgi7k0ayf22652f7763r` (`user_id`),
  CONSTRAINT `FK7ky67sgi7k0ayf22652f7763r` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES ('Information',1,'2022-08-18 13:22:53','2022-08-18 13:22:53','N','- SQL Injection은 코드 인젝션의 한 기법으로 클라이언트의 입력값을 조작하여 서버의 데이터베이스를 공격할 수 있는 공격방식을 말한다.\n- 인젝션 공격은 OWASP Top10 중 첫 번째에 속해 있으며, 공격이 비교적 쉬운 편이고 공격에 성공할 경우 큰 피해를 입힐 수 있다.',0,0,'SQL Injection',29,3),('Problem',2,'2022-08-18 13:23:36','2022-08-18 14:14:36','N','다음 중 HTTP method가 아닌 것은?',1,0,'HTTP 메소드',3,3),('Problem',3,'2022-08-18 13:24:47','2022-08-18 14:14:45','N','다음 중 그래프의 특징이 아닌 것은?',0,2,'그래프',10,3),('Information',4,'2022-08-18 13:28:19','2022-08-18 13:28:19','N','1. 프로세스(Process)\n프로그램이 실행되면(OS로부터 시스템 자원을 할당받으면) 프로세스가 된다\n프로세스는 각각 독립된 메모리 영역(Code, Data, Stack, Heap)을 할당받는다\n\n2. 스레드(Thread)\n스레드는 프로세스 내에서 실제로 수행되는 작업이다\n스레드는 독립된 Stack 영역과 레지스터를 할당 받고, 프로세스의 Code, Data, Heap 영역을 공유한다\n',0,0,'프로세스와 스레드',29,4),('Problem',5,'2022-08-18 13:41:14','2022-08-18 15:00:07','N','제3정규형에서 보이스코드 정규형(BCNF)으로 정규화하기 위한 작업은?',0,2,'BCNF',4,4),('Problem',6,'2022-08-18 13:42:54','2022-08-18 15:08:14','N','정규화 과정 중 1NF에서 2NF가 되기 위한 조건은?',0,2,'정규화',7,4),('Problem',7,'2022-08-18 14:16:40','2022-08-18 15:00:40','N','정규화의 목적으로 옳지 않은 것은?',0,1,'정규화의 목적',3,1),('Problem',8,'2022-08-18 14:17:24','2022-08-18 14:17:24','N','다음 중 좋은 데이터 모델의 요건이 아닌 것은?',0,0,'데이터 모델',0,1),('Information',9,'2022-08-18 14:18:33','2022-08-18 14:18:33','N','Trie란?\n트라이는 문자열을 저장하고 효율적으로 탐색하기 위한 트리 형태의 자료구조이다.\n자동완성 기능, 사전 검색 등 문자열을 탐색하는데 특화된 자료구조이다.\n레딕스 트리(radix tree), 접두사 트리(prefix tree), 탐색 트리(retrieval tree)라고도 한다.\nTrie는 re**”trie”**val tree에서 나온 단어이다.',0,0,'Trie',17,1),('Problem',10,'2022-08-18 14:21:49','2022-08-18 14:21:49','N','다음 중 BFS의 특징으로 옳지 않은 것은?',0,0,'너비 우선 탐색',2,1),('Workbook',11,'2022-08-18 15:01:07','2022-08-18 15:01:07','N',NULL,0,0,'정규화 문제집',1,3);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-19  0:14:56
