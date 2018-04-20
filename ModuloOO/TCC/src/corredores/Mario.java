package corredores;

public class Mario extends Corredor {

    public Mario() {
        super(7);
    }

    @Override
    protected int casaASerPercorrido() {
        return getQuantidadeDeCasasQuePercorre() + 1;
    }
}
