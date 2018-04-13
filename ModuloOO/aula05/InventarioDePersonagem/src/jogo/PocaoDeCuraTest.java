package jogo;

import jogo.pocoes.PocaoDeCura;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PocaoDeCuraTest {
    @Test
    public void pocaoCom1DoseSaiDoInventarioQuandoUsada(){
        PocaoDeCura pocaoDeCura=new PocaoDeCura(1);
        InventarioDeItens inventarioDeItens = new InventarioDeItens();
        inventarioDeItens.adicionarItem(pocaoDeCura);

        pocaoDeCura.gastarDose();

        assertEquals(0,inventarioDeItens.getListaDeItens().size());
    }
}
