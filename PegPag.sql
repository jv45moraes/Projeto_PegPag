

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


CREATE SCHEMA IF NOT EXISTS pegpag DEFAULT CHARACTER SET utf8 ;
USE pegpag ;

-- -----------------------------------------------------
-- Table pegpag.cliente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS cliente (
  idcliente INT NOT NULL AUTO_INCREMENT,
  nomeCliente VARCHAR(150) NOT NULL,
  rg VARCHAR(45) NOT NULL,
  cpf VARCHAR(45) NOT NULL unique,
  sexo VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (idcliente)
 )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table pegpag.vendedor
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS vendedor (
  idvendedor INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NOT NULL,
  rg VARCHAR(45) NOT NULL,
  cpf VARCHAR(45) NOT NULL UNIQUE,
  sexo VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  PRIMARY KEY (idvendedor)
 )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table pegpag.endereco
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS endereco (
  idendereco INT NOT NULL AUTO_INCREMENT,
  rua VARCHAR(45) NOT NULL,
  bairro VARCHAR(45) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  numero INT NOT NULL,
  cep VARCHAR(45) NOT NULL,
  complemento VARCHAR(45) NOT NULL,
  referencia VARCHAR(45) NULL,
  vendedor_idvendedor INT NULL,
  cliente_idcliente INT NULL,
  PRIMARY KEY (idendereco, vendedor_idvendedor, cliente_idcliente),
    FOREIGN KEY (vendedor_idvendedor)
    REFERENCES vendedor (idvendedor),

    FOREIGN KEY (cliente_idcliente)
    REFERENCES cliente (idcliente)
    )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table pegpag.telefone
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pegpag.telefone (
  idtelefone INT NOT NULL AUTO_INCREMENT,
  ddd INT NOT NULL,
  numero VARCHAR(45) NOT NULL,
  vendedor_idvendedor INT NULL,
  cliente_idcliente INT NULL,
  PRIMARY KEY (idtelefone),
    FOREIGN KEY (vendedor_idvendedor)
    REFERENCES vendedor (idvendedor),
    
    FOREIGN KEY (cliente_idcliente)
    REFERENCES cliente (idcliente)
    )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table pegpag.comercio
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS comercio (
  idcomercio INT NOT NULL AUTO_INCREMENT,
  nomeEmpresa VARCHAR(45) NOT NULL,
  tipoProdutos VARCHAR(45) NOT NULL,
  endereco VARCHAR(200) NOT NULL,
  avaliacao VARCHAR(45) NULL,
  vendedor_idvendedor INT NOT NULL,
  PRIMARY KEY (idcomercio),
 
    FOREIGN KEY (vendedor_idvendedor)
    REFERENCES pegpag.vendedor (idvendedor)
   )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table pegpag.produtos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS produtos (
  idprodutos INT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(45) NOT NULL,
  descricao VARCHAR(400) NOT NULL,
  tamanho VARCHAR(45) NULL,
  cor VARCHAR(45) NULL,
  sabor VARCHAR(45) NULL,
  estoque INT NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  preco DOUBLE NOT NULL,
  comercio_idcomercio INT NOT NULL,
  PRIMARY KEY (idprodutos),
 
    FOREIGN KEY (comercio_idcomercio)
    REFERENCES comercio (idcomercio)
    )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table pegpag.chat
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS chat (
  idchat INT NOT NULL AUTO_INCREMENT,
  mensagem TEXT(500) NOT NULL,
  cliente_idcliente INT NOT NULL,
  vendedor_idvendedor INT NOT NULL,
  PRIMARY KEY (idchat),
    FOREIGN KEY (cliente_idcliente)
    REFERENCES cliente (idcliente),
  
    FOREIGN KEY (vendedor_idvendedor)
    REFERENCES vendedor (idvendedor)
    )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table pegpag.pedidos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pedidos (
  idpedidos INT NOT NULL AUTO_INCREMENT,
  valor DOUBLE NOT NULL,
  dataRecebido DATE NULL,
  estado VARCHAR(45) NOT NULL,
  avalicao VARCHAR(45) NULL,
  tipopagamento VARCHAR(45) NOT NULL,
  cliente_idcliente INT NOT NULL,
  quantidadeProdutos int not null,
  produtos_idprodutos INT NOT NULL,
  produtos_comercio_idcomercio INT NOT NULL,
  PRIMARY KEY (idpedidos),
 
    FOREIGN KEY (cliente_idcliente)
    REFERENCES cliente (idcliente),
  
    FOREIGN KEY (produtos_idprodutos , produtos_comercio_idcomercio)
    REFERENCES .produtos (idprodutos , comercio_idcomercio)
    )
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
