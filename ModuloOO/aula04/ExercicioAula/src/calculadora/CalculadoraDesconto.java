package calculadora;

import produtos.Produto;

public class CalculadoraDesconto {
    public static double calculaDesconto(Produto produto, double porcentagemDesconto){
        double valorTotal = produto.calcularValorTotal();
        double valorDesconto=0;
        if(porcentagemDesconto!=0){
            valorDesconto=valorDesconto*(porcentagemDesconto/100);
        }
        return (valorTotal-valorDesconto);
    }
}
