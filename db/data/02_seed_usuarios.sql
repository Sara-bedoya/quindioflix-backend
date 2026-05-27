/*
PROYECTO: QUINDIOFLIX
SECCION : DATA 02
ARCHIVO : 02_seed_usuarios.sql
OBJETIVO: Datos semilla de usuarios
ORIGEN  : dml\03_seed_usuarios.sql
*/
-- =========================================================
-- USUARIOS
-- =========================================================

INSERT INTO USUARIOS (
    nombre_completo,email,telefono,
    fecha_nacimiento,id_ciudad,
    id_plan,id_estado,es_moderador
)
VALUES (
           'Juan Perez','juan1@test.com','3001111111',
           TO_DATE('1998-05-10','YYYY-MM-DD'),
           1,1,1,'N'
       );

INSERT INTO USUARIOS (
    nombre_completo,email,telefono,
    fecha_nacimiento,id_ciudad,id_plan,
    id_estado,es_moderador
)
VALUES (
           'Laura Gomez','laura1@test.com','3002222222',
           TO_DATE('1995-08-20','YYYY-MM-DD'),
           2,3,3,'S'
       );

INSERT INTO USUARIOS (
    nombre_completo,email,telefono,
    fecha_nacimiento,id_ciudad,id_plan,
    id_estado,es_moderador
)
VALUES (
           'Carlos Ruiz','carlos1@test.com','3003333333',
           TO_DATE('2001-01-15','YYYY-MM-DD'),
           3,4,2,
           'N'
       );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Juan Perez', 'juan1@test.com', '3001111111',
             TO_DATE('1998-05-10','YYYY-MM-DD'),
             1, 1, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Laura Gomez', 'laura1@test.com', '3002222222',
             TO_DATE('1995-08-20','YYYY-MM-DD'),
             2, 3, 3, 'S'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Carlos Ruiz', 'carlos1@test.com', '3003333333',
             TO_DATE('2001-01-15','YYYY-MM-DD'),
             3, 4, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Maria Torres', 'maria2@test.com', '3104444444',
             TO_DATE('1993-03-22','YYYY-MM-DD'),
             3, 1, 2, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Andres Castillo', 'andres2@test.com', '3105555555',
             TO_DATE('1990-11-05','YYYY-MM-DD'),
             1, 3, 1, 'S'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Sofia Herrera', 'sofia2@test.com', '3206666666',
             TO_DATE('2000-07-18','YYYY-MM-DD'),
             2, 4, 2, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Diego Morales', 'diego3@test.com', '3207777777',
             TO_DATE('1997-09-30','YYYY-MM-DD'),
             3, 1, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Valentina Cruz', 'vale3@test.com', '3118888888',
             TO_DATE('2003-02-14','YYYY-MM-DD'),
             2, 3, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Felipe Rios', 'felipe3@test.com', '3009999999',
             TO_DATE('1988-06-25','YYYY-MM-DD'),
             1, 4, 3, 'S'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Daniela Vargas', 'dani4@test.com', '3100000001',
             TO_DATE('1996-12-08','YYYY-MM-DD'),
             1, 1, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Alejandro Pena', 'alejo4@test.com', '3100000002',
             TO_DATE('1994-04-17','YYYY-MM-DD'),
             1, 3, 3, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Camila Flores', 'cami4@test.com', '3100000003',
             TO_DATE('1999-10-03','YYYY-MM-DD'),
             2, 4, 1, 'S'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Sebastian Lopez', 'sebas5@test.com', '3100000004',
             TO_DATE('2002-08-11','YYYY-MM-DD'),
             3, 1, 3, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Isabella Diaz', 'isa5@test.com', '3100000005',
             TO_DATE('1991-01-29','YYYY-MM-DD'),
             2, 2, 3, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Mateo Sanchez', 'mateo5@test.com', '3100000006',
             TO_DATE('1987-05-07','YYYY-MM-DD'),
             2, 4, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Juliana Rojas', 'juli6@test.com', '3100000007',
             TO_DATE('2004-03-19','YYYY-MM-DD'),
             3, 1, 2, 'S'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Nicolas Mendez', 'nico6@test.com', '3100000008',
             TO_DATE('1995-07-23','YYYY-MM-DD'),
             1, 3, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Gabriela Castro', 'gaby6@test.com', '3100000009',
             TO_DATE('1998-11-14','YYYY-MM-DD'),
             1, 4, 2, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Samuel Ortiz', 'sam7@test.com', '3100000010',
             TO_DATE('1993-09-02','YYYY-MM-DD'),
             2, 1, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Mariana Reyes', 'mari7@test.com', '3100000011',
             TO_DATE('2000-04-27','YYYY-MM-DD'),
             1, 3, 2, 'S'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Tomas Jimenez', 'tomas7@test.com', '3100000012',
             TO_DATE('1989-12-16','YYYY-MM-DD'),
             1, 4, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Luisa Ramirez', 'luisa8@test.com', '3100000013',
             TO_DATE('1997-06-09','YYYY-MM-DD'),
             2, 1, 2, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'David Alvarez', 'david8@test.com', '3100000014',
             TO_DATE('2001-02-21','YYYY-MM-DD'),
             3, 3, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Sara Gutierrez', 'sara8@test.com', '3100000015',
             TO_DATE('1992-08-04','YYYY-MM-DD'),
             2, 4, 1, 'S'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Emanuel Romero', 'ema9@test.com', '3100000016',
             TO_DATE('1986-10-31','YYYY-MM-DD'),
             3, 1, 2, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Natalia Suarez', 'nata9@test.com', '3100000017',
             TO_DATE('2003-05-13','YYYY-MM-DD'),
             2, 3, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Pablo Medina', 'pablo9@test.com', '3100000018',
             TO_DATE('1994-01-06','YYYY-MM-DD'),
             1, 4, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Lina Aguilar', 'lina10@test.com', '3100000019',
             TO_DATE('1999-07-28','YYYY-MM-DD'),
             3, 1, 2, 'S'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Ricardo Vega', 'ricar10@test.com', '3100000020',
             TO_DATE('1990-03-15','YYYY-MM-DD'),
             1, 3, 1, 'N'
         );
INSERT INTO USUARIOS (
    nombre_completo, email, telefono,
    fecha_nacimiento, id_ciudad, id_plan,
    id_estado, es_moderador
) VALUES (
             'Ana Molina', 'ana10@test.com', '3100000021',
             TO_DATE('2002-11-22','YYYY-MM-DD'),
             1, 4, 1, 'N'
         );

COMMIT;
