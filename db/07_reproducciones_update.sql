-- =============================================
-- AJUSTES TABLA REPRODUCCIONES
-- =============================================

ALTER TABLE REPRODUCCIONES ADD (
    dispositivo VARCHAR2(20),
    id_episodio NUMBER
    );

-- =============================================
-- FK HACIA EPISODIOS
-- =============================================

ALTER TABLE REPRODUCCIONES ADD CONSTRAINT fk_reproduccion_episodio
    FOREIGN KEY (id_episodio)
        REFERENCES EPISODIOS(id_episodio);

-- =============================================
-- VALIDACION DE DISPOSITIVO
-- =============================================

ALTER TABLE REPRODUCCIONES ADD CONSTRAINT chk_dispositivo
    CHECK (dispositivo IN ('CELULAR', 'TABLET', 'TV', 'COMPUTADOR'));
    
DESC REPRODUCCIONES;
SELECT * FROM reproducciones;