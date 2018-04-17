package produtos;

import contratos.Servico;

public class Manutencao extends Produto implements Servico {
    private double quantidadeDeHoras;
    private double quantidadeDePessoas;

    public Manutencao(double valorBase, int percentualLucro, double quantidadeDeHoras, double quantidadeDePessoas) {
        super(valorBase, percentualLucro);
        this.quantidadeDeHoras = quantidadeDeHoras;
        this.quantidadeDePessoas = quantidadeDePessoas;
    }

    @Override
    public double calcularValorBaseServico() {
        return (quantidadeDeHoras * quantidadeDePessoas) * this.getValorBase();
    }

    @Override
    public double calcularValorTotalImpostos() {
        return calcularValorBaseServico() * this.getICMS();
    }

    @Override
    public double calcularLucroTotal() {
        return (calcularValorBaseServico() + calcularValorTotalImpostos()) * this.getPercentualLucro();
    }

    @Override
    public double calcularValorTotalServico() {
        return calcularValorTotalServico() + calcularLucroTotal() + calcularValorTotalImpostos();
    }
}
