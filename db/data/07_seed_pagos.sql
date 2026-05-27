/*
PROYECTO: QUINDIOFLIX
SECCION : DATA 07
ARCHIVO : 07_seed_pagos.sql
OBJETIVO: Datos y ajustes semilla de pagos
ORIGEN  : dml\02_fix_pagos_data.sql
*/
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

/*
=====================================================
GENERADOR AUTOMÁTICO DE PAGOS
Proyecto QuindioFlix
=====================================================
Genera 80 pagos realistas.
=====================================================
*/

DECLARE

    v_usuario NUMBER;
    v_plan NUMBER;
    v_monto NUMBER(10,2);
    v_metodo VARCHAR2(50);
    v_estado VARCHAR2(20);
    v_fecha DATE;

BEGIN

    FOR i IN 1..80 LOOP

            -- USUARIO ALEATORIO
            SELECT id_usuario, id_plan
            INTO v_usuario, v_plan
            FROM (
                     SELECT id_usuario, id_plan
                     FROM usuarios
                     ORDER BY DBMS_RANDOM.VALUE
                 )
            WHERE ROWNUM = 1;

            -- MONTO SEGUN PLAN
            v_monto :=
                    CASE v_plan
                        WHEN 1 THEN 15000
                        WHEN 3 THEN 25000
                        WHEN 4 THEN 35000
                        END;

            -- METODO DE PAGO
            v_metodo :=
                    CASE TRUNC(DBMS_RANDOM.VALUE(1,6))
                        WHEN 1 THEN 'TARJETA_CREDITO'
                        WHEN 2 THEN 'TARJETA_DEBITO'
                        WHEN 3 THEN 'PSE'
                        WHEN 4 THEN 'NEQUI'
                        ELSE 'DAVIPLATA'
                        END;

            -- ESTADO DEL PAGO
            v_estado :=
                    CASE TRUNC(DBMS_RANDOM.VALUE(1,11))

                        WHEN 1 THEN 'FALLIDO'
                        WHEN 2 THEN 'PENDIENTE'
                        WHEN 3 THEN 'REEMBOLSADO'

                        ELSE 'EXITOSO'

                        END;

            -- FECHAS ENTRE 2025 Y 2026
            v_fecha :=
                    TO_DATE('2025-01-01','YYYY-MM-DD')
                        + TRUNC(DBMS_RANDOM.VALUE(1,500));

            -- INSERT
            INSERT INTO pagos (
                id_pago,
                id_usuario,
                id_plan,
                fecha_pago,
                monto,
                metodo_pago,
                estado_pago
            )
            VALUES (
                       seq_pagos.NEXTVAL,
                       v_usuario,
                       v_plan,
                       v_fecha,
                       v_monto,
                       v_metodo,
                       v_estado
                   );

        END LOOP;

    COMMIT;

END;
/