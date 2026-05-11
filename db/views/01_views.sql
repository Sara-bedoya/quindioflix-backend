-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 01_views.sql
-- OBJETIVO:
--     Crear vistas para:
--         - analítica
--         - reportes
--         - dashboards
--         - recomendaciones
-- =========================================================

-- =========================================================
-- VISTA: CONTENIDO POPULAR
--
-- OBJETIVO:
--     Mostrar el contenido con mayor consumo.
-- =========================================================

CREATE OR REPLACE VIEW vw_contenido_popular AS

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
-- VISTA: INGRESOS POR PLAN
-- =========================================================

CREATE OR REPLACE VIEW vw_ingresos_plan AS

SELECT

    pl.nombre AS plan,

    COUNT(pg.id_pago) AS total_pagos,

    SUM(pg.monto) AS ingresos_totales

FROM PAGOS pg

         JOIN PLANES pl
              ON pg.id_plan = pl.id_plan

GROUP BY pl.nombre;

-- =========================================================
-- VISTA: CONSUMO POR DISPOSITIVO
-- =========================================================

CREATE OR REPLACE VIEW vw_consumo_dispositivo AS

SELECT

    dispositivo,

    COUNT(id_reproduccion) AS total_reproducciones

FROM REPRODUCCIONES

GROUP BY dispositivo;

-- =========================================================
-- VISTA: CONSUMO POR CIUDAD
-- =========================================================

CREATE OR REPLACE VIEW vw_consumo_ciudad AS

SELECT

    ci.nombre_ciudad,

    COUNT(r.id_reproduccion) AS total_reproducciones

FROM REPRODUCCIONES r

         JOIN PERFILES p
              ON r.id_perfil = p.id_perfil

         JOIN USUARIOS u
              ON p.id_usuario = u.id_usuario

         JOIN CIUDADES ci
              ON u.id_ciudad = ci.id_ciudad

GROUP BY ci.nombre_ciudad;

-- =========================================================
-- VISTA: REPORTES PENDIENTES
-- =========================================================

CREATE OR REPLACE VIEW vw_reportes_pendientes AS

SELECT

    r.id_reporte,

    c.titulo,

    r.descripcion_reporte,

    r.fecha_reporte,

    r.estado

FROM REPORTES r

         JOIN CONTENIDO c
              ON r.id_contenido = c.id_contenido

WHERE r.estado = 'PENDIENTE';