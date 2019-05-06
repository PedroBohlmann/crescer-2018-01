package br.com.cwi.redesocial.service.contato;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IContatoRepository;
import br.com.cwi.redesocial.service.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class DeletarAmizadeService {

    @Autowired
    private IContatoRepository contatoRepository;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Transactional
    public void deletar(Long idCriador,Long idConvidado){
        Usuario usuarioCriador = buscarUsuarioPorIdService.buscar(idCriador);

        Usuario usuarioConvidado = buscarUsuarioPorIdService.buscar(idConvidado);

        if(Objects.isNull(usuarioCriador)){
            throw new IllegalArgumentException("Sem usuario criador com esse id");
        }
        if(Objects.isNull(usuarioConvidado)){
            throw new IllegalArgumentException("Sem usuario convidado com esse id");
        }

        Contato contatoCriador = contatoRepository.findByUsuarioAndUsuarioConvidado(usuarioCriador,usuarioConvidado);
        Contato contatoConvidado = contatoRepository.findByUsuarioAndUsuarioConvidado(usuarioConvidado,usuarioCriador);

        if(Objects.isNull(contatoCriador)||Objects.isNull(contatoConvidado)){
            throw new IllegalArgumentException("Sem relação com esse usuario");
        }

        contatoRepository.delete(contatoCriador);
        contatoRepository.delete(contatoConvidado);
    }
}
