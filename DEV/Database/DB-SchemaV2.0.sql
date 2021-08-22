-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bierkassedlrg
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bierkassedlrg
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bierkassedlrg` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bierkassedlrg` ;

-- -----------------------------------------------------
-- Table `bierkassedlrg`.`Ware`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bierkassedlrg`.`Ware` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bierkassedlrg`.`benutzer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bierkassedlrg`.`benutzer` (
  `idrfid` INT NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `vorname` VARCHAR(45) NULL DEFAULT NULL,
  `guthaben` DOUBLE NULL DEFAULT NULL,
  `isAdmin` INT NULL DEFAULT NULL,
  `chipid` BIGINT NOT NULL,
  PRIMARY KEY (`idrfid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bierkassedlrg`.`kauefe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bierkassedlrg`.`kauefe` (
  `id` INT NOT NULL,
  `Datum` DATE NOT NULL,
  `benutzer_idrfid` INT NOT NULL,
  `Ware_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_kauefe_benutzer_idx` (`benutzer_idrfid` ASC) VISIBLE,
  INDEX `fk_kauefe_Ware1_idx` (`Ware_id` ASC) VISIBLE,
  CONSTRAINT `fk_kauefe_benutzer`
    FOREIGN KEY (`benutzer_idrfid`)
    REFERENCES `bierkassedlrg`.`benutzer` (`idrfid`),
  CONSTRAINT `fk_kauefe_Ware1`
    FOREIGN KEY (`Ware_id`)
    REFERENCES `bierkassedlrg`.`Ware` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
