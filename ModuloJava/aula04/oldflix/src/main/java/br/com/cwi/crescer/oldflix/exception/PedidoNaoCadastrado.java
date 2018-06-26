package br.com.cwi.crescer.oldflix.exception;

public class PedidoNaoCadastrado extends RuntimeException{
    public PedidoNaoCadastrado(Long id){
        super("Não tem pedido com esse id="+id);
    }
}
