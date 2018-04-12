public class MagoArcano {
    private int vida;
    private int mana;
    private int nivel;
    private int poderMagico;
    private int numeroDeTreinosArcanos;
    private BolaDeFogo bolaDeFogo;
    private boolean bonus;

    public MagoArcano() {
        this.vida = 10;
        this.mana = 4;
        this.nivel = 1;
        this.poderMagico = 2;
        numeroDeTreinosArcanos=0;
        bolaDeFogo =null;
        bonus=false;
    }

    public int getVida() {
        return vida;
    }

    public int getMana() {
        return mana;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPoderMagico() { return poderMagico; }

    public void sobeNivel(){
        vida+=vida;
        mana+=mana;
        nivel++;
        poderMagico+=poderMagico;
    }
    public void realizaTreinamentoArcano(){
        sobeNivel();
        numeroDeTreinosArcanos++;
        addBonusPoderMagico();
    }
    private void addBonusPoderMagico(){//MARK: O Bonus é unico?
        if(numeroDeTreinosArcanos>=3&&!bonus) {
            poderMagico += 5;
            bonus = true;
        }
    }
    private int gastaMana(int manaASerGasto){
        if(manaASerGasto>mana){
            int retorno=mana;
            mana=0;
            return retorno;
        }else{
            mana-=manaASerGasto;
            return manaASerGasto;
        }
    }

    public void aprendeBolaDeFogo(BolaDeFogo bolaDeFogo){ this.bolaDeFogo =bolaDeFogo; }

    public int soltaBolaDeFogo(int manaASerGasto){
        if(bolaDeFogo !=null) {
            int poderBolaDeFogo = poderMagico+gastaMana(manaASerGasto)+bolaDeFogo.getPoderDaBolaDeFogo();
            return poderBolaDeFogo;
        }
        return 0;
    }

}
