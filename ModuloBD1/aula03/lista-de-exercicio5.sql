-- Exercicio 1
Select TOP(1) SUBSTRING(Nome,1,CHARINDEX(' ', Nome)) As PrimeiroNome, Count(1) As Quantidade
from Cliente GROUP BY SUBSTRING(Nome,1,CHARINDEX(' ', Nome)) ORDER BY 2 DESC;

-- Exercicio 2
Select  Count(1) As Quantidade, SUM(ValorPedido) As SomatorioTotal 
from Pedido
where DATEPART(month,DataPedido)=3 AND DATEPART(year,DataPedido)=2018;

-- Exercicio 3
Select tabela.UF, tabela.Quantidade 
from(Select UF, Count(1) as Quantidade 
	from Cidade ci Inner join Cliente cl ON ci.IDCidade=cl.IDCidade group by UF) tabela
where tabela.Quantidade in 
(Select Max(tabela2.Quantidade) from 
	(Select UF, Count(1) as Quantidade from Cidade ci Inner join Cliente cl ON ci.IDCidade=cl.IDCidade group by UF) tabela2)
UNION
Select tabela.UF, tabela.Quantidade 
from(Select UF, Count(1) as Quantidade 
	from Cidade ci Inner join Cliente cl ON ci.IDCidade=cl.IDCidade group by UF) tabela
where tabela.Quantidade in 
(Select min(tabela2.Quantidade) from 
	(Select UF, Count(1) as Quantidade from Cidade ci Inner join Cliente cl ON ci.IDCidade=cl.IDCidade group by UF) tabela2)

-- Exercicio 4
Insert into Produto(Nome,DataCadastro,PrecoCusto,PrecoVenda,Situacao)
values ('Coturno Pica Pau', GETDATE(),29.25,77.95,'A');

-- Exercicio 5
Select p.Nome 
from Produto p
where not exists(Select 1 from PedidoItem i where i.IDProduto=p.IDProduto);

-- Exercicio 6
Select p.Nome
from Produto p
left join PedidoItem i on p.IDProduto=i.IDProduto
where i.IDProduto is null;

-- Exercicio 7
SELECT TOP 30
p.Nome
 ,SUM((i.Quantidade * i.PrecoUnitario)) TotalItem
FROM PedidoItem i
INNER JOIN Pedido pe
ON pe.IDPedido = i.IDPedido
AND DATEPART(YEAR, pe.DataPedido) = 2018
INNER JOIN Produto p
ON p.IDProduto = i.IDProduto
GROUP BY p.Nome
ORDER BY TotalItem DESC