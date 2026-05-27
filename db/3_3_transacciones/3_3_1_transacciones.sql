/*
=====================================================
3.3.1.a
TRANSACCION REGISTRO COMPLETO
Proyecto QuindioFlix
=====================================================
*/

SET SERVEROUTPUT ON;

DECLARE

v_id_usuario NUMBER;
    v_id_perfil NUMBER;

BEGIN

    DBMS_OUTPUT.PUT_LINE(
        '=== INICIO TRANSACCION REGISTRO ==='
    );

    -------------------------------------------------
    -- ESTADO: ACTIVA
    -------------------------------------------------

INSERT INTO usuarios (

    id_usuario,
    nombre_completo,
    email,
    telefono,
    fecha_nacimiento,
    id_ciudad,
    id_plan,
    id_estado,
    fecha_registro,
    es_moderador,
    password

)
VALUES (

           seq_usuarios.NEXTVAL,
           'Usuario Transaccion',
           'transaccion@test.com',
           '3000000000',
           TO_DATE('2000-01-01','YYYY-MM-DD'),
           1,
           1,
           1,
           SYSDATE,
           'N',
           '123456'

       )

    RETURNING id_usuario INTO v_id_usuario;

DBMS_OUTPUT.PUT_LINE(
        'Usuario creado'
    );

    -------------------------------------------------
    -- CREAR PERFIL
    -------------------------------------------------

INSERT INTO perfiles (

    id_perfil,
    id_usuario,
    nombre_perfil,
    avatar,
    tipo

)
VALUES (

           seq_perfiles.NEXTVAL,
           v_id_usuario,
           'Mi Perfil',
           'default.png',
           'ADULTO'

       )

    RETURNING id_perfil INTO v_id_perfil;

DBMS_OUTPUT.PUT_LINE(
        'Perfil creado'
    );

    -------------------------------------------------
    -- REGISTRAR PAGO
    -------------------------------------------------

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
           v_id_usuario,
           1,
           SYSDATE,
           15000,
           'TARJETA',
           'EXITOSO'

       );

DBMS_OUTPUT.PUT_LINE(
        'Pago registrado'
    );

    -------------------------------------------------
    -- ESTADO: PARCIALMENTE CONFIRMADA
    -------------------------------------------------

COMMIT;

-------------------------------------------------
-- ESTADO: CONFIRMADA
-------------------------------------------------

DBMS_OUTPUT.PUT_LINE(
        'TRANSACCION CONFIRMADA'
    );

EXCEPTION

    WHEN OTHERS THEN

        -------------------------------------------------
        -- ESTADO: FALLIDA
        -------------------------------------------------

        DBMS_OUTPUT.PUT_LINE(
            'ERROR: ' || SQLERRM
        );

ROLLBACK;

-------------------------------------------------
-- ESTADO: ABORTADA
-------------------------------------------------

DBMS_OUTPUT.PUT_LINE(
            'TRANSACCION REVERTIDA'
        );

END;
/
/*
=====================================================
3.3.1.b
RENOVACION MENSUAL
Proyecto QuindioFlix
=====================================================
*/

SET SERVEROUTPUT ON;

DECLARE

CURSOR cursor_usuarios IS

SELECT
    u.id_usuario,
    u.id_plan,
    p.precio_mensual
FROM usuarios u
         JOIN planes p
              ON u.id_plan = p.id_plan
WHERE u.id_estado = 1;

BEGIN

    DBMS_OUTPUT.PUT_LINE(
        '=== INICIO RENOVACIONES ==='
    );

FOR usuario_rec IN cursor_usuarios LOOP

        SAVEPOINT inicio_usuario;

BEGIN

            -------------------------------------------------
            -- ESTADO: ACTIVA
            -------------------------------------------------

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
           usuario_rec.id_usuario,
           usuario_rec.id_plan,
           SYSDATE,
           usuario_rec.precio_mensual,
           'TARJETA',
           'EXITOSO'

       );

DBMS_OUTPUT.PUT_LINE(
                'Pago registrado usuario '
                || usuario_rec.id_usuario
            );

            -------------------------------------------------
            -- ESTADO: PARCIALMENTE CONFIRMADA
            -------------------------------------------------

EXCEPTION

            WHEN OTHERS THEN

                -------------------------------------------------
                -- ESTADO: FALLIDA
                -------------------------------------------------

                DBMS_OUTPUT.PUT_LINE(
                    'Error usuario '
                    || usuario_rec.id_usuario
                );

ROLLBACK TO inicio_usuario;

-------------------------------------------------
-- ESTADO: ABORTADA
-------------------------------------------------

DBMS_OUTPUT.PUT_LINE(
                    'Rollback usuario '
                    || usuario_rec.id_usuario
                );

END;

END LOOP;

COMMIT;

-------------------------------------------------
-- ESTADO: CONFIRMADA
-------------------------------------------------

DBMS_OUTPUT.PUT_LINE(
        'RENOVACIONES COMPLETADAS'
    );

END;
/

/*
=====================================================
3.3.1.c
ELIMINACION DE CUENTA
Proyecto QuindioFlix
=====================================================
*/

SET SERVEROUTPUT ON;

DECLARE

v_usuario NUMBER := 81;

BEGIN

    DBMS_OUTPUT.PUT_LINE(
        '=== INICIO ELIMINACION ==='
    );

    -------------------------------------------------
    -- ESTADO: ACTIVA
    -------------------------------------------------

DELETE FROM calificaciones
WHERE id_perfil IN (

    SELECT id_perfil
    FROM perfiles
    WHERE id_usuario = v_usuario

);

DELETE FROM favoritos
WHERE id_perfil IN (

    SELECT id_perfil
    FROM perfiles
    WHERE id_usuario = v_usuario

);

DELETE FROM reproducciones
WHERE id_perfil IN (

    SELECT id_perfil
    FROM perfiles
    WHERE id_usuario = v_usuario

);

DELETE FROM perfiles
WHERE id_usuario = v_usuario;

DELETE FROM pagos
WHERE id_usuario = v_usuario;

DELETE FROM usuarios
WHERE id_usuario = v_usuario;

-------------------------------------------------
-- ESTADO: PARCIALMENTE CONFIRMADA
-------------------------------------------------

COMMIT;

-------------------------------------------------
-- ESTADO: CONFIRMADA
-------------------------------------------------

DBMS_OUTPUT.PUT_LINE(
        'CUENTA ELIMINADA'
    );

EXCEPTION

    WHEN OTHERS THEN

        -------------------------------------------------
        -- ESTADO: FALLIDA
        -------------------------------------------------

        DBMS_OUTPUT.PUT_LINE(
            'ERROR: ' || SQLERRM
        );

ROLLBACK;

-------------------------------------------------
-- ESTADO: ABORTADA
-------------------------------------------------

DBMS_OUTPUT.PUT_LINE(
            'TRANSACCION REVERTIDA'
        );

END;
/