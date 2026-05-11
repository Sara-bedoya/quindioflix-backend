-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 01_seed_data.sql
-- OBJETIVO:
--     Insertar datos semilla necesarios para:
--         - pruebas
--         - desarrollo
--         - backend
--         - frontend
-- =========================================================


-- =========================================================
-- PLANES
-- =========================================================

INSERT INTO PLANES (
    nombre,
    max_pantallas,
    calidad_video,
    precio_mensual,
    max_perfiles
)
VALUES (
           'Básico',
           1,
           'HD',
           15000,
           1
       );

INSERT INTO PLANES (
    nombre,
    max_pantallas,
    calidad_video,
    precio_mensual,
    max_perfiles
)
VALUES (
           'Estándar',
           2,
           'FULL HD',
           25000,
           2
       );

INSERT INTO PLANES (
    nombre,
    max_pantallas,
    calidad_video,
    precio_mensual,
    max_perfiles
)
VALUES (
           'Premium',
           4,
           '4K',
           35000,
           4
       );


-- =========================================================
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


COMMIT;