-- CREATE DATABASE magazzino;
CREATE TABLE magazzino.tipi (
    tipoId int NOT NULL,
    nome varchar(20) NULL,
    primary key (tipoId));
    
CREATE TABLE magazzino.marche (
    marcaId int NOT NULL,
    nome varchar(20)NULL,
    primary key (marcaId));
    
CREATE TABLE magazzino.eventi (
    eventoId int NOT NULL,
    tipo varchar(20) NULL,
    primary key (eventoId));
    
CREATE TABLE magazzino.prodotti (
    prodottoId int NOT NULL,
    nome varchar(20) NULL,
    marca int NULL,
    tipo int NULL,
    evento int NULL,
    foreign key (marca) REFERENCES magazzino.marche(marcaId),
    foreign key (tipo) REFERENCES magazzino.tipi(tipoId),
    foreign key (evento) REFERENCES magazzino.eventi(eventoId),
    primary key (prodottoId));

INSERT INTO magazzino.tipi
    (tipoId,nome)
VALUES
    (1,'ChitarraAcustica'),
    (2,'ChitarraClassica'),
    (3,'ChitarraElettrica'),
    (4,'CordeAcustica'),
    (5,'CordeElettrica'),
    (6,'CordeClassica'),
    (7,'Plettro');
    
INSERT INTO magazzino.marche
    (marcaId,nome)
VALUES    
    (1,'Fender'),
    (2,'Ibanez'),
    (3,'Gibson'),
    (4,'Yamaha'),
    (5,'Martin'),
    (6,'D\'Addario'),
    (7,'Ernie Ball'),
    (8,'Alhambra');
    
INSERT INTO magazzino.eventi
    (eventoId,tipo)
VALUES    
    (1,'Imballaggio'),
    (2,'Spedizione'),
    (3,'Riparazione'),
    (4,'In arrivo');

INSERT INTO magazzino.prodotti
    (prodottoId,nome,marca,tipo,evento)
VALUES 
    (1,'Stratocaster',1,3,2),
	(2,'Telecaster',1,3,null),
    (3,'D-28',5,1,2),
    (4,'F-180',4,1,3),
    (5,'5p',8,2,4),
    (6,'Heavy',1,7,4),
    (7,'EJ27N',6,6,2),
    (8,'EZ910',6,4,1),
    (9,'Regular Slinky',7,5,2),
    (10,'Nuove corde', null,null,4),
    (11,'Nuova chitarra',null,3,4);
    
UPDATE magazzino.prodotti
SET nome = 'nuovaTaylor'
    where prodottoId=11;
    
SELECT p.nome, t.nome
FROM magazzino.prodotti p
JOIN magazzino.tipi t ON p.tipo = t.tipoId;  

SELECT p.nome AS nome, t.nome AS tipo, m.nome AS marca, e.tipo AS evento
FROM magazzino.prodotti p
LEFT JOIN magazzino.tipi t ON p.tipo = t.tipoId
LEFT JOIN magazzino.marche m ON p.marca = m.marcaId
LEFT JOIN magazzino.eventi e ON p.tipo = e.eventoId
    
    
    
    
    
    
    