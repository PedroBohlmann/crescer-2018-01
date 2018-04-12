public class Colaborador {
    private String nome;

    public Colaborador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String retornarString(){
        return "Eu sou o Colaborador "+nome;
    }
}
