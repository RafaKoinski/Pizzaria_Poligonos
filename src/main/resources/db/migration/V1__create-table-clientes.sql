create table Clientes(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(20),
    ativo TINYINT (1) not null,
    login varchar(50) not null unique,
    senha varchar(255) not null,
    endereco varchar(100) not null,
    bairro varchar(100) not null,
    cep integer not null,
    complemento varchar(100),
    num varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,

    primary key(id)

);