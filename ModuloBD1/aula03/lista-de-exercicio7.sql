-- Exercicio 1
Select e.NomeEmpregado, d.NomeDepartamento As DepartamentoFuncionario, 
(Select ein.NomeEmpregado from Empregado ein inner join Departamento din ON ein.IDDepartamento=din.IDDepartamento 
where e.IDGerente=ein.IDEmpregado) As NomeGerente,
(Select din.NomeDepartamento from Empregado ein inner join Departamento din ON ein.IDDepartamento=din.IDDepartamento 
where e.IDGerente=ein.IDEmpregado) As NomeDepartamentoGerente
from Empregado e inner join Departamento d ON e.IDDepartamento=d.IDDepartamento

-- Exercicio 2
Select Top(1) d.IDDepartamento, d.NomeDepartamento 
from Departamento d left join Empregado e on e.IDDepartamento=d.IDDepartamento
where e.Salario=(Select MAX(tabela.Salario) from (Select Salario from Empregado where IDDepartamento is not null) tabela)

-- Exercicio 3
Select e.NomeEmpregado, e.Salario,(e.Salario+e.Salario*(17.3/100)) As Aumento, d.Localizacao from Empregado e 
inner join Departamento d on e.IDDepartamento=d.IDDepartamento where d.Localizacao='SAO PAULO';
 
 UPDATE Empregado
 Set Salario=Salario+Salario*(17.3/100)
 from Empregado e 
inner join Departamento d on e.IDDepartamento=d.IDDepartamento 
where d.Localizacao='SAO PAULO'

-- Exercicio 4
