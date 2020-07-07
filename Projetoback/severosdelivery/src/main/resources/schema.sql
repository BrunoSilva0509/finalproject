drop table if exists pedidos;

create table pedidos(
    id_pedido bigint auto_increment,
    nome varchar(100) not null,
    endereco varchar(100) not null,
    pedido varchar(100) not null,
    primary key(id_pedido)
    );