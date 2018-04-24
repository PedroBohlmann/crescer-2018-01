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
-- Exercicio 5
Update Associado
Set CPF=12345,Endereco='Rua da morte', Bairro = 'Centro',Complemento = 'Apto. 40', 
IDCidade=(Select IdCidade from Cidade Where (Nome='Sao Leopoldo' AND UF='RS'))
where IDAssociado=1;
-- Exercicio 6
Delete from Cidade Where (Nome='Campinas' AND UF='SP') OR (Nome='Taquara' AND UF='RS');