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

      /* =========================================================
   3.5.2 IMPLEMENTACION DE USUARIOS Y PERFILES
   Proyecto: QuindioFlix
========================================================= */


/* =========================================================
   PARTE A - CREACION DE PROFILE
========================================================= */

CREATE PROFILE PERFIL_SEGURIDAD_QF LIMIT
    SESSIONS_PER_USER 2
    IDLE_TIME 15
    FAILED_LOGIN_ATTEMPTS 3
    PASSWORD_LIFE_TIME 60;



/* =========================================================
   PARTE B - CREACION DE USUARIOS
========================================================= */

CREATE USER ADMIN_QF
IDENTIFIED BY admin123
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
PROFILE PERFIL_SEGURIDAD_QF;

CREATE USER ANALISTA_QF
IDENTIFIED BY analista123
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
PROFILE PERFIL_SEGURIDAD_QF;

CREATE USER SOPORTE_QF
IDENTIFIED BY soporte123
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
PROFILE PERFIL_SEGURIDAD_QF;

CREATE USER CONTENIDO_QF
IDENTIFIED BY contenido123
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP
PROFILE PERFIL_SEGURIDAD_QF;



/* =========================================================
   PARTE C - ASIGNACION DE ROLES
========================================================= */

GRANT ROL_ADMIN TO ADMIN_QF;
GRANT ROL_ANALISTA TO ANALISTA_QF;
GRANT ROL_SOPORTE TO SOPORTE_QF;
GRANT ROL_CONTENIDO TO CONTENIDO_QF;



/* =========================================================
   PARTE D - VERIFICACION DE PRIVILEGIOS
========================================================= */

-- Ver perfiles
SELECT *
FROM DBA_PROFILES
WHERE PROFILE = 'PERFIL_SEGURIDAD_QF';


-- Ver usuarios y perfiles
SELECT USERNAME, PROFILE
FROM DBA_USERS
WHERE USERNAME IN (
                   'ADMIN_QF',
                   'ANALISTA_QF',
                   'SOPORTE_QF',
                   'CONTENIDO_QF'
    );


-- Ver roles asignados
SELECT *
FROM DBA_ROLE_PRIVS
WHERE GRANTEE IN (
                  'ADMIN_QF',
                  'ANALISTA_QF',
                  'SOPORTE_QF',
                  'CONTENIDO_QF'
    );



/* =========================================================
   PARTE E - DEMOSTRACION DE ACCESOS PERMITIDOS
========================================================= */

------------------------------------------------------------
-- ADMIN_QF
-- Puede hacer CRUD completo
------------------------------------------------------------

CONNECT ADMIN_QF/admin123;

SELECT * FROM USUARIOS;

INSERT INTO GENEROS (
    ID_GENERO,
    NOMBRE_GENERO
)
VALUES (
           999,
           'PRUEBA_ADMIN'
       );

ROLLBACK;



------------------------------------------------------------
-- ANALISTA_QF
-- Solo puede consultar
------------------------------------------------------------

CONNECT ANALISTA_QF/analista123;

SELECT * FROM REPRODUCCIONES;

-- Operacion NO permitida
INSERT INTO USUARIOS (
    ID_USUARIO,
    NOMBRE_COMPLETO
)
VALUES (
           999,
           'USUARIO PRUEBA'
       );

-- Oracle debe mostrar:
-- ORA-01031: insufficient privileges



------------------------------------------------------------
-- SOPORTE_QF
-- Puede consultar usuarios y actualizar pagos
------------------------------------------------------------

CONNECT SOPORTE_QF/soporte123;

SELECT * FROM USUARIOS;

UPDATE PAGOS
SET ESTADO_PAGO = 'EXITOSO'
WHERE ID_PAGO = 1;

ROLLBACK;

-- Operacion NO permitida
DELETE FROM CONTENIDO
WHERE ID_CONTENIDO = 1;

-- Oracle debe mostrar:
-- ORA-01031: insufficient privileges



------------------------------------------------------------
-- CONTENIDO_QF
-- Puede administrar catalogo
------------------------------------------------------------

CONNECT CONTENIDO_QF/contenido123;

SELECT * FROM CONTENIDO;

INSERT INTO GENEROS (
    ID_GENERO,
    NOMBRE_GENERO
)
VALUES (
           998,
           'PRUEBA_CONTENIDO'
       );

ROLLBACK;

-- Operacion NO permitida
DELETE FROM USUARIOS
WHERE ID_USUARIO = 1;

-- Oracle debe mostrar:
-- ORA-01031: insufficient privileges



/* =========================================================
   PARTE F - DEMOSTRACION DEL PROFILE
========================================================= */

-- Intentar ingresar varias veces con contraseña incorrecta

CONNECT ANALISTA_QF/clave_incorrecta;
CONNECT ANALISTA_QF/clave_incorrecta;
CONNECT ANALISTA_QF/clave_incorrecta;

-- Oracle bloqueara la cuenta:
-- ORA-28000: the account is locked



/* =========================================================
   CONSULTAS FINALES DE VERIFICACION
========================================================= */

-- Ver estado de cuentas
SELECT USERNAME, ACCOUNT_STATUS
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


-- Ver limites del profile
SELECT *
FROM DBA_PROFILES
WHERE PROFILE = 'PERFIL_SEGURIDAD_QF';
