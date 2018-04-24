-- Exercicio 1
Create table Produto(
    IDProduto int identify(1,1) not null,
    Nome varchar(30) not null,
    NomeDescritivo varchar(100),
    DataCriacao datetime not null,
    LocalEstoque varchar(50),
    Quantidade int,
    Preco float
);
-- Exercicio 2
Create table LocalEstoque(
    ID int not null,
    Nome varchar(50) not null,
    DataCriacao datetime not null,
    Capacidade int
);
-- Exercicio 3
Alter table Produto alter column LocalDoEstoque int;
-- Exercicio 4
exec sp_RENAME 'Produto.LocalEstoque' , 'IdEstoque', 'COLUMN'
-- Exercicio 5
Alter table Produto Add Constraint PK_Produto primary key (Id);
Alter table Estoque Add Constraint PK_Estoque primary key (Id);
-- Exercicio 6
Alter table Produto Add constraint FK_Produto_Estoque Foreign Key (IdEstoque) References Estoque (Id)
