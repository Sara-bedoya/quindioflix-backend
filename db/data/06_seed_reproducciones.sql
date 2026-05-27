 /*

SEED DATA - REPRODUCCIONES PARTE 1
Proyecto QuindioFlix
====================

Descripción:
Primer bloque de 50 reproducciones.
Datos asimétricos y coherentes con:

* edades
* perfiles infantiles
* episodios
* dispositivos
  =====================================================
  */

-- =====================================================
-- SERIES
-- =====================================================

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      1,
                                      35,
                                      TO_TIMESTAMP('2025-01-10 20:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-01-10 21:15:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      1
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      3,
                                      41,
                                      TO_TIMESTAMP('2025-02-11 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-02-11 23:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      25
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      14,
                                      38,
                                      TO_TIMESTAMP('2025-03-15 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-15 18:48:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      17
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      17,
                                      40,
                                      TO_TIMESTAMP('2025-04-01 14:20:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-04-01 14:50:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      19
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      18,
                                      37,
                                      TO_TIMESTAMP('2025-04-03 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-04-03 19:42:00','YYYY-MM-DD HH24:MI:SS'),
                                      95,
                                      'TV',
                                      13
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      20,
                                      2,
                                      TO_TIMESTAMP('2025-04-06 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-04-06 21:54:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      43
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      22,
                                      43,
                                      TO_TIMESTAMP('2025-04-08 17:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-04-08 18:10:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      31
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      23,
                                      46,
                                      TO_TIMESTAMP('2025-04-09 13:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-04-09 13:35:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      37
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      27,
                                      35,
                                      TO_TIMESTAMP('2025-04-12 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-04-12 20:45:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      2
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      32,
                                      41,
                                      TO_TIMESTAMP('2025-04-13 22:10:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-04-13 23:08:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      26
                                  );

-- =====================================================
-- PERFILES INFANTILES (SOLO TP +7 +13)
-- =====================================================

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      2,
                                      28,
                                      TO_TIMESTAMP('2025-03-01 16:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-01 17:28:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      10,
                                      40,
                                      TO_TIMESTAMP('2025-03-02 15:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-02 15:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      19
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      11,
                                      46,
                                      TO_TIMESTAMP('2025-03-03 11:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-03 11:35:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      37
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      19,
                                      47,
                                      TO_TIMESTAMP('2025-03-04 10:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-04 11:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      21,
                                      51,
                                      TO_TIMESTAMP('2025-03-05 12:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-05 13:10:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      24,
                                      23,
                                      TO_TIMESTAMP('2025-03-06 17:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-06 18:50:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      26,
                                      50,
                                      TO_TIMESTAMP('2025-03-07 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-07 19:40:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      29,
                                      40,
                                      TO_TIMESTAMP('2025-03-08 14:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-08 14:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      20
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      30,
                                      59,
                                      TO_TIMESTAMP('2025-03-09 16:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-09 16:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      34,
                                      52,
                                      TO_TIMESTAMP('2025-03-10 13:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2025-03-10 14:20:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

 /*

SEED DATA - REPRODUCCIONES PARTE 2
Proyecto QuindioFlix
====================

Descripción:
Segundo bloque de reproducciones.
Periodo:
ENERO 2026 - MAYO 2026
======================

*/

-- =====================================================
-- ENERO 2026
-- =====================================================

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      1,
                                      27,
                                      TO_TIMESTAMP('2026-01-03 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-03 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      3,
                                      38,
                                      TO_TIMESTAMP('2026-01-05 18:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-05 19:18:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      18
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      14,
                                      35,
                                      TO_TIMESTAMP('2026-01-07 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-07 21:45:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      3
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      17,
                                      41,
                                      TO_TIMESTAMP('2026-01-10 22:15:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-10 23:12:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      27
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      18,
                                      24,
                                      TO_TIMESTAMP('2026-01-12 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-12 20:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      22,
                                      37,
                                      TO_TIMESTAMP('2026-01-14 17:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-14 17:42:00','YYYY-MM-DD HH24:MI:SS'),
                                      96,
                                      'TABLET',
                                      14
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      23,
                                      33,
                                      TO_TIMESTAMP('2026-01-15 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-15 22:08:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      27,
                                      45,
                                      TO_TIMESTAMP('2026-01-18 23:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-18 23:55:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      32,
                                      43,
                                      TO_TIMESTAMP('2026-01-20 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-20 18:40:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      31
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      37,
                                      2,
                                      TO_TIMESTAMP('2026-01-22 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-22 21:55:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      44
                                  );

-- =====================================================
-- PERFILES INFANTILES
-- =====================================================

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      2,
                                      28,
                                      TO_TIMESTAMP('2026-01-04 15:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-04 16:28:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      10,
                                      40,
                                      TO_TIMESTAMP('2026-01-08 13:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-08 13:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      21
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      11,
                                      46,
                                      TO_TIMESTAMP('2026-01-09 11:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-09 11:35:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      38
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      19,
                                      47,
                                      TO_TIMESTAMP('2026-01-11 10:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-11 11:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      21,
                                      51,
                                      TO_TIMESTAMP('2026-01-13 12:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-01-13 13:10:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      NULL
                                  );

-- =====================================================
-- FEBRERO 2026
-- =====================================================

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      42,
                                      41,
                                      TO_TIMESTAMP('2026-02-02 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-02-02 22:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      26
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      43,
                                      38,
                                      TO_TIMESTAMP('2026-02-04 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-02-04 19:48:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      17
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      45,
                                      27,
                                      TO_TIMESTAMP('2026-02-06 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-02-06 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      46,
                                      35,
                                      TO_TIMESTAMP('2026-02-08 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-02-08 21:45:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      2
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      48,
                                      30,
                                      TO_TIMESTAMP('2026-02-10 23:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-02-10 24:38:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      49,
                                      37,
                                      TO_TIMESTAMP('2026-02-12 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-02-12 18:42:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      13
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      51,
                                      2,
                                      TO_TIMESTAMP('2026-02-15 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-02-15 21:55:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      43
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      53,
                                      33,
                                      TO_TIMESTAMP('2026-02-17 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-02-17 21:08:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      55,
                                      24,
                                      TO_TIMESTAMP('2026-02-20 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-02-20 21:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      57,
                                      43,
                                      TO_TIMESTAMP('2026-02-22 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-02-22 18:40:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      32
                                  );

/*

SEED DATA - REPRODUCCIONES PARTE 3
Proyecto QuindioFlix
====================

Periodo:
MARZO 2026 - ABRIL 2026
=======================

*/

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      59,
                                      41,
                                      TO_TIMESTAMP('2026-03-01 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-01 21:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      27
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      60,
                                      38,
                                      TO_TIMESTAMP('2026-03-02 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-02 19:48:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      18
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      1,
                                      35,
                                      TO_TIMESTAMP('2026-03-03 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-03 20:45:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      2
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      3,
                                      37,
                                      TO_TIMESTAMP('2026-03-04 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-04 18:42:00','YYYY-MM-DD HH24:MI:SS'),
                                      92,
                                      'TABLET',
                                      14
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      14,
                                      33,
                                      TO_TIMESTAMP('2026-03-05 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-05 23:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      17,
                                      27,
                                      TO_TIMESTAMP('2026-03-06 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-06 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      18,
                                      30,
                                      TO_TIMESTAMP('2026-03-07 23:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-07 23:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      20,
                                      43,
                                      TO_TIMESTAMP('2026-03-08 17:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-08 17:40:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      31
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      22,
                                      41,
                                      TO_TIMESTAMP('2026-03-09 21:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-09 22:28:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      26
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      23,
                                      35,
                                      TO_TIMESTAMP('2026-03-10 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-10 20:45:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      3
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      27,
                                      38,
                                      TO_TIMESTAMP('2026-03-11 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-11 18:48:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      17
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      32,
                                      45,
                                      TO_TIMESTAMP('2026-03-12 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-12 19:55:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      37,
                                      24,
                                      TO_TIMESTAMP('2026-03-13 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-13 23:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      42,
                                      2,
                                      TO_TIMESTAMP('2026-03-14 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-14 21:55:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      44
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      43,
                                      33,
                                      TO_TIMESTAMP('2026-03-15 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-15 22:08:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      45,
                                      41,
                                      TO_TIMESTAMP('2026-03-16 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-16 21:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      25
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      46,
                                      37,
                                      TO_TIMESTAMP('2026-03-17 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-17 18:42:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      13
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      48,
                                      38,
                                      TO_TIMESTAMP('2026-03-18 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-18 19:48:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      18
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      49,
                                      35,
                                      TO_TIMESTAMP('2026-03-19 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-19 20:45:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      1
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      51,
                                      27,
                                      TO_TIMESTAMP('2026-03-20 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-03-20 23:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

-- INFANTILES

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      2,
                                      28,
                                      TO_TIMESTAMP('2026-04-01 16:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-01 17:28:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      10,
                                      40,
                                      TO_TIMESTAMP('2026-04-02 14:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-02 14:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      20
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      11,
                                      46,
                                      TO_TIMESTAMP('2026-04-03 11:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-03 11:35:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      38
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      19,
                                      47,
                                      TO_TIMESTAMP('2026-04-04 10:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-04 11:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      21,
                                      51,
                                      TO_TIMESTAMP('2026-04-05 12:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-05 13:10:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      24,
                                      23,
                                      TO_TIMESTAMP('2026-04-06 17:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-06 18:50:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      26,
                                      50,
                                      TO_TIMESTAMP('2026-04-07 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-07 19:40:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      29,
                                      40,
                                      TO_TIMESTAMP('2026-04-08 14:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-08 14:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      19
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      30,
                                      59,
                                      TO_TIMESTAMP('2026-04-09 16:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-09 16:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      34,
                                      52,
                                      TO_TIMESTAMP('2026-04-10 13:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-10 14:20:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

 /*

SEED DATA - REPRODUCCIONES PARTE 4
Proyecto QuindioFlix
====================

Periodo:
ABRIL 2026 - MAYO 2026
======================

*/

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      37,
                                      41,
                                      TO_TIMESTAMP('2026-04-11 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-11 21:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      27
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      38,
                                      38,
                                      TO_TIMESTAMP('2026-04-12 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-12 19:48:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      17
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      39,
                                      35,
                                      TO_TIMESTAMP('2026-04-13 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-13 20:45:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      2
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      40,
                                      27,
                                      TO_TIMESTAMP('2026-04-14 20:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-14 22:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      41,
                                      24,
                                      TO_TIMESTAMP('2026-04-15 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-15 23:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      42,
                                      43,
                                      TO_TIMESTAMP('2026-04-16 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-16 18:40:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      32
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      43,
                                      41,
                                      TO_TIMESTAMP('2026-04-17 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-17 21:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      25
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      45,
                                      37,
                                      TO_TIMESTAMP('2026-04-18 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-18 18:42:00','YYYY-MM-DD HH24:MI:SS'),
                                      94,
                                      'TABLET',
                                      13
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      46,
                                      38,
                                      TO_TIMESTAMP('2026-04-19 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-19 19:48:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      18
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      48,
                                      35,
                                      TO_TIMESTAMP('2026-04-20 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-20 20:45:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      3
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      49,
                                      45,
                                      TO_TIMESTAMP('2026-04-21 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-21 20:55:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      51,
                                      30,
                                      TO_TIMESTAMP('2026-04-22 23:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-22 23:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      53,
                                      2,
                                      TO_TIMESTAMP('2026-04-23 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-23 21:55:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      43
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      55,
                                      33,
                                      TO_TIMESTAMP('2026-04-24 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-24 22:08:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      57,
                                      41,
                                      TO_TIMESTAMP('2026-04-25 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-25 21:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      26
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      59,
                                      37,
                                      TO_TIMESTAMP('2026-04-26 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-26 18:42:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      14
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      60,
                                      38,
                                      TO_TIMESTAMP('2026-04-27 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-04-27 19:48:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      17
                                  );

-- INFANTILES

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      2,
                                      28,
                                      TO_TIMESTAMP('2026-05-01 16:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-05-01 17:28:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      10,
                                      40,
                                      TO_TIMESTAMP('2026-05-02 14:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-05-02 14:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      20
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      11,
                                      46,
                                      TO_TIMESTAMP('2026-05-03 11:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-05-03 11:35:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      37
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      19,
                                      47,
                                      TO_TIMESTAMP('2026-05-04 10:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-05-04 11:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      21,
                                      51,
                                      TO_TIMESTAMP('2026-05-05 12:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-05-05 13:10:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'COMPUTADOR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      24,
                                      23,
                                      TO_TIMESTAMP('2026-05-06 17:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-05-06 18:50:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      26,
                                      50,
                                      TO_TIMESTAMP('2026-05-07 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-05-07 19:40:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'CELULAR',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      29,
                                      40,
                                      TO_TIMESTAMP('2026-05-08 14:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-05-08 14:30:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TABLET',
                                      19
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      30,
                                      59,
                                      TO_TIMESTAMP('2026-05-09 16:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-05-09 16:58:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

INSERT INTO REPRODUCCIONES VALUES (
                                      seq_reproducciones.NEXTVAL,
                                      34,
                                      52,
                                      TO_TIMESTAMP('2026-05-10 13:00:00','YYYY-MM-DD HH24:MI:SS'),
                                      TO_TIMESTAMP('2026-05-10 14:20:00','YYYY-MM-DD HH24:MI:SS'),
                                      100,
                                      'TV',
                                      NULL
                                  );

 /*

SEED DATA - REPRODUCCIONES PARTE 5
Proyecto QuindioFlix
====================

Último bloque de reproducciones.
Con esto se completan las 200 reproducciones.
=============================================

*/

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       1,
                                       41,
                                       TO_TIMESTAMP('2026-05-11 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-11 21:58:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       26
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       3,
                                       38,
                                       TO_TIMESTAMP('2026-05-12 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-12 19:48:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'COMPUTADOR',
                                       18
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       14,
                                       35,
                                       TO_TIMESTAMP('2026-05-13 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-13 20:45:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       1
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       17,
                                       27,
                                       TO_TIMESTAMP('2026-05-14 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-14 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       18,
                                       30,
                                       TO_TIMESTAMP('2026-05-15 23:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-15 23:58:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'CELULAR',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       20,
                                       43,
                                       TO_TIMESTAMP('2026-05-16 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-16 18:40:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       31
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       22,
                                       41,
                                       TO_TIMESTAMP('2026-05-17 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-17 21:58:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       25
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       23,
                                       37,
                                       TO_TIMESTAMP('2026-05-18 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-18 18:42:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TABLET',
                                       13
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       27,
                                       38,
                                       TO_TIMESTAMP('2026-05-19 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-19 19:48:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'COMPUTADOR',
                                       17
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       32,
                                       35,
                                       TO_TIMESTAMP('2026-05-20 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-20 20:45:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       3
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       37,
                                       45,
                                       TO_TIMESTAMP('2026-05-21 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-21 20:55:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       42,
                                       24,
                                       TO_TIMESTAMP('2026-05-22 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-22 23:58:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'COMPUTADOR',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       43,
                                       2,
                                       TO_TIMESTAMP('2026-05-23 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-23 21:55:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       44
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       45,
                                       33,
                                       TO_TIMESTAMP('2026-05-24 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-24 22:08:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       46,
                                       41,
                                       TO_TIMESTAMP('2026-05-25 21:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-25 21:58:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       27
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       48,
                                       37,
                                       TO_TIMESTAMP('2026-05-26 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-26 18:42:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TABLET',
                                       14
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       49,
                                       38,
                                       TO_TIMESTAMP('2026-05-27 19:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-27 19:48:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'COMPUTADOR',
                                       18
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       51,
                                       35,
                                       TO_TIMESTAMP('2026-05-28 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-28 20:45:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       2
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       53,
                                       27,
                                       TO_TIMESTAMP('2026-05-29 20:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-29 22:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       55,
                                       30,
                                       TO_TIMESTAMP('2026-05-30 23:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-30 23:58:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'CELULAR',
                                       NULL
                                   );

-- INFANTILES

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       2,
                                       28,
                                       TO_TIMESTAMP('2026-05-11 16:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-11 17:28:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       10,
                                       40,
                                       TO_TIMESTAMP('2026-05-12 14:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-12 14:30:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TABLET',
                                       21
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       11,
                                       46,
                                       TO_TIMESTAMP('2026-05-13 11:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-13 11:35:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'CELULAR',
                                       37
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       19,
                                       47,
                                       TO_TIMESTAMP('2026-05-14 10:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-14 11:30:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       21,
                                       51,
                                       TO_TIMESTAMP('2026-05-15 12:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-15 13:10:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'COMPUTADOR',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       24,
                                       23,
                                       TO_TIMESTAMP('2026-05-16 17:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-16 18:50:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       26,
                                       50,
                                       TO_TIMESTAMP('2026-05-17 18:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-17 19:40:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'CELULAR',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       29,
                                       40,
                                       TO_TIMESTAMP('2026-05-18 14:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-18 14:30:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TABLET',
                                       20
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       30,
                                       59,
                                       TO_TIMESTAMP('2026-05-19 16:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-19 16:58:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       NULL
                                   );

 INSERT INTO REPRODUCCIONES VALUES (
                                       seq_reproducciones.NEXTVAL,
                                       34,
                                       52,
                                       TO_TIMESTAMP('2026-05-20 13:00:00','YYYY-MM-DD HH24:MI:SS'),
                                       TO_TIMESTAMP('2026-05-20 14:20:00','YYYY-MM-DD HH24:MI:SS'),
                                       100,
                                       'TV',
                                       NULL
                                   );

 COMMIT;




