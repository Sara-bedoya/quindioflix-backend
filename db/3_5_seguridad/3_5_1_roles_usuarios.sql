/*
PROYECTO: QUINDIOFLIX
SECCION : 3.5.1 Roles y usuarios
ARCHIVO : 3_5_1_roles_usuarios.sql
OBJETIVO: Creacion de usuarios y roles del proyecto
ORIGEN  : security\01_user_and_permissions.sql
*/
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

       /* =========================================================
   3.5 NÚCLEO 5: ADMINISTRACION DE ACCESO A BD
   3.5.1 ESQUEMA DE USUARIOS Y ROLES
   Proyecto: QuindioFlix
========================================================= */


/* =========================================================
   CREACION DE ROLES
========================================================= */

CREATE ROLE ROL_ADMIN;
CREATE ROLE ROL_ANALISTA;
CREATE ROLE ROL_SOPORTE;
CREATE ROLE ROL_CONTENIDO;


/* =========================================================
   ROL_ADMIN
   Administrador total de la plataforma
========================================================= */

-- Privilegios de sistema
GRANT CREATE SESSION TO ROL_ADMIN;
GRANT CREATE TABLE TO ROL_ADMIN;
GRANT CREATE VIEW TO ROL_ADMIN;
GRANT CREATE PROCEDURE TO ROL_ADMIN;
GRANT CREATE SEQUENCE TO ROL_ADMIN;
GRANT CREATE TRIGGER TO ROL_ADMIN;
GRANT CREATE USER TO ROL_ADMIN;
GRANT ALTER USER TO ROL_ADMIN;
GRANT DROP USER TO ROL_ADMIN;

-- Privilegios sobre tablas
GRANT SELECT, INSERT, UPDATE, DELETE
    ON USUARIOS TO ROL_ADMIN;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON PERFILES TO ROL_ADMIN;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON CONTENIDO TO ROL_ADMIN;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON REPRODUCCIONES TO ROL_ADMIN;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON CALIFICACIONES TO ROL_ADMIN;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON PAGOS TO ROL_ADMIN;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON TEMPORADAS TO ROL_ADMIN;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON EPISODIOS TO ROL_ADMIN;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON GENEROS TO ROL_ADMIN;

GRANT EXECUTE
    ON SP_CAMBIAR_PLAN TO ROL_ADMIN;



/* =========================================================
   ROL_ANALISTA
   Analista de datos / gerencia
========================================================= */

GRANT CREATE SESSION TO ROL_ANALISTA;

-- Solo lectura
GRANT SELECT ON USUARIOS TO ROL_ANALISTA;
GRANT SELECT ON PERFILES TO ROL_ANALISTA;
GRANT SELECT ON CONTENIDO TO ROL_ANALISTA;
GRANT SELECT ON REPRODUCCIONES TO ROL_ANALISTA;
GRANT SELECT ON CALIFICACIONES TO ROL_ANALISTA;
GRANT SELECT ON PAGOS TO ROL_ANALISTA;
GRANT SELECT ON TEMPORADAS TO ROL_ANALISTA;
GRANT SELECT ON EPISODIOS TO ROL_ANALISTA;

-- Procedimientos de reportes
GRANT EXECUTE
    ON SP_REPORTE_MOROSOS TO ROL_ANALISTA;

GRANT EXECUTE
    ON SP_ACTUALIZAR_POPULARIDAD TO ROL_ANALISTA;



/* =========================================================
   ROL_SOPORTE
   Soporte al cliente
========================================================= */

GRANT CREATE SESSION TO ROL_SOPORTE;

GRANT SELECT
    ON USUARIOS TO ROL_SOPORTE;

GRANT SELECT
    ON PERFILES TO ROL_SOPORTE;

GRANT SELECT
    ON PAGOS TO ROL_SOPORTE;

GRANT UPDATE
    ON PAGOS TO ROL_SOPORTE;

GRANT EXECUTE
    ON SP_CAMBIAR_PLAN TO ROL_SOPORTE;



/* =========================================================
   ROL_CONTENIDO
   Gestor de catalogo
========================================================= */

GRANT CREATE SESSION TO ROL_CONTENIDO;

-- CRUD contenido
GRANT SELECT, INSERT, UPDATE, DELETE
    ON CONTENIDO TO ROL_CONTENIDO;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON TEMPORADAS TO ROL_CONTENIDO;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON EPISODIOS TO ROL_CONTENIDO;

GRANT SELECT, INSERT, UPDATE, DELETE
    ON GENEROS TO ROL_CONTENIDO;

-- Solo consulta
GRANT SELECT
    ON REPRODUCCIONES TO ROL_CONTENIDO;

GRANT SELECT
    ON CALIFICACIONES TO ROL_CONTENIDO;



/* =========================================================
   CREACION DE USUARIOS
========================================================= */

CREATE USER ADMIN_QF
IDENTIFIED BY admin123
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

CREATE USER ANALISTA_QF
IDENTIFIED BY analista123
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

CREATE USER SOPORTE_QF
IDENTIFIED BY soporte123
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

CREATE USER CONTENIDO_QF
IDENTIFIED BY contenido123
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;



/* =========================================================
   ASIGNACION DE ROLES
========================================================= */

GRANT ROL_ADMIN TO ADMIN_QF;
GRANT ROL_ANALISTA TO ANALISTA_QF;
GRANT ROL_SOPORTE TO SOPORTE_QF;
GRANT ROL_CONTENIDO TO CONTENIDO_QF;



/* =========================================================
   CONSULTAS DE VERIFICACION
========================================================= */

-- Ver roles creados
SELECT ROLE
FROM DBA_ROLES
WHERE ROLE LIKE 'ROL_%';


-- Ver usuarios creados
SELECT USERNAME
FROM DBA_USERS
WHERE USERNAME IN (
                   'ADMIN_QF',
                   'ANALISTA_QF',
                   'SOPORTE_QF',
                   'CONTENIDO_QF'
    );


-- Ver privilegios de roles
SELECT *
FROM ROLE_TAB_PRIVS
WHERE ROLE LIKE 'ROL_%';


-- Ver asignacion de roles a usuarios
SELECT *
FROM DBA_ROLE_PRIVS
WHERE GRANTEE IN (
                  'ADMIN_QF',
                  'ANALISTA_QF',
                  'SOPORTE_QF',
                  'CONTENIDO_QF'
    );