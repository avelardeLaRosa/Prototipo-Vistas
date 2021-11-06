-- MySQL Script generated by MySQL Workbench
-- Sat Nov  6 10:25:40 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BDTienda
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BDTienda
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BDTienda` DEFAULT CHARACTER SET utf8 ;
USE `BDTienda` ;

-- -----------------------------------------------------
-- Table `BDTienda`.`Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDTienda`.`Proveedor` (
  `ruc` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `informacion` VARCHAR(45) NULL,
  PRIMARY KEY (`ruc`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDTienda`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDTienda`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `dni` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `correo` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDTienda`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDTienda`.`Categoria` (
  `idCategoria` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDTienda`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDTienda`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `cantidad` INT NULL,
  `precio` DECIMAL NULL,
  `Proveedor_ruc` INT NOT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `fk_Producto_Proveedor_idx` (`Proveedor_ruc` ASC) VISIBLE,
  INDEX `fk_Producto_Categoria1_idx` (`Categoria_idCategoria` ASC) VISIBLE,
  CONSTRAINT `fk_Producto_Proveedor`
    FOREIGN KEY (`Proveedor_ruc`)
    REFERENCES `BDTienda`.`Proveedor` (`ruc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Producto_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `BDTienda`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDTienda`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDTienda`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  `clave` VARCHAR(45) NULL,
  `fecha_registro` DATE NULL,
  `fecha_eliminacion` DATE NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDTienda`.`Caja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDTienda`.`Caja` (
  `idCaja` INT NOT NULL AUTO_INCREMENT,
  `monto` DECIMAL NULL,
  `comentario` VARCHAR(45) NULL,
  `Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idCaja`),
  INDEX `fk_Caja_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Caja_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `BDTienda`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDTienda`.`Venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDTienda`.`Venta` (
  `idVenta` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `Cliente_idCliente` INT NOT NULL,
  `Caja_idCaja` INT NOT NULL,
  PRIMARY KEY (`idVenta`),
  INDEX `fk_Venta_Cliente1_idx` (`Cliente_idCliente` ASC) VISIBLE,
  INDEX `fk_Venta_Caja1_idx` (`Caja_idCaja` ASC) VISIBLE,
  CONSTRAINT `fk_Venta_Cliente1`
    FOREIGN KEY (`Cliente_idCliente`)
    REFERENCES `BDTienda`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Venta_Caja1`
    FOREIGN KEY (`Caja_idCaja`)
    REFERENCES `BDTienda`.`Caja` (`idCaja`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BDTienda`.`detalle_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BDTienda`.`detalle_venta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `precio` DECIMAL NULL,
  `cantidad` INT NULL,
  `Venta_idVenta` INT NOT NULL,
  `Categoria_idCategoria` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_detalle_venta_Venta1_idx` (`Venta_idVenta` ASC) VISIBLE,
  INDEX `fk_detalle_venta_Categoria1_idx` (`Categoria_idCategoria` ASC) VISIBLE,
  CONSTRAINT `fk_detalle_venta_Venta1`
    FOREIGN KEY (`Venta_idVenta`)
    REFERENCES `BDTienda`.`Venta` (`idVenta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_venta_Categoria1`
    FOREIGN KEY (`Categoria_idCategoria`)
    REFERENCES `BDTienda`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
