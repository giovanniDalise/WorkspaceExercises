-- CREATE DATABASE ristorante;

CREATE TABLE ristorante.ingredienti (
    ingredienteId int NOT NULL,
    nome varchar (50) NULL,
    primary key (ingredienteId)
);

CREATE TABLE ristorante.piatti (
    piattoId int NOT NULL,
    nome varchar (50) NULL,
    ingredienteId int NULL,
    foreign key (ingredienteId) REFERENCES ristorante.ingredienti(ingredienteId),
    primary key (piattoId)
);

CREATE TABLE ristorante.menues (
    menuId int NOT NULL,
    nome varchar (50) NULL,
    primary key (menuId)
);

CREATE TABLE ristorante.ordini (
    ordineId int NOT NULL,
    nome varchar (50) NULL,    
    primary key (ordineId)
);

CREATE TABLE ristorante.piatto_ingrediente (
    piattoId int NOT NULL,
    ingredienteId int NOT NULL,
	foreign key (piattoId) REFERENCES ristorante.piatti(piattoId),
	foreign key (ingredienteId) REFERENCES ristorante.ingredienti(ingredienteId),
    primary key (piattoId, ingredienteId)
);

CREATE TABLE ristorante.menu_piatto (
    menuId int NOT NULL,
    piattoId int NOT NULL,
	foreign key (menuId) REFERENCES ristorante.menues(menuId),
	foreign key (piattoId) REFERENCES ristorante.piatti(piattoId),
    primary key (menuId, piattoId)
);

CREATE TABLE ristorante.ordine_piatto (
    ordineId int NOT NULL,
    piattoId int NOT NULL,
	foreign key (ordineId) REFERENCES ristorante.ordini(ordineId),
	foreign key (piattoId) REFERENCES ristorante.piatti(piattoId),
    primary key (ordineId, piattoId)
);

INSERT INTO ristorante.ingredienti (ingredienteId, nome)
VALUES
    (1, 'Rigatoni'),
    (2, 'Spaghetti '),
    (3, 'Olio EVO'),
    (4, 'Aglio'),
    (5, 'Sale'),
    (6, 'Uova'),
    (7, 'Guanciale'),
    (8, 'Pecorino'),
    (9, 'Pomodorini'),
    (10, 'Basilico'),
    (11, 'Salvia'),
    (12, 'Origano'),
	(13, 'Petto di pollo'),
    (14, 'Iceberg'),
    (15, 'Fagioli cannellini'),
    (16, 'Farina di Ceci'),
    (17, 'Mozzarella di Bufala'),
    (18, 'Pepe'),
    (19, 'Gnocchetti Sardi'),
    (20, 'Peperoncino');
    
INSERT INTO ristorante.piatti (piattoId, nome)
VALUES
    (1, 'Carbonara'),
    (2, 'Spaghetti al pomodorino fresco'),
    (3, 'Insalatona con pollo'),
	(4, 'Insalatona con mozzarella'),
    (5, 'Caprese'),
    (6, 'Petto di pollo in padella'),
    (7, 'Pomodorini all\'insalata'),
	(8, 'Fagioli all\'insalata'),
	(9, 'Uovo all\'occhio di bue'),
	(10, 'Farinata'),
    (11, 'Pasta e fagioli'),
    (12, 'Spaghetti aglio olio e peperoncino');
    
INSERT INTO ristorante.menues (menuId,nome)
VALUES
    (1, 'Menu Pranzo'),
    (2, 'Menu Cena'),
    (3, 'Menu Vegano'),
    (4, 'Menu Vegetariano'),
    (5, 'Menu Celiaco');
    
INSERT INTO ristorante.ordini (ordineId,nome)
VALUES
    (1, 'Prima Comanda'),
    (2, 'Seconda Comanda'),
    (3, 'Terza Comanda'),
    (4, 'Quarta Comanda'),
    (5, 'Quinta Comanda');
    
INSERT INTO ristorante.piatto_ingrediente (piattoId,ingredienteId)
VALUES
    (1, 1), -- Carbonara
    (1, 3),
    (1, 5),
    (1, 6),
    (1, 8),
    (2, 2), -- Spaghetti al pomodorino
    (2, 4),
    (2, 9),
    (2, 5),
    (2, 10),
    (3, 14), -- Insalatona con pollo
    (3, 5),
    (3, 3),
    (3, 9),
    (3, 15),
    (3, 13), 
    (4, 14), -- Insalatona con mozzarella
    (4, 5),
    (4, 3),
    (4, 9),
    (4, 15), 
    (4, 17),
    (5, 17), -- Caprese
    (5, 9),
    (5, 10),
    (5, 12),
    (5, 5),
    (5, 3), 
    (6, 3), -- Petto di pollo in padella
    (6, 4),
	(6, 5),
    (6, 11),
    (6, 13),
    (7, 3), -- Pomodorini all\'insalata
    (7, 4),
    (7, 5),
	(7, 9),
    (7, 10),
    (7, 12),
    (8, 3), -- Fagioli all\'insalata
    (8, 4), 
	(8, 5),
    (8, 12),
	(8, 15),
    (9, 3), -- Uovo all\'occhio di bue
    (9, 5),
    (9, 6),
    (10, 3), -- Farinata
	(10, 5),
    (10, 16),
	(10, 18),
    (11, 19), -- Pasta e fagioli
    (11, 3),
    (11, 4),
    (11, 5),
    (11, 18),
	(11, 9),
	(11, 11),
    (12, 2), -- Spaghetti aglio olio e peperoncino
    (12, 3),
    (12, 4),
    (12, 5),
    (12, 20);
  
