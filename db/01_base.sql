-- =============================================
-- 01_base.sql
-- =============================================

-- =========================
-- TABLA PLANES
-- =========================
CREATE TABLE PLANES (
                        id_plan NUMBER,
                        nombre VARCHAR2(50) NOT NULL,
                        max_pantallas NUMBER NOT NULL,
                        calidad_video VARCHAR2(20) NOT NULL,
                        precio_mensual NUMBER(10,2) NOT NULL,

                        CONSTRAINT pk_planes PRIMARY KEY (id_plan),
                        CONSTRAINT uq_planes_nombre UNIQUE (nombre),
                        CONSTRAINT chk_pantallas CHECK (max_pantallas > 0),
                        CONSTRAINT chk_precio CHECK (precio_mensual >= 0)
);

CREATE SEQUENCE seq_planes START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_planes
    BEFORE INSERT ON PLANES
    FOR EACH ROW
BEGIN
    :NEW.id_plan := seq_planes.NEXTVAL;
END;
/

-- =========================
-- TABLA CIUDADES
-- =========================
CREATE TABLE CIUDADES (
                          id_ciudad NUMBER,
                          nombre_ciudad VARCHAR2(100) NOT NULL,

                          CONSTRAINT pk_ciudades PRIMARY KEY (id_ciudad),
                          CONSTRAINT uq_ciudad UNIQUE (nombre_ciudad)
);

CREATE SEQUENCE seq_ciudades START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_ciudades
    BEFORE INSERT ON CIUDADES
    FOR EACH ROW
BEGIN
    :NEW.id_ciudad := seq_ciudades.NEXTVAL;
END;
/

-- =========================
-- TABLA ESTADOS_CUENTA
-- =========================
CREATE TABLE ESTADOS_CUENTA (
                                id_estado NUMBER,
                                descripcion VARCHAR2(50) NOT NULL,

                                CONSTRAINT pk_estados PRIMARY KEY (id_estado),
                                CONSTRAINT uq_estado UNIQUE (descripcion)
);

CREATE SEQUENCE seq_estados START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_estados
    BEFORE INSERT ON ESTADOS_CUENTA
    FOR EACH ROW
BEGIN
    :NEW.id_estado := seq_estados.NEXTVAL;
END;
/

-- =========================
-- TABLA CATEGORIAS
-- =========================
CREATE TABLE CATEGORIAS (
                            id_categoria NUMBER,
                            nombre_categoria VARCHAR2(100) NOT NULL,

                            CONSTRAINT pk_categorias PRIMARY KEY (id_categoria),
                            CONSTRAINT uq_categoria UNIQUE (nombre_categoria)
);

CREATE SEQUENCE seq_categorias START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_categorias
    BEFORE INSERT ON CATEGORIAS
    FOR EACH ROW
BEGIN
    :NEW.id_categoria := seq_categorias.NEXTVAL;
END;
/