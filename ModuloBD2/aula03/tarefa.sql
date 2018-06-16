create or replace package pck_cidade as
 procedure ajusta_cidade_cliente(pNome in varchar2,
                                pUF in varchar2,
                                pMenorIDCidade in integer);

 procedure exclui_cidades_duplicadas(pNome in varchar2,
                                    pUF in varchar2,
                                    pMenorIDCidade in integer);
 procedure elimina_duplicadas;

end;
/
create or replace package body pck_cidade as
    procedure ajusta_cidade_cliente(pNome in varchar2,
                                    pUF in varchar2,
                                    pMenorIDCidade in integer) as
    begin
        UPDATE CLIENTE CLI
            SET CLI.IDCIDADE = pMenorIDCidade
            WHERE CLI.IDCLIENTE IN (
                SELECT CL.IDCLIENTE
                FROM CLIENTE CL
                INNER JOIN CIDADE C ON C.IDCIDADE=CL.IDCIDADE
                WHERE C.NOME = pNome AND C.UF = pUf);
    end ajusta_cidade_cliente;

    procedure exclui_cidades_duplicadas(pNome in varchar2,
                                        pUF in varchar2,
                                        pMenorIDCidade in integer) as
    begin
        DELETE FROM CIDADE C
        WHERE C.NOME = pNome AND C.UF = pUF AND C.IDCIDADE!=pMenorIDCidade;
    end exclui_cidades_duplicadas;

    procedure elimina_duplicadas as
    CURSOR C_CidadesDuplicadas IS Select DISTINCT C.NOME, C.UF
            FROM CIDADE C
            HAVING COUNT(1)>1
            GROUP BY C.NOME,C.UF;
    pMenorIDCidade INTEGER;
    begin
        FOR cidade IN C_CidadesDuplicadas LOOP
            SELECT MIN(C.IDCIDADE)
            INTO pMenorIDCidade
            FROM CIDADE C
            WHERE C.NOME = cidade.NOME AND C.UF = cidade.UF;
            
            ajusta_cidade_cliente(cidade.NOME, cidade.UF,pMenorIDCidade);
            exclui_cidades_duplicadas(cidade.NOME, cidade.UF,pMenorIDCidade);
        END LOOP;
    end elimina_duplicadas;

end;
/