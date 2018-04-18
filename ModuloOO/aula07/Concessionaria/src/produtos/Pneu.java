package produtos;

public class Pneu extends Produto {
    public Pneu(double valorBase, int percentualLucro) {
        super(valorBase, percentualLucro);
    }

    @Override
    public double calcularValorTotalImpostos() {
        return getValorBase()*getICMS();
    }

    public double calcularValorBase(){
        return getValorBase()+calcularValorTotalImpostos();
    }
}
