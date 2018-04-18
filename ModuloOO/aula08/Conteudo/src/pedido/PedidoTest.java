package pedido;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PedidoTest {

    @Test
    public void test(){
        Pedido pedido=new Pedido();
        StatusPedido statusPedido=pedido.getStatusPedido();
    }

    @Test
    public void test2(){
        Map<StatusPedido,List<Pedido>> relatorio= new HashMap<>();

        List<Pedido> pedidosAguardandoPagamento= new LinkedList<>();

        relatorio.put(StatusPedido.PENDENTE_PAGAMENTO,pedidosAguardandoPagamento);

        if(relatorio.containsKey(StatusPedido.PENDENTE_PAGAMENTO)){//verifica se tem alguma chave
            List<Pedido> pedido=relatorio.get(StatusPedido.PENDENTE_PAGAMENTO);
        }

        for(StatusPedido statusPedidoAtual:relatorio.keySet()){//para percorrer o map
            List lista = relatorio.get(statusPedidoAtual);
        }
    }
}
