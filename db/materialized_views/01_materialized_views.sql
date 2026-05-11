-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 01_materialized_views.sql
-- OBJETIVO:
--     Crear materialized views para optimizar:
--         - analytics
--         - rankings
--         - dashboards
--         - reportes administrativos
-- =========================================================

-- =========================================================
-- MATERIALIZED VIEW:
--     CONTENIDO POPULAR
-- =========================================================

CREATE MATERIALIZED VIEW mv_contenido_popular

            BUILD IMMEDIATE
    REFRESH COMPLETE
        ON DEMAND

AS

SELECT

    c.id_contenido,

    c.titulo,

    c.popularidad,

    COUNT(r.id_reproduccion) AS total_reproducciones

FROM CONTENIDO c

         LEFT JOIN REPRODUCCIONES r
                   ON c.id_contenido = r.id_contenido

GROUP BY
    c.id_contenido,
    c.titulo,
    c.popularidad;

-- =========================================================
-- MATERIALIZED VIEW:
--     INGRESOS POR PLAN
-- =========================================================

CREATE MATERIALIZED VIEW mv_ingresos_plan

            BUILD IMMEDIATE
    REFRESH COMPLETE
        ON DEMAND

AS

SELECT

    pl.nombre AS plan,

    COUNT(pg.id_pago) AS total_pagos,

    SUM(pg.monto) AS ingresos_totales

FROM PAGOS pg

         JOIN PLANES pl
              ON pg.id_plan = pl.id_plan

GROUP BY pl.nombre;

-- =========================================================
-- MATERIALIZED VIEW:
--     CONSUMO POR DISPOSITIVO
-- =========================================================

CREATE MATERIALIZED VIEW mv_consumo_dispositivo

            BUILD IMMEDIATE
    REFRESH COMPLETE
        ON DEMAND

AS

SELECT

    dispositivo,

    COUNT(id_reproduccion) AS total_reproducciones

FROM REPRODUCCIONES

GROUP BY dispositivo;

-- ===========================================================
-- REFRESCAR
-- ===========================================================
BEGIN

    DBMS_MVIEW.REFRESH('MV_CONTENIDO_POPULAR');

    DBMS_MVIEW.REFRESH('MV_INGRESOS_PLAN');

    DBMS_MVIEW.REFRESH('MV_CONSUMO_DISPOSITIVO');

END;
/