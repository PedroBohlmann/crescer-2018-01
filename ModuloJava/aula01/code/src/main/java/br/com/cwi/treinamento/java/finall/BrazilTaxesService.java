package br.com.cwi.treinamento.java.finall;

public class BrazilTaxesService extends TaxesService {

    public BrazilTaxesService(double price) {
        super(price);
    }

    @Override
    public double getLocalTaxes() {
        return 0.6;
    }

}
