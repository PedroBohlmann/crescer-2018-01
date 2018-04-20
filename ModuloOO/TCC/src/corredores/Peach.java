package corredores;

public class Peach extends Corredor {

    private int quantidadeDeVezesAndadoSeguido;

    public Peach() {
        super(6);
        this.quantidadeDeVezesAndadoSeguido = 0;
    }

    @Override
    protected int casaASerPercorrido() {
        quantidadeDeVezesAndadoSeguido++;
        if (quantidadeDeVezesAndadoSeguido == 3) {
            this.quantidadeDeVezesAndadoSeguido = 0;
            return super.getQuantidadeDeCasasQuePercorre() + 2;
        }
        return super.getQuantidadeDeCasasQuePercorre();
    }
}
