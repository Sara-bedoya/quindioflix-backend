# /*

SEED DATA - EPISODIOS
Proyecto QuindioFlix
====================

Descripción:
Inserción de 50 episodios distribuidos entre
las temporadas existentes.
==========================

*/

-- =====================================================
-- TEMPORADA 1 - CODIGO OSCURO T1
-- =====================================================

INSERT INTO EPISODIOS (
    id_episodio,
    id_temporada,
    numero_episodio,
    titulo_episodio,
    duracion_minutos,
    sinopsis
) VALUES (
             seq_episodios.NEXTVAL,
             1,
             1,
             'Hackeo Inicial',
             45,
             'Un grupo de hackers descubre una red secreta global.'
         );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 1,
                                 2,
                                 'Conexion Fantasma',
                                 43,
                                 'Una señal misteriosa aparece en los servidores.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 1,
                                 3,
                                 'Codigo Rojo',
                                 47,
                                 'El sistema principal entra en emergencia.'
                             );

-- =====================================================
-- TEMPORADA 21
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 21,
                                 1,
                                 'El Regreso',
                                 46,
                                 'Los protagonistas vuelven tras meses desaparecidos.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 21,
                                 2,
                                 'Firewall Humano',
                                 44,
                                 'La organizacion recluta un nuevo aliado.'
                             );

-- =====================================================
-- TEMPORADA 22
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 22,
                                 1,
                                 'La Ultima Linea',
                                 50,
                                 'La batalla final comienza.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 22,
                                 2,
                                 'Caida del Sistema',
                                 48,
                                 'Todo el sistema mundial colapsa.'
                             );

-- =====================================================
-- TEMPORADA 23
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 23,
                                 1,
                                 'El Despertar',
                                 49,
                                 'Un antiguo guardian despierta.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 23,
                                 2,
                                 'Las Runas',
                                 50,
                                 'Las runas revelan una profecia.'
                             );

-- =====================================================
-- TEMPORADA 25
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 25,
                                 1,
                                 'La Guerra Helada',
                                 52,
                                 'La guerra llega al norte.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 25,
                                 2,
                                 'El Guardian Caido',
                                 48,
                                 'Uno de los guardianes desaparece.'
                             );

-- =====================================================
-- TEMPORADA 27
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 27,
                                 1,
                                 'Paciente Cero',
                                 42,
                                 'Un paciente misterioso llega al hospital.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 27,
                                 2,
                                 'Diagnostico Fatal',
                                 43,
                                 'El equipo medico descubre la verdad.'
                             );

-- =====================================================
-- TEMPORADA 29
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 29,
                                 1,
                                 'Cirugia de Riesgo',
                                 44,
                                 'Una operacion puede cambiarlo todo.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 29,
                                 2,
                                 'La Verdad',
                                 45,
                                 'Los secretos comienzan a salir.'
                             );

-- =====================================================
-- TEMPORADA 31
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 31,
                                 1,
                                 'Realidad 01',
                                 48,
                                 'El primer portal es abierto.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 31,
                                 2,
                                 'Versiones',
                                 46,
                                 'Distintas versiones del protagonista aparecen.'
                             );

-- =====================================================
-- TEMPORADA 33
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 33,
                                 1,
                                 'Colapso',
                                 50,
                                 'Las dimensiones comienzan a mezclarse.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 33,
                                 2,
                                 'El Ultimo Portal',
                                 49,
                                 'Solo queda una oportunidad.'
                             );

-- =====================================================
-- TEMPORADA 35
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 35,
                                 1,
                                 'Primer Trabajo',
                                 30,
                                 'Los protagonistas buscan empleo.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 35,
                                 2,
                                 'Independencia',
                                 31,
                                 'Mudarse parece una gran idea.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 35,
                                 3,
                                 'Red Social',
                                 29,
                                 'Una publicacion cambia todo.'
                             );

-- =====================================================
-- TEMPORADA 37
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 37,
                                 1,
                                 'Crisis',
                                 32,
                                 'La ansiedad afecta al grupo.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 37,
                                 2,
                                 'Ansiedad Social',
                                 33,
                                 'Las relaciones se rompen.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 37,
                                 3,
                                 'Depresion',
                                 34,
                                 'El protagonista toca fondo.'
                             );

