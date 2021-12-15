-- Here write initialization data

INSERT INTO t_customer (id, first_name, last_name, phone_number)
VALUES (1, 'Artur', 'Pendragon', '0123456789'),
       (2, 'Léodagan', 'De Carmélide', '1234567890'),
       (3, 'Perceval', 'De Galle', '2345678901'),
       (4, 'Karadoc', 'De Vanne', '3456789012'),
       (5, 'Lancelot', 'Du Lac', '4567890123'),
       (6, 'Guenièvre', 'De Carmélide', '5678901234'),
       (7, 'Bohort', 'De Gaune', '6789012345'),
       (8, 'Le père', 'Blaise', '7890123456'),
       (9, 'Séli', 'De Carmélide', '8901234567'),
       (10, 'Yvain', 'Chevalier au Lion', '9012345678');


INSERT INTO t_dish (id, description, name, price, tva, type)
VALUES (1,
        'Sans vouloir la ramener, la seule différence concrète avec des briques, c''est que vous appelez ça des tartes !',
        'Tarte aux fraises', 5, .1, 'DESERT'),
       (2, 'Arthour !… Pas changer assiette pour fromage !', 'Assiette de fromage', 4, .15, 'ENTRY'),
       (3, 'JE NE MANGE PAS DE GRAINES !', 'Lasagnes végétariennes', 5, .1, 'MAIN'),
       (4, 'Il faut pas respirer la compote, ça fait tousser.', 'Compote de pomme', 5, .1, 'DESERT'),
       (5, 'Elle est où la poulette ?', 'Poulet frit', 5, .1, 'MAIN');


INSERT INTO t_truck (id, description, name)
VALUES
       (1, 'Le truck de Yvain et Gauvain !', 'Les petits pédestres'),
       (2, 'Le truck de Provencal et Karadoc !', 'Le clan des semis croustillants'),
       (3, 'La nouvelle experience de Yvain et Gauvain', 'Les petits pédestres dont un au Lion');

INSERT INTO t_menu (id, description, name, tva)
VALUES
       (1, 'Pour les grand voyageurs', 'Le Petit frichti', .3),
       (2, 'Pour les grand gourmands', 'Le Banquet', .31),
       (3, 'Pour ceux qui ont les dents solides', 'Le repas de belle maman', .32);

INSERT INTO t_menu_dishes
VALUES
       (1, 2),
       (1, 1),
       (1, 3),
       (2, 1),
       (2, 2);


-- insert into users(id, firstname, lastname, username, password, email, enabled) values (1, 'Admin', 'Client', 'admin', 'adminpwd', 'admin@lacatholille.fr', true);
-- insert into users(id, firstname, lastname, username, password, email, enabled) values (2, 'User', 'Client', 'user', 'userpwd', 'user@lacatholille.fr', true);
--
-- insert into authorities(username, authority) values ('user', 'USER');
-- insert into authorities(username, authority) values ('admin', 'ADMIN');