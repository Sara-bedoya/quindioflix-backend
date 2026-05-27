/*
=====================================================
3.1.2.a PIVOT
Usuarios activos por ciudad y plan
Proyecto QuindioFlix
=====================================================
*/

SELECT *
FROM (

    SELECT

        c.nombre_ciudad,
        p.nombre AS plan_suscripcion,
        u.id_usuario

    FROM usuarios u

             JOIN ciudades c
                  ON u.id_ciudad = c.id_ciudad

             JOIN planes p
                  ON u.id_plan = p.id_plan

    WHERE u.id_estado = 1

)

    PIVOT (

    COUNT(id_usuario)

    FOR plan_suscripcion IN (

        'Básico' AS BASICO,
        'Estándar' AS ESTANDAR,
        'Premium' AS PREMIUM

        )

    )

ORDER BY nombre_ciudad;

/*
=====================================================
3.1.2.b PIVOT
Reproducciones por categoria y dispositivo
Proyecto QuindioFlix
=====================================================
*/

SELECT *
FROM (

    SELECT

        cat.nombre_categoria,
        r.dispositivo,
        r.id_reproduccion

    FROM reproducciones r

             JOIN contenido c
                  ON r.id_contenido = c.id_contenido

             JOIN categorias cat
                  ON c.id_categoria = cat.id_categoria

)

    PIVOT (

    COUNT(id_reproduccion)

    FOR dispositivo IN (

        'CELULAR' AS CELULAR,
        'TABLET' AS TABLET,
        'TV' AS TV,
        'COMPUTADOR' AS COMPUTADOR

        )

    )

ORDER BY nombre_categoria;