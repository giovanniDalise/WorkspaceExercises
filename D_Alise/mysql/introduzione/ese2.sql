CREATE TABLE corso.autori (
    autoreId int NOT NULL,
    nome varchar(20) NULL,
    primary key (autoreId));

CREATE TABLE corso.editori (
    editoreId int NOT NULL,
    nome varchar(20) NULL,
    primary key (editoreId));

CREATE TABLE corso.libri (
    libroId int NOT NULL,
    titolo varchar(20) NULL,
    autore int NULL,
    editore int NULL,
	foreign key (autore) REFERENCES corso.autori(autoreId),
    foreign key (editore) REFERENCES corso.editori(editoreId),
    primary key (libroId));

INSERT INTO corso.autori 
    (autoreId,nome)
VALUES
    (1,'Melville'),
    (2,'Foscolo'),
    (3,'Calvino'),
    (4,'Petrarca');
    
INSERT INTO corso.editori 
    (editoreId,nome)
VALUES
    (1,'Bonpiani'),
    (2,'Feltrinelli'),
    (3,'Einaudi'), 
    (4,'Giunti');

INSERT INTO corso.libri 
    (libroId,titolo,autore,editore)
VALUES
    (1,'Moby Dick',1,1),
    (2,'Sonetti',2,2),
    (3,'Il Barone Rampante',3,3),
    (4,'Le Citta Invisibili',3,1),
    (5,'Codex Seraphinianus',null,2),
    (6,'Il Mio Libro',null,null);
-- Recupero tutti gli autori con i libri associati    
SELECT corso.libri.titolo, corso.autori.nome
FROM corso.libri
JOIN corso.autori ON corso.libri.autore = corso.autori.autoreId;  
-- Recupero tutti gli editori con i libri associati   
-- esempio INNER JOIN con alias per editori
SELECT l.titolo as LibroTitolo, e.nome as EditoreNome
FROM corso.libri as l
JOIN corso.editori as e ON l.editore = e.editoreId;  

-- Esempio di LEFT JOIN
SELECT a.nome AS nome_autore, l.titolo AS titolo_libro
FROM corso.autori a
LEFT JOIN corso.libri l ON a.autoreId = l.autore;

-- Esempio di RIGHT JOIN
SELECT e.nome AS nome_editore, l.titolo AS titolo_libro
FROM corso.editori e
RIGHT JOIN corso.libri l ON e.editoreId = l.editore;

-- Esempio di OUTER JOIN con UNION per autori
SELECT a.nome AS nome_autore, l.titolo AS titolo_libro
FROM corso.autori a
LEFT JOIN corso.libri l ON a.autoreId = l.autore
UNION
SELECT a.nome AS nome_autore, l.titolo AS titolo_libro
FROM corso.autori a
RIGHT JOIN corso.libri l ON a.autoreId = l.autore;

-- Esempio di OUTER JOIN con UNION per editori 
SELECT e.nome AS nome_editore, l.titolo AS titolo_libro
FROM corso.editori e
LEFT JOIN corso.libri l ON e.editoreId = l.editore
UNION
SELECT e.nome AS nome_editore, l.titolo AS titolo_libro
FROM corso.editori e
RIGHT JOIN corso.libri l ON e.editoreId = l.editore;

-- Recupero tutti i libri con relativo autore ed editore (senza null)
SELECT l.titolo titolo_libro, a.nome nome_autore, e.nome nome_editore
FROM corso.libri l
JOIN corso.autori a ON l.autore = a.autoreId
JOIN corso.editori e ON l.editore = e.editoreId;

-- Recupero tutti i libri con relativo autore ed editore (tutti)
SELECT l.titolo AS titolo_libro, a.nome AS nome_autore, e.nome AS nome_editore
FROM corso.libri l
LEFT JOIN corso.autori a ON l.autore = a.autoreId
LEFT JOIN corso.editori e ON l.editore = e.editoreId;

-- Cancello autore senza libro associato
DELETE 
FROM corso.autori
where autoreId=4;
-- Cancello autore con libro associato, prima in corso.libri e poi in corso.autori dato che non posso cancellare prima
-- l'autore dalla taballa autore visto che la foreign key nella tabella libri fa riferimento alla primary key della tabella autori
DELETE 
FROM corso.libri
where autore=2;
DELETE 
FROM corso.autori
where autoreId=2;
-- Cancello editore senza libro associato
DELETE 
FROM corso.editori
where editoreId=4;
-- Cancello editore con libro associato
DELETE 
FROM corso.libri
where editore=3;
DELETE 
FROM corso.editori
where editoreId=3;

SELECT l.titolo AS titolo_libro, a.nome AS nome_autore, e.nome AS nome_editore
FROM corso.libri l
LEFT JOIN corso.autori a ON l.autore = a.autoreId
LEFT JOIN corso.editori e ON l.editore = e.editoreId;
-- Ho cancellato due libri eliminando l'editore a cui erano entrambi associati ed un autore ne ho eliminato un altro
-- eliminando l'autore a cui era associato 
    
    
    