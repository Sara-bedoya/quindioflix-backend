/*
PROYECTO: QUINDIOFLIX
SECCION : DATA 01
ARCHIVO : 01_seed_planes.sql
OBJETIVO: Datos semilla de planes
ORIGEN  : dml\01_seed_data.sql
*/
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

COMMIT;
