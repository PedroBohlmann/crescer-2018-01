package dominio;

public enum Categoria {
    DOURADA(1),
    PRATA(2),
    BRONZE(3);

    private int categoria;

    Categoria(int categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        switch (categoria) {
            case 1:
                return 10;
            case 2:
                return 7;
            case 3:
                return 3;
            default:
                return -1;
        }
    }

    public int getPrazo() {
        switch (categoria) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 5;
            default:
                return -1;
        }
    }
}
