package br.com.cwi.treinamento.java.finall;

public abstract class TaxesService {

    private static final double DEFAULT_TAXES = 0.1;

    private double price;

    public TaxesService(double price) {
        this.price = price;
    }

    public double getFinalPrice() {
        return price * totalTaxes();
    }

    public final double totalTaxes() {
        return DEFAULT_TAXES + getLocalTaxes();
    }

    public abstract double getLocalTaxes();

}
