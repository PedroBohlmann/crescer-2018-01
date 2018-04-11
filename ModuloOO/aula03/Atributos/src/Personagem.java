public class Personagem {
    //1- Modificador de acesso
    //2- Tipo de atributo
    //3- Nome do atributo
    private int vida;

    //1- Modificador de acesso
    //2- Nome da classe
    public Personagem(int vida){
        this.vida=vida;
    }
    public Personagem(){
        this.vida=10;
    }
    //1- modificador de acesso
    //2- Tipo de retorno do metodo
    //3- Nome do metodo
    public int getVida(){
        return this.vida;
    }

}
