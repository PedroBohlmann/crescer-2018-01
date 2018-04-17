package produtos;

public class Veiculo extends Produto{
    private double potencia;
    private String marca;
    private String modelo;
    private String cor;
    private double ipi;
    private final double PIS = 0.017;
    private final double COFINS = 0.076;

    public Veiculo(double valorBase, int percentualLucro, double potencia, String marca, String modelo, String cor){
        super(valorBase, percentualLucro);
        this.potencia = potencia;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ipi = potencia <= 1.0 ? 0.02 : 0.08;
    }

    @Override
    public double calcularValorTotalImpostos(){
        return (double) Math.round(calcularTotalPorcentagemImpostos() * valorBase);
    }

    private double calcularTotalPorcentagemImpostos(){
        return super.ICMS + ipi + PIS + COFINS;
    }

}
