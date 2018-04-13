package armas;

public class Ariete extends Arma{
    protected boolean pontaDeFerro;

    public Ariete(String nome, boolean pontaDeFerro) {
        super(nome);
        this.pontaDeFerro = pontaDeFerro;
        this.poderDeAtaque=500;
        this.tipoAtaque="terrestre";
    }
    @Override
    public int getPoderDeAtaque(){
        if(pontaDeFerro){
            return poderDeAtaque+poderDeAtaque;
        }
        return poderDeAtaque;
    }

}
