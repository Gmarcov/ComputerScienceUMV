-- TP 1.1
DROP DATABASE if exists gestionCompagnie;
CREATE DATABASE gestionCompagnie;
USE gestionCompagnie;

CREATE TABLE compagnie (
    comp VARCHAR(5),
    nomcomp VARCHAR(30),
    numRue INT,
    ville VARCHAR(30)
);

CREATE TABLE pilote (
    idPilote INT,
    nom VARCHAR(30),
    nbHVol INT,
    codecomp VARCHAR(5)
);

DESC compagnie ;
DESC pilote ;

-- TP1.2

DROP TABLE compagnie ;
DROP TABLE pilote ;

USE gestionCompagnie;

CREATE TABLE compagnie (
    comp VARCHAR(5) PRIMARY KEY,
    nomcomp VARCHAR(30) NOT NULL,
    numRue INT,
    ville VARCHAR(30) DEFAULT "INCONNU"
) ;

CREATE TABLE pilote (
    idPilote INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(30) NOT NULL,
    nbHVol INT,
    codecomp VARCHAR(5),
    CONSTRAINT fk_comp FOREIGN KEY(codecomp)
    REFERENCES compagnie(comp)
);

DESC compagnie ;
DESC pilote ;

-- TP1.3

CREATE TABLE voyage (
    num INT,
    depart DATE,
    arrivee DATE,
    pilote INT
);

ALTER TABLE voyage
RENAME TO vol;

ALTER TABLE vol
ADD heureDepart TIME;

ALTER TABLE vol
ADD heureArrivee TIME;

ALTER TABLE vol
ADD PRIMARY KEY(num);

ALTER TABLE vol
ADD CONSTRAINT fk_pilote FOREIGN KEY(pilote)
REFERENCES pilote(idpilote);

ALTER TABLE vol
MODIFY depart TIME NOT NULL;

ALTER TABLE vol
CHANGE depart dateDepart DATE NOT NULL;

ALTER TABLE vol
CHANGE arrivee dateArrivee DATE NOT NULL;

CREATE TABLE avion (
Immat VARCHAR(10) PRIMARY KEY,
type VARCHAR(30),
nbHVol INT,
prop VARCHAR(5),
FOREIGN KEY(prop) REFERENCES compagnie(comp)
);

-- TP 2

-- 2.1.1
INSERT INTO compagnie
VALUES  ("RAM", "ROYAL AIR MAROC", 1000, "SALE"),
        ("FE", "FLY EMIRATES", 1000, "DUBAI"),
        ("FR", "FRANCE AIR", 2000, "PARIS");

-- 2.1.2
INSERT INTO pilote (nom, nbHVol, codecomp)
VALUES  ("TARIK", 10, "RAM"),
        ("MARCOS", 99, DEFAULT),
        ("JHON PIERRE DUPONT", NULL, "FR");

-- 2.1.3
INSERT INTO vol (num, dateDepart, dateArrivee)
VALUES  (101, 20211002, 20211003),
        (201, 20211002, NULL),
        (301, 20211002, 20211005);

-- 2.1.4
INSERT INTO avion
VALUES  (100, "MERCDES", 500, "RAM"),
        (200, "REDBULL", 100, "FR"),
        (300, "OMEN", 300, "RAM");

-- 2.1.5
ALTER TABLE vol
ADD (avion VARCHAR(10), 
FOREIGN KEY(avion) REFERENCES avion(Immat));

-- 2.1.6
UPDATE vol
SET avion = 100
WHERE num = 101;

-- 2.1.7
UPDATE vol
SET avion = 200
WHERE avion IS NULL;

-- 2.1.8
DELETE FROM pilote
WHERE idPilote = 2 ;

-- TP3

-- 3.1.1
SELECT * FROM pilote;

-- 3.1.2
SELECT codecomp, nom FROM pilote;

-- 3.1.3
SELECT codecomp Companie, nom Nom FROM pilote;

-- 3.1.4 
SELECT DISTINCT codecomp FROM pilote;

-- 3.1.5
SELECT num FROM vol
ORDER BY dateDepart ASC;

-- 3.1.6
CREATE TABLE newTab
AS SELECT num, pilote FROM vol;

-- 3.1.7
SELECT idPilote, nom FROM pilote
WHERE idPilote < 500;

-- 3.1.7
SELECT nom FROM pilote
WHERE codecomp = "RAM";

-- 3.1.8
UPDATE pilote SET nbHVol = 300 WHERE idPilote = 3;

