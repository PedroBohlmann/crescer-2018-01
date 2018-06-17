create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
  procedure geraProximoConcurso as
    vValorTotal NUMBER(16,2);
    vIdConcurso INTEGER;
    vAcumulou INTEGER;
    vValorAcumulado NUMBER(16,2);
   begin
      SELECT SUM(AP.VALOR)
          INTO vValorTotal
          FROM APOSTA AP
          WHERE AP.IDCONCURSO = (SELECT MAX(IDCONCURSO) FROM CONCURSO)
          GROUP BY AP.IDCONCURSO;
          
      SELECT MAX(IDCONCURSO) 
        INTO vIdConcurso
        FROM CONCURSO;
      
      SELECT C.ACUMULOU
        INTO vAcumulou
        FROM CONCURSO C
        WHERE C.IDCONCURSO = (SELECT MAX(IDCONCURSO) FROM CONCURSO);
        
      vValorTotal:=(vValorTotal*45.3)/100;
      vIdConcurso:=vIdConcurso+1;
      
      IF vAcumulou=1 THEN
        SELECT C.PREMIO_SENA
            INTO vValorAcumulado
            FROM CONCURSO C 
            WHERE C.IDCONCURSO = (SELECT MAX(IDCONCURSO) FROM CONCURSO);
        vValorTotal:= vValorTotal+vValorAcumulado;
      END IF;
      
      DBMS_OUTPUT.PUT_LINE('valor total:' ||vValorTotal ||'|id concurso'|| vIdConcurso);
      
      salvaConcurso(vIdConcurso,sysdate,vValorTotal);
    EXCEPTION
        WHEN no_data_found THEN
            DBMS_OUTPUT.PUT_LINE('Sem vendas no ultimo concurso');
      
   end geraProximoConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
  procedure atualizaAcertadores (pConcurso in integer) as
    vIdAposta INTEGER;
    CURSOR C_ListaDeApostas IS
        SELECT * FROM APOSTA WHERE IDCONCURSO=pConcurso;
        
    CURSOR C_NumerosAposta IS
        SELECT *  FROM NUMERO_APOSTA N WHERE N.IDAPOSTA=vIdAposta;
        
    CURSOR C_ApostasDoConcurso IS
        SELECT * FROM APOSTA P
            INNER JOIN APOSTA_PREMIADA PP ON P.IDAPOSTA=PP.IDAPOSTA
            WHERE P.IDCONCURSO= pConcurso;
        
    vPrimeiraDezena NUMBER;
    vSegundaDezena NUMBER;
    vTerceiraDezena NUMBER;
    vQuartaDezena NUMBER;
    vQuintaDezena NUMBER;
    vSextaDezena NUMBER;
    vNumeroDeAcertosPorAposta INTEGER:=0;
    
    vNumeroTotalDeAcertosQuadra INTEGER:=0;
    vNumeroTotalDeAcertosQuina INTEGER:=0;
    vNumeroTotalDeAcertosSena INTEGER:=0;
    
    vValor NUMBER(12,2);

   begin
    SELECT C.PRIMEIRA_DEZENA
        INTO vPrimeiraDezena
        FROM CONCURSO 
        C WHERE C.IDCONCURSO = 
        (SELECT MAX(IDCONCURSO) FROM CONCURSO);
        
    SELECT C.SEGUNDA_DEZENA
        INTO vSegundaDezena
        FROM CONCURSO 
        C WHERE C.IDCONCURSO = 
        (SELECT MAX(IDCONCURSO) FROM CONCURSO);
        
    SELECT C.TERCEIRA_DEZENA
        INTO vTerceiraDezena
        FROM CONCURSO 
        C WHERE C.IDCONCURSO = pConcurso;
    
    SELECT C.QUARTA_DEZENA
        INTO vQuartaDezena
        FROM CONCURSO 
        C WHERE C.IDCONCURSO = pConcurso;
        
    SELECT C.QUINTA_DEZENA
        INTO vQuintaDezena
        FROM CONCURSO 
        C WHERE C.IDCONCURSO = pConcurso;
    
    SELECT C.SEXTA_DEZENA
        INTO vSextaDezena
        FROM CONCURSO 
        C WHERE C.IDCONCURSO = pConcurso;
    
    -- CRIA GANHADORES COM VALOR DO PREMIO ERRADO E ATUALIZA O ACUMULOU PARA 0 SE ALGUEM GANHOU
    FOR aposta IN C_ListaDeApostas LOOP
        vIdAposta:=aposta.IDAPOSTA;
        FOR numero IN C_NumerosAposta LOOP
            IF vPrimeiraDezena = numero.NUMERO OR vSegundaDezena = numero.NUMERO OR vTerceiraDezena = numero.NUMERO OR vQuartaDezena = numero.NUMERO OR vQuintaDezena = numero.NUMERO OR vSextaDezena = numero.NUMERO THEN
                vNumeroDeAcertosPorAposta := vNumeroDeAcertosPorAposta + 1;
            END IF;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('numero de acertos:'||vNumeroDeAcertosPorAposta ||' id:'||aposta.IDAPOSTA);
        
        IF vNumeroDeAcertosPorAposta = 4 THEN
            SELECT C.PREMIO_QUADRA 
                INTO vValor
                FROM CONCURSO C 
                WHERE C.IDCONCURSO=pConcurso;
            vNumeroTotalDeAcertosQuadra:=vNumeroTotalDeAcertosQuadra+1;
        END IF;
        
        IF vNumeroDeAcertosPorAposta = 5 THEN
            SELECT C.PREMIO_QUINA 
                INTO vValor
                FROM CONCURSO C 
                WHERE C.IDCONCURSO=pConcurso;
            vNumeroTotalDeAcertosQuina:=vNumeroTotalDeAcertosQuina+1;
        END IF;
        
        IF vNumeroDeAcertosPorAposta = 6 THEN
            SELECT C.PREMIO_SENA 
                INTO vValor
                FROM CONCURSO C 
                WHERE C.IDCONCURSO=pConcurso;
            vNumeroTotalDeAcertosSena:=vNumeroTotalDeAcertosSena+1;
        END IF;
        
        IF vNumeroDeAcertosPorAposta >= 4 THEN
            INSERT INTO APOSTA_PREMIADA (IDAPOSTA,ACERTOS,VALOR)
            VALUES(vIdAposta,vNumeroDeAcertosPorAposta,vValor);
            
            UPDATE CONCURSO
            SET ACUMULOU=0
            WHERE IDCONCURSO = pConcurso;
        END IF;
        
        vNumeroDeAcertosPorAposta :=0;
    END LOOP;
    
    FOR aposta IN C_ApostasDoConcurso LOOP
            IF aposta.ACERTOS = 4 THEN
                SELECT C.PREMIO_QUADRA 
                    INTO vValor
                    FROM CONCURSO C 
                    WHERE C.IDCONCURSO=pConcurso;
                    
                    UPDATE APOSTA_PREMIADA
                    SET VALOR = vValor/vNumeroTotalDeAcertosQuadra
                    WHERE IDAPOSTA_PREMIADA = aposta.IDAPOSTA_PREMIADA;
            END IF;
            
            IF aposta.ACERTOS = 5 THEN
                SELECT C.PREMIO_QUINA 
                    INTO vValor
                    FROM CONCURSO C 
                    WHERE C.IDCONCURSO=pConcurso;
                    
                    UPDATE APOSTA_PREMIADA
                    SET VALOR = vValor/vNumeroTotalDeAcertosQuina
                    WHERE IDAPOSTA_PREMIADA = aposta.IDAPOSTA_PREMIADA;
            END IF;
            
            IF aposta.ACERTOS = 6 THEN
                SELECT C.PREMIO_SENA 
                    INTO vValor
                    FROM CONCURSO C 
                    WHERE C.IDCONCURSO=pConcurso;
                    
                    UPDATE APOSTA_PREMIADA
                    SET VALOR = vValor/vNumeroTotalDeAcertosSena
                    WHERE IDAPOSTA_PREMIADA = aposta.IDAPOSTA_PREMIADA;
            END IF;
        END LOOP;    
    
   end atualizaAcertadores;
   
begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;