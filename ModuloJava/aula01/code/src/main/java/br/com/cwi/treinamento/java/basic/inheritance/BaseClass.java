package br.com.cwi.treinamento.java.basic.inheritance;

public class BaseClass {

    private String codigo;

    private String descricao;

    public BaseClass(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void overridableMethod() {
        System.out.println("base method");
    }

    public final void nonOverridableMethod() {
        System.out.println("base method");
    }
}
