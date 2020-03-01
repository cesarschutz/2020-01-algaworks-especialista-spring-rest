insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');
insert into cozinha (id, nome) values (3, 'Peruana'); /* Não utilizar essa cozinha em relacionamento pois ela é utilizada no teste de remover() */
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 2);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 1);
insert into forma_de_pagamento (descricao) values ('Cartão débito');
insert into forma_de_pagamento (descricao) values ('Cartão Crédito');
insert into forma_de_pagamento (descricao) values ('Dinheiro');
insert into estado (nome) values ('Santa Catarina');
insert into estado (nome) values ('Parana');
insert into estado (nome) values ('São Paulo');
insert into cidade (nome, estado_id) values ('Florianópolis', 1);
insert into cidade (nome, estado_id) values ('Curitiba', 2);
insert into cidade (nome, estado_id) values ('São Paulo', 3);
insert into permissao (nome, descricao) values ('read', 'permissao de leitura');
insert into permissao (nome, descricao) values ('write', 'permissao de escrita');



