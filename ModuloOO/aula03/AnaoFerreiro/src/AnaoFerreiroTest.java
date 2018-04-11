import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnaoFerreiroTest {
    @Test
    void testaAnaoFerreiroForjaMachado(){
        AnaoFerreiro anaoFerreiro=new AnaoFerreiro(160,22);
        Machado machado=anaoFerreiro.forjaMachado();
        int poderMachadoEsperado= 20;

        int poderMachadoObtido = anaoFerreiro.melhoraMachado(machado).getPoderDoMachado();

        assertEquals(poderMachadoEsperado,poderMachadoObtido);
    }

    @Test
    void testaAnaoFerreiroMelhoraMachadoMais3(){
        AnaoFerreiro anaoFerreiro=new AnaoFerreiro(260,16);
        Machado machado= new Machado(16);
        int poderMachadoEsperado= 19;

        int poderMachadoObtido = anaoFerreiro.melhoraMachado(machado).getPoderDoMachado();

        assertEquals(poderMachadoEsperado,poderMachadoObtido);
    }

    @Test
    void testaAnaoFerreiroForjaEMelhoraMachadoMais3(){
        AnaoFerreiro anaoFerreiro=new AnaoFerreiro(260,17);
        Machado machado=anaoFerreiro.forjaMachado();
        int poderMachadoEsperado= 20;

        int poderMachadoObtido = anaoFerreiro.melhoraMachado(machado).getPoderDoMachado();

        assertEquals(poderMachadoEsperado,poderMachadoObtido);
    }
}