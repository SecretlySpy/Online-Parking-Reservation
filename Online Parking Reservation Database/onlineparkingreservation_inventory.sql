-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: onlineparkingreservation
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `ID` varchar(45) NOT NULL,
  `FullName` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Gender` varchar(45) NOT NULL,
  `MobileNumber` varchar(45) NOT NULL,
  `Birthdate` varchar(45) NOT NULL,
  `PlateNumber` varchar(45) NOT NULL,
  `Brand` varchar(45) NOT NULL,
  `Color` varchar(45) NOT NULL,
  `Type` varchar(45) NOT NULL,
  `DOR` varchar(45) NOT NULL,
  `DOP` varchar(45) NOT NULL,
  `SlotNumber` varchar(45) NOT NULL,
  `THP` varchar(45) NOT NULL,
  `TP` varchar(45) NOT NULL,
  `TD` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`,`FullName`,`Email`,`Gender`,`MobileNumber`,`Birthdate`,`PlateNumber`,`Brand`,`Color`,`Type`,`DOR`,`DOP`,`SlotNumber`,`THP`,`TP`,`TD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES ('1','Full Name:','michaelareyes@gmail.com','female','09252525252','1999','zxcv0987','Honda','Pink','SUV','d MMM y','d MMM y','1','6','12PM','6AM'),('2','Full Name:','reyesjoy@gmail.com','female','09717171717','1999','dfskfjewp342345','Ford','Blue','Crossover','d MMM y','d MMM y','2','6','6PM','12PM');
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-29 17:53:35
