-- CREATE DATABASE bb;
CREATE TABLE bb.registi(
    registaId int NOT NULL,
    nome varchar(20) NULL,
    primary key (registaId));

CREATE TABLE bb.caseProduzione(
    casaProduzioneId int NOT NULL,
    nome varchar(30) NULL,
    primary key (casaProduzioneId));
    
CREATE TABLE bb.generi(
    genereId int NOT NULL,
    nome varchar(20) NULL,
    primary key (genereId));
    
CREATE TABLE bb.films(
    filmId int NOT NULL,
    nome varchar(30) NULL,
    regista int NULL,
    casaProduzione int NULL,
    genere int NULL,
    foreign key (regista) REFERENCES bb.registi(registaId),
	foreign key (casaProduzione) REFERENCES bb.caseProduzione(casaProduzioneId),   
	foreign key (genere) REFERENCES bb.generi(genereId),  
    primary key (filmId));
    
INSERT INTO bb.registi
    (registaId,nome)
VALUES
    (1,'David Lynch'),
    (2,'Michael Haneke'),
    (3,'Mario Bava'),
    (4,'Regista Sconosciuto'),
    (5,'Roman Polanski'),
    (6,'Lars Von Trier');
    
INSERT INTO bb.caseproduzione
    (casaProduzioneId,nome)
VALUES
    (1,'Asymmetrical Productions'),
    (2,'Halcyon Pictures'),
    (3,'Emmepi Cinematografica'),
    (4,'Paramount'),
    (5,'William Castle Productions'),
    (6,'Zentropa');
    
INSERT INTO bb.generi
    (genereId,nome)
VALUES
    (1,'Horror'),
    (2,'Mistero'),
    (3,'Drammatico'),
    (4,'Thriller'),
    (5,'Commedia'),
    (6,'Fantasy'),
    (7,'Fantascienza'),
    (8,'Noir'),
    (9,'Grottesco');
    
INSERT INTO bb.films
    (filmId,nome,regista,casaProduzione,genere)
VALUES
    (1,'Funny Games',2,2,9),
    (2,'Mulholland Drive',1,1,2),
    (3,'Strade Perdute',1,1,2),
    (4,'I Tre Volti della Paura',3,3,1),
    (5,'L\'inquilino del terzo piano ',5,5,3),
    (6,'Rosemary\s Baby',5,5,2),
    (7,'Dogville',6,6,3),
    (8,'Antichrist',6,6,3),
    (9,'Film sconosciuto',null,4,null);
    
UPDATE bb.registi
SET nome = 'Martin Scorsese'
    where registaId=4;

UPDATE bb.films
SET nome = 'Jurassik Park'
    where filmId=9;

SELECT f.nome AS NomeFilm, r.nome AS NomeRegista
FROM bb.films f
JOIN bb.registi r ON f.regista = r.registaId;  

SELECT f.nome AS Nome, r.nome AS Autore, c.nome AS CasaProduzione, g.nome AS Genere
FROM bb.films f
LEFT JOIN bb.registi r ON f.regista = r.registaId
LEFT JOIN bb.caseProduzione c ON f.casaProduzione = c.casaProduzioneId
LEFT JOIN bb.generi g ON f.genere = g.genereId
    
    
    
    
    
    
    
    