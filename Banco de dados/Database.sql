create database estoque;
use estoque;

create table usuario(
	id_user int auto_increment primary key,
    nome varchar(30) not null,
    login varchar(30) not null,
    senha varchar(30) not null,
    permicao varchar(15) not null
);

create table produto (
	id_produto int auto_increment primary key,
    nome varchar(30) not null,
    descricao text not null,
    quantidade int not null,
    posicao varchar(10) not null
);

create table userProd(
	id_userProd int auto_increment primary key,
    id_usuario int not null,
    foreign key(id_usuario) references usuario(id_user),
    id_prod int not null,
    foreign key (id_prod) references produto(id_produto),
    quantidade int not null
);