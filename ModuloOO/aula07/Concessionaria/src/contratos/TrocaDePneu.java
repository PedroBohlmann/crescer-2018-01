package contratos;

import produtos.Pneu;

import java.util.List;

public class TrocaDePneu implements Servico {

    private final double valorDaMaoDeObra=100;
    private final double valorLucroDeCadaPneu=150;

    private List<Pneu> listaDePneus;

    public TrocaDePneu(List<Pneu> listaDePneus) {
        this.listaDePneus = listaDePneus;
    }

    @Override
    public double calcularValorBaseDeMaoDeObra() {
        double valorBaseDosPneus=0;
        for(Pneu pneuAtual:listaDePneus){
            valorBaseDosPneus+=pneuAtual.calcularValorBase();
        }
        return listaDePneus.size()*valorDaMaoDeObra+valorBaseDosPneus;//1304
    }

    @Override
    public double calcularValorTotalServico() {
        return listaDePneus.size()*(calcularValorBaseDeMaoDeObra()+calcularLucroTotal())+calculaValorTotalDosPneus();
    }

    @Override
    public double calcularLucroTotal() {
        return listaDePneus.size()*valorLucroDeCadaPneu;//600
    }

    private double calculaValorTotalDosPneus(){
        double valorTotal=0;
        for(Pneu pneuAtual:listaDePneus){
            valorTotal+=pneuAtual.calcularValorTotal();
        }
        return valorTotal;//1096.1
    }
}
