package itens.ervas;

import itens.Item;

public class Erva extends Item {
    private Erva ervaMisturada;

    public Erva(int tilesOcupadosEmX, int tilesOcupadosEmY, double peso, String nome) {
        super(tilesOcupadosEmX, tilesOcupadosEmY, peso, nome);
    }

    public void misturarCom(Erva erva) {
        if (erva != null && this != erva) {
            ervaMisturada = erva;
            erva.getInventarioAQuePertence().removerItem(erva);
        } else {
            ervaMisturada = null;
        }
    }

    public String getMistura() {
        if (ervaMisturada != null) {
            StringBuilder retorno = new StringBuilder();
            retorno.append("Mistura de ");
            retorno.append(this.getNome());
            retorno.append(" com ");
            retorno.append(ervaMisturada.getNome());
            return retorno.toString();
        }
        return this.getNome();
    }
}
