package grupo;

import alvos.Alvo;
import personagem.Personagem;
import personagem.racas.Humano;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Personagem> listaDePersonagens;

    public Grupo() {
        listaDePersonagens=new ArrayList<>();
    }

    public void adicionarPersonagem(Personagem personagem){
            listaDePersonagens.add(personagem);
    }
    public void adicionarListaDePersonagens(List<Personagem> listaDePersonagensNovos){
        for(Personagem personagemAtual: listaDePersonagensNovos){
            listaDePersonagens.add(personagemAtual);
        }
    }
    public void ataqueOrdenado(Alvo alvo){
        Personagem []listaOrdenada=ordenaPersonagens();
        for(int i=0;i<listaOrdenada.length;i++){
            listaOrdenada[i].atacarAlvo(alvo);
        }
    }

    public Personagem[] ordenaPersonagens(){
        Personagem []personagens=new Personagem[listaDePersonagens.size()];
        personagens=listaDePersonagens.toArray(personagens);

        int numeroDeItens = personagens.length;

        for (int i = 0; i < numeroDeItens; i++) {
            for (int j = 0; j < numeroDeItens - 1; j++) {
                Personagem personagemA = personagens[j];
                Personagem personagemB = personagens[j + 1];

                if (personagemA.getNome().compareTo(personagemB.getNome())>0) {
                    personagens[j] = personagemB;
                    personagens[j + 1] = personagemA;
                }
            }
        }

        return personagens;
    }

    public void ataqueSimples(Alvo alvo){
        for(Personagem personagemAtual:listaDePersonagens){
            personagemAtual.atacarAlvo(alvo);
        }
    }

    public int calcularAtaqueTotal(){
        int poderDeAtaqueDoGrupo=0;
        for(Personagem personagemAtual:listaDePersonagens){
            poderDeAtaqueDoGrupo+=personagemAtual.getPoderDeAtaqueTotal();
        }
        return poderDeAtaqueDoGrupo;
    }

    public void atacaDosHumanos(Alvo alvo){
        for(Personagem personagemAtual:listaDePersonagens){
            if(personagemAtual instanceof Humano) {
                personagemAtual.atacarAlvo(alvo);
            }
        }
    }

    public Personagem pegaPersonagemNaPosicao(int posicao) {
        if(posicao<listaDePersonagens.size()){
            return listaDePersonagens.get(posicao);
        }
        return null;
    }
}
