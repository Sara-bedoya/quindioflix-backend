/*
PROYECTO: QUINDIOFLIX
SECCION : DDL
ARCHIVO : 08_planes_update.sql
OBJETIVO: Actualizaciones estructurales de planes
ORIGEN  : ddl\08_planes_update.sql
*/
-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 08_planes_update.sql
-- OBJETIVO:
--     Agregar soporte de cantidad máxima
--     de perfiles por plan.
-- =========================================================


-- =========================================================
-- ALTER TABLE: PLANES
-- =========================================================

ALTER TABLE PLANES ADD (

    max_perfiles NUMBER DEFAULT 1
    );