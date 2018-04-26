-- Exercicio 1
Select p.IDPedido,p.DataEntrega, p.ValorPedido, cli.Nome from Pedido p
inner join PedidoItem pitem on p.IDPedido=pitem.IDPedido
inner join Produto pro on pitem.IDProduto=pro.IDProduto
inner join ProdutoMaterial promat on pro.IDProduto=promat.IDProduto
inner join Cliente cli on cli.IDCliente=p.IDCliente
where DATEPART(year,p.DataEntrega)=2018 and DATEPART(MONTH,p.DataEntrega)=4 
and promat.IDMaterial in(14650,15703,15836,16003,16604,17226)

-- Exercicio 2
Select * from Produto where IDProduto not in(Select IDProduto from ProdutoMaterial)

-- Exercicio 3
Select cid.UF, cli.Nome, Count(1) as Quantidade from Pedido p
inner join Cliente cli on p.IDCliente=cli.IDCliente
inner join Cidade cid on cli.IDCidade=cid.IDCidade
where p.DataPedido>=(GETDATE()-90)
group by cid.UF, cli.Nome
order by Quantidade Desc

-- Exercicio 4
Select p.IDProduto,p.Nome,p.PrecoVenda,mat.IDMaterial,mat.Descricao from Produto p
left join ProdutoMaterial promat on p.IDProduto=promat.IDProduto
left join Material mat on promat.IDMaterial=mat.IDMaterial
where p.Nome='Broca Vidia 58' or p.Nome='Coturno Pica-Pau'