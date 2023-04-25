-- This file allow to write SQL commands that will be emitted in test and dev.
insert into t_artikel (id, ean, bezeichnung) values 
(nextval('hibernate_sequence'), 'EAN1', 'Artikel 1'),
(nextval('hibernate_sequence'), 'EAN2', 'Artikel 2'),
(nextval('hibernate_sequence'), 'EAN3', 'Artikel 3'),
(nextval('hibernate_sequence'), 'EAN4', 'Artikel 4'),
(nextval('hibernate_sequence'), 'EAN5', 'Artikel 5'),
(nextval('hibernate_sequence'), 'EAN6', 'Artikel 6'),
(nextval('hibernate_sequence'), 'EAN7', 'Artikel 7');