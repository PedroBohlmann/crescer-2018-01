package armas;

public class Catapulta extends Arma {
    protected int alturaDeAtaque;

    public Catapulta(String nome, int alturaDeAtaque) {
        super(nome);
        this.poderDeAtaque=3500;
        this.alturaDeAtaque = alturaDeAtaque;
        this.tipoAtaque="aereo";
    }
    @Override
    public int getPoderDeAtaque() {
        return poderDeAtaque+(alturaDeAtaque*2);
    }
}
