-- Exercicio 1
Select Empregado, Count(1) from Projeto group by Empregado;
-- Exercicio 2
Select Distinct ValorFaturado from Projeto where ValorFaturado>ValorRealizado;
-- Exercicio 3
Select Distinct((ValorRealizado-ValorPrevisto)/ValorPrevisto)*100, Projeto
from Projeto where ValorRealizado>ValorPrevisto
-- Exercicio 4
Select Distinct Empregado, 
(Case when CHARINDEX(' ',Empregado)=-1 then Empregado
	else SUBSTRING(Empregado, 1,CHARINDEX(' ',Empregado))
end)
from Projeto