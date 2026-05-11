-- =============================================
-- RESTRICCIONES PAGOS
-- =============================================

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

ALTER TABLE PAGOS ADD CONSTRAINT chk_estado_pago
    CHECK (
        estado_pago IN (
                        'EXITOSO',
                        'FALLIDO',
                        'PENDIENTE',
                        'REEMBOLSADO'
            )
        );
    
SELECT DISTINCT metodo_pago
FROM PAGOS;

SELECT DISTINCT estado_pago
FROM PAGOS;

UPDATE PAGOS
SET metodo_pago = 'TARJETA_CREDITO'
WHERE metodo_pago = 'Tarjeta';

UPDATE PAGOS
SET estado_pago = 'EXITOSO'
WHERE estado_pago = 'COMPLETADO';

COMMIT;

ALTER TABLE PAGOS ADD CONSTRAINT chk_pagos_estado_pago
CHECK (
    estado_pago IN (
        'EXITOSO',
        'FALLIDO',
        'PENDIENTE',
        'REEMBOLSADO'
    )
);
UPDATE PAGOS
SET estado_pago = TRIM(UPPER(estado_pago));

UPDATE PAGOS
SET estado_pago = 'EXITOSO'
WHERE estado_pago = 'COMPLETADO';

COMMIT;

SELECT constraint_name, search_condition
FROM user_constraints
WHERE table_name = 'PAGOS'
AND constraint_type = 'C';

ALTER TABLE PAGOS
DROP CONSTRAINT CHK_ESTADO_PAGO;

UPDATE PAGOS
SET estado_pago = 'EXITOSO'
WHERE estado_pago = 'COMPLETADO';

COMMIT;

SELECT * FROM PAGOS;
SELECT * FROM PLANES;