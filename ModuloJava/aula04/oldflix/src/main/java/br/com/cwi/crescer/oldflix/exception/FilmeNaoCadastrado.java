package br.com.cwi.crescer.oldflix.exception;

public class FilmeNaoCadastrado extends RuntimeException{
    public FilmeNaoCadastrado(Long id){
        super("Não tem filme com esse id="+id);
    }
}
