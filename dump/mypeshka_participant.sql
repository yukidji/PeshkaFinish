-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: mypeshka
-- ------------------------------------------------------
-- Server version	8.0.15

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
-- Table structure for table `participant`
--

DROP TABLE IF EXISTS `participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `participant` (
  `id` varchar(36) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `age` year(4) DEFAULT NULL COMMENT 'Год рождения, при создании протоколов (выбор записей участников) по результату запроса определеяется возростная группа',
  `gender` enum('ж','м') DEFAULT NULL,
  `rank` enum('б/р','1','2','3','1ю','2ю','3ю','КМС') DEFAULT NULL,
  `id_delegation` varchar(36) NOT NULL,
  `id_race_group` varchar(36) DEFAULT NULL,
  `id_race_twain` varchar(36) DEFAULT NULL,
  `id_chip` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `id_delegation_idx` (`id_delegation`),
  KEY `id_race_twain_idx` (`id_race_twain`),
  KEY `id_race_group_idx` (`id_race_group`),
  KEY `fk_participant_chip1_idx` (`id_chip`),
  CONSTRAINT `fk_participant_chip1` FOREIGN KEY (`id_chip`) REFERENCES `chip` (`id`),
  CONSTRAINT `id_delegation` FOREIGN KEY (`id_delegation`) REFERENCES `delegation` (`id`),
  CONSTRAINT `id_race_group` FOREIGN KEY (`id_race_group`) REFERENCES `race_group` (`id`),
  CONSTRAINT `id_race_twain` FOREIGN KEY (`id_race_twain`) REFERENCES `race_twain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-26  9:26:39
