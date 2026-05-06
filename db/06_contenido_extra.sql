-- =============================================
-- AJUSTES TABLA CONTENIDO
-- =============================================

ALTER TABLE CONTENIDO ADD (
    id_empleado_responsable NUMBER,
    popularidad NUMBER DEFAULT 0
    );

ALTER TABLE CONTENIDO ADD CONSTRAINT fk_contenido_empleado
    FOREIGN KEY (id_empleado_responsable)
        REFERENCES EMPLEADOS(id_empleado);
-- =============================================
-- TABLA REPRODUCCIONES
-- =============================================

CREATE TABLE REPRODUCCIONES (
                                id_reproduccion NUMBER PRIMARY KEY,
                                id_perfil NUMBER NOT NULL,
                                id_contenido NUMBER NOT NULL,
                                fecha_inicio TIMESTAMP DEFAULT SYSTIMESTAMP,
                                fecha_fin TIMESTAMP,
                                porcentaje_visto NUMBER(5,2),

                                CONSTRAINT fk_rep_perfil_rep FOREIGN KEY (id_perfil)
                                    REFERENCES PERFILES(id_perfil),

                                CONSTRAINT fk_rep_contenido_rep FOREIGN KEY (id_contenido)
                                    REFERENCES CONTENIDO(id_contenido)
);

-- =============================================
-- TABLA CALIFICACIONES
-- =============================================

CREATE TABLE CALIFICACIONES (
                                id_calificacion NUMBER PRIMARY KEY,
                                id_perfil NUMBER NOT NULL,
                                id_contenido NUMBER NOT NULL,
                                estrellas NUMBER,
                                comentario VARCHAR2(500),

                                CONSTRAINT fk_cal_perfil FOREIGN KEY (id_perfil)
                                    REFERENCES PERFILES(id_perfil),

                                CONSTRAINT fk_cal_contenido FOREIGN KEY (id_contenido)
                                    REFERENCES CONTENIDO(id_contenido),

                                CONSTRAINT chk_estrellas CHECK (estrellas BETWEEN 1 AND 5)
);
-- =============================================
-- TABLA FAVORITOS
-- =============================================

CREATE TABLE FAVORITOS (
                           id_favorito NUMBER PRIMARY KEY,
                           id_perfil NUMBER NOT NULL,
                           id_contenido NUMBER NOT NULL,
                           fecha_agregado DATE DEFAULT SYSDATE,

                           CONSTRAINT fk_fav_perfil FOREIGN KEY (id_perfil)
                               REFERENCES PERFILES(id_perfil),

                           CONSTRAINT fk_fav_contenido FOREIGN KEY (id_contenido)
                               REFERENCES CONTENIDO(id_contenido)
);

-- SECUENCIAS

CREATE SEQUENCE seq_reproducciones START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_calificaciones START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_favoritos START WITH 1 INCREMENT BY 1;

-- =============================================
-- TRIGGERS
-- =============================================

CREATE OR REPLACE TRIGGER trg_reproducciones
    BEFORE INSERT ON REPRODUCCIONES
    FOR EACH ROW
BEGIN
    IF :NEW.id_reproduccion IS NULL THEN
        :NEW.id_reproduccion := seq_reproducciones.NEXTVAL;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_calificaciones
    BEFORE INSERT ON CALIFICACIONES
    FOR EACH ROW
BEGIN
    IF :NEW.id_calificacion IS NULL THEN
        :NEW.id_calificacion := seq_calificaciones.NEXTVAL;
    END IF;
END;
/

CREATE OR REPLACE TRIGGER trg_favoritos
    BEFORE INSERT ON FAVORITOS
    FOR EACH ROW
BEGIN
    IF :NEW.id_favorito IS NULL THEN
        :NEW.id_favorito := seq_favoritos.NEXTVAL;
    END IF;
END;
/
