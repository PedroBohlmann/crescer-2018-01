package corredores;

import exceptions.AlvoInvalidoException;
import exceptions.ItemInvalidoException;
import pistas.casas.Casa;
import pistas.Pista;
import pistas.casas.CasaCustomizada;
import itens.tipos_de_itens.Item;
import itens.tipos_de_itens.ataque.ItemDeAtaque;
import itens.tipos_de_itens.uso.ItemDeUso;

public abstract class Corredor {

    private int vida;
    private int quantidadeDeCasasQuePercorre;

    private Pista pistaQuePertence;
    private Casa casaAtual;
    private Item itemArmazenado;

    public Corredor(int vida) {
        this.vida = vida;
        this.quantidadeDeCasasQuePercorre = 3;
    }

    public void andar() {
        int quantidadeDeCasasASerPercorrido = casaASerPercorrido();
        this.andaUmNumeroEspecificoDeCasas(quantidadeDeCasasASerPercorrido);
    }

    protected abstract int casaASerPercorrido();

    public void associarAUmaPista(Pista pista, Casa casa) {
        this.pistaQuePertence = pista;
        this.casaAtual = casa;
    }

    public int getQuantidadeDeCasasQuePercorre() {
        return quantidadeDeCasasQuePercorre;
    }

    public Pista getPistaQuePertence() {
        return pistaQuePertence;
    }

    public Casa getCasaAtual() {
        return casaAtual;
    }

    public void avancaParaACasa(Casa casa) {
        this.casaAtual = casa;
    }

    public int getVida() {
        return vida;
    }

    public void equiparItem(Item item) {
        this.itemArmazenado = item;
    }

    public Item getItemArmazenado() {
        return itemArmazenado;
    }

    public void usarItem(ItemDeAtaque item, Corredor alvo) throws ItemInvalidoException, AlvoInvalidoException {
        if (itemArmazenado != item) {
            throw new ItemInvalidoException();
        }
        if (alvo == this) {
            throw new AlvoInvalidoException();
        }
        item.usarAlvo(this, alvo);
        this.itemArmazenado = null;
    }

    public void usarItem(ItemDeUso item) throws ItemInvalidoException {
        if (this.itemArmazenado != item) {
            throw new ItemInvalidoException();
        }
        item.consumir(this);
        this.itemArmazenado = null;

    }

    public void andaUmNumeroEspecificoDeCasas(int bonusDeCasas) {
        int quantidadeDeCasasASerPercorrido = bonusDeCasas;

        if (pistaQuePertence != null) {
            if (casaAtual != null) {
                int numeroDaCasaAtual = casaAtual.getNumeroDaCasa();
                int numeroDaProximaCasa = numeroDaCasaAtual + quantidadeDeCasasASerPercorrido;

                if (numeroDaProximaCasa >= pistaQuePertence.getTamanhoDaPista()) {//Ganhou
                    avancaParaACasa(null);
                    pistaQuePertence.adicionarAoPodium(this);
                } else {//Nao ganhou ainda
                    Casa proximaCasa = pistaQuePertence.getCasaPelaPosicao(numeroDaProximaCasa);
                    avancaParaACasa(proximaCasa);
                    if (proximaCasa instanceof CasaCustomizada) {
                        ((CasaCustomizada) proximaCasa).aplicaEfeitoNoCorredor(this);
                    }
                }
            }
        }
    }

    public void recebeCura(int cura) {
        this.vida += cura;
    }

    public void recebeDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            pistaQuePertence.corredorSaiDaCorrida(this);
            pistaQuePertence = null;
            casaAtual = null;
        }
    }
}
