package corredores;

import exceptions.AlvoInvalidoException;
import exceptions.ItemInvalidoException;
import pistas.casas.Casa;
import pistas.Pista;
import tipos_de_itens.Item;
import tipos_de_itens.ataque.ItemDeAtaque;
import tipos_de_itens.uso.ItemDeUso;

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
        Pista pista = this.getPistaQuePertence();
        Casa casa = this.getCasaAtual();
        int quantidadeDeCasas = casaASerPercorrido();
        if (pista != null) {
            int numeroDaCasaAtual = casa.getNumeroDaCasa();
            if (numeroDaCasaAtual + quantidadeDeCasas > pista.getTamanhoDaPista()) {
                setCasaAtual(new Casa(pista.getTamanhoDaPista()));
                pista.adicionarAoPodium(this);
            } else {
                setCasaAtual(new Casa(numeroDaCasaAtual + quantidadeDeCasas));
            }
        }
    }

    protected abstract int casaASerPercorrido();

    public void associarAUmaPista(Pista pista) {
        this.pistaQuePertence = pista;
        this.casaAtual = new Casa(0);
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

    protected void setCasaAtual(Casa casa) {
        this.casaAtual = casa;
    }

    public int getVida() {
        return vida;
    }

    public void equiparItem(Item item) {
        this.itemArmazenado = item;
    }

    public void usarItem(ItemDeAtaque item, Corredor alvo) throws ItemInvalidoException, AlvoInvalidoException {
        if (itemArmazenado != item) {
            throw new ItemInvalidoException();
        }
        if (alvo == this) {
            throw new AlvoInvalidoException();
        }
        item.usarAlvo(alvo);
        this.itemArmazenado = null;
    }

    public void usarItem(ItemDeUso item) throws ItemInvalidoException {
        if (this.itemArmazenado != item) {
            throw new ItemInvalidoException();
        }
        item.consumir(this);
        this.itemArmazenado = null;

    }

    public void recebeBonus(int bonusDeCasas) {
        Pista pista = this.getPistaQuePertence();
        Casa casa = this.getCasaAtual();
        int quantidadeDeCasas = bonusDeCasas;
        if (pista != null) {
            int numeroDaCasaAtual = casa.getNumeroDaCasa();
            if (numeroDaCasaAtual + quantidadeDeCasas >= pista.getTamanhoDaPista()) {
                setCasaAtual(new Casa(pista.getTamanhoDaPista()));
                pista.adicionarAoPodium(this);
            } else {
                setCasaAtual(new Casa(numeroDaCasaAtual + quantidadeDeCasas));
            }
        }
    }

    public void recebeCura(int cura) {
        this.vida += cura;
    }

    public void recebeDano(int dano) {
        this.vida -= dano;
        if (this.vida <= 0) {
            pistaQuePertence = null;
            casaAtual = null;
        }
    }
}
