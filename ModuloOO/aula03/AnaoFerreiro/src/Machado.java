public class Machado {
    private int poderDoMachado;

    public Machado(int poderDoMachado) {
        this.poderDoMachado = poderDoMachado;
    }

    public int getPoderDoMachado() {
        return poderDoMachado;
    }
    public void melhoraMachado(int bonus){
        poderDoMachado+=bonus;
        if(poderDoMachado>20){
            poderDoMachado=20;
        }
    }
}
