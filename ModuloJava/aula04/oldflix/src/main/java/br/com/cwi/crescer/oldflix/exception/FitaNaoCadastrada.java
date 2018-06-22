package br.com.cwi.crescer.oldflix.exception;

public class FitaNaoCadastrada extends RuntimeException {
    public FitaNaoCadastrada(Long id){
        super("Não possui fica com esse id="+id);
    }
}
