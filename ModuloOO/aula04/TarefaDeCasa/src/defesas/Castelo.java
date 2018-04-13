package defesas;

import armas.Arma;

public class Castelo {
    private String nome;
    private int pontosDeDefesa;
    private boolean vivo;
    private Muro muro;

    public Castelo(String nome) {
        this.nome = nome;
        this.pontosDeDefesa=50000;
        this.vivo=true;
        this.muro=new Muro();
    }
    public void receberAtaque(Arma arma){
        if(vivo){
            if(arma.getTipoAtaque().equals("aereo")|| muro.getPontosDeDefesa()<=0){
                pontosDeDefesa-=arma.getPoderDeAtaque();
            }
            else{
                muro.recebeAtaque(arma);
            }
        }
        vivo = (pontosDeDefesa>0)? true:false;
    }
    public boolean verificaSeMuroEstaDePe(){
        return (muro.getPontosDeDefesa()>0)? true:false;
    }

    public int getPontosDeDefesa() {
        return pontosDeDefesa;
    }

    public boolean veirifcaSeCasteloTaDePe(){
        return vivo;
    }
}
