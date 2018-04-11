import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonagemTest {

    @Test
    void personagemDeveIniciarComVida10() {
        Personagem  personagem=new Personagem(10);

        int vidaEsperada =10;
        int vidaObtida = personagem.getVida();

        assertEquals(vidaEsperada,vidaObtida);
    }

    @Test
    void personagemDeveIniciarComVidaInicialDe10() {
        Personagem  personagem=new Personagem();

        int vidaEsperada =10;
        int vidaObtida = personagem.getVida();

        assertEquals(vidaEsperada,vidaObtida);
    }

}