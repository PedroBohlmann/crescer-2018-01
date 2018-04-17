package produtos;

public class Artigo extends Produto {
    private String nome;
    private String descricao;

    public Artigo(double valorBase, int percentualLucro, String nome, String descricao){
        super(valorBase, percentualLucro);
        this.nome = nome;
        this.descricao = descricao;
    }
}
