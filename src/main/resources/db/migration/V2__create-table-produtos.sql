create table Produtos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    descricao varchar(255) not null,
    imagem varchar(255) not null,
    grupo varchar(30) not null,
    ativo TINYINT (1) not null,

    primary key(id)

);