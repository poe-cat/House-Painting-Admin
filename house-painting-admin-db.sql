-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: house-painting
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `clients`
--

use heroku_dbf06e7457996f8;

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `id` int NOT NULL AUTO_INCREMENT,
  `client_description` varchar(255) DEFAULT NULL,
  `client_name` varchar(255) DEFAULT NULL,
  `phone_number` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_759udbd1akn2tuipnp89ubjl6` (`client_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Pani po 80tce, bardzo miła, mieszka z 10-cioma kotami','Maria Janion',222333444),(2,'Właścicielka schroniska dla zwierząt, energiczna, oszczędna','Anna Maria Jopek',333555343),(3,'Właściciel baru mlecznego, często nie odbiera telefonu','Wacław Kowalski',444555333),(4,'Rencista, ma problemy z poruszaniem się, niedosłyszy','Marian Lewandowski',490933333);
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commissions_table`
--

DROP TABLE IF EXISTS `commissions_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `commissions_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `hours` double NOT NULL,
  `payment` double NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `client_id` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2opof4rykawx1979kou9wbk5j` (`title`),
  KEY `FK649bn7u9gdgw94fqfdir0kj57` (`client_id`),
  CONSTRAINT `FK649bn7u9gdgw94fqfdir0kj57` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commissions_table`
--

LOCK TABLES `commissions_table` WRITE;
/*!40000 ALTER TABLE `commissions_table` DISABLE KEYS */;
INSERT INTO `commissions_table` VALUES (2,'Polna 14','Szpachlowanie i malowanie strychu, piwnicy i komórki',20,5000,'Taki stary, samotny dom',1),(3,'Tatrzańska 20/1','Malowanie kuchni i łazienki. Biała farba, doliczony koszt zakupów i dowozu, rabat za sprzątanie',16,3000,'Mieszkanie na wynajem',1),(4,'Wiślana 12, Gdynia','Malowanie błękitną, białą i fioletową farbą, zabezpieczenie sprzętu (nie odsuwany)',17,4000,'Bar mleczny \"Ryba piła\"',3),(5,'Długosza 12/3','Układanie paneli w salonie, założenie listew i progów, dodatkowo przykręcenie kontaktów',4,300,'Panele w salonie',4);
/*!40000 ALTER TABLE `commissions_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'USER'),(2,'ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `enabled` tinyint DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (3,1,'$2a$12$sl/hoMdrgRvw8gtvw/XLD.gQjFPcH75g.O/AzfhZiGHQ1Gc.0USDi','poe'),(4,1,'$2a$12$sl/hoMdrgRvw8gtvw/XLD.gQjFPcH75g.O/AzfhZiGHQ1Gc.0USDi','blaise');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `users_roles` (
  `role_id` bigint NOT NULL,
  `roles_role_id` int NOT NULL,
  PRIMARY KEY (`role_id`,`roles_role_id`),
  KEY `FKtgou1kvdhyryu3fia6uu1fhoi` (`roles_role_id`),
  CONSTRAINT `FK7bvb4gjgqcgxvgddx0pgefkei` FOREIGN KEY (`role_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKtgou1kvdhyryu3fia6uu1fhoi` FOREIGN KEY (`roles_role_id`) REFERENCES `roles` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (4,1),(3,2);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-06 10:05:00
