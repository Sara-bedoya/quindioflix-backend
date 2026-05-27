/*
PROYECTO: QUINDIOFLIX
SECCION : DATA 00
ARCHIVO : 00_seed_catalogos_base.sql
OBJETIVO: Datos semilla de ciudades, estados y categorias
ORIGEN  : dml\01_seed_data.sql
*/
-- CIUDADES
-- =========================================================

INSERT INTO CIUDADES (nombre_ciudad)
VALUES ('Armenia');

INSERT INTO CIUDADES (nombre_ciudad)
VALUES ('Pereira');

INSERT INTO CIUDADES (nombre_ciudad)
VALUES ('Manizales');


-- =========================================================
-- ESTADOS_CUENTA
-- =========================================================

INSERT INTO ESTADOS_CUENTA (descripcion)
VALUES ('ACTIVO');

INSERT INTO ESTADOS_CUENTA (descripcion)
VALUES ('SUSPENDIDO');

INSERT INTO ESTADOS_CUENTA (descripcion)
VALUES ('CANCELADO');


-- =========================================================
-- CATEGORIAS
-- =========================================================

INSERT INTO CATEGORIAS (nombre_categoria)
VALUES ('Películas');

INSERT INTO CATEGORIAS (nombre_categoria)
VALUES ('Series');

INSERT INTO CATEGORIAS (nombre_categoria)
VALUES ('Documentales');

INSERT INTO CATEGORIAS (nombre_categoria)
VALUES ('Música');

INSERT INTO CATEGORIAS (nombre_categoria)
VALUES ('Podcasts');


-- =========================================================

COMMIT;
