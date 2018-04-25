-- Exercicio 5
Insert into Produto(Nome,DataCadastro,PrecoCusto,PrecoVenda,Situacao)
values ('Coturno Pica Pau', GETDATE(),29.25,77.95,'A');
-- Exercicio 6
Select p.Nome 
from Produto p
where not exists(Select 1 from PedidoItem i where i.IDProduto=p.IDProduto);

Select p.Nome
from Produto p
left join PedidoItem i on p.IDProduto=i.IDProduto
where i.IDProduto is null;
-- Exercicio 7