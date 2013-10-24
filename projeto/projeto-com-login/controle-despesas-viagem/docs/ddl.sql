CREATE  TABLE relatorio_despesa (
	codigo INT NOT NULL AUTO_INCREMENT,
  	PRIMARY KEY (codigo) )
ENGINE = InnoDB;

CREATE  TABLE despesa (
  codigo INT NOT NULL AUTO_INCREMENT ,
  descricao VARCHAR(45) NOT NULL ,
  valor VARCHAR(45) NOT NULL ,
  codigo_relatorio_despesa INT NOT NULL ,
  
  PRIMARY KEY (codigo) ,
  
  INDEX fk_relatorio_despesa (codigo_relatorio_despesa ASC) ,
  CONSTRAINT fk_relatorio_despesa
    FOREIGN KEY (codigo_relatorio_despesa )
    REFERENCES controle_despesas.relatorio_despesa (codigo ) )
ENGINE = InnoDB;

