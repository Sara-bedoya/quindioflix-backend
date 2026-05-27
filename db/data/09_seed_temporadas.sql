# /*

SEED DATA - TEMPORADAS
Proyecto QuindioFlix
====================

Descripción:
Inserción de temporadas para series.
====================================

*/

-- =====================================================
-- CODIGO OSCURO (3 temporadas)
-- id_contenido = 35
-- =====================================================

INSERT INTO TEMPORADAS (
    id_contenido,
    numero_temporada,
    titulo_temporada
) VALUES (35, 1, 'Codigo Oscuro - Temporada 1');

INSERT INTO TEMPORADAS (
    id_contenido,
    numero_temporada,
    titulo_temporada
) VALUES (35, 2, 'Codigo Oscuro - Temporada 2');

INSERT INTO TEMPORADAS (
    id_contenido,
    numero_temporada,
    titulo_temporada
) VALUES (35, 3, 'Codigo Oscuro - Temporada Final');

-- =====================================================
-- GUARDIANES DEL NORTE (2 temporadas)
-- id_contenido = 36
-- =====================================================

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  36,
                                  1,
                                  'Guardianes del Norte - El despertar'
                              );

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  36,
                                  2,
                                  'Guardianes del Norte - La guerra ancestral'
                              );

-- =====================================================
-- LA CLINICA (2 temporadas)
-- id_contenido = 37
-- =====================================================

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  37,
                                  1,
                                  'La Clinica - Emergencias'
                              );

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  37,
                                  2,
                                  'La Clinica - Secretos internos'
                              );

-- =====================================================
-- MUNDOS PARALELOS (2 temporadas)
-- id_contenido = 38
-- =====================================================

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  38,
                                  1,
                                  'Mundos Paralelos - Realidad Alterna'
                              );

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  38,
                                  2,
                                  'Mundos Paralelos - Colapso dimensional'
                              );

-- =====================================================
-- GENERACION Z (3 temporadas)
-- id_contenido = 40
-- =====================================================

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  40,
                                  1,
                                  'Generacion Z - Primer empleo'
                              );

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  40,
                                  2,
                                  'Generacion Z - Crisis existencial'
                              );

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  40,
                                  3,
                                  'Generacion Z - Vida adulta'
                              );

-- =====================================================
-- IMPERIO DE SANGRE (2 temporadas)
-- id_contenido = 41
-- =====================================================

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  41,
                                  1,
                                  'Imperio de Sangre - Ascenso'
                              );

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  41,
                                  2,
                                  'Imperio de Sangre - Caida'
                              );

-- =====================================================
-- EL INTERNADO (2 temporadas)
-- id_contenido = 43
-- =====================================================

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  43,
                                  1,
                                  'El Internado - Nuevos estudiantes'
                              );

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  43,
                                  2,
                                  'El Internado - El secreto del sotano'
                              );

-- =====================================================
-- CHEF SECRETO (2 temporadas)
-- id_contenido = 46
-- =====================================================

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  46,
                                  1,
                                  'Chef Secreto - Competencia inicial'
                              );

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  46,
                                  2,
                                  'Chef Secreto - Cocina internacional'
                              );

-- =====================================================
-- ANTARTICA (1 temporada)
-- id_contenido = 42
-- =====================================================

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  42,
                                  1,
                                  'Antartica - Descubrimiento'
                              );

-- =====================================================
-- REINAS (1 temporada)
-- id_contenido = 44
-- =====================================================

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  44,
                                  1,
                                  'Reinas - Poder y ambicion'
                              );

-- =====================================================
-- STRANGER THINGS (2 temporadas)
-- id_contenido = 2
-- =====================================================

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  2,
                                  1,
                                  'Stranger Things - El otro lado'
                              );

INSERT INTO TEMPORADAS VALUES (
                                  seq_temporadas.NEXTVAL,
                                  2,
                                  2,
                                  'Stranger Things - Sombras de Hawkins'
                              );

COMMIT;
