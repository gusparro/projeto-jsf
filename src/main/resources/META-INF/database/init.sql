INSERT INTO appuser (name, email, password, created_at) VALUES ('Gustavo Parro', 'parrogustavo@gmail.com', '123456', now());

INSERT INTO role (name, description, created_at) VALUES ('Admin', 'Person who is in charge of the operation of the website.', now());
INSERT INTO role (name, description, created_at) VALUES ('Manager', 'A person responsible for controlling  all or part of the website.', now());

INSERT INTO appuser_role (appuser_id, role_id) VALUES (1, 1);
INSERT INTO appuser_role (appuser_id, role_id) VALUES (1, 2);

INSERT INTO product (name, description, price, created_at) values ('Câmera GoPro Hero 7', 'Desempenho 2x melhor.',  1400.0, now());
INSERT INTO product (name, description, price, created_at) values ('Mochila Infantil de Costa Homem Aranha Gd 16', 'Mochila Infantil de Costa Homem Aranha Gd 16 - Xeryuss Material em polyester com PVC cristal, um compartimento grande.',  104.99, now());
INSERT INTO product (name, description, price, created_at) values ('Smartphone Motorola Moto G51 5G 128GB Android 11 Tela 6.8 Azul', 'Ficha técnica Fabricante Motorola tela Tamanho 6,8 polegadas Resolução 1080 x 2400 pixels Tecnologia ips.',  1488.90, now());
INSERT INTO product (name, description, price, created_at) values ('Notebook Multilaser Ultra Celeron N4020 14.1 HD 128GB ssd 4GB Linux', 'Notebook Multilaser Ultra Celeron N4020 14.1 HD 128GB ssd 4GB Linux Intel Celeron O desempenho notável do Notebook Ultra é possível graças a um processador Intel Celeron.',  1044.20, now());

INSERT INTO client (name, email, cpf, gender,created_at) VALUES ('Marcos Mariano', 'marcosma@gmail.com', '123.542.123-34', 'MASCULINE', now());
INSERT INTO client (name, email, cpf, gender,created_at) VALUES ('Felipe Nunes', 'lipenunes@gmail.com', '564.326.887-09', 'MASCULINE', now());
INSERT INTO client (name, email, cpf, gender,created_at) VALUES ('Fabiana Cabral', 'facabral@gmail.com', '99.243.564-98', 'FEMININE', now());



