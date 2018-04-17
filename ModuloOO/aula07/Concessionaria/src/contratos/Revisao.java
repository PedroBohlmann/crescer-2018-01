package contratos;

public class Revisao implements Servico {
    private double valor;
    private double valorLucro;

    public Revisao(double valor, double valorLucro) {
        this.valor = valor;
        this.valorLucro = valorLucro;
    }

    @Override
    public double calcularValorBaseServico() {
        return valor;
    }

    @Override
    public double calcularValorTotalServico() {
        return valor+valorLucro;
    }

    @Override
    public double calcularLucroTotal() {
        return valorLucro;
    }
}
