package produtos;

public abstract class Produto {
    protected double valorBase;
    protected int percentualLucro;
    protected final double ICMS = 0.13;

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
    public double calcularValorTotalImpostos(){
        return valorBase * ICMS;
    }
}
