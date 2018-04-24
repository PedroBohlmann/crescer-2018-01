-- Exercicio 1
Select * into CidadeAux from Cidade;
-- Exercicio 2
Truncate Table CidadeAux;

Insert Into CidadeAux(IDCidade,Nome,UF)
Select IDCidade,Nome,UF from Cidade where UF='RS'
-- Exercicio 3
Insert into LocalEstoque(Nome,DataCriacao,Capacidade) values('Estocao',convert(datetime, '1997/05/17', 111),45);
-- Exercicio 4
Insert into Produto(Nome,NomeDescritivo,DataCriacao,IdEstoque,Quantidade,Preco) 
values ('Caixa','Guarda coisas',convert(datetime, '1997/06/22', 111),1,80,45);

Insert into Produto(Nome,NomeDescritivo,DataCriacao,IdEstoque,Quantidade,Preco) 
values ('Carro','Anda',convert(datetime, '1997/08/05', 111),1,5,45000);