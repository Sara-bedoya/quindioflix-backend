-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 07_pagos_constraints.sql
-- OBJETIVO:
--     Agregar restricciones de integridad
--     para métodos y estados de pago.
-- =========================================================


-- =========================================================
-- CONSTRAINT: METODO DE PAGO
-- =========================================================

ALTER TABLE PAGOS ADD CONSTRAINT chk_metodo_pago
    CHECK (
        metodo_pago IN (
                        'TARJETA_CREDITO',
                        'TARJETA_DEBITO',
                        'PSE',
                        'NEQUI',
                        'DAVIPLATA'
            )
        );


-- =========================================================
-- CONSTRAINT: ESTADO DE PAGO
-- =========================================================

ALTER TABLE PAGOS ADD CONSTRAINT chk_pagos_estado_pago
    CHECK (
        estado_pago IN (
                        'EXITOSO',
                        'FALLIDO',
                        'PENDIENTE',
                        'REEMBOLSADO'
            )
        );