INSERT INTO ristorante.menu_piatto (menuId,piattoId)
VALUES
    (1, 11), -- Menu Pranzo
    (1, 12),
    (1, 4),
    (1, 9),
    (1, 5),
    (1, 7),
	(2, 1), -- Menu Cena
    (2, 2),
    (2, 3),
    (2, 6),
    (2, 10),
    (2, 7),
    (2, 8),
    (3, 2), -- Menu Vegetariano
    (3, 11),
    (3, 12),
	(3, 9),
    (3, 5),
    (3, 10),
    (3, 4),
    (3, 8),
    (3, 7),
    (4, 2), -- Menu Vegano
    (4, 11),
	(4, 12),
    (4, 10),
	(4, 7),
    (4, 8),
    (5, 3), -- Menu Celiaco
    (5, 4),
    (5, 9),
    (5, 10),
    (5, 6),
	(5, 7),
    (5, 8);
    
INSERT INTO ristorante.ordine_piatto (ordineId,piattoId)
VALUES
    (1, 1), -- Prima Comanda
    (1, 2),
    (1, 3),
    (1, 7),
    (1, 8),
    (2, 11), -- Seconda Comanda   
	(2, 12), 
    (3, 11), -- Terza Comanda
    (3, 5),
    (3, 8),
    (4, 10), -- Quarta Comanda
    (4, 7), 
    (5, 1), -- Quinta Comanda
    (5, 2),
    (5, 4),
    (5, 5),
    (5, 8);
    
SELECT m.nome AS menu, p.nome AS nome
FROM ristorante.piatti p
JOIN ristorante.menues m ON p.piattoId = m.piattoId
;

use ristorante;
select menues.nome, piatti.nome
from menues
inner join menu_piatto on menues.menuId = menu_piatto.menuId
inner join piatti on menu_piatto.piattoId = piatti.piattoId
where menues.nome = 'Menu Vegano';

select menues.nome, piatti.nome
from menues
inner join menu_piatto on menues.menuId = menu_piatto.menuId
inner join piatti on menu_piatto.piattoId = piatti.piattoId
where menues.nome = 'Menu Vegetariano';

select menues.nome, piatti.nome
from menues
inner join menu_piatto on menues.menuId = menu_piatto.menuId
inner join piatti on menu_piatto.piattoId = piatti.piattoId
where menues.nome = 'Menu Celiaco';

select menues.nome, piatti.nome
from menues
inner join menu_piatto on menues.menuId = menu_piatto.menuId
inner join piatti on menu_piatto.piattoId = piatti.piattoId
where menues.nome = 'Menu Pranzo';

select menues.nome, piatti.nome
from menues
inner join menu_piatto on menues.menuId = menu_piatto.menuId
inner join piatti on menu_piatto.piattoId = piatti.piattoId
where menues.nome = 'Menu Cena';

select ordini.nome, piatti.nome
from ordini
inner join ordine_piatto on ordini.ordineId = ordine_piatto.ordineId
inner join piatti on ordine_piatto.piattoId = piatti.piattoId
where ordini.nome = 'Prima Comanda';

select ordini.nome, piatti.nome
from ordini
inner join ordine_piatto on ordini.ordineId = ordine_piatto.ordineId
inner join piatti on ordine_piatto.piattoId = piatti.piattoId
where ordini.nome = 'Seconda Comanda';

select ordini.nome, piatti.nome
from ordini
inner join ordine_piatto on ordini.ordineId = ordine_piatto.ordineId
inner join piatti on ordine_piatto.piattoId = piatti.piattoId
where ordini.nome = 'Terza Comanda';

select ordini.nome, piatti.nome
from ordini
inner join ordine_piatto on ordini.ordineId = ordine_piatto.ordineId
inner join piatti on ordine_piatto.piattoId = piatti.piattoId
where ordini.nome = 'Quarta Comanda';

select ordini.nome, piatti.nome
from ordini
inner join ordine_piatto on ordini.ordineId = ordine_piatto.ordineId
inner join piatti on ordine_piatto.piattoId = piatti.piattoId
where ordini.nome = 'Quinta Comanda';

SELECT ordini.nome, piatti.nome, ingredienti.nome
from ordini
inner join ordine_piatto on ordini.ordineId = ordine_piatto.ordineId
inner join piatti on ordine_piatto.piattoId = piatti.piattoId
inner join piatto_ingrediente on piatti.piattoId = piatto_ingrediente.piattoId
inner join ingredienti on piatto_ingrediente.ingredienteId = ingredienti.ingredienteId
where ordini.nome = 'Quinta Comanda';