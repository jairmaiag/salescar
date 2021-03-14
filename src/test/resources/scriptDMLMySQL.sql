-- dados de fabricantes
insert into fabricante(nome) values ('Volkswagen');
insert into fabricante(nome) values ('Fiat');
insert into fabricante(nome) values ('Ford');
insert into fabricante(nome) values ('General Motors');
insert into fabricante(nome) values ('Hyundai');
insert into fabricante(nome) values ('Renault');
insert into fabricante(nome) values ('Toyota');
insert into fabricante(nome) values ('Honda');
insert into fabricante(nome) values ('Nissan');

-- dados de modelo
insert into modelo(nome,idfabricante) values ('Gol',1);
insert into modelo(nome,idfabricante) values ('CrossFox',1);
insert into modelo(nome,idfabricante) values ('Voyage',1);
insert into modelo(nome,idfabricante) values ('Uno',2);
insert into modelo(nome,idfabricante) values ('Palio',2);
insert into modelo(nome,idfabricante) values ('Siena',2);
insert into modelo(nome,idfabricante) values ('Celta',4);
insert into modelo(nome,idfabricante) values ('Corsa Sedan',4);
insert into modelo(nome,idfabricante) values ('Onix',4);
insert into modelo(nome,idfabricante) values ('HB20',5);
insert into modelo(nome,idfabricante) values ('Sandero',6);

insert into opcional(nome) values ('Trava elétrica');
insert into opcional(nome) values ('Vidro elétrica');
insert into opcional(nome) values ('Ar condicionado');
insert into opcional(nome) values ('Direção hidraulica');
insert into opcional(nome) values ('Direção elétrica');
insert into opcional(nome) values ('Alarme');
insert into opcional(nome) values ('Air Bag');
insert into opcional(nome) values ('Bancos de couro');
insert into opcional(nome) values ('Central multimídia');
insert into opcional(nome) values ('Rodas de liga leve');

-- listagem de modelo com fabricantes
SELECT m.*,f.nome FRoM modelo m INNER JOIN fabricante f ON m.idfabricante =  f.id;

