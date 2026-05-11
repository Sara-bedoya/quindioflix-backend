-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 02_fix_pagos_data.sql
-- OBJETIVO:
--     Normalizar datos antiguos de pagos.
-- =========================================================


-- =========================================================
-- NORMALIZAR METODOS DE PAGO
-- =========================================================

UPDATE PAGOS
SET metodo_pago = 'TARJETA_CREDITO'
WHERE metodo_pago = 'Tarjeta';


-- =========================================================
-- NORMALIZAR ESTADOS
-- =========================================================

UPDATE PAGOS
SET estado_pago = TRIM(UPPER(estado_pago));


UPDATE PAGOS
SET estado_pago = 'EXITOSO'
WHERE estado_pago = 'COMPLETADO';


COMMIT;