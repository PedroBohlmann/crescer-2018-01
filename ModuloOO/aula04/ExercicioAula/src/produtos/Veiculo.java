package produtos;
/*potência,marca, modelo, cor, IPI, ICMS, PIS, COFINS.

ICMS: 13%(0,13)
PIS: 1,7% (0,017)
COFINS: 7,6% (0,076)

Para o realizar o cálculo do valor total de impostos de um veículo, é necessário executar
o cálculo da seguinte maneira:

    (valor base * IPI) + (valor base * ICMS) + (valor base * PIS) + (valor base *COFINS)
*/
public class Veiculo extends Produto {
    protected double potencia;
    protected String marca;
    protected String modelo;
    protected String cor;

    protected static final double PIS=0.017;
    protected static final double CONFINS=0.076;
    protected double IPI;

    public Veiculo(double valorBase, double percentualLucro, double potencia, String marca, String modelo, String cor) {
        super(valorBase, percentualLucro);
        this.potencia = potencia;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        calcularIPI();
    }

    private void calcularIPI() {
        IPI = (potencia>=1)? 0.08:0.02;
    }

    @Override
    public double calcularValorTotalImpostos(){
        return (valorBase * IPI) + (valorBase * ICMS) + (valorBase * PIS) + (valorBase *CONFINS);
    }
}
