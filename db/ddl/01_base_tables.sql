-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 01_base_tables.sql
-- OBJETIVO:
--     Crear tablas base del sistema:
--         - PLANES
--         - CIUDADES
--         - ESTADOS_CUENTA
--         - CATEGORIAS
-- =========================================================


-- =========================================================
-- TABLA: PLANES
-- DESCRIPCION:
--     Almacena los planes de suscripción disponibles.
-- =========================================================

CREATE TABLE PLANES (

                        id_plan NUMBER,

                        nombre VARCHAR2(50) NOT NULL,

                        max_pantallas NUMBER NOT NULL,

                        calidad_video VARCHAR2(20) NOT NULL,

                        precio_mensual NUMBER(10,2) NOT NULL,

                        CONSTRAINT pk_planes
                            PRIMARY KEY (id_plan),

                        CONSTRAINT uq_planes_nombre
                            UNIQUE (nombre),

                        CONSTRAINT chk_pantallas
                            CHECK (max_pantallas > 0),

                        CONSTRAINT chk_precio
                            CHECK (precio_mensual >= 0)
);


-- =========================================================
-- TABLA: CIUDADES
-- =========================================================

CREATE TABLE CIUDADES (

                          id_ciudad NUMBER,

                          nombre_ciudad VARCHAR2(100) NOT NULL,

                          CONSTRAINT pk_ciudades
                              PRIMARY KEY (id_ciudad),

                          CONSTRAINT uq_ciudad
                              UNIQUE (nombre_ciudad)
);


-- =========================================================
-- TABLA: ESTADOS_CUENTA
-- =========================================================

CREATE TABLE ESTADOS_CUENTA (

                                id_estado NUMBER,

                                descripcion VARCHAR2(50) NOT NULL,

                                CONSTRAINT pk_estados
                                    PRIMARY KEY (id_estado),

                                CONSTRAINT uq_estado
                                    UNIQUE (descripcion)
);


-- =========================================================
-- TABLA: CATEGORIAS
-- =========================================================

CREATE TABLE CATEGORIAS (

                            id_categoria NUMBER,

                            nombre_categoria VARCHAR2(100) NOT NULL,

                            CONSTRAINT pk_categorias
                                PRIMARY KEY (id_categoria),

                            CONSTRAINT uq_categoria
                                UNIQUE (nombre_categoria)
);