package br.com.cwi.redesocial.service.contato;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.StatusContato;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IContatoRepository;
import br.com.cwi.redesocial.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class AceitarPedidoDeAmizadeService {

    @Autowired
    private IContatoRepository contatoRepository;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Transactional
    public void aceitar(Long idCriador,Long idConvidado){
        Usuario criador = buscarUsuarioPorIdService.buscar(idCriador);

        Usuario convidado = buscarUsuarioPorIdService.buscar(idConvidado);

        if(Objects.isNull(criador)){
            throw new IllegalArgumentException("Sem usuario criador com esse id");
        }
        if(Objects.isNull(convidado)){
            throw new IllegalArgumentException("Sem usuario convidado com esse id");
        }

        Contato contatoCriador = contatoRepository.findByUsuarioAndUsuarioConvidado(criador,convidado);

        if(Objects.isNull(contatoCriador)){
            throw new IllegalArgumentException("Sem convite para ser aceito");
        }

        if(contatoCriador.getStatusContato()==StatusContato.CONVIDADO){
            contatoCriador.setStatusContato(StatusContato.AMIGO);
        }else{
            throw new IllegalArgumentException("Vocês já são amigos =D");
        }

        contatoRepository.save(contatoCriador);

        Contato contatoConvidado = contatoRepository.findByUsuarioAndUsuarioConvidado(convidado,criador);

        if(contatoConvidado.getStatusContato()==StatusContato.CONVIDADO){
            contatoConvidado.setStatusContato(StatusContato.AMIGO);
        }

        contatoRepository.save(contatoConvidado);
    }
}
