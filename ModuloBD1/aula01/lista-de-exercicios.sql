-- Exercicio 1
Create table Produto(
    IDProduto int not null,
    Nome varchar(30) not null,
    NomeDescritivo varchar(100),
    DataCriacao datetime not null,
    LocalDoEstoque varchar(50),
    Quantidade int,
    Preco float,
    constraint PK_Produto primary key (IDProduto)
);
-- Exercicio 2
Create table LocalEstoque(
    IDLocalEstoque int not null,
    Nome varchar(50) not null,
    DataCriacao datetime not null,
    Capacidade int,
    constraint PK_LocalEstoque primary key (IDLocalEstoque)
);
-- Exercicio 3
Alter table Produto alter column LocalDoEstoque int;
-- Exercicio 4
