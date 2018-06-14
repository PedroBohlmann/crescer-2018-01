-- Questão 1
DECLARE 
    CURSOR C_CidadeLista IS
        Select DISTINCT C.NOME, C.UF
        FROM CIDADE C
        HAVING COUNT(1)>1
        GROUP BY C.NOME,C.UF;
    CURSOR C_ClienteLista(vNome CIDADE.NOME%TYPE,vUf CIDADE.UF%TYPE) IS
        SELECT CLI.NOME, CLI.RAZAOSOCIAL
        FROM CLIENTE CLI
        INNER JOIN CIDADE CI ON CLI.IDCIDADE = CI.IDCIDADE
        WHERE CI.NOME =vNome AND CI.UF=Uf;
BEGIN
    FOR cidade IN C_CidadeLista LOOP
        DBMS_OUTPUT.PUT_LINE('Cidade '|| cidade.NOME || ' está duplicada');
    END LOOP;

    FOR cidade IN C_CidadeLista LOOP
        FOR cliente IN C_ClienteLista(cidade.NOME,cidade.UF) LOOP
            DBMS_OUTPUT.PUT_LINE('Este cliente em relação com uma cidade duplicada '|| cliente.Nome);
        END LOOP;
    END LOOP;
END;

-- Questão 2
DECLARE 
    CURSOR C_ListPedidos IS
        Select DISTINCT P.IDPEDIDO,P.VALORPEDIDO,
            (SELECT SUM(PI.PRECOUNITARIO*PI.QUANTIDADE) FROM PEDIDOITEM PI WHERE PI.IDPEDIDO=P.IDPEDIDO) AS ValorCalculado
        FROM PEDIDO P ORDER BY 1 ASC;
BEGIN
    FOR pedido in C_ListPedidos LOOP
        UPDATE PEDIDO P
        SET P.VALORPEDIDO= pedido.ValorCalculado
        WHERE P.IDPEDIDO=pedido.IDPEDIDO;
    END LOOP;
    COMMIT;
END;

-- Questão 3
DECLARE
CURSOR C_ClienteLista IS
    SELECT C.IDCLIENTE,C.NOME,C.SITUACAO
    FROM CLIENTE C
    WHERE C.IDCLIENTE 
    NOT IN
    (Select CLI.IDCLIENTE FROM CLIENTE CLI
    INNER JOIN PEDIDO P ON P.IDCLIENTE=CLI.IDCLIENTE
    WHERE P.DATAPEDIDO>=add_months(sysdate,-6));
BEGIN
    FOR cliente IN C_ClienteLista LOOP
        UPDATE CLIENTE C
        SET C.SITUACAO = 'I'
        WHERE C.IDCLIENTE = cliente.IDCLIENTE;
    END LOOP;
    COMMIT;
END;

-- Questão 4
DECLARE
   CURSOR C_MateriaisLista IS
    SELECT PR.IDPRODUTO,M.DESCRICAO, SUM(PI.QUANTIDADE) AS TOTAL FROM PEDIDO PE
    INNER JOIN PEDIDOITEM PI ON PE.IDPEDIDO=PI.IDPEDIDO
    INNER JOIN PRODUTO PR ON PR.IDPRODUTO=PI.IDPRODUTO
    INNER JOIN PRODUTOMATERIAL PM ON PR.IDPRODUTO=PM.IDPRODUTO
    INNER JOIN MATERIAL M ON M.IDMATERIAL=PM.IDMATERIAL
    WHERE TO_CHAR(PE.DATAPEDIDO,'MM')=:Mes AND TO_CHAR(PE.DATAPEDIDO,'YYYY')=:Ano AND PR.IDPRODUTO=:IdProduto
    GROUP BY PR.IDPRODUTO,PR.NOME,M.DESCRICAO;
BEGIN
    FOR material IN C_MateriaisLista LOOP
        DBMS_OUTPUT.PUT_LINE('Material '|| material.DESCRICAO || ' precisa de um total de '|| material.TOTAL ||' unidades');
    END LOOP;
END;