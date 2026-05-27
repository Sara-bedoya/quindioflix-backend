/*
PROYECTO: QUINDIOFLIX
SECCION : DATA 04
ARCHIVO : 04_seed_generos.sql
OBJETIVO: Datos semilla de generos
ORIGEN  : dml\01_seed_data.sql, dml\03_seed_generos.sql
*/
-- GENEROS
-- =========================================================

INSERT INTO GENEROS (nombre_genero)
VALUES ('Acción');

INSERT INTO GENEROS (nombre_genero)
VALUES ('Drama');

INSERT INTO GENEROS (nombre_genero)
VALUES ('Comedia');

INSERT INTO GENEROS (nombre_genero)
VALUES ('Ciencia Ficción');

INSERT INTO GENEROS (nombre_genero)
VALUES ('Terror');

-- =========================================================
-- GENEROS FALTANTES
-- =========================================================

INSERT INTO GENEROS (nombre_genero)
VALUES ('Suspenso');

INSERT INTO GENEROS (nombre_genero)
VALUES ('Romance');

INSERT INTO GENEROS (nombre_genero)
VALUES ('Ciencia Ficcion');

INSERT INTO GENEROS (nombre_genero)
VALUES ('Infantil');

INSERT INTO GENEROS (nombre_genero)
VALUES ('Musical');

COMMIT;
