package produtos;

public class Artigo extends Produto {
    protected String nome;
    protected String descricao;

    public Artigo(double valorBase, double percentualLucro, String nome, String descricao) {
        super(valorBase, percentualLucro);
        this.nome = nome;
        this.descricao = descricao;
    }
}
