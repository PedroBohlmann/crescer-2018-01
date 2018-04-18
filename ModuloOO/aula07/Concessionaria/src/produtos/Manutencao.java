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
    public double calcularValorBaseDeMaoDeObra() {
        return (quantidadeDeHoras * quantidadeDePessoas) * this.getValorBase();
    }

    @Override
    public double calcularValorTotalImpostos() {
        return calcularValorBaseDeMaoDeObra() * this.getICMS();
    }

    @Override
    public double calcularLucroTotal() {
        return (calcularValorBaseDeMaoDeObra() + calcularValorTotalImpostos()) * this.getPercentualLucro()/100;
    }

    @Override
    public double calcularValorTotalServico() {
        return calcularValorBaseDeMaoDeObra() + calcularLucroTotal() + calcularValorTotalImpostos();
    }
}
