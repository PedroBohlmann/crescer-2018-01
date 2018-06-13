-- Questão 1 
    -- A - Verdade

    -- B - Falsa, Não pode declarar varias variaveis ao mesmo tempo

    -- C - Falsa, Não pode declarar variaveis como not null por que todas as variaveis podem ser nulas

    -- D - Falsa, Verdadeiro ou falso é feito com TRUE e FALSE não com 1 e 0

DECLARE 
 vIdPedido PEDIDO.IDPEDIDO%TYPE:=:IdPedido;
 vData PEDIDO.DATAENTREGA%TYPE;
 vValorPedido PEDIDO.VALORPEDIDO%TYPE;
 BEGIN
  SELECT P.DATAENTREGA
  INTO vData
  FROM PEDIDO P
  WHERE P.IDPEDIDO=vIdPedido;
  
  SELECT P.VALORPEDIDO
  INTO vValorPedido
  FROM PEDIDO P
  WHERE P.IDPEDIDO=vIdPedido;
  
  IF(vData>=sysdate and vValorPedido>9000) THEN
    UPDATE PEDIDO
    SET VALORPEDIDO= VALORPEDIDO-(vValorPedido*0.005)
    where IDPEDIDO=vIdPedido;
  END IF;
 END;
