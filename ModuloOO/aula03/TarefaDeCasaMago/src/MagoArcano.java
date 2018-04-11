public class MagoArcano {
    private int vida;
    private int mana;
    private int nivel;
    private int poderMagico;
    private int numeroDeTreinosArcanos;

    public MagoArcano() {
        this.vida = 10;
        this.mana = 4;
        this.nivel = 1;
        this.poderMagico = 2;
        numeroDeTreinosArcanos=0;
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

    public int getPoderMagico() {
        return poderMagico;
    }

    public void sobeNivel(){
        vida+=vida;
        mana+=mana;
        nivel++;
        poderMagico+=poderMagico;
    }
    public void realizaTreinamentoArcano(){
        numeroDeTreinosArcanos++;
        addBonusPoderMagico();
    }
    private void addBonusPoderMagico(){//MARK: O Bonus é unico?
        if(numeroDeTreinosArcanos>=3) {
            poderMagico += 5;
        }
    }

}
