/* =========================================================
   3.4.2 ANALISIS DE RENDIMIENTO
   CONSULTA PESADA ANTES Y DESPUES DEL INDICE
========================================================= */


/* =========================================================
   PARTE 1 - ANALISIS SIN INDICE
========================================================= */

-- Eliminar indice si existe
DROP INDEX IDX_REPRODUCCIONES_PERFIL_FECHA;

-- Limpiar plan anterior
DELETE FROM PLAN_TABLE;
COMMIT;

-- Generar plan de ejecucion
EXPLAIN PLAN FOR
SELECT *
FROM REPRODUCCIONES
WHERE ID_PERFIL = 17
ORDER BY FECHA_INICIO DESC;

-- Mostrar plan de ejecucion
SELECT *
FROM TABLE(DBMS_XPLAN.DISPLAY);



/* =========================================================
   PARTE 2 - CREACION DEL INDICE
========================================================= */

CREATE INDEX IDX_REPRODUCCIONES_PERFIL_FECHA
    ON REPRODUCCIONES (ID_PERFIL, FECHA_INICIO);



/* =========================================================
   PARTE 3 - ANALISIS CON INDICE
========================================================= */

-- Limpiar plan anterior
DELETE FROM PLAN_TABLE;
COMMIT;

-- Generar nuevamente el plan
EXPLAIN PLAN FOR
SELECT *
FROM REPRODUCCIONES
WHERE ID_PERFIL = 17
ORDER BY FECHA_INICIO DESC;

-- Mostrar plan de ejecucion
SELECT *
FROM TABLE(DBMS_XPLAN.DISPLAY);



/* =========================================================
   MEDICION DE TIEMPO (OPCIONAL)
========================================================= */

SET TIMING ON;

SELECT *
FROM REPRODUCCIONES
WHERE ID_PERFIL = 17
ORDER BY FECHA_INICIO DESC;

SET TIMING OFF;