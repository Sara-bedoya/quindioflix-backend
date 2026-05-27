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
