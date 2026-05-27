/*
PROYECTO: QUINDIOFLIX
SECCION : DDL
ARCHIVO : 04_administracion_tables.sql
OBJETIVO: Tablas administrativas de departamentos, empleados y reportes
ORIGEN  : ddl\04_administracion_tables.sql
*/
-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 04_administracion_tables.sql
-- OBJETIVO:
--     Crear estructuras administrativas:
--         - DEPARTAMENTOS
--         - EMPLEADOS
--         - REPORTES
-- =========================================================

-- =========================
-- TABLA DEPARTAMENTOS
-- =========================
CREATE TABLE DEPARTAMENTOS (
                               id_departamento NUMBER,
                               nombre_departamento VARCHAR2(100) NOT NULL,
                               id_jefe NUMBER,

                               CONSTRAINT pk_departamentos PRIMARY KEY (id_departamento)
);

CREATE SEQUENCE seq_departamentos START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_departamentos
    BEFORE INSERT ON DEPARTAMENTOS
    FOR EACH ROW
BEGIN
    :NEW.id_departamento := seq_departamentos.NEXTVAL;
END;
/

-- =========================
-- TABLA EMPLEADOS
-- =========================
CREATE TABLE EMPLEADOS (
                           id_empleado NUMBER,
                           nombre_completo VARCHAR2(200) NOT NULL,
                           email VARCHAR2(100) NOT NULL,
                           password VARCHAR2(100),
                           telefono VARCHAR2(20),
                           id_departamento NUMBER,
                           id_supervisor NUMBER,
                           cargo VARCHAR2(100),

                           CONSTRAINT pk_empleados PRIMARY KEY (id_empleado),

                           CONSTRAINT fk_emp_departamento FOREIGN KEY (id_departamento)
                               REFERENCES DEPARTAMENTOS(id_departamento),

                           CONSTRAINT fk_emp_supervisor FOREIGN KEY (id_supervisor)
                               REFERENCES EMPLEADOS(id_empleado),

                           CONSTRAINT uq_emp_email UNIQUE (email)
);

CREATE SEQUENCE seq_empleados START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_empleados
    BEFORE INSERT ON EMPLEADOS
    FOR EACH ROW
BEGIN
    :NEW.id_empleado := seq_empleados.NEXTVAL;
END;
/

-- =========================
-- TABLA REPORTES
-- =========================
CREATE TABLE REPORTES (
                          id_reporte NUMBER,
                          id_perfil_reportante NUMBER NOT NULL,
                          id_contenido NUMBER NOT NULL,
                          descripcion_reporte VARCHAR2(1000),
                          fecha_reporte DATE DEFAULT SYSDATE,
                          estado VARCHAR2(20),
                          id_moderador NUMBER,
                          fecha_resolucion DATE,
                          comentario_resolucion VARCHAR2(1000),

                          CONSTRAINT pk_reportes PRIMARY KEY (id_reporte),

                          CONSTRAINT fk_rep_perfil FOREIGN KEY (id_perfil_reportante)
                              REFERENCES PERFILES(id_perfil),

                          CONSTRAINT fk_rep_contenido FOREIGN KEY (id_contenido)
                              REFERENCES CONTENIDO(id_contenido),

                          CONSTRAINT fk_rep_moderador FOREIGN KEY (id_moderador)
                              REFERENCES USUARIOS(id_usuario),

                          CONSTRAINT chk_estado_reporte CHECK (
                              estado IN ('PENDIENTE','EN_REVISION','RESUELTO')
                              )
);

CREATE SEQUENCE seq_reportes START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_reportes
    BEFORE INSERT ON REPORTES
    FOR EACH ROW
BEGIN
    :NEW.id_reporte := seq_reportes.NEXTVAL;
END;
/
