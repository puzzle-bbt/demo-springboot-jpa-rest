INSERT INTO person (id, firstname, lastname, age) VALUES (1, 'Yanick', 'Minder', 12),
                                                         (2, 'Marc', 'Egli', 12),
                                                         (3, 'Niklas', 'Jäggi', 12),
                                                         (4, 'Lias', 'Kleisa', 12),
                                                         (5, 'Jonas', 'Schmid', 12);

INSERT INTO objective (id, title, description, person_id) VALUES (1, 'TestObjective1', 'TestObjDesc1', 1);
INSERT INTO key_result (id, title, description, result_type, objective_id, person_id) VALUES (1, 'TestKeyResult1', 'TestKeyDescription1', 1, 1, 1);
INSERT INTO result (id, name, description, "value", key_result_id, person_id) VALUES (1, 'TestResult1', 'TestDescription1', 100, 1, 1);

ALTER SEQUENCE hibernate_sequence RESTART WITH 1000;