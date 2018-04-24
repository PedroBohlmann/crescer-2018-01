-- Exercicio 1
Select IDEmpregado, NomeEmpregado, DATEDIFF(year,DataAdmissao,getDate())
from Empregado where DATEPART(YEAR, DataAdmissao)=1981;
-- Exercicio 2
Select TOP(1) Cargo, COUNT(1) AS QuantidadeFuncionarios 
FROM Empregado GROUP BY Cargo Order by QuantidadeFuncionarios DESC;
-- Exercicio 3
Select UF, COUNT(1) AS QuantidadeCidades 
FROM Cidade GROUP BY UF ORDER BY QuantidadeCidades DESC;
-- Exercicio 4
INSERT INTO Departamento(IDDepartamento,NomeDepartamento, Localizacao)
VALUES (2,'Inovação','SAO LEOPOLDO')

UPDATE Empregado
Set IDDepartamento=(Select IDDepartamento from Departamento where NomeDepartamento='Inovação')
WHERE DATEPART(month, DataAdmissao)=12 AND Cargo!='Atendente';