/* =========================================================
   3.2.5 DISPARADORES (TRIGGERS)
   Proyecto: QuindioFlix
========================================================= */



/* =========================================================
   TRIGGER A
   Verificar cuenta activa en REPRODUCCIONES
========================================================= */

CREATE OR REPLACE TRIGGER TRG_VALIDAR_CUENTA_ACTIVA
BEFORE INSERT ON REPRODUCCIONES
FOR EACH ROW
DECLARE

V_ESTADO VARCHAR2(20);

BEGIN

SELECT E.NOMBRE_ESTADO
INTO V_ESTADO
FROM PERFILES P
         JOIN USUARIOS U
              ON P.ID_USUARIO = U.ID_USUARIO
         JOIN ESTADOS_CUENTA E
              ON U.ID_ESTADO = E.ID_ESTADO
WHERE P.ID_PERFIL = :NEW.ID_PERFIL;

IF UPPER(V_ESTADO) <> 'ACTIVO' THEN
        RAISE_APPLICATION_ERROR(
            -20001,
            'La cuenta del usuario no esta activa'
        );
END IF;

END;
/




/* =========================================================
   TRIGGER B
   Validar maximo de perfiles segun el plan
========================================================= */

CREATE OR REPLACE TRIGGER TRG_VALIDAR_MAX_PERFILES
BEFORE INSERT ON PERFILES
FOR EACH ROW
DECLARE

V_TOTAL_PERFILES NUMBER;
    V_MAX_PERFILES NUMBER;

BEGIN

    -- Obtener cantidad actual de perfiles
SELECT COUNT(*)
INTO V_TOTAL_PERFILES
FROM PERFILES
WHERE ID_USUARIO = :NEW.ID_USUARIO;

-- Obtener limite segun el plan
SELECT PL.MAX_PERFILES
INTO V_MAX_PERFILES
FROM USUARIOS U
         JOIN PLANES PL
              ON U.ID_PLAN = PL.ID_PLAN
WHERE U.ID_USUARIO = :NEW.ID_USUARIO;

-- Validar limite
IF V_TOTAL_PERFILES >= V_MAX_PERFILES THEN

        RAISE_APPLICATION_ERROR(
            -20002,
            'El usuario excede el maximo de perfiles permitidos'
        );

END IF;

END;
/




/* =========================================================
   TRIGGER C
   Verificar reproduccion minima para calificar
========================================================= */

CREATE OR REPLACE TRIGGER TRG_VALIDAR_CALIFICACION
BEFORE INSERT ON CALIFICACIONES
FOR EACH ROW
DECLARE

V_REPRODUCCION NUMBER;

BEGIN

SELECT COUNT(*)
INTO V_REPRODUCCION
FROM REPRODUCCIONES
WHERE ID_PERFIL = :NEW.ID_PERFIL
  AND ID_CONTENIDO = :NEW.ID_CONTENIDO
  AND PORCENTAJE_VISTO >= 50;

IF V_REPRODUCCION = 0 THEN

        RAISE_APPLICATION_ERROR(
            -20003,
            'El perfil debe ver al menos el 50% del contenido antes de calificar'
        );

END IF;

END;
/




/* =========================================================
   TRIGGER D
   Actualizar estado y fecha despues de pago exitoso
========================================================= */

CREATE OR REPLACE TRIGGER TRG_ACTUALIZAR_ESTADO_PAGO
AFTER INSERT ON PAGOS
DECLARE
BEGIN

UPDATE USUARIOS
SET
    ID_ESTADO = (
        SELECT ID_ESTADO
        FROM ESTADOS_CUENTA
        WHERE UPPER(NOMBRE_ESTADO) = 'ACTIVO'
    ),
    FECHA_ULTIMO_PAGO = SYSDATE
WHERE ID_USUARIO IN (
    SELECT ID_USUARIO
    FROM PAGOS
    WHERE UPPER(ESTADO_PAGO) = 'EXITOSO'
);

END;
/




/* =========================================================
   PRUEBAS DE FUNCIONAMIENTO
========================================================= */


------------------------------------------------------------
-- PRUEBA TRIGGER A
------------------------------------------------------------

INSERT INTO REPRODUCCIONES (
    ID_REPRODUCCION,
    ID_PERFIL,
    ID_CONTENIDO,
    FECHA_INICIO,
    FECHA_FIN,
    PORCENTAJE_VISTO,
    DISPOSITIVO
)
VALUES (
    SEQ_REPRODUCCIONES.NEXTVAL,
    1,
    21,
    SYSTIMESTAMP,
    SYSTIMESTAMP + INTERVAL '2' HOUR,
    80,
    'TV'
);



------------------------------------------------------------
-- PRUEBA TRIGGER B
------------------------------------------------------------

INSERT INTO PERFILES (
    ID_PERFIL,
    ID_USUARIO,
    NOMBRE_PERFIL,
    AVATAR,
    TIPO
)
VALUES (
           SEQ_PERFILES.NEXTVAL,
           1,
           'Perfil Extra',
           'default.png',
           'ADULTO'
       );

-- Debe mostrar:
-- ORA-20002: El usuario excede el maximo de perfiles permitidos



------------------------------------------------------------
-- PRUEBA TRIGGER C
------------------------------------------------------------

INSERT INTO CALIFICACIONES (
    ID_CALIFICACION,
    ID_PERFIL,
    ID_CONTENIDO,
    ESTRELLAS,
    COMENTARIO
)
VALUES (
           SEQ_CALIFICACIONES.NEXTVAL,
           1,
           30,
           5,
           'Excelente contenido'
       );

-- Debe mostrar:
-- ORA-20003



------------------------------------------------------------
-- PRUEBA TRIGGER D
------------------------------------------------------------

INSERT INTO PAGOS (
    ID_PAGO,
    ID_USUARIO,
    ID_PLAN,
    FECHA_PAGO,
    MONTO,
    METODO_PAGO,
    ESTADO_PAGO
)
VALUES (
           SEQ_PAGOS.NEXTVAL,
           1,
           4,
           SYSDATE,
           35000,
           'TARJETA',
           'EXITOSO'
       );


-- Verificar actualizacion
SELECT
    ID_USUARIO,
    ID_ESTADO,
    FECHA_ULTIMO_PAGO
FROM USUARIOS
WHERE ID_USUARIO = 1;