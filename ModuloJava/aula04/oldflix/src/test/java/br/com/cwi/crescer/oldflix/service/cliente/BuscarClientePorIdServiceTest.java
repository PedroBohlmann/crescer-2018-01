package br.com.cwi.crescer.oldflix.service.cliente;

import br.com.cwi.crescer.oldflix.dominio.Cliente;
import br.com.cwi.crescer.oldflix.dominio.repository.IClienteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

//@RunWith(SpringRunner.class) sobe o spring mas para o mockito é outro caso
@RunWith(MockitoJUnitRunner.class) // roda test com mockito show
public class BuscarClientePorIdServiceTest {

    @InjectMocks
    private BuscarClientePorIdService tested;

    @Mock
    private IClienteRepository repository;


    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExceptionQuandobuscar() {
        tested.buscar(null);
    }

    @Test()
    public void deveAcharOUsuarioComIdQuandobuscar() {
        Long id = 1L;

        Cliente cliente = new Cliente();
        cliente.setId(id);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(cliente));

        Cliente clienteAchado = tested.buscar(id);

        Assert.assertNotNull(clienteAchado);

        Assert.assertEquals(id,clienteAchado.getId());
    }
}