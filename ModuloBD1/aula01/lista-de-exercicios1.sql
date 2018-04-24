Create table Produto(
    ID int identity(1,1) not null,
    Nome varchar(30) not null,
    NomeDescritivo varchar(100),
    DataCriacao datetime not null,
    LocalEstoque varchar(50),
    Quantidade int,
    Preco float
	);
-- Exercicio 2
Create table LocalEstoque(
    ID int identity(1,1) not null,
    Nome varchar(50) not null,
    DataCriacao datetime not null,
    Capacidade int
);
-- Exercicio 3
Alter table Produto alter column LocalEstoque int;
-- Exercicio 4
exec sp_RENAME 'Produto.LocalEstoque' , 'IdEstoque', 'COLUMN'
-- Exercicio 5
Alter table Produto Add Constraint PK_Produto primary key (Id);
Alter table LocalEstoque Add Constraint PK_Estoque primary key (Id);
-- Exercicio 6
Alter table Produto Add constraint FK_Produto_Estoque Foreign Key (IdEstoque) References LocalEstoque (Id)
