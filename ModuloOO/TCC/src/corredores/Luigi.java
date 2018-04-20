package corredores;

public class Luigi extends Corredor {

    public Luigi() {
        super(5);
    }

    @Override
    protected int casaASerPercorrido() {
        return getQuantidadeDeCasasQuePercorre();
    }
}
