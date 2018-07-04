package br.com.cwi.redesocial.service.usuario;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class CadastraUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    @Transactional
    public void cadastra(Usuario usuario){

        if(Objects.isNull(usuario)){
            throw new IllegalArgumentException("Usuario nulo");
        }

        if(Objects.isNull(usuario.getNome())||usuario.getNome().length()==0){
            throw new IllegalArgumentException("Nome invalido");
        }

        if(Objects.isNull(usuario.getEmail())||usuario.getEmail().length()==0){
            throw new IllegalArgumentException("Email nulo");
        }

        if(Objects.isNull(usuario.getSenha())||usuario.getSenha().length()==0){
            throw new IllegalArgumentException("Senha nulo");
        }

        if(Objects.isNull(usuario.getDataDeNascimento())){
            throw new IllegalArgumentException("Data nascimento nula");
        }

        Usuario usuarioCadastrado = buscaUsuarioPorEmailService.buscar(usuario.getEmail());

        if(usuarioCadastrado==null){
            String senhaCripada = BCrypt.hashpw(usuario.getSenha(),BCrypt.gensalt());

            usuario.setSenha(senhaCripada);

            usuarioRepository.save(usuario);
        }else{
            throw  new IllegalArgumentException("Esse email já possui uma conta");
        }
    }
}
