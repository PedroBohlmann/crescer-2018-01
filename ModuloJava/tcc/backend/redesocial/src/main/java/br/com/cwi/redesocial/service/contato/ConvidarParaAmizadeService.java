package br.com.cwi.redesocial.service.contato;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.StatusContato;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IContatoRepository;
import br.com.cwi.redesocial.service.usuario.BuscaUsuarioPorEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ConvidarParaAmizadeService {

    @Autowired
    private IContatoRepository contatoRepository;

    @Autowired
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    @Transactional
    public void criarAmizada(String criadorEmail, String convidadoEmail){

        Usuario criador = buscaUsuarioPorEmailService.buscar(criadorEmail);

        Usuario convidado = buscaUsuarioPorEmailService.buscar(convidadoEmail);

        if(Objects.isNull(criador)){
            throw new IllegalArgumentException("Sem usuario criador com esse id");
        }
        if(Objects.isNull(convidado)){
            throw new IllegalArgumentException("Sem usuario convidado com esse id");
        }

        Contato contatoDoUsuario = new Contato();
        contatoDoUsuario.setStatusContato(StatusContato.CONVIDADO);
        contatoDoUsuario.setUsuario(criador);
        contatoDoUsuario.setUsuarioConvidado(convidado);

        contatoRepository.save(contatoDoUsuario);

        Contato contadoDoConvidado = new Contato();

        contadoDoConvidado.setStatusContato(StatusContato.CONVIDADO);
        contadoDoConvidado.setUsuario(convidado);
        contadoDoConvidado.setUsuarioConvidado(criador);
        contatoRepository.save(contadoDoConvidado);
    }
}
