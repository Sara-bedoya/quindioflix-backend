/*
PROYECTO: QUINDIOFLIX
SECCION : DDL
ARCHIVO : 06_reproducciones_tables.sql
OBJETIVO: Tablas de reproducciones, calificaciones y favoritos
ORIGEN  : ddl\06_reproducciones_tables.sql
*/
-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 06_reproducciones_tables.sql
-- OBJETIVO:
--     Crear tablas relacionadas con interacción
--     del usuario:
--         - REPRODUCCIONES
--         - CALIFICACIONES
--         - FAVORITOS
-- =========================================================


-- =========================================================
-- TABLA: REPRODUCCIONES
-- =========================================================

CREATE TABLE REPRODUCCIONES (

                                id_reproduccion NUMBER PRIMARY KEY,

                                id_perfil NUMBER NOT NULL,

                                id_contenido NUMBER NOT NULL,

                                fecha_inicio TIMESTAMP DEFAULT SYSTIMESTAMP,

                                fecha_fin TIMESTAMP,

                                porcentaje_visto NUMBER(5,2),

                                dispositivo VARCHAR2(20),

                                id_episodio NUMBER,

                                CONSTRAINT fk_rep_perfil_rep
                                    FOREIGN KEY (id_perfil)
                                        REFERENCES PERFILES(id_perfil),

                                CONSTRAINT fk_rep_contenido_rep
                                    FOREIGN KEY (id_contenido)
                                        REFERENCES CONTENIDO(id_contenido),

                                CONSTRAINT fk_reproduccion_episodio
                                    FOREIGN KEY (id_episodio)
                                        REFERENCES EPISODIOS(id_episodio),

                                CONSTRAINT chk_dispositivo
                                    CHECK (
                                        dispositivo IN (
                                                        'CELULAR',
                                                        'TABLET',
                                                        'TV',
                                                        'COMPUTADOR'
                                            )
                                        )
);


-- =========================================================
-- TABLA: CALIFICACIONES
-- =========================================================

CREATE TABLE CALIFICACIONES (

                                id_calificacion NUMBER PRIMARY KEY,

                                id_perfil NUMBER NOT NULL,

                                id_contenido NUMBER NOT NULL,

                                estrellas NUMBER,

                                comentario VARCHAR2(500),

                                CONSTRAINT fk_cal_perfil
                                    FOREIGN KEY (id_perfil)
                                        REFERENCES PERFILES(id_perfil),

                                CONSTRAINT fk_cal_contenido
                                    FOREIGN KEY (id_contenido)
                                        REFERENCES CONTENIDO(id_contenido),

                                CONSTRAINT chk_estrellas
                                    CHECK (
                                        estrellas BETWEEN 1 AND 5
                                        )
);


-- =========================================================
-- TABLA: FAVORITOS
-- =========================================================

CREATE TABLE FAVORITOS (

                           id_favorito NUMBER PRIMARY KEY,

                           id_perfil NUMBER NOT NULL,

                           id_contenido NUMBER NOT NULL,

                           fecha_agregado DATE DEFAULT SYSDATE,

                           CONSTRAINT fk_fav_perfil
                               FOREIGN KEY (id_perfil)
                                   REFERENCES PERFILES(id_perfil),

                           CONSTRAINT fk_fav_contenido
                               FOREIGN KEY (id_contenido)
                                   REFERENCES CONTENIDO(id_contenido)
);