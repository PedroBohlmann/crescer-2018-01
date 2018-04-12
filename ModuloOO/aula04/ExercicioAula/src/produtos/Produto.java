package produtos;
/*Cada produto possui valor base, percentual de lucro, ICMS e possui os
métodos calcular valor total, calcular valor total de lucro, calcular valor total
impostos.*/
public class Produto {
    protected static final double ICMS=0.13;
    protected double valorBase;
    protected double percentualLucro;

    public Produto(double valorBase, double percentualLucro) {
        this.valorBase = valorBase;
        this.percentualLucro = percentualLucro/100;
    }

    public double calcularValorTotal(){
        return valorBase+calcularValorTotalDeLucro()+calcularValorTotalImpostos();
    }
    public double calcularValorTotalDeLucro(){
        return (valorBase+calcularValorTotalImpostos())*percentualLucro;
    }
    public double calcularValorTotalImpostos(){
        return valorBase*ICMS;
    }
}
