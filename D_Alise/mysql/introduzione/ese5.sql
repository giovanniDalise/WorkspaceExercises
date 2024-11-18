-- CREATE DATABASE scuola;
-- Tabella "classi"
CREATE TABLE scuola.classi (
    classeId int NOT NULL,
    nome varchar(20) NULL,
    primary key (classeId)
);

-- Tabella "sezioni"
CREATE TABLE scuola.sezioni (
    sezioneId int NOT NULL,
    nome varchar(20) NULL,
    primary key (sezioneId)
);

-- Tabella "voti"
CREATE TABLE scuola.voti (
    votoId int NOT NULL,
    valore int NULL,
    primary key (votoId)
);

-- Tabella "studenti"
CREATE TABLE scuola.studenti (
    studenteId int NOT NULL,
    nome varchar(50) NULL,
    classeId int NULL,
    sezioneId int NULL,
    foreign key (classeId) REFERENCES scuola.classi(classeId),
    foreign key (sezioneId) REFERENCES scuola.sezioni(sezioneId),
    primary key (studenteId)
);

CREATE TABLE scuola.classi_sezioni (
    classeId int NOT NULL,
    sezioneId int NOT NULL,
	foreign key (classeId) REFERENCES scuola.classi(classeId),
	foreign key (sezioneId) REFERENCES scuola.sezioni(sezioneId),
    primary key (classeId, sezioneId)
);

CREATE TABLE scuola.voti_studenti (
    votoId int NOT NULL,
    studenteId int NOT NULL,
    foreign key (studenteId) REFERENCES scuola.studenti(studenteId),
	foreign key (votoId) REFERENCES scuola.voti(votoId),
    primary key (votoId, studenteId)
);

INSERT INTO scuola.classi (classeId, nome)
VALUES
    (1, 'Classe A'),
    (2, 'Classe B'),
    (3, 'Classe C');
    
INSERT INTO scuola.sezioni (sezioneId, nome)
VALUES
    (1, 'Sezione 1'),
    (2, 'Sezione 2'),
    (3, 'Sezione 3');
    
INSERT INTO scuola.voti (votoId, valore)
VALUES
    (1, 3),
    (2, 4),
    (3, 5),
    (4, 6),
    (5, 7),
    (6, 8),
    (7, 9),
    (8, 10);
    
INSERT INTO scuola.studenti (studenteId, nome, classeId, sezioneId)
VALUES
    (1, 'Mario Rossi',1,1),
    (2, 'Anna Verdi',1,3),
    (3, 'Luca Bianchi',1,2),
    (4, 'Marco Neri',2,2),
    (5, 'Irene Santi',2,1),
    (6, 'Giuseppe Russo',2,3),
    (7, 'Alfonso Spada',3,1),
    (8, 'Germana Selzi',3,3),
    (9, 'Michela Giunti',3,2),
    (10, 'Gianfranco Esposito',1,2),
    (11, 'Ciro Festa',2,2),
    (12, 'Irene Grandi',3,2);
  
INSERT INTO scuola.classi_sezioni (classeId, sezioneId)
VALUES
    (1, 1), -- Classe A - Sezione 1
    (1, 2), -- Classe A - Sezione 2
    (1, 3), -- Classe A - Sezione 3
    (2, 1), -- Classe B - Sezione 1
    (2, 2), -- Classe B - Sezione 2 
    (2, 3), -- Classe B - Sezione 3
    (3, 1), -- Classe C - Sezione 1
    (3, 2), -- Classe C - Sezione 2
    (3, 3); -- Classe C - Sezione 3
    
SELECT classeId, sezioneId
FROM scuola.classi_sezioni
ORDER BY classeId, sezioneId;
  
INSERT INTO scuola.voti_studenti (votoId, studenteId)
VALUES
    (6, 1), -- Voto 8 - Mario Rossi
    (6, 2), -- Voto 8 - Anna Verdi
    (5, 1), -- Voto 7 - Mario Rossi
    (7, 3), -- Voto 9 - Luca Bianchi
    (8, 2),
    (5, 3),
    (1, 11),
    (2, 10),
    (3, 9),
    (4, 8),
    (5, 7),
    (2, 6),
    (3, 8),
    (5, 12),
    (2, 11);
    
    
SELECT votoId, studenteId
FROM scuola.voti_studenti
ORDER BY votoId, studenteId;
    
-- ogni JOIN confronta la tabella che sta richiamando con quella prensente sulla riga di sopra ovviamente nel primo caso al posto del JOIN avremo il FROM
SELECT st.studenteId, st.nome AS studente, c.nome AS classe, s.nome AS sezione, v.valore AS voto
FROM scuola.studenti st
JOIN scuola.classi c ON st.classeId = c.classeId
JOIN scuola.sezioni s ON st.sezioneId = s.sezioneId
JOIN scuola.voti_studenti vs ON st.studenteId = vs.studenteId
JOIN scuola.voti v ON vs.votoId = v.votoId;







    


    


