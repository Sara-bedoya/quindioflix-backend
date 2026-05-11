-- =============================================
-- AJUSTE TABLA PLANES
-- =============================================

ALTER TABLE PLANES ADD (
    max_perfiles NUMBER DEFAULT 1
    );

UPDATE PLANES
SET max_perfiles = 1
WHERE nombre = 'Básico';

UPDATE PLANES
SET max_perfiles = 2
WHERE nombre = 'Estándar';

UPDATE PLANES
SET max_perfiles = 4
WHERE nombre = 'Premium';

COMMIT;