-- criação do usuário do banco
create user salescar@'%' identified by 'salescar’;

-- Dando privilégios
grant all privileges on *.* to salescar@'%' with grant option;

-- Criação do banco de dados
create database salescar;

-- Apagando a tabela de fabricante
drop table fabricante;

-- Criando tabela de fabricante.
CREATE TABLE fabricante (
	id INT(10) NOT NULL AUTO_INCREMENT,
	nome VARCHAR(20) NOT NULL,
	PRIMARY KEY (id),
	UNIQUE INDEX Nome (nome)
);

-- Apagando a tabela de modelo
drop table modelo;

-- Criando tabela de modelo.
create table modelo(
	id int not null auto_increment,
	nome varchar(20),
	idfabricante int not null,
	CONSTRAINT FK_fabricante FOREIGN KEY (idfabricante) REFERENCES fabricante (id),
	UNIQUE INDEX Nome (nome),
	primary key (id)
);

-- Apagando a tabela de opcional
drop table opcional;

-- Criando tabela de opcional.
create table opcional(
	id int not null auto_increment,
	nome varchar(30),
	primary key (id),
	UNIQUE INDEX Nome (nome)
);

-- Apagando a tabela de carro
drop table carro;

-- Criando tabela de carro.
create table carro(
	id int not null auto_increment,
	placa varchar(7) not null,
	renavam varchar(9) not null,
	valorvenda DOUBLE,
	cadastro date,
	idmodelo int not null,
	CONSTRAINT FK_modelo FOREIGN KEY (idmodelo) REFERENCES modelo (id),
	UNIQUE INDEX Placa (placa),
	UNIQUE INDEX Renavam (renavam),
	primary key (id)
);

-- Apagando a tabela de carro
drop table carro_opcional;

-- Criando carro_opcional.
create table carro_opcional(
	idcarro int not null,
	idopcional int not null,
	CONSTRAINT FK_carro FOREIGN KEY (idcarro) REFERENCES carro (id),
	CONSTRAINT FK_idopcional FOREIGN KEY (idopcional) REFERENCES opcional (id)
);