-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 159.69.144.39    Database: bierkassedlrg
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

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
-- Table structure for table `Ware`
--

DROP TABLE IF EXISTS `Ware`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Ware` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ware`
--

LOCK TABLES `Ware` WRITE;
/*!40000 ALTER TABLE `Ware` DISABLE KEYS */;
INSERT INTO `Ware` VALUES (1,'Cola'),(2,'Fanta'),(3,'Mezzo'),(4,'Bier'),(5,'Kiezmische'),(6,'Flensburger Helles'),(7,'Pils'),(8,'Sprudel');
/*!40000 ALTER TABLE `Ware` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `benutzer`
--

DROP TABLE IF EXISTS `benutzer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `benutzer` (
  `idrfid` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `vorname` varchar(45) DEFAULT NULL,
  `guthaben` double DEFAULT NULL,
  `isAdmin` int DEFAULT NULL,
  `chipid` bigint NOT NULL,
  PRIMARY KEY (`idrfid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `benutzer`
--

LOCK TABLES `benutzer` WRITE;
/*!40000 ALTER TABLE `benutzer` DISABLE KEYS */;
INSERT INTO `benutzer` VALUES (187,'Werner','Florian',20,1,189162273005),(188,'Mayer','Julian',10,0,0),(189,'Kost','Marvin',10,0,456798),(190,'Tremmel','Jonas',10,0,12345678),(191,'Bertsch','Robert',10,0,0),(192,'Büchele','Mika1',60,0,0);
/*!40000 ALTER TABLE `benutzer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kauefe`
--

DROP TABLE IF EXISTS `kauefe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kauefe` (
  `id` int NOT NULL,
  `Datum` date NOT NULL,
  `benutzer_idrfid` int NOT NULL,
  `Ware_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_kauefe_benutzer_idx` (`benutzer_idrfid`),
  KEY `fk_kauefe_Ware1_idx` (`Ware_id`),
  CONSTRAINT `fk_kauefe_benutzer` FOREIGN KEY (`benutzer_idrfid`) REFERENCES `benutzer` (`idrfid`),
  CONSTRAINT `fk_kauefe_Ware1` FOREIGN KEY (`Ware_id`) REFERENCES `Ware` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kauefe`
--

LOCK TABLES `kauefe` WRITE;
/*!40000 ALTER TABLE `kauefe` DISABLE KEYS */;
/*!40000 ALTER TABLE `kauefe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-26 14:47:05
