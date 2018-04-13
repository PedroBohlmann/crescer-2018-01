package jogo;

import jogo.equipamentos.Armadura;
import jogo.equipamentos.Equipamento;
import jogo.equipamentos.Espada;
import jogo.pocoes.PocaoDeCura;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventarioDeItensTest {
    @Test
    public void inventarioDeveTerEspadaDeppoisDeAdicionar(){
        Espada espada=new Espada();
        InventarioDeItens inventarioDeItens=new InventarioDeItens();

        inventarioDeItens.adicionarItem(espada);

        Espada espadaNoInventario=(Espada)inventarioDeItens.getListaDeItens().get(0);

        assertEquals(espada,espadaNoInventario);
    }

    @Test
    public void filtrarEquipamentosRetornaSomenteArmadura(){
        Armadura armadura=new Armadura();
        PocaoDeCura pocaoDeCura=new PocaoDeCura(1);
        InventarioDeItens inventarioDeItens=new InventarioDeItens();
        inventarioDeItens.adicionarItem(armadura);
        inventarioDeItens.adicionarItem(pocaoDeCura);

        List<Equipamento> equipamentos=inventarioDeItens.getEquipamentos();

        assertEquals(1,equipamentos.size());

    }

    @Test
    public void itemAdicionadoAoInventarioEstaVinculado(){
        Espada espada=new Espada();
        InventarioDeItens inventarioDeItens=new InventarioDeItens();

        inventarioDeItens.adicionarItem(espada);

        assertEquals(inventarioDeItens,espada.getInventarioDeItensAquePertence());
    }
}
