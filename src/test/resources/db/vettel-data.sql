-- MySQL dump 10.13  Distrib 5.6.10, for Win64 (x86_64)
--
-- Host: localhost    Database: vettel
-- ------------------------------------------------------
-- Server version	5.6.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` (`authority`, `description`) VALUES ('ROLE_ADMIN','The most powerful role');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`username`, `name`, `password`, `enabled`) VALUES ('admin','Administrator','$2a$10$3Frma5rvcwKUi9EkIxP6nejNWh9Ex9nak6KljbR/khHTcFQjUQF26',1);
INSERT INTO `person` (`username`, `name`, `password`, `enabled`) VALUES ('user01','user01','$2a$10$2yAAF1O16bjZCl4Vu8xc5O6vuKyE3zzmg1aJ1pJx1HbSXnT5waKP.',0);
INSERT INTO `person` (`username`, `name`, `password`, `enabled`) VALUES ('user02','user02','$2a$10$PqC2Ql/7WfsWIMFvvu39Oe/YA5BHPo9MpQAwMkz06MWlNm8mTGFB6',1);
INSERT INTO `person` (`username`, `name`, `password`, `enabled`) VALUES ('user03','user03','$2a$10$n2dOpncJdJk4icZSNCeJ1u/48cOo2sFHBGB5oSKO6h53XRqORknla',1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person_authority`
--

LOCK TABLES `person_authority` WRITE;
/*!40000 ALTER TABLE `person_authority` DISABLE KEYS */;
INSERT INTO `person_authority` (`id`, `username`, `authority`) VALUES (1,'admin','ROLE_ADMIN');
/*!40000 ALTER TABLE `person_authority` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

