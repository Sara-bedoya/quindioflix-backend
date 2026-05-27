/*
PROYECTO: QUINDIOFLIX
SECCION : DDL
ARCHIVO : 03_contenido_tables.sql
OBJETIVO: Tablas de contenido, generos, temporadas y episodios
ORIGEN  : ddl\03_contenido_tables.sql
*/
-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 03_contenido_tables.sql
-- OBJETIVO:
--     Crear estructuras relacionadas con contenido:
--         - GENEROS
--         - CONTENIDO
--         - TEMPORADAS
--         - EPISODIOS
--         - CONTENIDO_GENERO
--         - CONTENIDO_RELACIONADO
-- =========================================================

-- =========================
-- TABLA GENEROS
-- =========================
CREATE TABLE GENEROS (
                         id_genero NUMBER,
                         nombre_genero VARCHAR2(100) NOT NULL,

                         CONSTRAINT pk_generos PRIMARY KEY (id_genero),
                         CONSTRAINT uq_genero UNIQUE (nombre_genero)
);

CREATE SEQUENCE seq_generos START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_generos
    BEFORE INSERT ON GENEROS
    FOR EACH ROW
BEGIN
    :NEW.id_genero := seq_generos.NEXTVAL;
END;
/

-- =========================
-- TABLA CONTENIDO
-- =========================
CREATE TABLE CONTENIDO (
                           id_contenido NUMBER,
                           titulo VARCHAR2(200) NOT NULL,
                           anio_lanzamiento NUMBER(4),
                           duracion_minutos NUMBER,
                           sinopsis VARCHAR2(2000),
                           clasificacion_edad VARCHAR2(10),
                           fecha_agregado DATE DEFAULT SYSDATE,
                           id_categoria NUMBER,
                           es_original CHAR(1) DEFAULT 'N',

                           CONSTRAINT pk_contenido PRIMARY KEY (id_contenido),

                           CONSTRAINT fk_contenido_categoria FOREIGN KEY (id_categoria)
                               REFERENCES CATEGORIAS(id_categoria),

                           CONSTRAINT chk_clasificacion CHECK (
                               clasificacion_edad IN ('TP','+7','+13','+16','+18')
                               ),

                           CONSTRAINT chk_es_original CHECK (es_original IN ('S','N'))
);

CREATE SEQUENCE seq_contenido START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_contenido
    BEFORE INSERT ON CONTENIDO
    FOR EACH ROW
BEGIN
    :NEW.id_contenido := seq_contenido.NEXTVAL;
END;
/

-- =========================
-- TABLA TEMPORADAS
-- =========================
CREATE TABLE TEMPORADAS (
                            id_temporada NUMBER,
                            id_contenido NUMBER NOT NULL,
                            numero_temporada NUMBER NOT NULL,
                            titulo_temporada VARCHAR2(200),

                            CONSTRAINT pk_temporadas PRIMARY KEY (id_temporada),

                            CONSTRAINT fk_temp_contenido FOREIGN KEY (id_contenido)
                                REFERENCES CONTENIDO(id_contenido)
);

CREATE SEQUENCE seq_temporadas START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_temporadas
    BEFORE INSERT ON TEMPORADAS
    FOR EACH ROW
BEGIN
    :NEW.id_temporada := seq_temporadas.NEXTVAL;
END;
/

-- =========================
-- TABLA EPISODIOS
-- =========================
CREATE TABLE EPISODIOS (
                           id_episodio NUMBER,
                           id_temporada NUMBER NOT NULL,
                           numero_episodio NUMBER NOT NULL,
                           titulo_episodio VARCHAR2(200),
                           duracion_minutos NUMBER,
                           sinopsis VARCHAR2(2000),

                           CONSTRAINT pk_episodios PRIMARY KEY (id_episodio),

                           CONSTRAINT fk_episodio_temporada FOREIGN KEY (id_temporada)
                               REFERENCES TEMPORADAS(id_temporada)
);

CREATE SEQUENCE seq_episodios START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_episodios
    BEFORE INSERT ON EPISODIOS
    FOR EACH ROW
BEGIN
    :NEW.id_episodio := seq_episodios.NEXTVAL;
END;
/

-- =========================
-- TABLA CONTENIDO_GENERO
-- =========================
CREATE TABLE CONTENIDO_GENERO (
                                  id_contenido NUMBER NOT NULL,
                                  id_genero NUMBER NOT NULL,

                                  CONSTRAINT pk_contenido_genero PRIMARY KEY (id_contenido, id_genero),

                                  CONSTRAINT fk_cg_contenido FOREIGN KEY (id_contenido)
                                      REFERENCES CONTENIDO(id_contenido),

                                  CONSTRAINT fk_cg_genero FOREIGN KEY (id_genero)
                                      REFERENCES GENEROS(id_genero)
);

-- =========================
-- TABLA CONTENIDO_RELACIONADO
-- =========================
CREATE TABLE CONTENIDO_RELACIONADO (
                                       id_contenido_origen NUMBER NOT NULL,
                                       id_contenido_destino NUMBER NOT NULL,
                                       tipo_relacion VARCHAR2(50),

                                       CONSTRAINT pk_contenido_rel PRIMARY KEY (id_contenido_origen, id_contenido_destino),

                                       CONSTRAINT fk_cr_origen FOREIGN KEY (id_contenido_origen)
                                           REFERENCES CONTENIDO(id_contenido),

                                       CONSTRAINT fk_cr_destino FOREIGN KEY (id_contenido_destino)
                                           REFERENCES CONTENIDO(id_contenido)
);
