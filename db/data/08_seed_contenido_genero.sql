/*
PROYECTO: QUINDIOFLIX
SECCION : DATA 08
ARCHIVO : 08_seed_contenido_genero.sql
OBJETIVO: Relacion semilla entre contenido y generos
ORIGEN  : dml\06_seed_contenido_genero.sql
*/
-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 06_seed_contenido_genero.sql
-- OBJETIVO:
--     Asociar contenidos con géneros
-- =========================================================

-- =========================================================
-- PELICULAS
-- =========================================================

-- Sombras del Futuro
-- Accion + Ciencia Ficcion

INSERT INTO CONTENIDO_GENERO VALUES (21, 1);
INSERT INTO CONTENIDO_GENERO VALUES (21, 23);

-- La Ultima Frontera
-- Ciencia Ficcion + Suspenso

INSERT INTO CONTENIDO_GENERO VALUES (22, 23);
INSERT INTO CONTENIDO_GENERO VALUES (22, 21);

-- Corazones de Cristal
-- Drama + Romance

INSERT INTO CONTENIDO_GENERO VALUES (23, 2);
INSERT INTO CONTENIDO_GENERO VALUES (23, 22);

-- El Ultimo Aliento
-- Suspenso + Terror

INSERT INTO CONTENIDO_GENERO VALUES (24, 21);
INSERT INTO CONTENIDO_GENERO VALUES (24, 5);

-- Tierra de Nadie
-- Drama + Accion

INSERT INTO CONTENIDO_GENERO VALUES (25, 2);
INSERT INTO CONTENIDO_GENERO VALUES (25, 1);

-- Luces de Neon
-- Drama + Suspenso

INSERT INTO CONTENIDO_GENERO VALUES (26, 2);
INSERT INTO CONTENIDO_GENERO VALUES (26, 21);

-- El Gran Robo
-- Accion + Suspenso

INSERT INTO CONTENIDO_GENERO VALUES (27, 1);
INSERT INTO CONTENIDO_GENERO VALUES (27, 21);

-- Pequeños Heroes
-- Infantil + Comedia

INSERT INTO CONTENIDO_GENERO VALUES (28, 24);
INSERT INTO CONTENIDO_GENERO VALUES (28, 3);

-- La Tormenta Perfecta
-- Drama + Suspenso

INSERT INTO CONTENIDO_GENERO VALUES (29, 2);
INSERT INTO CONTENIDO_GENERO VALUES (29, 21);

-- Silencio Eterno
-- Terror + Suspenso

INSERT INTO CONTENIDO_GENERO VALUES (30, 5);
INSERT INTO CONTENIDO_GENERO VALUES (30, 21);

-- El Principe del Desierto
-- Drama + Accion

INSERT INTO CONTENIDO_GENERO VALUES (31, 2);
INSERT INTO CONTENIDO_GENERO VALUES (31, 1);

-- Amor en Cuarentena
-- Romance + Comedia

INSERT INTO CONTENIDO_GENERO VALUES (32, 22);
INSERT INTO CONTENIDO_GENERO VALUES (32, 3);

-- Dimension 7
-- Ciencia Ficcion + Suspenso

INSERT INTO CONTENIDO_GENERO VALUES (33, 23);
INSERT INTO CONTENIDO_GENERO VALUES (33, 21);

-- La Casa del Fin del Mundo
-- Terror

INSERT INTO CONTENIDO_GENERO VALUES (34, 5);

-- =========================================================
-- SERIES
-- =========================================================

-- Codigo Oscuro
-- Accion + Suspenso

INSERT INTO CONTENIDO_GENERO VALUES (35, 1);
INSERT INTO CONTENIDO_GENERO VALUES (35, 21);

-- Guardianes del Norte
-- Accion + Drama

INSERT INTO CONTENIDO_GENERO VALUES (36, 1);
INSERT INTO CONTENIDO_GENERO VALUES (36, 2);

-- La Clinica
-- Drama + Suspenso

INSERT INTO CONTENIDO_GENERO VALUES (37, 2);
INSERT INTO CONTENIDO_GENERO VALUES (37, 21);

-- Mundos Paralelos
-- Ciencia Ficcion

INSERT INTO CONTENIDO_GENERO VALUES (38, 23);

-- La Banda del Rio
-- Drama + Musical

INSERT INTO CONTENIDO_GENERO VALUES (39, 2);

-- Generacion Z
-- Comedia

INSERT INTO CONTENIDO_GENERO VALUES (40, 3);

-- Imperio de Sangre
-- Drama + Terror

INSERT INTO CONTENIDO_GENERO VALUES (41, 2);
INSERT INTO CONTENIDO_GENERO VALUES (41, 5);

-- Antartica
-- Ciencia Ficcion + Drama

INSERT INTO CONTENIDO_GENERO VALUES (42, 23);
INSERT INTO CONTENIDO_GENERO VALUES (42, 2);

-- El Internado
-- Suspenso + Drama

INSERT INTO CONTENIDO_GENERO VALUES (43, 21);
INSERT INTO CONTENIDO_GENERO VALUES (43, 2);

-- Reinas
-- Drama

INSERT INTO CONTENIDO_GENERO VALUES (44, 2);

-- Los Ultimos Dias
-- Ciencia Ficcion + Accion

INSERT INTO CONTENIDO_GENERO VALUES (45, 23);
INSERT INTO CONTENIDO_GENERO VALUES (45, 1);

-- Chef Secreto
-- Comedia

INSERT INTO CONTENIDO_GENERO VALUES (46, 3);

-- =========================================================
-- DOCUMENTALES
-- =========================================================

-- Amazonia Viva

INSERT INTO CONTENIDO_GENERO VALUES (47, 2);

-- El Ultimo Glaciar

INSERT INTO CONTENIDO_GENERO VALUES (48, 2);

-- Mentes Criminales

INSERT INTO CONTENIDO_GENERO VALUES (49, 21);

-- La Ruta de la Seda Hoy

INSERT INTO CONTENIDO_GENERO VALUES (50, 2);

-- Cuerpo y Mente

INSERT INTO CONTENIDO_GENERO VALUES (51, 2);

-- Oceanos en Peligro

INSERT INTO CONTENIDO_GENERO VALUES (52, 2);

-- =========================================================
-- MUSICA
-- =========================================================

-- Noches Electricas

INSERT INTO CONTENIDO_GENERO VALUES (53, 3);

-- Raices

INSERT INTO CONTENIDO_GENERO VALUES (54, 3);

-- Piano y Silencio

INSERT INTO CONTENIDO_GENERO VALUES (55, 3);

-- =========================================================
-- PODCASTS
-- =========================================================

-- Historias del Crimen

INSERT INTO CONTENIDO_GENERO VALUES (56, 21);
INSERT INTO CONTENIDO_GENERO VALUES (56, 5);

-- Mente Maestra

INSERT INTO CONTENIDO_GENERO VALUES (57, 2);

-- El Mundo Segun Ellos

INSERT INTO CONTENIDO_GENERO VALUES (58, 2);

-- Ciencia en 60 Minutos

INSERT INTO CONTENIDO_GENERO VALUES (59, 23);

COMMIT;