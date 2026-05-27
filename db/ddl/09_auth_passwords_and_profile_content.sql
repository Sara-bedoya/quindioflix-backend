/*
PROYECTO: QUINDIOFLIX
SECCION : DDL
ARCHIVO : 09_auth_passwords_and_profile_content.sql
OBJETIVO: Ajustes de autenticacion y contenido de perfiles
ORIGEN  : ddl\09_auth_passwords_and_profile_content.sql
*/
-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 09_auth_passwords_and_profile_content.sql
-- OBJETIVO:
--     Ajustes para conectar el frontend:
--       - contrasenas de usuarios
--       - contrasenas de empleados
--       - datos semilla minimos para login de empleados
-- =========================================================

ALTER TABLE USUARIOS ADD (password VARCHAR2(100));

ALTER TABLE EMPLEADOS ADD (password VARCHAR2(100));

UPDATE USUARIOS
SET password = '123456'
WHERE password IS NULL;

-- Si ya tienes empleados, puedes asignar una temporal para probar.
UPDATE EMPLEADOS
SET password = '123456'
WHERE password IS NULL;

-- Empleados semilla para probar permisos por departamento.
-- Ejecutar solo si no tienes estos departamentos/empleados creados.
INSERT INTO DEPARTAMENTOS (nombre_departamento)
SELECT 'Contenido'
FROM dual
WHERE NOT EXISTS (
    SELECT 1 FROM DEPARTAMENTOS WHERE LOWER(nombre_departamento) = 'contenido'
);

INSERT INTO DEPARTAMENTOS (nombre_departamento)
SELECT 'Soporte'
FROM dual
WHERE NOT EXISTS (
    SELECT 1 FROM DEPARTAMENTOS WHERE LOWER(nombre_departamento) = 'soporte'
);

INSERT INTO DEPARTAMENTOS (nombre_departamento)
SELECT 'Analitica'
FROM dual
WHERE NOT EXISTS (
    SELECT 1 FROM DEPARTAMENTOS WHERE LOWER(nombre_departamento) = 'analitica'
);

INSERT INTO EMPLEADOS (
    nombre_completo,
    email,
    password,
    telefono,
    id_departamento,
    cargo
)
SELECT
    'Editor Contenido',
    'contenido@quindioflix.com',
    '123456',
    '3000000000',
    d.id_departamento,
    'Editor de contenido'
FROM DEPARTAMENTOS d
WHERE LOWER(d.nombre_departamento) = 'contenido'
  AND NOT EXISTS (
      SELECT 1 FROM EMPLEADOS WHERE LOWER(email) = 'contenido@quindioflix.com'
  );

INSERT INTO EMPLEADOS (
    nombre_completo,
    email,
    password,
    telefono,
    id_departamento,
    cargo
)
SELECT
    'Agente Soporte',
    'soporte@quindioflix.com',
    '123456',
    '3000000001',
    d.id_departamento,
    'Agente de soporte'
FROM DEPARTAMENTOS d
WHERE LOWER(d.nombre_departamento) = 'soporte'
  AND NOT EXISTS (
      SELECT 1 FROM EMPLEADOS WHERE LOWER(email) = 'soporte@quindioflix.com'
  );

INSERT INTO EMPLEADOS (
    nombre_completo,
    email,
    password,
    telefono,
    id_departamento,
    cargo
)
SELECT
    'Analista',
    'analitica@quindioflix.com',
    '123456',
    '3000000002',
    d.id_departamento,
    'Analista'
FROM DEPARTAMENTOS d
WHERE LOWER(d.nombre_departamento) = 'analitica'
  AND NOT EXISTS (
      SELECT 1 FROM EMPLEADOS WHERE LOWER(email) = 'analitica@quindioflix.com'
  );

COMMIT;
