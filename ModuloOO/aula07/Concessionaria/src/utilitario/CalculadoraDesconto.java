package utilitario;

import produtos.Produto;

public class CalculadoraDesconto {
    public static double calcularValorTotalProdutoComDesconto(Produto produto, int percentualDesconto){
        double valorTotal = produto.calcularValorTotal();
        double valorDesconto = valorTotal * ((double) percentualDesconto / 100);
        return valorTotal - valorDesconto;
    }
}
