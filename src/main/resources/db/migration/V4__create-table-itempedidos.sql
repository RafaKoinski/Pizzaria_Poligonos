create table ItemPedidos(

    id bigint not null auto_increment,
    id_pedido bigint,
    id_produto bigint,
    quantidade integer,
    precounitario DECIMAL(10,2),
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id) ON DELETE CASCADE,
    FOREIGN KEY (id_produto) REFERENCES produtos(id) ON DELETE CASCADE,

    primary key(id)

);