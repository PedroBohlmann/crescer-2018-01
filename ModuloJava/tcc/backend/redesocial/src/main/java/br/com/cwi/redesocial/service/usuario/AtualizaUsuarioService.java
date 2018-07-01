package br.com.cwi.redesocial.service.usuario;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AtualizaUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private BuscaUsuarioPorEmailService emailService;

    public void atualiza(String email, Usuario usuario){
        Usuario usuarioCarregado = emailService.buscar(email);

        if(Objects.isNull(usuarioCarregado)){
            throw new IllegalArgumentException("Usuario invalido");
        }
        if(Objects.isNull(usuario.getNome())||usuario.getNome().length()==0){
            throw new IllegalArgumentException("nome invalido");
        }
        if(Objects.isNull(usuario.getEmail())||usuario.getEmail().length()==0){
            throw new IllegalArgumentException("email invalido");
        }
        if(Objects.isNull(usuario.getSenha())||usuario.getSenha().length()==0){
            throw new IllegalArgumentException("senha invalido");
        }
        if(Objects.isNull(usuario.getDataDeNascimento())){
            throw new IllegalArgumentException("data de nascimento invalido");
        }

        usuarioCarregado.atualizar(usuario);

        usuarioRepository.save(usuarioCarregado);
    }
}
