-- Exercicio 1
Select IDEmpregado,NomeEmpregado from Empregado order by DataAdmissao;
-- Exercicio 2
Select NomeEmpregado, Salario from Empregado where Comissao IS NULL ORDER BY Salario;
-- Exercicio 3
Select IDEmpregado, NomeEmpregado,Salario*13,Comissao*12,(Salario*13+isNull(Comissao*12,0)) AS RendaAnual 
from Empregado order by NomeEmpregado;
-- Exercicio 4
Select IDEmpregado,NomeEmpregado, Cargo,(Salario*13+isNull(Comissao*12,0)) AS RendaAnual 
From Empregado Where (Salario*13+isNull(Comissao*12,0))<18500 OR Cargo='Atendente';
-- Exercicio 5
Select NomeEmpregado,Cargo from Empregado where Cargo='Atendente' or IdGerente=7698;
-- Exercicio 6
Select IDDepartamento, NomeDepartamento from Departamento where Localizacao LIKE 'SAO%';
-- Exercicio 7
Select * from Cidade where IdCidade between 4 and 9;
-- Exercicio 8
Select * from Departamento d 
where Not Exists(Select 1 from Empregado e where e.IDDepartamento=d.IDDepartamento)
Order by d.IDDepartamento;
-- Exercicio 9
Select NomeEmpregado,Cargo from Empregado where IDDepartamento is null order by NomeEmpregado;
-- Exercicio 10
Select NomeEmpregado from Empregado Where IDGerente in (7566,7698,7782) order by NomeEmpregado;