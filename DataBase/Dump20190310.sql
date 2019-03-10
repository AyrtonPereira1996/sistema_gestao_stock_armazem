CREATE DATABASE  IF NOT EXISTS `bd_arm_fcsp` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_arm_fcsp`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_arm_fcsp
-- ------------------------------------------------------
-- Server version	8.0.11

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
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `departamento` (
  `idDepartamento` int(4) NOT NULL AUTO_INCREMENT,
  `codDepartamento` varchar(4) NOT NULL,
  `nomeDepartamento` varchar(30) NOT NULL,
  `nomecoordenador` varchar(30) NOT NULL,
  `dataRegisto` datetime DEFAULT NULL,
  PRIMARY KEY (`idDepartamento`),
  UNIQUE KEY `codDepartamento` (`codDepartamento`),
  UNIQUE KEY `nomeDepartamento` (`nomeDepartamento`),
  UNIQUE KEY `nomeCoordenador` (`nomecoordenador`),
  UNIQUE KEY `codDepartamento_2` (`codDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'ICT1','ICT','Ayrton Pereira','2019-01-24 10:32:21'),(2,'DIRE','Direção','João Francisco','2019-01-24 10:50:27'),(3,'PATL','Patrimonio e logística','Joaquina Francisca','2019-01-24 10:51:46');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `novoDepartamento` AFTER INSERT ON `departamento` FOR EACH ROW insert into historial_departamento values(default, new.idDepartamento, "Registo de departamento", now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `edicaoDepartamento` AFTER UPDATE ON `departamento` FOR EACH ROW insert into historial_departamento values(default, new.idDepartamento, "Departamento editado", now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `exclusaoDepartamento` AFTER DELETE ON `departamento` FOR EACH ROW insert into historial_departamento values(default, old.idDepartamento, "Departamento exclu�do", now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `entrada_producto`
--

DROP TABLE IF EXISTS `entrada_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `entrada_producto` (
  `idEntrada` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) DEFAULT NULL,
  `dataEntrada` datetime DEFAULT NULL,
  `quantidade_entrada` int(11) DEFAULT NULL,
  `descricao` mediumtext,
  PRIMARY KEY (`idEntrada`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `entrada_producto_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada_producto`
--

LOCK TABLES `entrada_producto` WRITE;
/*!40000 ALTER TABLE `entrada_producto` DISABLE KEYS */;
INSERT INTO `entrada_producto` VALUES (1,1,'2019-02-11 17:07:01',10,'Entrada de producto'),(2,2,'2019-02-11 17:07:56',20,'Entrada de producto'),(3,4,'2019-02-11 17:08:51',10,'Entrada de producto'),(4,5,'2019-02-11 17:09:42',40,'Entrada de producto');
/*!40000 ALTER TABLE `entrada_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funcionario` (
  `idFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `idDepartamento` int(4) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `apelido` varchar(30) NOT NULL,
  `sexo` enum('M','F') NOT NULL,
  `cargo` varchar(40) NOT NULL,
  `enderecoElectronico` varchar(50) DEFAULT NULL,
  `contacto` varchar(13) NOT NULL,
  `dataRegisto` datetime DEFAULT NULL,
  PRIMARY KEY (`idFuncionario`),
  KEY `idDepartamento` (`idDepartamento`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`iddepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,1,'Ayrton','Pereira','M','Técnico','ayrton_pereira1996@hotmail.com','847079623','2019-01-24 10:36:28'),(2,2,'Renato','Silva','M','Administrador','renato@exemplo.com','874847384','2019-01-24 10:52:59'),(3,3,'Manuela','Conceição','F','Fiél do armazém','manuela@exemplo.com','828374893','2019-01-24 10:54:22');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `novoFuncionario` AFTER INSERT ON `funcionario` FOR EACH ROW insert into Historial_funcionario values(default, new.idFuncionario, new.idDepartamento, "Registo de funcion�rio", now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `edicaoFuncionario` AFTER UPDATE ON `funcionario` FOR EACH ROW insert into Historial_funcionario values(default, new.idFuncionario, new.idDepartamento, "Funcion�rio editado", now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `exclusaoFuncionario` AFTER DELETE ON `funcionario` FOR EACH ROW insert into Historial_funcionario values(default, old.idFuncionario, old.idDepartamento, "Funcion�rio excluido", now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `historial_departamento`
--

DROP TABLE IF EXISTS `historial_departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `historial_departamento` (
  `idHistorialDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `idDepartamento` int(11) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `dataModificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`idHistorialDepartamento`),
  KEY `idDepartamento` (`idDepartamento`),
  CONSTRAINT `historial_departamento_ibfk_1` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`iddepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_departamento`
--

LOCK TABLES `historial_departamento` WRITE;
/*!40000 ALTER TABLE `historial_departamento` DISABLE KEYS */;
INSERT INTO `historial_departamento` VALUES (1,1,'Registo de departamento','2019-01-24 10:32:21'),(2,2,'Registo de departamento','2019-01-24 10:50:27'),(3,3,'Registo de departamento','2019-01-24 10:51:46');
/*!40000 ALTER TABLE `historial_departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_funcionario`
--

DROP TABLE IF EXISTS `historial_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `historial_funcionario` (
  `idHistorialFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `idFuncionario` int(11) DEFAULT NULL,
  `idDepartamento` int(11) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `dataModificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`idHistorialFuncionario`),
  KEY `idFuncionario` (`idFuncionario`),
  KEY `idDepartamento` (`idDepartamento`),
  CONSTRAINT `historial_funcionario_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idfuncionario`),
  CONSTRAINT `historial_funcionario_ibfk_2` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`iddepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_funcionario`
--

LOCK TABLES `historial_funcionario` WRITE;
/*!40000 ALTER TABLE `historial_funcionario` DISABLE KEYS */;
INSERT INTO `historial_funcionario` VALUES (1,1,1,'Registo de funcionário','2019-01-24 10:36:28'),(2,2,2,'Registo de funcionário','2019-01-24 10:52:59'),(3,3,3,'Registo de funcionário','2019-01-24 10:54:22'),(4,2,2,'Funcionário editado','2019-01-24 11:05:43');
/*!40000 ALTER TABLE `historial_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_producto`
--

DROP TABLE IF EXISTS `historial_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `historial_producto` (
  `idHistorial_Producto` int(11) NOT NULL AUTO_INCREMENT,
  `idProducto` int(11) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `dataModificacao` datetime DEFAULT NULL,
  PRIMARY KEY (`idHistorial_Producto`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `historial_producto_ibfk_3` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idproducto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_producto`
--

LOCK TABLES `historial_producto` WRITE;
/*!40000 ALTER TABLE `historial_producto` DISABLE KEYS */;
INSERT INTO `historial_producto` VALUES (1,1,'Registo de produto','2019-02-11 17:07:01'),(2,2,'Registo de produto','2019-02-11 17:07:56'),(3,4,'Registo de produto','2019-02-11 17:08:51'),(4,5,'Registo de produto','2019-02-11 17:09:42'),(5,2,'Produto editado','2019-02-11 17:12:29'),(6,5,'Produto editado','2019-02-11 17:12:49');
/*!40000 ALTER TABLE `historial_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_sys`
--

DROP TABLE IF EXISTS `login_sys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `login_sys` (
  `idLoginSys` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(15) DEFAULT NULL,
  `descricao` mediumtext,
  `dataRegisto` datetime DEFAULT NULL,
  PRIMARY KEY (`idLoginSys`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_sys`
--

LOCK TABLES `login_sys` WRITE;
/*!40000 ALTER TABLE `login_sys` DISABLE KEYS */;
INSERT INTO `login_sys` VALUES (1,'Admin','Iniciou sessão','2019-01-24 10:42:46'),(2,'Administrador','Iniciou sessão','2019-01-24 10:56:53'),(3,'Admin','Iniciou sessão','2019-01-24 11:05:06'),(4,'Administrador','Iniciou sessão','2019-01-24 11:06:00'),(5,'Admin','Iniciou sessão','2019-02-11 17:04:48'),(6,'Administrador','Iniciou sessão','2019-02-11 17:05:22'),(7,'Funcionario','Iniciou sessão','2019-02-11 17:06:10'),(8,'Administrador','Iniciou sessão','2019-02-11 17:13:20'),(9,'Admin','Iniciou sessão','2019-02-22 17:59:46'),(10,'Admin','Iniciou sessão','2019-02-22 18:11:34');
/*!40000 ALTER TABLE `login_sys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `artigo` varchar(4) NOT NULL,
  `data` datetime NOT NULL,
  `tipoProducto` varchar(50) NOT NULL,
  `descricao` mediumtext NOT NULL,
  `quantidade` int(10) unsigned DEFAULT NULL,
  `validade` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `artigo` (`artigo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'01RE','2019-02-11 17:07:01','Resma A4','Resma A4',10,'Sem validade'),(2,'01TI','2019-02-11 17:07:56','Teclado Dell','Teclado Dell cor preta',18,'Sem validade'),(4,'02TI','2019-02-11 17:08:51','Monitor','Monitor Lenovo',10,'Sem validade'),(5,'01LO','2019-02-11 17:09:42','Soclean','Produto de limpeza',20,'Sem validade');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
ALTER DATABASE `bd_arm_fcsp` CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `novoProducto` AFTER INSERT ON `producto` FOR EACH ROW insert into entrada_producto values (default, new.idproducto, now(), new.quantidade, "Entrada de producto" ) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
ALTER DATABASE `bd_arm_fcsp` CHARACTER SET utf8 COLLATE utf8_general_ci ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `registoProducto` AFTER INSERT ON `producto` FOR EACH ROW insert into historial_producto values(default, new.idProducto, "Registo de produto", now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `logAcrescimoQuantidade` AFTER UPDATE ON `producto` FOR EACH ROW BEGIN
if new.quantidade>old.quantidade then insert into entrada_producto values(null, new.idProducto, now(), new.quantidade, 'Acréscimo na quantidade');
end if;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `edicaoProducto` AFTER UPDATE ON `producto` FOR EACH ROW insert into historial_producto values(default, new.idProducto, "Produto editado", now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `productoExcluido` AFTER DELETE ON `producto` FOR EACH ROW insert into historial_producto values(default, old.idProducto, 'Producto foi exluído', old.data, now()) */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `requisicao`
--

DROP TABLE IF EXISTS `requisicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `requisicao` (
  `idRequisicao` int(11) NOT NULL AUTO_INCREMENT,
  `idDepartamento` int(11) NOT NULL,
  `idFuncionario` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `data` datetime NOT NULL,
  PRIMARY KEY (`idRequisicao`),
  KEY `idDepartamento` (`idDepartamento`),
  KEY `idProducto` (`idProducto`),
  KEY `idFuncionario` (`idFuncionario`),
  CONSTRAINT `requisicao_ibfk_1` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`iddepartamento`),
  CONSTRAINT `requisicao_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idproducto`),
  CONSTRAINT `requisicao_ibfk_3` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idfuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisicao`
--

LOCK TABLES `requisicao` WRITE;
/*!40000 ALTER TABLE `requisicao` DISABLE KEYS */;
INSERT INTO `requisicao` VALUES (1,1,1,2,2,'2019-02-11 17:12:29'),(2,3,3,5,20,'2019-02-11 17:12:49');
/*!40000 ALTER TABLE `requisicao` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `requisicaoLog` AFTER INSERT ON `requisicao` FOR EACH ROW insert into saida_producto values(default, new.idRequisicao, new.idDepartamento, new.idProducto, now(), new.quantidade, 'Producto requirido') */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = cp850 */ ;
/*!50003 SET character_set_results = cp850 */ ;
/*!50003 SET collation_connection  = cp850_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `reducaoQuantidade` AFTER INSERT ON `requisicao` FOR EACH ROW update producto set quantidade = quantidade - new.quantidade where idProducto = new.idProducto */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `saida_producto`
--

DROP TABLE IF EXISTS `saida_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `saida_producto` (
  `idSaida` int(11) NOT NULL AUTO_INCREMENT,
  `idRequisicao` int(11) DEFAULT NULL,
  `idDepartamento` int(4) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `dataSaida` datetime NOT NULL,
  `Quantidade_saida` int(11) NOT NULL,
  `descricao` mediumtext,
  PRIMARY KEY (`idSaida`),
  KEY `idProducto` (`idProducto`),
  KEY `idDepartamento` (`idDepartamento`),
  KEY `idRequisicao` (`idRequisicao`),
  CONSTRAINT `saida_producto_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idproducto`),
  CONSTRAINT `saida_producto_ibfk_3` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`iddepartamento`),
  CONSTRAINT `saida_producto_ibfk_4` FOREIGN KEY (`idRequisicao`) REFERENCES `requisicao` (`idrequisicao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saida_producto`
--

LOCK TABLES `saida_producto` WRITE;
/*!40000 ALTER TABLE `saida_producto` DISABLE KEYS */;
INSERT INTO `saida_producto` VALUES (1,1,1,2,'2019-02-11 17:12:29',2,'Producto requirido'),(2,2,3,5,'2019-02-11 17:12:49',20,'Producto requirido');
/*!40000 ALTER TABLE `saida_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `idFuncionario` int(11) NOT NULL,
  `usuario` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `rolestring` enum('Admin','Funcionario','Administrador') NOT NULL,
  `data_registo` datetime NOT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `idFuncionario` (`idFuncionario`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`idfuncionario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,1,'Admin','Admin','Admin','2019-01-24 10:39:27'),(2,2,'Administrador','administrador','Administrador','2019-01-24 10:56:08'),(3,3,'Funcionario','funcionario','Funcionario','2019-01-24 10:56:30');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-10 12:38:25
