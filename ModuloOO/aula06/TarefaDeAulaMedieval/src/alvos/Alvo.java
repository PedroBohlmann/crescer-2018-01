package alvos;

public class Alvo {
    private int pontosDeVida;

    public Alvo(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public void recebeAtaque(int danoASerTomado){
        if(danoASerTomado>pontosDeVida) {
            pontosDeVida=0;
        }else{
            pontosDeVida-=danoASerTomado;
        }
    }

    public int getPontosDeVida() {
        return pontosDeVida;
    }
}
