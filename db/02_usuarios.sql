-- =============================================
-- 02_usuarios.sql
-- Conexión: quindioflix
-- =============================================

-- =========================
-- TABLA USUARIOS
-- =========================
CREATE TABLE USUARIOS (
                          id_usuario NUMBER,
                          nombre_completo VARCHAR2(200) NOT NULL,
                          email VARCHAR2(100) NOT NULL,
                          telefono VARCHAR2(20),
                          fecha_nacimiento DATE,
                          id_ciudad NUMBER,
                          id_plan NUMBER,
                          id_estado NUMBER,
                          fecha_registro DATE DEFAULT SYSDATE,
                          fecha_ultimo_pago DATE,
                          es_moderador CHAR(1) DEFAULT 'N',

                          CONSTRAINT pk_usuarios PRIMARY KEY (id_usuario),
                          CONSTRAINT uq_usuario_email UNIQUE (email),

                          CONSTRAINT fk_usuario_ciudad FOREIGN KEY (id_ciudad)
                              REFERENCES CIUDADES(id_ciudad),

                          CONSTRAINT fk_usuario_plan FOREIGN KEY (id_plan)
                              REFERENCES PLANES(id_plan),

                          CONSTRAINT fk_usuario_estado FOREIGN KEY (id_estado)
                              REFERENCES ESTADOS_CUENTA(id_estado),

                          CONSTRAINT chk_es_moderador CHECK (es_moderador IN ('S','N'))
);

CREATE SEQUENCE seq_usuarios START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_usuarios
    BEFORE INSERT ON USUARIOS
    FOR EACH ROW
BEGIN
    :NEW.id_usuario := seq_usuarios.NEXTVAL;
END;
/

-- =========================
-- TABLA PERFILES
-- =========================
CREATE TABLE PERFILES (
                          id_perfil NUMBER,
                          id_usuario NUMBER NOT NULL,
                          nombre_perfil VARCHAR2(100) NOT NULL,
                          avatar VARCHAR2(200),
                          tipo VARCHAR2(10) DEFAULT 'ADULTO',

                          CONSTRAINT pk_perfiles PRIMARY KEY (id_perfil),

                          CONSTRAINT fk_perfil_usuario FOREIGN KEY (id_usuario)
                              REFERENCES USUARIOS(id_usuario),

                          CONSTRAINT chk_tipo_perfil CHECK (tipo IN ('ADULTO','INFANTIL'))
);

CREATE SEQUENCE seq_perfiles START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_perfiles
    BEFORE INSERT ON PERFILES
    FOR EACH ROW
BEGIN
    :NEW.id_perfil := seq_perfiles.NEXTVAL;
END;
/

-- =========================
-- TABLA REFERIDOS
-- =========================
CREATE TABLE REFERIDOS (
                           id_referido NUMBER,
                           id_usuario_referidor NUMBER NOT NULL,
                           id_usuario_referido NUMBER NOT NULL,
                           fecha_referido DATE DEFAULT SYSDATE,
                           estado VARCHAR2(20),

                           CONSTRAINT pk_referidos PRIMARY KEY (id_referido),

                           CONSTRAINT fk_ref_referidor FOREIGN KEY (id_usuario_referidor)
                               REFERENCES USUARIOS(id_usuario),

                           CONSTRAINT fk_ref_referido FOREIGN KEY (id_usuario_referido)
                               REFERENCES USUARIOS(id_usuario),

                           CONSTRAINT uq_referido UNIQUE (id_usuario_referidor, id_usuario_referido)
);

CREATE SEQUENCE seq_referidos START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_referidos
    BEFORE INSERT ON REFERIDOS
    FOR EACH ROW
BEGIN
    :NEW.id_referido := seq_referidos.NEXTVAL;
END;
/

-- =========================
-- TABLA PAGOS
-- =========================
CREATE TABLE PAGOS (
                       id_pago NUMBER,
                       id_usuario NUMBER NOT NULL,
                       id_plan NUMBER NOT NULL,
                       fecha_pago DATE DEFAULT SYSDATE,
                       monto NUMBER(10,2) NOT NULL,
                       metodo_pago VARCHAR2(50),
                       estado_pago VARCHAR2(20),

                       CONSTRAINT pk_pagos PRIMARY KEY (id_pago),

                       CONSTRAINT fk_pago_usuario FOREIGN KEY (id_usuario)
                           REFERENCES USUARIOS(id_usuario),

                       CONSTRAINT fk_pago_plan FOREIGN KEY (id_plan)
                           REFERENCES PLANES(id_plan),

                       CONSTRAINT chk_estado_pago CHECK (
                           estado_pago IN ('COMPLETADO','PENDIENTE','FALLIDO')
                           )
);

CREATE SEQUENCE seq_pagos START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER trg_pagos
    BEFORE INSERT ON PAGOS
    FOR EACH ROW
BEGIN
    :NEW.id_pago := seq_pagos.NEXTVAL;
END;
/

