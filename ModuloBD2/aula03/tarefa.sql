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
        null; -- implementar
    end ajusta_cidade_cliente;

    procedure exclui_cidades_duplicadas(pNome in varchar2,
                                        pUF in varchar2,
                                        pMenorIDCidade in integer) as
    begin
        null; -- implementar
    end exclui_cidades_duplicadas;

    procedure elimina_duplicadas as
    begin
        null; -- implementar
        --ajusta_cidade_cliente(pNome=> <?>, pUF=> <?>, pMenorIDCidade=> <?>);
        --exclui_cidades_duplicadas(pNome=> <?>, pUF=> <?>, pMenorIDCidade=> <?>);
    end elimina_duplicadas;

end;
/