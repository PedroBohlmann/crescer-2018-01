package armas;

public class Arma {
    protected String nome;
    protected int poderDeAtaque;
    protected String tipoAtaque;

    public Arma(String nome) {
        this.nome = nome;
        this.tipoAtaque = "normal";
        this.poderDeAtaque=20;
    }

    public int getPoderDeAtaque() {
        return poderDeAtaque;
    }

    public String getTipoAtaque() {
        return tipoAtaque;
    }
}
