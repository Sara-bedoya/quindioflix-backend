/*
PROYECTO: QUINDIOFLIX
SECCION : DATA 03
ARCHIVO : 03_seed_perfiles.sql
OBJETIVO: Datos semilla de perfiles
ORIGEN  : dml\04_seed_perfiles.sql
*/
-- =========================================================
-- PERFILES (50 registros)
-- =========================================================

-- ID 3 | Carlos Ruiz | Básico (1/1)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (3, 'Carlos', 'avatar_3_1.png', 'ADULTO');

-- ID 4 | Sara | Premium (3/4 y 4/4)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (4, 'Sara Kids', 'avatar_4_3.png', 'INFANTIL');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (4, 'Sara Noche', 'avatar_4_4.png', 'ADULTO');

-- ID 6 | Juan Perez | Básico (1/1)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (6, 'Juan', 'avatar_6_1.png', 'ADULTO');

-- ID 8 | Carlos Ruiz | Premium (1/4 - 4/4)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (8, 'Carlos', 'avatar_8_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (8, 'Carlos Jr', 'avatar_8_2.png', 'INFANTIL');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (8, 'Carlos Work', 'avatar_8_3.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (8, 'Carlos Kids', 'avatar_8_4.png', 'INFANTIL');

-- ID 12 | Maria Torres | Básico (1/1)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (12, 'Maria', 'avatar_12_1.png', 'ADULTO');

-- ID 14 | Sofia Herrera | Premium (1/4 - 4/4)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (14, 'Sofia', 'avatar_14_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (14, 'Sofia Kids', 'avatar_14_2.png', 'INFANTIL');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (14, 'Sofia Night', 'avatar_14_3.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (14, 'Sofia Mini', 'avatar_14_4.png', 'INFANTIL');

-- ID 15 | Diego Morales | Básico (1/1)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (15, 'Diego', 'avatar_15_1.png', 'ADULTO');

-- ID 17 | Felipe Rios | Premium (1/4 - 4/4)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (17, 'Felipe', 'avatar_17_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (17, 'Felipe Kids', 'avatar_17_2.png', 'INFANTIL');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (17, 'Felipe Jr', 'avatar_17_3.png', 'INFANTIL');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (17, 'Felipe Max', 'avatar_17_4.png', 'ADULTO');

-- ID 18 | Daniela Vargas | Básico (1/1)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (18, 'Daniela', 'avatar_18_1.png', 'ADULTO');

-- ID 20 | Camila Flores | Premium (1/4 - 4/4)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (20, 'Camila', 'avatar_20_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (20, 'Camila Kids', 'avatar_20_2.png', 'INFANTIL');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (20, 'Cami', 'avatar_20_3.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (20, 'Cami Mini', 'avatar_20_4.png', 'INFANTIL');

-- ID 21 | Sebastian Lopez | Básico (1/1)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (21, 'Sebastian', 'avatar_21_1.png', 'ADULTO');

-- ID 23 | Mateo Sanchez | Premium (1/4 - 4/4)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (23, 'Mateo', 'avatar_23_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (23, 'Mateo Kids', 'avatar_23_2.png', 'INFANTIL');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (23, 'Mateo Jr', 'avatar_23_3.png', 'INFANTIL');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (23, 'Mateo Plus', 'avatar_23_4.png', 'ADULTO');

-- ID 24 | Juliana Rojas | Básico (1/1)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (24, 'Juliana', 'avatar_24_1.png', 'ADULTO');

-- ID 26 | Gabriela Castro | Premium (1/4 - 2/4)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (26, 'Gabriela', 'avatar_26_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (26, 'Gaby Kids', 'avatar_26_2.png', 'INFANTIL');

-- ID 27 | Samuel Ortiz | Básico (1/1)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (27, 'Samuel', 'avatar_27_1.png', 'ADULTO');

-- ID 29 | Tomas Jimenez | Premium (1/4 - 2/4)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (29, 'Tomas', 'avatar_29_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (29, 'Tomas Kids', 'avatar_29_2.png', 'INFANTIL');

-- ID 30 | Luisa Ramirez | Básico (1/1)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (30, 'Luisa', 'avatar_30_1.png', 'ADULTO');

-- ID 40 | Laura Gomez | Estándar (1/2 - 2/2)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (40, 'Laura', 'avatar_40_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (40, 'Laura Kids', 'avatar_40_2.png', 'INFANTIL');

-- ID 46 | Andres Castillo | Estándar (1/2 - 2/2)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (46, 'Andres', 'avatar_46_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (46, 'Andres Kids', 'avatar_46_2.png', 'INFANTIL');

-- ID 49 | Valentina Cruz | Estándar (1/2 - 2/2)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (49, 'Valentina', 'avatar_49_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (49, 'Vale Kids', 'avatar_49_2.png', 'INFANTIL');

-- ID 52 | Alejandro Pena | Estándar (1/2 - 2/2)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (52, 'Alejandro', 'avatar_52_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (52, 'Alejo Kids', 'avatar_52_2.png', 'INFANTIL');

-- ID 58 | Nicolas Mendez | Estándar (1/2 - 2/2)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (58, 'Nicolas', 'avatar_58_1.png', 'ADULTO');
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (58, 'Nico Kids', 'avatar_58_2.png', 'INFANTIL');

-- ID 61 | Mariana Reyes | Estándar (1/2)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (61, 'Mariana', 'avatar_61_1.png', 'ADULTO');

-- ID 64 | David Alvarez | Estándar (1/2)
INSERT INTO PERFILES (id_usuario, nombre_perfil, avatar, tipo) VALUES (64, 'David', 'avatar_64_1.png', 'ADULTO');

COMMIT;