/*
PROYECTO: QUINDIOFLIX
SECCION : DATA 05
ARCHIVO : 05_seed_contenido.sql
OBJETIVO: Datos semilla de contenido
ORIGEN  : dml\05_seed_contenido.sql
*/
-- =========================================================
-- CONTENIDO (40 registros)
-- =========================================================

-- -------------------------
-- PELÍCULAS (id_categoria = 1) → 14 registros
-- -------------------------

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Sombras del Futuro', 2021, 125, 'Una organizacion secreta controla el tiempo.', '+13', SYSDATE - 400, 1, 1, 120);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('La Ultima Frontera', 2020, 140, 'Exploradores viajan a un planeta desconocido.', '+16', SYSDATE - 350, 1, 1, 210);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Corazones de Cristal', 2022, 110, 'Historia romantica ambientada en Paris.', '+7', SYSDATE - 120, 1, 2, 95);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('El Ultimo Aliento', 2023, 118, 'Un detective resuelve su propio asesinato desde el mas alla.', '+16', SYSDATE - 80, 1, 1, 305);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Tierra de Nadie', 2019, 132, 'Dos soldados enemigos quedan atrapados juntos tras una batalla.', '+13', SYSDATE - 700, 1, 2, 175);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Luces de Neon', 2022, 105, 'Un artista callejero descubre una conspiracion en la ciudad.', '+13', SYSDATE - 200, 1, 1, 230);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('El Gran Robo', 2021, 120, 'Un grupo de ladrones planea el atraco del siglo.', '+16', SYSDATE - 310, 1, 2, 415);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Pequeños Heroes', 2023, 88, 'Tres ninos salvan su barrio de una empresa malvada.', 'TP', SYSDATE - 60, 1, 1, 190);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('La Tormenta Perfecta', 2020, 135, 'Un equipo de rescate enfrenta el huracan mas devastador de la historia.', '+13', SYSDATE - 450, 1, 2, 270);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Silencio Eterno', 2024, 98, 'Una mujer descubre que su vecino lleva 10 anos desaparecido... y vive frente a ella.', '+18', SYSDATE - 30, 1, 1, 380);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('El Principe del Desierto', 2019, 145, 'Un rey en el exilio lucha por recuperar su trono.', '+13', SYSDATE - 800, 1, 2, 155);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Amor en Cuarentena', 2021, 95, 'Dos desconocidos comparten apartamento durante un confinamiento inesperado.', '+7', SYSDATE - 370, 1, 1, 210);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Dimension 7', 2022, 128, 'Un fisico abre un portal a una dimension paralela con consecuencias impredecibles.', '+16', SYSDATE - 180, 1, 2, 340);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('La Casa del Fin del Mundo', 2023, 112, 'Una familia descubre que su nueva casa oculta un oscuro secreto.', '+18', SYSDATE - 95, 1, 1, 460);

-- -------------------------
-- SERIES (id_categoria = 2) → 12 registros
-- -------------------------

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Codigo Oscuro', 2023, 45, 'Hackers luchan contra una corporacion mundial.', '+16', SYSDATE - 90, 2, 1, 340);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Guardianes del Norte', 2021, 50, 'Guerreros protegen antiguos secretos.', '+13', SYSDATE - 300, 2, 2, 280);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('La Clinica', 2022, 42, 'Los secretos de un hospital privado salen a la luz uno a uno.', '+16', SYSDATE - 220, 2, 1, 395);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Mundos Paralelos', 2023, 48, 'Cada episodio sigue a la misma persona en universos distintos.', '+13', SYSDATE - 110, 2, 2, 420);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('La Banda del Rio', 2020, 55, 'Una familia de musicos enfrenta la corrupcion en su ciudad.', '+13', SYSDATE - 500, 2, 1, 195);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Generacion Z', 2024, 30, 'Comedia sobre jovenes navegando la vida adulta en la era digital.', '+7', SYSDATE - 20, 2, 2, 510);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Imperio de Sangre', 2021, 60, 'La caida de una dinastia criminal contada desde adentro.', '+18', SYSDATE - 360, 2, 1, 480);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Antartica', 2022, 50, 'Cientificos atrapados en el polo sur descubren una forma de vida desconocida.', '+13', SYSDATE - 250, 2, 2, 315);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('El Internado', 2023, 40, 'Estudiantes de una academia de elite resuelven misterios entre clases.', '+13', SYSDATE - 130, 2, 1, 365);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Reinas', 2022, 45, 'Cuatro mujeres lideran distintas industrias y sus vidas se cruzan inesperadamente.', '+16', SYSDATE - 270, 2, 2, 290);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Los Ultimos Dias', 2020, 55, 'Un grupo de sobrevivientes reconstruye la civilizacion tras un colapso global.', '+16', SYSDATE - 480, 2, 1, 350);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Chef Secreto', 2024, 35, 'Un famoso chef oculta su verdadera identidad mientras compite en anonimato.', '+7', SYSDATE - 15, 2, 2, 275);

