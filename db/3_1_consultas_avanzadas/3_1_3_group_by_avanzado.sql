/*
=====================================================
3.1.3.a ROLLUP
Ingresos por ciudad y plan
Proyecto QuindioFlix
=====================================================
*/

SELECT

    NVL(c.nombre_ciudad, 'TOTAL GENERAL') AS ciudad,

    NVL(p.nombre, 'SUBTOTAL CIUDAD') AS plan_suscripcion,

    SUM(pa.monto) AS total_ingresos

FROM pagos pa

         JOIN usuarios u
              ON pa.id_usuario = u.id_usuario

         JOIN ciudades c
              ON u.id_ciudad = c.id_ciudad

         JOIN planes p
              ON pa.id_plan = p.id_plan

WHERE pa.estado_pago = 'EXITOSO'

GROUP BY ROLLUP(
    c.nombre_ciudad,
    p.nombre
    )

ORDER BY
    c.nombre_ciudad,
    p.nombre;

/*
=====================================================
3.1.3.b CUBE
Reproducciones por categoria y dispositivo
Proyecto QuindioFlix
=====================================================
*/

SELECT

    NVL(cat.nombre_categoria, 'TOTAL GENERAL') AS categoria,

    NVL(r.dispositivo, 'TODOS LOS DISPOSITIVOS') AS dispositivo,

    COUNT(r.id_reproduccion) AS total_reproducciones

FROM reproducciones r

         JOIN contenido c
              ON r.id_contenido = c.id_contenido

         JOIN categorias cat
              ON c.id_categoria = cat.id_categoria

GROUP BY CUBE(
    cat.nombre_categoria,
    r.dispositivo
    )

ORDER BY
    cat.nombre_categoria,
    r.dispositivo;

/*
=====================================================
3.1.3.d GROUPING SETS
Totales por categoria y ciudad
Proyecto QuindioFlix
=====================================================
*/

SELECT

    cat.nombre_categoria,
    c.nombre_ciudad,

    COUNT(r.id_reproduccion) AS total_reproducciones

FROM reproducciones r

         JOIN perfiles p
              ON r.id_perfil = p.id_perfil

         JOIN usuarios u
              ON p.id_usuario = u.id_usuario

         JOIN ciudades c
              ON u.id_ciudad = c.id_ciudad

         JOIN contenido co
              ON r.id_contenido = co.id_contenido

         JOIN categorias cat
              ON co.id_categoria = cat.id_categoria

GROUP BY GROUPING SETS (

    (cat.nombre_categoria),
    (c.nombre_ciudad)

    )

ORDER BY
    cat.nombre_categoria,
    c.nombre_ciudad;