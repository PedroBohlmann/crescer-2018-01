package tests;

import contratos.TrocaDePneu;
import org.junit.jupiter.api.Test;
import produtos.Pneu;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrocaDePneuTest {
    @Test
    public void testaTrocaDeDoisPneus(){
        Pneu pneu=new Pneu(100,10);
        List<Pneu> listaDePneus=new ArrayList<>();

        for(int i=0;i<2;i++){
            listaDePneus.add(pneu);
        }

        TrocaDePneu trocaDePneu=new TrocaDePneu(listaDePneus);

        double valorEsperado=1700.6;
        double valorObtido=trocaDePneu.calcularValorTotalServico();

        assertEquals(valorEsperado,valorObtido);
    }

    @Test
    public void testaTrocaDeQuatroPneusDiferentes(){
        Pneu pneuBarato=new Pneu(100,10);
        Pneu pneuCaro=new Pneu(300,25);
        List<Pneu> listaDePneus=new ArrayList<>();

        for(int i=0;i<2;i++){
            listaDePneus.add(pneuBarato);
            listaDePneus.add(pneuCaro);
        }

        TrocaDePneu trocaDePneu=new TrocaDePneu(listaDePneus);

        double valorEsperado=8712.1;
        double valorObtido=trocaDePneu.calcularValorTotalServico();

        assertEquals(valorEsperado,valorObtido);
    }

    @Test
    public void testaValorBaseDaTrocaDeQuatroPneusIguais(){
        Pneu pneuCaro=new Pneu(300,25);
        List<Pneu> listaDePneus=new ArrayList<>();

        for(int i=0;i<4;i++){
            listaDePneus.add(pneuCaro);
        }

        TrocaDePneu trocaDePneu =new TrocaDePneu(listaDePneus);
        double valorEsperado=1756;
        double valorObtido=trocaDePneu.calcularValorBaseDeMaoDeObra();

        assertEquals(valorEsperado,valorObtido);
    }

    @Test
    public void testaValorLucroDeQuatroPneusIguais(){
        Pneu pneuCaro=new Pneu(300,25);
        List<Pneu> listaDePneus=new ArrayList<>();

        for(int i=0;i<4;i++){
            listaDePneus.add(pneuCaro);
        }

        TrocaDePneu trocaDePneu =new TrocaDePneu(listaDePneus);
        double valorEsperado=600;
        double valorObtido=trocaDePneu.calcularLucroTotal();

        assertEquals(valorEsperado,valorObtido);
    }
}
