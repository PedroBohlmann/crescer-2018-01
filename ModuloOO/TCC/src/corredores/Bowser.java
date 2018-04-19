package corredores;

public class Bowser extends Corredor {

    private int quantidadeDeCasasPercorridoSeguido;

    public Bowser() {
        super(10);
        this.quantidadeDeCasasPercorridoSeguido=0;
    }

    @Override
    protected int casaASerPercorrido() {
        quantidadeDeCasasPercorridoSeguido++;
        if(quantidadeDeCasasPercorridoSeguido<=2){
            return super.getQuantidadeDeCasasQuePercorre()-2;
        }else{
            return super.getQuantidadeDeCasasQuePercorre()+2;
        }
    }
}
