/*
=====================================================
GENERADOR AUTOMÁTICO DE FAVORITOS
Proyecto QuindioFlix
=====================================================
Genera 40 favoritos válidos.
=====================================================
*/

DECLARE

    v_perfil NUMBER;
    v_contenido NUMBER;
    v_fecha DATE;

BEGIN

    FOR i IN 1..40 LOOP

            -- PERFIL ALEATORIO
            SELECT id_perfil
            INTO v_perfil
            FROM (
                     SELECT id_perfil
                     FROM perfiles
                     ORDER BY DBMS_RANDOM.VALUE
                 )
            WHERE ROWNUM = 1;

            -- CONTENIDO SEGUN TIPO PERFIL
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

            -- FECHA
            v_fecha :=
                    TO_DATE('2025-01-01','YYYY-MM-DD')
                        + TRUNC(DBMS_RANDOM.VALUE(1,500));

            -- INSERT
            INSERT INTO favoritos (
                id_favorito,
                id_perfil,
                id_contenido,
                fecha_agregado
            )
            VALUES (
                       seq_favoritos.NEXTVAL,
                       v_perfil,
                       v_contenido,
                       v_fecha
                   );

        END LOOP;

    COMMIT;

END;
/