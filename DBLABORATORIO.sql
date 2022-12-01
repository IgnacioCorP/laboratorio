-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema laboratorio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema laboratorio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `laboratorio` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `laboratorio` ;

-- -----------------------------------------------------
-- Table `laboratorio`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`cliente` (
  `Nif` VARCHAR(9) NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Apellido` VARCHAR(45) NULL DEFAULT NULL,
  `Telefono` VARCHAR(9) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Fecha_nac` DATE NULL DEFAULT NULL,
  `Clave` VARBINARY(100) NOT NULL,
  PRIMARY KEY (`Nif`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `laboratorio`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`departamento` (
  `ID_dep` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(100) NOT NULL,
  `Descripcion` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID_dep`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `laboratorio`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`empleado` (
  `Nif` VARCHAR(9) NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Apellido` VARCHAR(45) NULL DEFAULT NULL,
  `Telefono` VARCHAR(9) NULL DEFAULT NULL,
  `Direccion` VARCHAR(70) NULL DEFAULT NULL,
  `Email` VARCHAR(60) NOT NULL,
  `Fecha_Nac` DATE NULL DEFAULT NULL,
  `Clave` VARBINARY(100) NOT NULL,
  PRIMARY KEY (`Nif`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `laboratorio`.`laboratorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`laboratorio` (
  `ID_lab` INT NOT NULL AUTO_INCREMENT,
  `Nombre_sede` VARCHAR(90) NOT NULL,
  `Direccion` VARCHAR(90) NOT NULL,
  `Telefono` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`ID_lab`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `laboratorio`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `laboratorio`.`producto` (
  `ID_pro` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` DOUBLE NOT NULL,
  `Fecha_caducidad` DATE NOT NULL,
  PRIMARY KEY (`ID_pro`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