-- -------------------------
-- DOCUMENTALES (id_categoria = 21) → 6 registros
-- -------------------------

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Amazonia Viva', 2019, 90, 'Exploracion de la biodiversidad amazonica.', 'TP', SYSDATE - 600, 21, 1, 75);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('El Ultimo Glaciar', 2022, 85, 'Cientificos documentan el deshielo acelerado de los polos.', 'TP', SYSDATE - 210, 21, 2, 130);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Mentes Criminales', 2021, 95, 'Perfil psicologico de los criminales mas buscados de la decada.', '+16', SYSDATE - 320, 21, 1, 200);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('La Ruta de la Seda Hoy', 2020, 100, 'Viaje moderno por los paises que conecta la antigua ruta comercial.', 'TP', SYSDATE - 550, 21, 2, 88);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Cuerpo y Mente', 2023, 70, 'La ciencia detras del bienestar fisico y mental en el siglo XXI.', 'TP', SYSDATE - 100, 21, 1, 145);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Oceanos en Peligro', 2024, 80, 'Investigacion submarina sobre la contaminacion de los mares.', 'TP', SYSDATE - 45, 21, 2, 162);

-- -------------------------
-- MÚSICA (id_categoria = 22) → 4 registros
-- -------------------------

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Noches Electricas', 2024, 55, 'Album de musica electronica contemporanea.', 'TP', SYSDATE - 40, 22, 2, 180);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Raices', 2022, 62, 'Concierto en vivo que fusiona musica folclorica latinoamericana con jazz.', 'TP', SYSDATE - 230, 22, 1, 140);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Urban Frequencies', 2023, 48, 'Compilado de hip-hop y R&B de artistas emergentes urbanos.', '+13', SYSDATE - 140, 22, 2, 220);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Piano y Silencio', 2021, 75, 'Recital de musica clasica contemporanea interpretado en solitario.', 'TP', SYSDATE - 390, 22, 1, 95);

-- -------------------------
-- PODCASTS (id_categoria = 24) → 4 registros
-- -------------------------

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Historias del Crimen', 2023, 60, 'Podcast sobre casos policiales reales.', '+18', SYSDATE - 150, 24, 1, 260);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Mente Maestra', 2022, 50, 'Entrevistas a psicologos y coaches sobre productividad y salud mental.', 'TP', SYSDATE - 260, 24, 2, 195);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('El Mundo Segun Ellos', 2023, 65, 'Conversaciones con personajes que cambiaron sus industrias.', '+13', SYSDATE - 170, 24, 1, 230);

INSERT INTO CONTENIDO (titulo, anio_lanzamiento, duracion_minutos, sinopsis, clasificacion_edad, fecha_agregado, id_categoria, id_empleado_responsable, popularidad)
VALUES ('Ciencia en 60 Minutos', 2024, 58, 'Divulgacion cientifica accesible sobre los temas mas relevantes del ano.', 'TP', SYSDATE - 35, 24, 2, 175);

COMMIT;