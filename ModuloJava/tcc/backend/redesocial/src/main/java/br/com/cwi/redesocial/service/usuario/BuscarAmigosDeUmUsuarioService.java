package br.com.cwi.redesocial.service.usuario;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IContatoRepository;
import br.com.cwi.redesocial.service.mapeamento.MapearUsuarioService;
import br.com.cwi.redesocial.web.model.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BuscarAmigosDeUmUsuarioService {

    @Autowired
    private IContatoRepository contatoRepository;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    private MapearUsuarioService mapearUsuarioService;

    public List<UsuarioResponse> listar(Long id){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("Id nulo");
        }

        Usuario usuario = buscarUsuarioPorIdService.buscar(id);

        if(Objects.isNull(usuario)){
            throw new IllegalArgumentException("Sem usuario com esse id");
        }

        List<Contato> contatos = contatoRepository.findByUsuario(usuario);

        List<Usuario> amigos = contatos.stream().map(Contato::getUsuarioConvidado).collect(Collectors.toList());

        List<UsuarioResponse> response = new ArrayList<>();

        for(Usuario amigo : amigos){
            response.add(mapearUsuarioService.mapearUsuarioParaUsuarioResponse(amigo));
        }

        return response;
    }
}
