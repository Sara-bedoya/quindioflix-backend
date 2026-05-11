-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 01_user_and_permissions.sql
-- AUTOR   : Equipo QuindioFlix
-- OBJETIVO:
--     Crear el usuario exclusivo del proyecto y asignar
--     privilegios mínimos necesarios para el desarrollo.
--
-- IMPORTANTE:
--     Este script debe ejecutarse con el usuario SYSTEM.
-- =========================================================

-- =========================================================
-- CREACION DEL USUARIO
-- =========================================================

CREATE USER quindioflix_user
    IDENTIFIED BY quindio2024;


-- =========================================================
-- PRIVILEGIOS DEL SISTEMA
-- =========================================================

GRANT CREATE SESSION TO quindioflix_user;
GRANT CREATE TABLE TO quindioflix_user;
GRANT CREATE SEQUENCE TO quindioflix_user;
GRANT CREATE PROCEDURE TO quindioflix_user;
GRANT CREATE TRIGGER TO quindioflix_user;
GRANT CREATE VIEW TO quindioflix_user;


-- =========================================================
-- CONFIGURACION DE TABLESPACES
-- =========================================================

ALTER USER quindioflix_user
    DEFAULT TABLESPACE USERS;

ALTER USER quindioflix_user
    TEMPORARY TABLESPACE TEMP;

ALTER USER quindioflix_user
    QUOTA UNLIMITED ON USERS;