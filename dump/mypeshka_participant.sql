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
  `ID_participant` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `patronymic` varchar(45) DEFAULT NULL,
  `age` year(4) DEFAULT NULL COMMENT '''Год рождения'', при создании протоколов (выбор записей участников) по результату запроса определеяется возростная группа',
  `gender` enum('ж','м') DEFAULT NULL,
  `rank` enum('б/р','1','2','3','1ю','2ю','3ю','КМС') DEFAULT NULL COMMENT '''разряд''',
  `delegation_id` int(11) DEFAULT NULL,
  `chip_id` int(11) NOT NULL,
  `race_sv_id` int(11) DEFAULT NULL,
  `race_g_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_participant`),
  KEY `id delegation_idx` (`delegation_id`),
  KEY `fk_participant_chip1_idx` (`chip_id`),
  KEY `fk_participant_race_sv1_idx` (`race_sv_id`),
  KEY `fk_participant_race_g1_idx` (`race_g_id`),
  CONSTRAINT `fk_participant_chip1` FOREIGN KEY (`chip_id`) REFERENCES Chip (`id`),
  CONSTRAINT `fk_participant_race_g1` FOREIGN KEY (`race_g_id`) REFERENCES `race_group` (id),
  CONSTRAINT `fk_participant_race_sv1` FOREIGN KEY (`race_sv_id`) REFERENCES `race_twain` (id),
  CONSTRAINT `id delegation` FOREIGN KEY (`delegation_id`) REFERENCES `delegation` (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-18 14:45:26