SELECT nom FROM pilote
WHERE codecomp = "RAM" OR (codecomp = "FR" AND nbHVol < 500);

-- 3.1.9
INSERT INTO avion
VALUES  (400, "Airbus", 500, "RAM"),
        (500, "Airbus", 100, "FR"),
        (600, "Airbus", 300, "RAM");

SELECT * FROM avion
WHERE prop = "RAM" AND type = "Airbus";

-- 3.1.10
SELECT * from compagnie
WHERE nomcomp LIKE "R%" OR nomcomp LIKE "F%";

-- TP 4

-- 4.1.1
SELECT AVG(nbHVol) MoyenHeureVol FROM pilote
WHERE codecomp = "RAM"; -- ou codecomp = "AF"

-- 4.1.2
SELECT COUNT(*) NombreDePilote FROM pilote;

-- 4.1.3
SELECT MAX(nbHVol) MaxHeureVol FROM avion;

-- 4.1.4
SELECT SUM(nbHVol) SommeHeureRAM FROM pilote
WHERE codecomp LIKE "RAM";

-- 4.1.5
SELECT codecomp, AVG(nbHVol) FROM pilote
GROUP BY codecomp;

-- 4.1.6
SELECT codecomp, COUNT(*) NombreDePilote FROM pilote
GROUP BY codecomp;

-- 4.1.7
SELECT codecomp, COUNT(*) FROM pilote
GROUP BY codecomp
HAVING COUNT(*) >= 1;

-- 4.1.8
SELECT prop, AVG(nbHVol) FROM avion
GROUP BY prop
HAVING AVG(nbHVol) = 500;

-- 4.1.9
SELECT idPilote FROM pilote
WHERE codecomp = "RAM" AND nbHVol > 500;

-- TP 5

-- 5.1
SELECT idPilote FROM pilote, compagnie
WHERE codecomp = comp AND nomcomp = "ROYAL AIR MAROC";

-- 5.2
SELECT * FROM compagnie, pilote
WHERE comp = codecomp AND nbHVol > 500;

-- 5.3
SELECT avion.* FROM compagnie, avion
WHERE comp = prop AND type LIKE "A%";

-- 5.4
UPDATE vol SET pilote = 1 WHERE num = 101;
SELECT pilote.nom FROM pilote, vol
WHERE idPilote = pilote AND dateDepart >= '2019-12-01';

-- 5.5
ALTER TABLE pilote
ADD chefPilote INT;

ALTER TABLE pilote
ADD CONSTRAINT fk_chefPilote FOREIGN KEY(chefPilote)
REFERENCES pilote(idPilote);

-- 5.6
UPDATE pilote SET chefPilote = 1;
SELECT * FROM pilote
WHERE chefPilote = 1 AND idPilote != 1;

-- 5.7
INSERT INTO pilote (nom, nbHVol, codecomp)
VALUES  ("Karim", 10, "RAM"),
        ("MARCOS", 99, "RAM"),
        ("JHON PIERRE BANANE", NULL, "FR");
UPDATE pilote SET chefPilote = 4;

SELECT * FROM pilote P, pilote CP
WHERE P.chefPilote = CP.idPilote AND CP.nom = "Karim";

-- 5.8
SELECT P.* FROM pilote P, pilote MARCOS
WHERE MARCOS.nom = "MARCOS" AND P.nbHVol > MARCOS.nbHVol; 

-- 5.9
SELECT SUM(P.nbHVol) FROM pilote P, pilote CP
WHERE CP.nbHVol > 9 AND P.chefPilote = CP.idPilote;

-- 5.10
CREATE TABLE Grade(
    niveau VARCHAR(30),
    minHVol INT,
    maxHVOL INT
);

INSERT INTO grade
VALUES  ("Debutant", 0, 500),
        ("Initie", 501, 1000),
        ("Expert", 1001, 3000);

-- 5.11
UPDATE pilote SET nbHVol = 700 WHERE nom = "Karim";

SELECT * FROM pilote, grade
WHERE pilote.nbHVol > grade.minHVol AND pilote.nbHVol < grade.maxHVOL;

-- 5.12
-- SELECT * FROM pilote LEFT JOIN vol
-- WHERE pilote.idPilote = vol.pilote;

-- 5.13
-- Les vols realisés par les pilotes de la "ROYAL AIR MARCO" en uti. AIR BUS
UPDATE vol SET pilote = 4;
UPDATE vol SET avion = 400;

SELECT vol.*
FROM vol, compagnie, avion, pilote
WHERE idPilote = vol.pilote
    AND comp = codecomp
    AND 
