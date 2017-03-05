SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema caemdejeh
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema caemdejeh
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `caemdejeh` DEFAULT CHARACTER SET utf8 ;
USE `caemdejeh` ;

-- -----------------------------------------------------
-- Table `caemdejeh`.`tipo_articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`tipo_articulo` (
  `codigo` INT(4) NOT NULL,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caemdejeh`.`marcas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`marcas` (
  `idmarcas` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`idmarcas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `caemdejeh`.`bodega`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`bodega` (
  `idbodega` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idbodega`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caemdejeh`.`articulo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`articulo` (
  `idarticulo` INT(11) NOT NULL,
  `nombre` VARCHAR(35) NOT NULL,
  `marca` INT NULL,
  `descripcion` VARCHAR(100) NOT NULL,
  `cod_tipo_articulo` INT(4) NULL DEFAULT NULL,
  `precio_venta` INT NULL,
  `cantidad` INT NULL,
  `bodega` INT NULL,
  `punto_de_pedido` INT NULL,
  PRIMARY KEY (`idarticulo`),
  INDEX `cod_tipo_articulo` (`cod_tipo_articulo` ASC),
  INDEX `FK_marca_idx` (`marca` ASC),
  INDEX `FK_bodega_idx` (`bodega` ASC),
  CONSTRAINT `articulo_ibfk_1`
    FOREIGN KEY (`cod_tipo_articulo`)
    REFERENCES `caemdejeh`.`tipo_articulo` (`codigo`),
  CONSTRAINT `FK_marca`
    FOREIGN KEY (`marca`)
    REFERENCES `caemdejeh`.`marcas` (`idmarcas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_bodega`
    FOREIGN KEY (`bodega`)
    REFERENCES `caemdejeh`.`bodega` (`idbodega`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caemdejeh`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`persona` (
  `cedula` INT NOT NULL,
  `nombre` VARCHAR(12) NULL DEFAULT NULL,
  `apellidos` VARCHAR(15) NULL DEFAULT NULL,
  `correo` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`cedula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caemdejeh`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`proveedor` (
  `idproveedor` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(12) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idproveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caemdejeh`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`usuario` (
  `idusuario` INT(11) NOT NULL AUTO_INCREMENT,
  `idpersona` INT(11) NULL,
  `alias` VARCHAR(35) NULL DEFAULT NULL,
  `password` VARCHAR(35) NULL DEFAULT NULL,
  `rol` INT NULL DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  INDEX `FK_persona_idx` (`idpersona` ASC),
  CONSTRAINT `FK_persona`
    FOREIGN KEY (`idpersona`)
    REFERENCES `caemdejeh`.`persona` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `caemdejeh`.`direcciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`direcciones` (
  `iddirecciones` INT NOT NULL AUTO_INCREMENT,
  `direccion1` VARCHAR(45) NOT NULL,
  `direccion2` VARCHAR(45) NULL,
  `provincia` VARCHAR(45) NULL,
  `canton` VARCHAR(45) NULL,
  `distrito` VARCHAR(45) NULL,
  `codigoPostal` INT NULL,
  PRIMARY KEY (`iddirecciones`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `caemdejeh`.`direccion_proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`direccion_proveedor` (
  `iddireccion_proveedor` INT NOT NULL AUTO_INCREMENT,
  `proveedor` INT NULL,
  `direccion` INT NULL,
  PRIMARY KEY (`iddireccion_proveedor`),
  INDEX `FK_dirrecion_idx` (`direccion` ASC),
  INDEX `FK_proveedor_idx` (`proveedor` ASC),
  CONSTRAINT `FK_proveedor`
    FOREIGN KEY (`proveedor`)
    REFERENCES `caemdejeh`.`proveedor` (`idproveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_dirrecion`
    FOREIGN KEY (`direccion`)
    REFERENCES `caemdejeh`.`direcciones` (`iddirecciones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `caemdejeh`.`movimiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`movimiento` (
  `persona` INT NOT NULL,
  `articulo` INT NOT NULL,
  `fecha` DATE NULL,
  `cantidad` INT NULL,
  `tipo` INT NULL,
  INDEX `FK_persona_idx` (`persona` ASC),
  INDEX `FK_articulo_idx` (`articulo` ASC),
  CONSTRAINT `FK_persona_m`
    FOREIGN KEY (`persona`)
    REFERENCES `caemdejeh`.`persona` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_articulo_m`
    FOREIGN KEY (`articulo`)
    REFERENCES `caemdejeh`.`articulo` (`idarticulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `caemdejeh`.`articulo_proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `caemdejeh`.`articulo_proveedor` (
  `articulo` INT NOT NULL,
  `proveedor` INT NOT NULL,
  `porcentaje_descuento` INT NULL,
  `precio_estandar` INT NULL,
  `fecha_primera_compra` DATE NULL,
  `fecha_ultima_compra` DATE NULL,
  `cantidad_pedido` INT NULL,
  `total_pedido` INT NULL,
  INDEX `FK_proveedor_idx` (`proveedor` ASC),
  INDEX `FK_articulo_idx` (`articulo` ASC),
  CONSTRAINT `FK_proveedor_p`
    FOREIGN KEY (`proveedor`)
    REFERENCES `caemdejeh`.`proveedor` (`idproveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_articulo_p`
    FOREIGN KEY (`articulo`)
    REFERENCES `caemdejeh`.`articulo` (`idarticulo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
