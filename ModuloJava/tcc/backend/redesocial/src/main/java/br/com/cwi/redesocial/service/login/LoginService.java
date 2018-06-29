package br.com.cwi.redesocial.service.login;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.service.cliente.BuscaUsuarioPorEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    public String login(String email,String senha){
        Usuario usuarioCarregado = buscaUsuarioPorEmailService.buscar(email);

        if(Objects.isNull(senha)||senha.equals("")){
            throw new IllegalArgumentException("Senha invalida ou vazia");
        }

        if(!BCrypt.checkpw(senha,usuarioCarregado.getSenha())){
            throw new IllegalArgumentException("Usuario e senha invalido");
        }

        return usuarioCarregado.getSenha();
    }
}
