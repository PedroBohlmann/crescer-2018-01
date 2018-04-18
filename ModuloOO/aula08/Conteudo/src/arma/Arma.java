package arma;

public class Arma {

    private int municao;

    public Arma() {
        municao=6;
    }

    public void atirar() throws SemMunicaoExtraException {
        if(municao>0){
            municao-=1;
            return;
        }else{
            recarregar();
            this.atirar();
        }
    }

    private void recarregar() throws SemMunicaoExtraException {
        this.municao+=this.getMunicaoExtra();
        if(municao<1){
            throw new SemMunicaoExtraException();
        }
    }

    private int getMunicaoExtra(){
        //fingir que é caixinha de balas
        return 0;
    }
}
