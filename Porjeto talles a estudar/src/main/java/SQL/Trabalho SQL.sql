-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ifood
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ifood
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ifood` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ifood` ;

-- -----------------------------------------------------
-- Table `ifood`.`acompanhamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`acompanhamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL DEFAULT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  `valor` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`promocao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`promocao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL DEFAULT NULL,
  `codigo` VARCHAR(50) NULL DEFAULT NULL,
  `valor` DECIMAL(10,2) NULL DEFAULT NULL,
  `validade` DATE NULL DEFAULT NULL,
  `tipo` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rua` VARCHAR(255) NULL DEFAULT NULL,
  `bairro` VARCHAR(100) NULL DEFAULT NULL,
  `cidade` VARCHAR(100) NULL DEFAULT NULL,
  `estado` VARCHAR(50) NULL DEFAULT NULL,
  `CEP` VARCHAR(10) NULL DEFAULT NULL,
  `promocao_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `promocao_id` (`promocao_id` ASC) VISIBLE,
  CONSTRAINT `endereco_ibfk_1`
    FOREIGN KEY (`promocao_id`)
    REFERENCES `ifood`.`promocao` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(50) NULL DEFAULT NULL,
  `nome` VARCHAR(100) NULL DEFAULT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`restaurante` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL DEFAULT NULL,
  `endereco_id` INT NULL DEFAULT NULL,
  `telefone` VARCHAR(20) NULL DEFAULT NULL,
  `categoria_id` INT NULL DEFAULT NULL,
  `hora_funcionamento` VARCHAR(100) NULL DEFAULT NULL,
  `is_retirada` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `endereco_id` (`endereco_id` ASC) VISIBLE,
  INDEX `categoria_id` (`categoria_id` ASC) VISIBLE,
  CONSTRAINT `restaurante_ibfk_1`
    FOREIGN KEY (`endereco_id`)
    REFERENCES `ifood`.`endereco` (`id`),
  CONSTRAINT `restaurante_ibfk_2`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `ifood`.`categoria` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`status_entrega`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`status_entrega` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`forma_pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`forma_pagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo_de_pagamento` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NULL DEFAULT NULL,
  `id_restaurante` INT NULL DEFAULT NULL,
  `valor` DECIMAL(10,2) NULL DEFAULT NULL,
  `taxa_entrega` DECIMAL(10,2) NULL DEFAULT NULL,
  `id_promo` INT NULL DEFAULT NULL,
  `id_status_entrega` INT NULL DEFAULT NULL,
  `id_forma_pagamento` INT NULL DEFAULT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  `troco` DECIMAL(10,2) NULL DEFAULT NULL,
  `id_endereco` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_restaurante` (`id_restaurante` ASC) VISIBLE,
  INDEX `id_promo` (`id_promo` ASC) VISIBLE,
  INDEX `id_status_entrega` (`id_status_entrega` ASC) VISIBLE,
  INDEX `id_forma_pagamento` (`id_forma_pagamento` ASC) VISIBLE,
  INDEX `id_endereco` (`id_endereco` ASC) VISIBLE,
  CONSTRAINT `pedido_ibfk_1`
    FOREIGN KEY (`id_restaurante`)
    REFERENCES `ifood`.`restaurante` (`id`),
  CONSTRAINT `pedido_ibfk_2`
    FOREIGN KEY (`id_promo`)
    REFERENCES `ifood`.`promocao` (`id`),
  CONSTRAINT `pedido_ibfk_3`
    FOREIGN KEY (`id_status_entrega`)
    REFERENCES `ifood`.`status_entrega` (`id`),
  CONSTRAINT `pedido_ibfk_4`
    FOREIGN KEY (`id_forma_pagamento`)
    REFERENCES `ifood`.`forma_pagamento` (`id`),
  CONSTRAINT `pedido_ibfk_5`
    FOREIGN KEY (`id_endereco`)
    REFERENCES `ifood`.`endereco` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`avaliacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nota` INT NULL DEFAULT NULL,
  `pedido_id` INT NULL DEFAULT NULL,
  `id_restaurante` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `pedido_id` (`pedido_id` ASC) VISIBLE,
  INDEX `id_restaurante` (`id_restaurante` ASC) VISIBLE,
  CONSTRAINT `avaliacao_ibfk_1`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `ifood`.`pedido` (`id`),
  CONSTRAINT `avaliacao_ibfk_2`
    FOREIGN KEY (`id_restaurante`)
    REFERENCES `ifood`.`restaurante` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`historico_entrega`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`historico_entrega` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_status_entrega` INT NULL DEFAULT NULL,
  `id_pedido` INT NULL DEFAULT NULL,
  `data` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_status_entrega` (`id_status_entrega` ASC) VISIBLE,
  INDEX `id_pedido` (`id_pedido` ASC) VISIBLE,
  CONSTRAINT `historico_entrega_ibfk_1`
    FOREIGN KEY (`id_status_entrega`)
    REFERENCES `ifood`.`status_entrega` (`id`),
  CONSTRAINT `historico_entrega_ibfk_2`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `ifood`.`pedido` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`historico_pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`historico_pagamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NULL DEFAULT NULL,
  `id_forma_pagamento` INT NULL DEFAULT NULL,
  `valor` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_forma_pagamento` (`id_forma_pagamento` ASC) VISIBLE,
  CONSTRAINT `historico_pagamento_ibfk_1`
    FOREIGN KEY (`id_forma_pagamento`)
    REFERENCES `ifood`.`forma_pagamento` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL DEFAULT NULL,
  `descricao` TEXT NULL DEFAULT NULL,
  `preco` DECIMAL(10,2) NULL DEFAULT NULL,
  `categoria_id` INT NULL DEFAULT NULL,
  `restaurante_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `categoria_id` (`categoria_id` ASC) VISIBLE,
  INDEX `restaurante_id` (`restaurante_id` ASC) VISIBLE,
  CONSTRAINT `produto_ibfk_1`
    FOREIGN KEY (`categoria_id`)
    REFERENCES `ifood`.`categoria` (`id`),
  CONSTRAINT `produto_ibfk_2`
    FOREIGN KEY (`restaurante_id`)
    REFERENCES `ifood`.`restaurante` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`pedido_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`pedido_produto` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_pedido` INT NULL DEFAULT NULL,
  `id_produto` INT NULL DEFAULT NULL,
  `quantidade` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_pedido` (`id_pedido` ASC) VISIBLE,
  INDEX `id_produto` (`id_produto` ASC) VISIBLE,
  CONSTRAINT `pedido_produto_ibfk_1`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `ifood`.`pedido` (`id`),
  CONSTRAINT `pedido_produto_ibfk_2`
    FOREIGN KEY (`id_produto`)
    REFERENCES `ifood`.`produto` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`pedido_produto_acompanhamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`pedido_produto_acompanhamento` (
  `id_pedido_produto` INT NOT NULL,
  `id_acompanhamento` INT NOT NULL,
  PRIMARY KEY (`id_pedido_produto`, `id_acompanhamento`),
  INDEX `id_acompanhamento` (`id_acompanhamento` ASC) VISIBLE,
  CONSTRAINT `pedido_produto_acompanhamento_ibfk_1`
    FOREIGN KEY (`id_pedido_produto`)
    REFERENCES `ifood`.`pedido_produto` (`id`),
  CONSTRAINT `pedido_produto_acompanhamento_ibfk_2`
    FOREIGN KEY (`id_acompanhamento`)
    REFERENCES `ifood`.`acompanhamento` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`produto_acompanhamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`produto_acompanhamento` (
  `id_produto` INT NOT NULL,
  `id_acompanhamento` INT NOT NULL,
  PRIMARY KEY (`id_produto`, `id_acompanhamento`),
  INDEX `id_acompanhamento` (`id_acompanhamento` ASC) VISIBLE,
  CONSTRAINT `produto_acompanhamento_ibfk_1`
    FOREIGN KEY (`id_produto`)
    REFERENCES `ifood`.`produto` (`id`),
  CONSTRAINT `produto_acompanhamento_ibfk_2`
    FOREIGN KEY (`id_acompanhamento`)
    REFERENCES `ifood`.`acompanhamento` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifood`.`restaurante_pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifood`.`restaurante_pagamento` (
  `id_restaurante` INT NOT NULL,
  `id_pagamento` INT NOT NULL,
  PRIMARY KEY (`id_restaurante`, `id_pagamento`),
  INDEX `id_pagamento` (`id_pagamento` ASC) VISIBLE,
  CONSTRAINT `restaurante_pagamento_ibfk_1`
    FOREIGN KEY (`id_restaurante`)
    REFERENCES `ifood`.`restaurante` (`id`),
  CONSTRAINT `restaurante_pagamento_ibfk_2`
    FOREIGN KEY (`id_pagamento`)
    REFERENCES `ifood`.`forma_pagamento` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
