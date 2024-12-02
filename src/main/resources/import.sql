INSERT INTO tb_categoria (descricao) VALUES ('Combo');
INSERT INTO tb_categoria (descricao) VALUES ('Refrigerante');

INSERT INTO tb_produto(descricao, preco) VALUES ('Box burguer família',100.00);
INSERT INTO tb_produto(descricao, preco) VALUES ('Bacon Lover’s Dream',80.00);
INSERT INTO tb_produto(descricao, preco) VALUES ('Frango Frenético',50.00);
INSERT INTO tb_produto(descricao, preco) VALUES ('Bebidas',10.00);

INSERT INTO tb_produto_categoria(produto_id,categoria_id) VALUES(1,1);
INSERT INTO tb_produto_categoria(produto_id,categoria_id) VALUES(2,1);
INSERT INTO tb_produto_categoria(produto_id,categoria_id) VALUES(3,1);
INSERT INTO tb_produto_categoria(produto_id,categoria_id) VALUES(4,2);

INSERT INTO tb_detalhe_produto(produto_id, descricao) VALUES (1, 'Box burguer família');
INSERT INTO tb_detalhe_produto(produto_id, descricao) VALUES (2, 'Bacon Lover’s Dream');
INSERT INTO tb_detalhe_produto(produto_id, descricao) VALUES (3, 'Frango Frenético');
INSERT INTO tb_detalhe_produto(produto_id, descricao) VALUES (4, 'Bebidas');

INSERT INTO tb_item_detalhe_produto(descricao,preco,adicional,possue_acucar) VALUES ('Bacon', 10.00,'S','N');
INSERT INTO tb_item_detalhe_produto(descricao,preco,adicional,possue_acucar) VALUES ('Queijo', 10.00,'S','N');
INSERT INTO tb_item_detalhe_produto(descricao,preco,adicional,possue_acucar) VALUES ('Alface', 5.00,'S','N');
INSERT INTO tb_item_detalhe_produto(descricao,preco,adicional,possue_acucar) VALUES ('Calabresa', 10.00,'S','N');
INSERT INTO tb_item_detalhe_produto(descricao,preco,adicional,possue_acucar) VALUES ('Molho', 10.00,'S','N');
INSERT INTO tb_item_detalhe_produto(descricao,preco,adicional,possue_acucar) VALUES ('Batata palha', 5.00,'S','N');
INSERT INTO tb_item_detalhe_produto(descricao,preco,adicional,possue_acucar) VALUES ('Coca Cola 2L ', 15.00,'N','S');
INSERT INTO tb_item_detalhe_produto(descricao,preco,adicional,possue_acucar) VALUES ('Coca Cola Zero 2L', 15.00,'N','N');

INSERT INTO  tb_itens_detalhe_produto(detalhe_produto_id, item_detalhe_produto_id) VALUES (1,1);
INSERT INTO  tb_itens_detalhe_produto(detalhe_produto_id, item_detalhe_produto_id) VALUES (1,2);
INSERT INTO  tb_itens_detalhe_produto(detalhe_produto_id, item_detalhe_produto_id) VALUES (1,3);
INSERT INTO  tb_itens_detalhe_produto(detalhe_produto_id, item_detalhe_produto_id) VALUES (1,5);
INSERT INTO  tb_itens_detalhe_produto(detalhe_produto_id, item_detalhe_produto_id) VALUES (4,4);


INSERT INTO tb_cliente(nome, email, telefone, data_nascimento,endereco) VALUES('Ana', 'ana@gmail.com','988888888','1987-12-13','AV. SAUDADE,123');
INSERT INTO tb_cliente(nome, email, telefone, data_nascimento,endereco) VALUES('Maria', 'maria@gmail.com','988888887','1981-12-13','AV. TIRADENTES,55');
INSERT INTO tb_cliente(nome, email, telefone, data_nascimento,endereco) VALUES('João', 'joao@gmail.com','988888897','1981-01-03','AV. BAGUAÇU,275');

INSERT INTO tb_pedido(descricao, data, status,cliente_id)VALUES('Cliente exigente','2024-12-01T11:10:00Z','ENVIADO', 1);
INSERT INTO tb_pedido(descricao, data, status,cliente_id)VALUES('Entregar o mais rápido possível','2024-12-01T20:00:00Z','ENTREGUE', 2);
INSERT INTO tb_pedido(descricao, data, status,cliente_id)VALUES('Cliente não tem pressa','2024-12-01T21:00:00Z','PAGO', 3);

INSERT INTO tb_item_pedido(observacao,quantidade,preco,produto_id,pedido_id) VALUES('Dobro de bacon',1,80.00,2,1);
INSERT INTO tb_item_pedido(observacao,quantidade,preco,produto_id,pedido_id) VALUES('Bem gelada',1,10.00,4,1);
INSERT INTO tb_item_pedido(observacao,quantidade,preco,produto_id,pedido_id) VALUES('Não colocar molho',1,100.00,1,2);
INSERT INTO tb_item_pedido(observacao,quantidade,preco,produto_id,pedido_id) VALUES('Bem gelada',1,10.00,4,2);