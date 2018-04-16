package test;

import alvos.Alvo;
import alvos.RaidBoss;
import grupo.Grupo;
import org.junit.jupiter.api.Test;
import personagem.Personagem;
import personagem.racas.Elfo;
import personagem.racas.Humano;
import personagem.racas.Orc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrupoTest {
    @Test
    public void testaInsercaoDeUmHumano() {
        Grupo grupo = new Grupo();
        Personagem humano = new Humano("Pedroka Silva", 10, true);

        grupo.adicionarPersonagem(humano);
        Personagem esperado = humano;
        Personagem obtido = grupo.pegaPersonagemNaPosicao(0);

        assertEquals(esperado, obtido);
    }

    @Test
    public void testaInsercaoDeUmaListaDePersonagens() {
        Grupo grupo = new Grupo();
        Personagem humano = new Humano("Pedroka Silva", 10, true);
        Personagem elfo = new Elfo("Joao", 15, 55);
        Personagem orc = new Orc("Orc loko", 50, true);
        List<Personagem> listaDePersonagensNovos = new ArrayList<>();
        listaDePersonagensNovos.add(humano);
        listaDePersonagensNovos.add(elfo);
        listaDePersonagensNovos.add(orc);

        grupo.adicionarListaDePersonagens(listaDePersonagensNovos);

        Personagem esperado = elfo;
        Personagem obtido = grupo.pegaPersonagemNaPosicao(1);

        assertEquals(esperado, obtido);
    }

    @Test
    public void testaGrupoAtacandoAlvoDeFormaSimples() {
        Grupo grupo = new Grupo();

        Personagem humano = new Humano("Pedroka Silva", 10, true);
        Personagem elfo = new Elfo("Joao", 15, 55);
        Personagem orc = new Orc("Orc loko", 5, false);

        List<Personagem> listaDePersonagensNovos = new ArrayList<>();

        listaDePersonagensNovos.add(humano);
        listaDePersonagensNovos.add(elfo);
        listaDePersonagensNovos.add(orc);
        grupo.adicionarListaDePersonagens(listaDePersonagensNovos);

        Alvo alvo = new Alvo(110);

        grupo.ataqueSimples(alvo);

        int vidaDoAlvoEsperada = 5;
        int vidaDoAlvoObtido = alvo.getPontosDeVida();

        assertEquals(vidaDoAlvoEsperada, vidaDoAlvoObtido);
    }

    @Test
    public void testaGrupoAtacandoAlvoDeFormaOrdenada() {
        Grupo grupo = new Grupo();

        Personagem humano = new Humano("Pedroka Silva", 10, true);
        Personagem elfo = new Elfo("Joao", 15, 55);
        Personagem orc = new Orc("Orc loko", 5, false);

        List<Personagem> listaDePersonagensNovos = new ArrayList<>();

        listaDePersonagensNovos.add(humano);
        listaDePersonagensNovos.add(elfo);
        listaDePersonagensNovos.add(orc);
        grupo.adicionarListaDePersonagens(listaDePersonagensNovos);

        Alvo alvo = new Alvo(110);

        grupo.ataqueOrdenado(alvo);

        int vidaDoAlvoEsperada = 5;
        int vidaDoAlvoObtido = alvo.getPontosDeVida();

        assertEquals(vidaDoAlvoEsperada, vidaDoAlvoObtido);
    }

    @Test
    public void testaGrupoAtacandoAlvoComOsHumanos() {
        Grupo grupo = new Grupo();
        Personagem humano = new Humano("Bixo piruleta", 30, false);
        Personagem humano2 = new Humano("Pedroka Silva", 10, true);
        Personagem elfo = new Elfo("Joao", 15, 55);
        Personagem orc = new Orc("Orc loko", 5, false);

        List<Personagem> listaDePersonagensNovos = new ArrayList<>();
        listaDePersonagensNovos.add(humano);
        listaDePersonagensNovos.add(humano2);
        listaDePersonagensNovos.add(elfo);
        listaDePersonagensNovos.add(orc);
        grupo.adicionarListaDePersonagens(listaDePersonagensNovos);

        Alvo alvo = new Alvo(100);

        grupo.atacaDosHumanos(alvo);

        int vidaDoAlvoEsperada = 40;
        int vidaDoAlvoObtido = alvo.getPontosDeVida();

        assertEquals(vidaDoAlvoEsperada, vidaDoAlvoObtido);
    }

    @Test
    public void testaOrdenaPersonagens() {
        Grupo grupo = new Grupo();
        Personagem humano = new Humano("Bixo piruleta", 30, false);
        Personagem humanoComArco = new Humano("Pedroka Silva", 10, true);
        Personagem elfo = new Elfo("Joao", 15, 55);
        Personagem orc = new Orc("Orc loko", 5, false);

        List<Personagem> listaDePersonagensNovos = new ArrayList<>();
        listaDePersonagensNovos.add(humano);
        listaDePersonagensNovos.add(humanoComArco);
        listaDePersonagensNovos.add(elfo);
        listaDePersonagensNovos.add(orc);
        grupo.adicionarListaDePersonagens(listaDePersonagensNovos);

        Personagem[] personagens = grupo.ordenaPersonagens();

        Personagem personagemEsperado = humanoComArco;
        Personagem personagemObtido = personagens[3];

        assertEquals(personagemEsperado, personagemObtido);
    }

    @Test
    public void testaCalculoTotalDoPoderDoGrupo() {
        Grupo grupo = new Grupo();
        Personagem humano = new Humano("Bixo piruleta", 30, false);
        Personagem humanoComArco = new Humano("Pedroka Silva", 10, true);
        Personagem elfo = new Elfo("Joao", 15, 55);
        Personagem orc = new Orc("Orc loko", 5, false);

        List<Personagem> listaDePersonagensNovos = new ArrayList<>();
        listaDePersonagensNovos.add(humano);
        listaDePersonagensNovos.add(humanoComArco);
        listaDePersonagensNovos.add(elfo);
        listaDePersonagensNovos.add(orc);
        grupo.adicionarListaDePersonagens(listaDePersonagensNovos);

        int poderTotalEsperado = 135;
        int poderTotalObtido = grupo.calcularAtaqueTotal();

        assertEquals(poderTotalEsperado, poderTotalObtido);
    }

    @Test
    public void testaGrupoAtacandoRaidBoss() {
        Grupo grupo = new Grupo();
        Personagem humano = new Humano("Bixo piruleta", 30, false);
        Personagem humanoComArco = new Humano("Pedroka Silva", 10, true);
        Personagem elfo = new Elfo("Joao", 15, 55);
        Personagem orc = new Orc("Orc loko", 5, false);

        List<Personagem> listaDePersonagensNovos = new ArrayList<>();
        listaDePersonagensNovos.add(humano);
        listaDePersonagensNovos.add(humanoComArco);
        listaDePersonagensNovos.add(elfo);
        listaDePersonagensNovos.add(orc);
        grupo.adicionarListaDePersonagens(listaDePersonagensNovos);

        Alvo raidBoss = new RaidBoss(5, "Zulrah", 130);

        grupo.ataqueSimples(raidBoss);

        int vidaDoAlvoEsperado = 0;
        int vidaDoAlvoObtido = raidBoss.getPontosDeVida();

        assertEquals(vidaDoAlvoEsperado, vidaDoAlvoObtido);
    }
}
