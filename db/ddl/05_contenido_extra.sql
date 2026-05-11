-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 05_contenido_extra.sql
-- OBJETIVO:
--     Agregar campos avanzados a CONTENIDO:
--         - empleado responsable
--         - popularidad
-- =========================================================


-- =========================================================
-- ALTER TABLE: CONTENIDO
-- =========================================================

ALTER TABLE CONTENIDO ADD (

    id_empleado_responsable NUMBER,

    popularidad NUMBER DEFAULT 0
    );


-- =========================================================
-- FK: CONTENIDO -> EMPLEADOS
-- =========================================================

ALTER TABLE CONTENIDO ADD CONSTRAINT fk_contenido_empleado
    FOREIGN KEY (id_empleado_responsable)
        REFERENCES EMPLEADOS(id_empleado);