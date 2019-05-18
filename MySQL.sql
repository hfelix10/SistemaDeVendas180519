CREATE DATABASE poo;
USE poo;

CREATE TABLE cliente(

id int auto_increment,
nome varchar(48),
cpf varchar(48),
primary key(id)


);

insert into cliente (nome,cpf) values('willian','3443432');
insert into cliente (nome,cpf) values('hassan','3443432');
insert into cliente (nome,cpf) values('disraele','3443432');
insert into cliente (nome,cpf) values('zurubuzamba','3443432');

CREATE TABLE Item_venda(

id_item_venda int auto_increment,
id_venda int,
id_produto int,
qtde int,
valor_item double,

primary key(id_item_venda)


);

CREATE TABLE produto(

id_produto int auto_increment,
descricao varchar (60),
valor_unitario double,

primary key(id_produto)


);

CREATE TABLE venda(

id_venda int auto_increment,
data_venda datetime,
id_cliente int,
valor_total double,

primary key(id_venda)


);

insert into produto (descricao,valor_unitario) values("camiseta",25);
insert into produto (descricao,valor_unitario) values("moletom",35);
insert into produto (descricao,valor_unitario) values("jaqueta",280);
insert into produto (descricao,valor_unitario) values("bota",100);