package alvos;

public class RaidBoss extends Alvo {

    private String nome;
    private int pontosDeDefesa;

    public RaidBoss(int pontosDeVida, String nome, int pontosDeDefesa) {
        super(pontosDeVida);
        this.nome = nome;
        this.pontosDeDefesa = pontosDeDefesa;
    }

    @Override
    public void recebeAtaque(int danoASerTomado){
        if(pontosDeDefesa>0){
            super.recebeAtaque(danoASerTomado);
        }
        else{
            if(danoASerTomado>pontosDeDefesa){
                pontosDeDefesa=0;
            }else {
                pontosDeDefesa -= danoASerTomado;
            }
        }
    }
}
