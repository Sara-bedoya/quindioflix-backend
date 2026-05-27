/* =========================================================
   3.3.2 CONCURRENCIA DE DATOS
   Escenario:
   Dos sesiones intentan cambiar el plan
   del mismo usuario simultáneamente.
   ========================================================= */


/* =========================================================
   PASO 1 — PREPARAR DATOS
   Ejecutar UNA SOLA VEZ
   ========================================================= */

UPDATE usuarios
SET id_plan = 1
WHERE id_usuario = 1;

COMMIT;


/* =========================================================
   =================== SESION 1 =============================
   ========================================================= */

-- Verificar plan actual
SELECT id_usuario,
       nombre_completo,
       id_plan
FROM usuarios
WHERE id_usuario = 1;


-- BLOQUEAR EL REGISTRO
SELECT *
FROM usuarios
WHERE id_usuario = 1
    FOR UPDATE;


-- Cambiar plan a PREMIUM
UPDATE usuarios
SET id_plan = 4
WHERE id_usuario = 1;


-- NO HACER COMMIT TODAVIA
-- La fila queda bloqueada


/* =========================================================
   =================== SESION 2 =============================
   ========================================================= */

-- Intentar consultar normalmente
SELECT id_usuario,
       nombre_completo,
       id_plan
FROM usuarios
WHERE id_usuario = 1;


-- Intentar bloquear la misma fila
SELECT *
FROM usuarios
WHERE id_usuario = 1
    FOR UPDATE;


-- ESTA CONSULTA QUEDARA ESPERANDO
-- porque la SESION 1 tiene el bloqueo


-- Intentar actualizar tambien
UPDATE usuarios
SET id_plan = 3
WHERE id_usuario = 1;


-- Oracle NO permite modificar la fila
-- hasta que la SESION 1 termine


/* =========================================================
   =================== SESION 1 =============================
   ========================================================= */

-- Confirmar cambios
COMMIT;


-- Al hacer COMMIT:
-- 1. Se guarda el cambio a plan PREMIUM
-- 2. Se libera el bloqueo


/* =========================================================
   =================== SESION 2 =============================
   ========================================================= */

-- Ahora Oracle libera la espera
-- y la sesion 2 continua

-- Verificar plan actual
SELECT id_usuario,
       nombre_completo,
       id_plan
FROM usuarios
WHERE id_usuario = 1;


-- Ahora SI puede actualizar
UPDATE usuarios
SET id_plan = 3
WHERE id_usuario = 1;

COMMIT;


/* =========================================================
   VERIFICACION FINAL
   ========================================================= */

SELECT id_usuario,
       nombre_completo,
       id_plan
FROM usuarios
WHERE id_usuario = 1;


/* =========================================================
   EXPLICACION DEL ESCENARIO
   =========================================================

1. La SESION 1 ejecuta:
      SELECT ... FOR UPDATE

   Oracle coloca un BLOQUEO EXCLUSIVO
   sobre la fila del usuario.

2. La SESION 2 intenta acceder
   a la misma fila con FOR UPDATE
   o UPDATE.

3. Oracle pone la SESION 2 en espera
   hasta que la SESION 1 haga:

      COMMIT
      o
      ROLLBACK

4. Cuando la SESION 1 confirma,
   el bloqueo se libera.

5. La SESION 2 continua normalmente.

========================================================= */


/* =========================================================
   CONSULTA OPCIONAL PARA VER BLOQUEOS ACTIVOS
   ========================================================= */

SELECT
    s.sid,
    s.serial#,
    s.username,
    o.object_name,
    l.locked_mode
FROM v$locked_object l
         JOIN dba_objects o
              ON l.object_id = o.object_id
         JOIN v$session s
              ON l.session_id = s.sid;


/* =========================================================
   EJEMPLO DE ROLLBACK
   ========================================================= */

-- SESION 1

SELECT *
FROM usuarios
WHERE id_usuario = 1
    FOR UPDATE;

UPDATE usuarios
SET id_plan = 4
WHERE id_usuario = 1;

ROLLBACK;


-- El cambio NO se guarda
-- y Oracle libera el bloqueo automáticamente