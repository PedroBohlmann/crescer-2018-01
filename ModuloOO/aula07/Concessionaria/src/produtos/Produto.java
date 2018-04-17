package produtos;

public abstract class Produto {
    private double valorBase;
    private int percentualLucro;
    private final double ICMS = 0.13;

    public Produto(double valorBase, int percentualLucro){
        this.valorBase = valorBase;
        this.percentualLucro = percentualLucro;
    }

    public double calcularValorTotal(){
        return calcularLucroTotal() + calcularValorTotalImpostos() + valorBase;
    }

    public double calcularLucroTotal(){
        return (valorBase + calcularValorTotalImpostos()) * ((double) percentualLucro / 100);
    }
    public abstract double calcularValorTotalImpostos();

    public double getValorBase() {
        return valorBase;
    }

    public double getICMS() {
        return ICMS;
    }

    public int getPercentualLucro() {
        return percentualLucro;
    }
}
