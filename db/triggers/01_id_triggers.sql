-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 01_id_triggers.sql
-- OBJETIVO:
--     Automatizar la generación de IDs primarios
--     mediante sequences en todas las tablas.
-- =========================================================


-- =========================================================
-- TRIGGER: PLANES
-- =========================================================

CREATE OR REPLACE TRIGGER trg_planes
    BEFORE INSERT ON PLANES
    FOR EACH ROW
BEGIN

    IF :NEW.id_plan IS NULL THEN
        :NEW.id_plan := seq_planes.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: CIUDADES
-- =========================================================

CREATE OR REPLACE TRIGGER trg_ciudades
    BEFORE INSERT ON CIUDADES
    FOR EACH ROW
BEGIN

    IF :NEW.id_ciudad IS NULL THEN
        :NEW.id_ciudad := seq_ciudades.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: ESTADOS_CUENTA
-- =========================================================

CREATE OR REPLACE TRIGGER trg_estados
    BEFORE INSERT ON ESTADOS_CUENTA
    FOR EACH ROW
BEGIN

    IF :NEW.id_estado IS NULL THEN
        :NEW.id_estado := seq_estados.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: CATEGORIAS
-- =========================================================

CREATE OR REPLACE TRIGGER trg_categorias
    BEFORE INSERT ON CATEGORIAS
    FOR EACH ROW
BEGIN

    IF :NEW.id_categoria IS NULL THEN
        :NEW.id_categoria := seq_categorias.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: USUARIOS
-- =========================================================

CREATE OR REPLACE TRIGGER trg_usuarios
    BEFORE INSERT ON USUARIOS
    FOR EACH ROW
BEGIN

    IF :NEW.id_usuario IS NULL THEN
        :NEW.id_usuario := seq_usuarios.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: PERFILES
-- =========================================================

CREATE OR REPLACE TRIGGER trg_perfiles
    BEFORE INSERT ON PERFILES
    FOR EACH ROW
BEGIN

    IF :NEW.id_perfil IS NULL THEN
        :NEW.id_perfil := seq_perfiles.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: REFERIDOS
-- =========================================================

CREATE OR REPLACE TRIGGER trg_referidos
    BEFORE INSERT ON REFERIDOS
    FOR EACH ROW
BEGIN

    IF :NEW.id_referido IS NULL THEN
        :NEW.id_referido := seq_referidos.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: PAGOS
-- =========================================================

CREATE OR REPLACE TRIGGER trg_pagos
    BEFORE INSERT ON PAGOS
    FOR EACH ROW
BEGIN

    IF :NEW.id_pago IS NULL THEN
        :NEW.id_pago := seq_pagos.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: GENEROS
-- =========================================================

CREATE OR REPLACE TRIGGER trg_generos
    BEFORE INSERT ON GENEROS
    FOR EACH ROW
BEGIN

    IF :NEW.id_genero IS NULL THEN
        :NEW.id_genero := seq_generos.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: CONTENIDO
-- =========================================================

CREATE OR REPLACE TRIGGER trg_contenido
    BEFORE INSERT ON CONTENIDO
    FOR EACH ROW
BEGIN

    IF :NEW.id_contenido IS NULL THEN
        :NEW.id_contenido := seq_contenido.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: TEMPORADAS
-- =========================================================

CREATE OR REPLACE TRIGGER trg_temporadas
    BEFORE INSERT ON TEMPORADAS
    FOR EACH ROW
BEGIN

    IF :NEW.id_temporada IS NULL THEN
        :NEW.id_temporada := seq_temporadas.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: EPISODIOS
-- =========================================================

CREATE OR REPLACE TRIGGER trg_episodios
    BEFORE INSERT ON EPISODIOS
    FOR EACH ROW
BEGIN

    IF :NEW.id_episodio IS NULL THEN
        :NEW.id_episodio := seq_episodios.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: DEPARTAMENTOS
-- =========================================================

CREATE OR REPLACE TRIGGER trg_departamentos
    BEFORE INSERT ON DEPARTAMENTOS
    FOR EACH ROW
BEGIN

    IF :NEW.id_departamento IS NULL THEN
        :NEW.id_departamento := seq_departamentos.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: EMPLEADOS
-- =========================================================

CREATE OR REPLACE TRIGGER trg_empleados
    BEFORE INSERT ON EMPLEADOS
    FOR EACH ROW
BEGIN

    IF :NEW.id_empleado IS NULL THEN
        :NEW.id_empleado := seq_empleados.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: REPORTES
-- =========================================================

CREATE OR REPLACE TRIGGER trg_reportes
    BEFORE INSERT ON REPORTES
    FOR EACH ROW
BEGIN

    IF :NEW.id_reporte IS NULL THEN
        :NEW.id_reporte := seq_reportes.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: REPRODUCCIONES
-- =========================================================

CREATE OR REPLACE TRIGGER trg_reproducciones
    BEFORE INSERT ON REPRODUCCIONES
    FOR EACH ROW
BEGIN

    IF :NEW.id_reproduccion IS NULL THEN
        :NEW.id_reproduccion := seq_reproducciones.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: CALIFICACIONES
-- =========================================================

CREATE OR REPLACE TRIGGER trg_calificaciones
    BEFORE INSERT ON CALIFICACIONES
    FOR EACH ROW
BEGIN

    IF :NEW.id_calificacion IS NULL THEN
        :NEW.id_calificacion := seq_calificaciones.NEXTVAL;
    END IF;

END;
/


-- =========================================================
-- TRIGGER: FAVORITOS
-- =========================================================

CREATE OR REPLACE TRIGGER trg_favoritos
    BEFORE INSERT ON FAVORITOS
    FOR EACH ROW
BEGIN

    IF :NEW.id_favorito IS NULL THEN
        :NEW.id_favorito := seq_favoritos.NEXTVAL;
    END IF;

END;
/