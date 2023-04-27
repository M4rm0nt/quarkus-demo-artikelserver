-- This file allow to write SQL commands that will be emitted in test and dev.
insert into t_artikel (id, ean, bezeichnung) values
(1, 'EAN1', 'Artikel 1'),
(2, 'EAN2', 'Artikel 2'),
(3, 'EAN3', 'Artikel 3'),
(4, 'EAN4', 'Artikel 4'),
(5, 'EAN5', 'Artikel 5'),
(6, 'EAN6', 'Artikel 6'),
(7, 'EAN7', 'Artikel 7');
ALTER SEQUENCE t_artikel_SEQ RESTART WITH 8;