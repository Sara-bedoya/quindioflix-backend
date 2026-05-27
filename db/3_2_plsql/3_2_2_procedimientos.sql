/*
PROYECTO: QUINDIOFLIX
SECCION : 3.2.2 Procedimientos
ARCHIVO : 3_2_2_procedimientos.sql
OBJETIVO: Procedimientos almacenados del proyecto
ORIGEN  : procedures\01_registro_completo.sql
*/
-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 01_registro_completo.sql
-- OBJETIVO:
--     Registrar:
--         - usuario
--         - perfil inicial
--         - primer pago
--
--     Todo en una sola transacción.
-- =========================================================

CREATE OR REPLACE PROCEDURE sp_registro_completo (

    p_nombre_completo      IN VARCHAR2,
    p_email                IN VARCHAR2,
    p_password             IN VARCHAR2,
    p_telefono             IN VARCHAR2,
    p_fecha_nacimiento     IN DATE,
    p_id_ciudad            IN NUMBER,
    p_id_plan              IN NUMBER,
    p_id_estado            IN NUMBER,

    p_nombre_perfil        IN VARCHAR2,
    p_avatar               IN VARCHAR2,
    p_tipo_perfil          IN VARCHAR2,

    p_monto                IN NUMBER,
    p_metodo_pago          IN VARCHAR2,
    p_estado_pago          IN VARCHAR2

)

AS

    v_id_usuario NUMBER;

BEGIN

    -- =====================================================
    -- INSERTAR USUARIO
    -- =====================================================

    INSERT INTO USUARIOS (

        nombre_completo,
        email,
        password,
        telefono,
        fecha_nacimiento,
        id_ciudad,
        id_plan,
        id_estado

    )

    VALUES (

               p_nombre_completo,
               p_email,
               p_password,
               p_telefono,
               p_fecha_nacimiento,
               p_id_ciudad,
               p_id_plan,
               p_id_estado

           )

    RETURNING id_usuario
    INTO v_id_usuario;


    -- =====================================================
    -- INSERTAR PERFIL
    -- =====================================================

    INSERT INTO PERFILES (

        id_usuario,
        nombre_perfil,
        avatar,
        tipo

    )

    VALUES (

               v_id_usuario,
               p_nombre_perfil,
               p_avatar,
               p_tipo_perfil

           );


-- =====================================================
-- INSERTAR PAGO
-- =====================================================

    INSERT INTO PAGOS (

        id_usuario,
        id_plan,
        monto,
        metodo_pago,
        estado_pago

    )

    VALUES (

               v_id_usuario,
               p_id_plan,
               p_monto,
               p_metodo_pago,
               p_estado_pago

           );


    -- =====================================================
    -- CONFIRMAR TRANSACCION
    -- =====================================================

    COMMIT;


EXCEPTION

    WHEN OTHERS THEN

        ROLLBACK;

        RAISE;

END;
/

-- ================================================
--PRUEBA
-- ================================================
BEGIN

    sp_registro_completo(

            'Laura Gómez',
            'laura@test.com',
            '123456',
            '3001234567',
            TO_DATE('2000-05-10', 'YYYY-MM-DD'),
            1,
            1,
            1,

            'Laura',
            'avatar.png',
            'ADULTO',

            15000,
            'NEQUI',
            'EXITOSO'

    );

END;
/
