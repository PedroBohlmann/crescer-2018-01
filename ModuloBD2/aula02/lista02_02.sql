-- Questão 1
Select C.NOME, C.UF
FROM CIDADE C
HAVING (SELECT COUNT(1) FROM CIDADE CI WHERE CI.NOME = C.NOME AND CI.UF = C.UF)>0

DECLARE 
    CURSOR C_CidadeLista IS
        SELECT C.NOME, C.UF
        FROM CIDADE C
        HAVING (SELECT COUNT(1) FROM CIDADE CI WHERE CI.NOME = C.NOME AND CI.UF = C.UF)>0
    CURSOR C_ClienteLista(Nome CIDADE.NOME%TYPE,Uf CIDADE.UF%TYPE) IS
        -- select que pega usuarios que tem relação a cidade repetidas
BEGIN
    FOR cidade INT C_CidadeLista LOOP
        DBMS_OUTPUT.PUT_LINE('Cidade '|| cidade.NOME || ' está duplicada');
    END FOR;

    FOR cidade INT C_CidadeLista LOOP
        FOR cliente IN C_ClienteLista(cidade.NOME,cidade.UF) LOOP
            IF(cliente.Nome!=null) THEN
                DBMS_OUTPUT.PUT_LINE('Este cliente em relação com uma cidade duplicada'||)
            END IF;
        END LOOP;
    END FOR;


END;

