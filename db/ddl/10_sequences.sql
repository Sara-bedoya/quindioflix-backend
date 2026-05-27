/*
PROYECTO: QUINDIOFLIX
SECCION : DDL Secuencias
ARCHIVO : 10_sequences.sql
OBJETIVO: Secuencias centralizadas del esquema QuindioFlix
ORIGEN  : sequences\01_sequences.sql
*/
-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 01_sequences.sql
-- OBJETIVO:
--     Centralizar todas las secuencias del sistema.
-- =========================================================


-- =========================================================
-- SEQUENCES TABLAS BASE
-- =========================================================

CREATE SEQUENCE seq_planes START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_ciudades START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_estados START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_categorias START WITH 1 INCREMENT BY 1;


-- =========================================================
-- SEQUENCES USUARIOS
-- =========================================================

CREATE SEQUENCE seq_usuarios START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_perfiles START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_referidos START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_pagos START WITH 1 INCREMENT BY 1;


-- =========================================================
-- SEQUENCES CONTENIDO
-- =========================================================

CREATE SEQUENCE seq_generos START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_contenido START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_temporadas START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_episodios START WITH 1 INCREMENT BY 1;


-- =========================================================
-- SEQUENCES ADMINISTRACION
-- =========================================================

CREATE SEQUENCE seq_departamentos START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_empleados START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_reportes START WITH 1 INCREMENT BY 1;


-- =========================================================
-- SEQUENCES REPRODUCCIONES
-- =========================================================

CREATE SEQUENCE seq_reproducciones START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_calificaciones START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_favoritos START WITH 1 INCREMENT BY 1;