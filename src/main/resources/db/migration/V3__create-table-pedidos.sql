create table Pedidos(

    id bigint not null auto_increment,
    idCliente bigint,
    dataHora datetime,
    status VARCHAR(50),
    FOREIGN KEY (idCliente) REFERENCES clientes(id) ON DELETE CASCADE,

    primary key(id)

);