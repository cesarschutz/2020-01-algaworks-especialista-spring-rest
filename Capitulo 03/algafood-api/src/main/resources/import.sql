insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Peruana'); /* Não utilizar essa cozinha em relacionamento pois ela é utilizada no teste de remover() */
insert into restaurante (nome, taxa_frete, cozinha_codigo) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_codigo) values ('Thai Delivery', 9.50, 2);
insert into restaurante (nome, taxa_frete, cozinha_codigo) values ('Tuk Tuk Comida Indiana', 15, 1);

