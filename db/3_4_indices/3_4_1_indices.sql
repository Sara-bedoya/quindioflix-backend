/*
PROYECTO: QUINDIOFLIX
SECCION : 3.4.1 Indices
ARCHIVO : 3_4_1_indices.sql
OBJETIVO: Indices para optimizacion de consultas
ORIGEN  : indexes\01_indexes.sql
*/
-- =========================================================
-- PROYECTO: QUINDIOFLIX
-- ARCHIVO : 01_indexes.sql
-- OBJETIVO:
--     Crear índices para optimizar:
--         - búsquedas
--         - joins
--         - reportes
--         - analítica
--         - recomendaciones
-- =========================================================

-- =========================================================
-- INDICES USUARIOS
-- =========================================================

CREATE INDEX idx_usuarios_plan
    ON USUARIOS(id_plan);

CREATE INDEX idx_usuarios_ciudad
    ON USUARIOS(id_ciudad);

-- =========================================================
-- INDICES PERFILES
-- =========================================================

CREATE INDEX idx_perfiles_usuario
    ON PERFILES(id_usuario);

-- =========================================================
-- INDICES CONTENIDO
-- =========================================================

CREATE INDEX idx_contenido_categoria
    ON CONTENIDO(id_categoria);

CREATE INDEX idx_contenido_popularidad
    ON CONTENIDO(popularidad);

CREATE INDEX idx_contenido_empleado
    ON CONTENIDO(id_empleado_responsable);

-- =========================================================
-- INDICES REPRODUCCIONES
-- =========================================================

CREATE INDEX idx_reproducciones_perfil
    ON REPRODUCCIONES(id_perfil);

CREATE INDEX idx_reproducciones_contenido
    ON REPRODUCCIONES(id_contenido);

CREATE INDEX idx_reproducciones_dispositivo
    ON REPRODUCCIONES(dispositivo);

CREATE INDEX idx_reproducciones_episodio
    ON REPRODUCCIONES(id_episodio);

-- =========================================================
-- INDICES PAGOS
-- =========================================================

CREATE INDEX idx_pagos_usuario
    ON PAGOS(id_usuario);

CREATE INDEX idx_pagos_plan
    ON PAGOS(id_plan);

CREATE INDEX idx_pagos_estado
    ON PAGOS(estado_pago);

-- =========================================================
-- INDICES REPORTES
-- =========================================================

CREATE INDEX idx_reportes_estado
    ON REPORTES(estado);

CREATE INDEX idx_reportes_moderador
    ON REPORTES(id_moderador);