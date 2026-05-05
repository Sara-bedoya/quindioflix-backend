-- =============================================
-- 01_user_and_permissions.sql
-- Conexión: SYSTEM
-- Descripción: Crea el usuario exclusivo del proyecto y asigna privilegios mínimos
-- =============================================

-- 1. Crear usuario con contraseña segura
CREATE USER quindioflix_user IDENTIFIED BY quindio2024;

-- 2. Privilegios de sistema esenciales
GRANT CREATE SESSION TO quindioflix_user;
GRANT CREATE TABLE TO quindioflix_user;
GRANT CREATE SEQUENCE TO quindioflix_user;
GRANT CREATE PROCEDURE TO quindioflix_user;
GRANT CREATE TRIGGER TO quindioflix_user;
GRANT CREATE VIEW TO quindioflix_user;

-- 3. Asignar tablespaces correctos (evita errores ORA-01950)
ALTER USER quindioflix_user DEFAULT TABLESPACE USERS;
ALTER USER quindioflix_user TEMPORARY TABLESPACE TEMP;
ALTER USER quindioflix_user QUOTA UNLIMITED ON USERS;