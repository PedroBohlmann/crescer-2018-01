public class AcademiaDoFogo {
    private int nivelDePoder;

    public AcademiaDoFogo(int nivelDePoder) {
        this.nivelDePoder = nivelDePoder;
    }
    public int getNivelDePoder() {
        return nivelDePoder;
    }

    public void treinarMago(MagoArcano magoArcano){
        BolaDeFogo bolaDeFogo=new BolaDeFogo(nivelDePoder);
        magoArcano.aprendeBolaDeFogo(bolaDeFogo);
    }
}
