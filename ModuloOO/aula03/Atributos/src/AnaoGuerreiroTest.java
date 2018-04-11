import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnaoGuerreiroTest {
    @Test
    public void anaoGuerreiroEquipaMachadoFraco(){
        AnaoGuerreiro anaoGuerreiro=new AnaoGuerreiro();
        Machado machado=new Machado();
        anaoGuerreiro.equiparMachado(machado);

        Machado machadoEsperado = null;
        Machado machadoObtido = anaoGuerreiro.getMachadoEquipado();

        assertEquals(machadoEsperado,machadoObtido);//5º
    }
}