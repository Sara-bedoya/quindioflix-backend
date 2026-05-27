/*
=====================================================
GENERADOR AUTOMÁTICO DE CALIFICACIONES
Proyecto QuindioFlix
=====================================================
Genera 60 calificaciones válidas.
=====================================================
*/

DECLARE

    v_perfil NUMBER;
    v_contenido NUMBER;
    v_estrellas NUMBER;
    v_comentario VARCHAR2(500);

BEGIN

    FOR i IN 1..60 LOOP

            -- PERFIL ALEATORIO
            SELECT id_perfil
            INTO v_perfil
            FROM (
                     SELECT id_perfil
                     FROM perfiles
                     ORDER BY DBMS_RANDOM.VALUE
                 )
            WHERE ROWNUM = 1;

            -- CONTENIDO VALIDO SEGUN PERFIL
            SELECT id_contenido
            INTO v_contenido
            FROM (
                     SELECT c.id_contenido
                     FROM contenido c
                              JOIN perfiles p
                                   ON p.id_perfil = v_perfil
                     WHERE
                         p.tipo = 'ADULTO'
                        OR (
                         p.tipo = 'INFANTIL'
                             AND c.clasificacion_edad IN ('TP', '+7', '+13')
                         )
                     ORDER BY DBMS_RANDOM.VALUE
                 )
            WHERE ROWNUM = 1;

            -- ESTRELLAS
            v_estrellas := TRUNC(DBMS_RANDOM.VALUE(1,6));

            -- COMENTARIOS SEGUN CALIFICACION
            v_comentario :=
                    CASE v_estrellas

                        WHEN 1 THEN
                            'No me gusto el contenido.'

                        WHEN 2 THEN
                            'Esperaba algo mejor.'

                        WHEN 3 THEN
                            'Entretenido pero regular.'

                        WHEN 4 THEN
                            'Muy buen contenido.'

                        WHEN 5 THEN
                            'Excelente produccion, recomendado.'

                        END;

            -- INSERT
            INSERT INTO calificaciones (
                id_calificacion,
                id_perfil,
                id_contenido,
                estrellas,
                comentario
            )
            VALUES (
                       seq_calificaciones.NEXTVAL,
                       v_perfil,
                       v_contenido,
                       v_estrellas,
                       v_comentario
                   );

        END LOOP;

    COMMIT;

END;
/