/*
PROYECTO: QUINDIOFLIX
SECCION : 3.5.2 Grants y profiles
ARCHIVO : 3_5_2_grants_profiles.sql
OBJETIVO: Privilegios, cuotas y configuracion de acceso
ORIGEN  : security\01_user_and_permissions.sql
*/
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