-- =====================================================
-- TEMPORADA 39
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 39,
                                 1,
                                 'Mudanza',
                                 31,
                                 'Todos cambian de ciudad.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 39,
                                 2,
                                 'La Vida Real',
                                 34,
                                 'Ser adulto no era tan facil.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 39,
                                 3,
                                 'Primer Apartamento',
                                 32,
                                 'El grupo intenta convivir.'
                             );

-- =====================================================
-- TEMPORADA 41
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 41,
                                 1,
                                 'Ascenso',
                                 58,
                                 'La familia criminal gana poder.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 41,
                                 2,
                                 'Traicion',
                                 57,
                                 'Un aliado traiciona al imperio.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 41,
                                 3,
                                 'La Venganza',
                                 59,
                                 'El lider busca revancha.'
                             );

-- =====================================================
-- TEMPORADA 43
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 43,
                                 1,
                                 'La Caida',
                                 60,
                                 'Todo comienza a derrumbarse.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 43,
                                 2,
                                 'Ultimo Rey',
                                 61,
                                 'Solo uno puede gobernar.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 43,
                                 3,
                                 'Herederos',
                                 58,
                                 'La nueva generacion aparece.'
                             );

-- =====================================================
-- TEMPORADA 45
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 45,
                                 1,
                                 'Bienvenidos',
                                 41,
                                 'Los estudiantes llegan al internado.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 45,
                                 2,
                                 'El Sotano',
                                 42,
                                 'Un secreto oculto es descubierto.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 45,
                                 3,
                                 'Noche Oscura',
                                 44,
                                 'Algo extraño sucede en la noche.'
                             );

-- =====================================================
-- TEMPORADA 47
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 47,
                                 1,
                                 'La Sociedad',
                                 43,
                                 'Una organizacion secreta controla el colegio.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 47,
                                 2,
                                 'Escape',
                                 44,
                                 'Los protagonistas intentan huir.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 47,
                                 3,
                                 'El Director',
                                 45,
                                 'El director revela sus planes.'
                             );

-- =====================================================
-- TEMPORADA 49
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 49,
                                 1,
                                 'Cocina Oculta',
                                 35,
                                 'El chef entra a la competencia.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 49,
                                 2,
                                 'El Jurado',
                                 34,
                                 'El jurado elimina a un participante.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 49,
                                 3,
                                 'Postres',
                                 36,
                                 'La competencia llega al limite.'
                             );

-- =====================================================
-- TEMPORADA 51
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 51,
                                 1,
                                 'Sabores del Mundo',
                                 36,
                                 'Los chefs viajan internacionalmente.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 51,
                                 2,
                                 'Final Gourmet',
                                 38,
                                 'La gran final comienza.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 51,
                                 3,
                                 'Master Chef',
                                 37,
                                 'Solo uno ganara el concurso.'
                             );

-- =====================================================
-- TEMPORADA 53
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 53,
                                 1,
                                 'La Señal',
                                 49,
                                 'Una señal misteriosa surge bajo el hielo.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 53,
                                 2,
                                 'Bajo el Hielo',
                                 50,
                                 'El equipo encuentra algo imposible.'
                             );

-- =====================================================
-- TEMPORADA 55
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 55,
                                 1,
                                 'Poder',
                                 46,
                                 'Las protagonistas luchan por el control.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 55,
                                 2,
                                 'Negocios',
                                 45,
                                 'Las decisiones afectan a todos.'
                             );

-- =====================================================
-- TEMPORADA 57
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 57,
                                 1,
                                 'Desaparicion',
                                 52,
                                 'Un niño desaparece en Hawkins.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 57,
                                 2,
                                 'El Portal',
                                 54,
                                 'El laboratorio es investigado.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 57,
                                 3,
                                 'Vecna',
                                 57,
                                 'Una nueva amenaza aparece.'
                             );

-- =====================================================
-- TEMPORADA 59
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 59,
                                 1,
                                 'Sombras',
                                 55,
                                 'Las sombras regresan.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 59,
                                 2,
                                 'Hawkins',
                                 56,
                                 'El pueblo entra en caos.'
                             );

-- =====================================================
-- TEMPORADA 61
-- =====================================================

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 61,
                                 1,
                                 'Episodio Especial',
                                 60,
                                 'Evento especial de la temporada.'
                             );

INSERT INTO EPISODIOS VALUES (
                                 seq_episodios.NEXTVAL,
                                 61,
                                 2,
                                 'Final Especial',
                                 62,
                                 'Un cierre inesperado para la historia.'
                             );

COMMIT;
