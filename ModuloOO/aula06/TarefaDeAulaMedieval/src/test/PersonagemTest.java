package test;

import org.junit.jupiter.api.Test;
import personagem.Personagem;
import personagem.racas.Elfo;
import personagem.racas.Humano;
import personagem.racas.Orc;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonagemTest {
    @Test
    public void testaAtaqueDeHumanoComArco(){
        Personagem humano =new Humano("Pedroka",10,true);
        int podeEsperado = 30;
        int poderObtido=humano.getPoderDeAtaqueTotal();

        assertEquals(podeEsperado,poderObtido);
    }

    @Test
    public void testaAtaqueDeHumanoSemArco(){
        Personagem humano =new Humano("Pedroka",10,false);
        int podeEsperado = 10;
        int poderObtido=humano.getPoderDeAtaqueTotal();

        assertEquals(podeEsperado,poderObtido);
    }

    @Test
    public void testaAtaqueDeElfo(){
        Personagem elfo =new Elfo("Pedroka",10,55);
        int podeEsperado = 65;
        int poderObtido=elfo.getPoderDeAtaqueTotal();

        assertEquals(podeEsperado,poderObtido);
    }

    @Test
    public void testaAtaqueDeOrcSemGarra(){
        Personagem orc =new Orc("Pedroka",10,false);
        int podeEsperado = 10;
        int poderObtido=orc.getPoderDeAtaqueTotal();

        assertEquals(podeEsperado,poderObtido);
    }

    @Test
    public void testaAtaqueDeOrcComGarra(){
        Personagem orc =new Orc("Pedroka",10,true);
        int podeEsperado = 50;
        int poderObtido=orc.getPoderDeAtaqueTotal();

        assertEquals(podeEsperado,poderObtido);
    }
}
