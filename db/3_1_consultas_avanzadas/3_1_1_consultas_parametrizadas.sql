/*
PROYECTO: QUINDIOFLIX
SECCION : 3.1.1 Consultas parametrizadas
OBJETIVO: Consultas avanzadas con parametros de SQL*Plus
ORIGEN  : queries\01_parametrized_queries.sql
*/
-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 01_parametrized_queries.sql
-- OBJETIVO:
--     Crear consultas parametrizadas usando:
--         - &
--         - &&
--         - DEFINE
-- =========================================================

-- =========================================================
-- CONSULTA 1
-- TOP 10 CONTENIDO MAS REPRODUCIDO POR CIUDAD
-- =========================================================

SELECT *

FROM (

         SELECT

             c.titulo,

             COUNT(r.id_reproduccion) AS total_reproducciones

         FROM REPRODUCCIONES r

                  JOIN PERFILES p
                       ON r.id_perfil = p.id_perfil

                  JOIN USUARIOS u
                       ON p.id_usuario = u.id_usuario

                  JOIN CIUDADES ci
                       ON u.id_ciudad = ci.id_ciudad

                  JOIN CONTENIDO c
                       ON r.id_contenido = c.id_contenido

         WHERE UPPER(ci.nombre_ciudad) = UPPER('&ciudad')

         GROUP BY c.titulo

         ORDER BY total_reproducciones DESC

     )

WHERE ROWNUM <= 10;

-- =========================================================
-- CONSULTA 2
-- INGRESOS POR PLAN EN UN PERIODO
-- =========================================================

SELECT

    pl.nombre AS plan,

    COUNT(pg.id_pago) AS total_pagos,

    SUM(pg.monto) AS ingresos_totales

FROM PAGOS pg

         JOIN PLANES pl
              ON pg.id_plan = pl.id_plan

WHERE EXTRACT(MONTH FROM pg.fecha_pago) = &mes
  AND EXTRACT(YEAR FROM pg.fecha_pago) = &anio

GROUP BY pl.nombre

ORDER BY ingresos_totales DESC;

-- =========================================================
-- CONSULTA 3
-- CALIFICACION PROMEDIO POR GENERO
-- =========================================================

SELECT

    cat.nombre_categoria,

    ROUND(AVG(cal.estrellas), 2) AS promedio_calificacion

FROM CALIFICACIONES cal

         JOIN CONTENIDO c
              ON cal.id_contenido = c.id_contenido

         JOIN CATEGORIAS cat
              ON c.id_categoria = cat.id_categoria

         JOIN CONTENIDO_GENERO cg
              ON c.id_contenido = cg.id_contenido

         JOIN GENEROS g
              ON cg.id_genero = g.id_genero

WHERE UPPER(g.nombre_genero) = UPPER('&genero')

GROUP BY cat.nombre_categoria

ORDER BY promedio_calificacion DESC;