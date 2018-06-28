package br.com.cwi.redesocial.service.cliente;

import br.com.cwi.redesocial.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

@Repository
public class LoginService {

    @Autowired
    private BuscaUsuarioPorEmailService buscaUsuarioPorEmailService;

    public String login(String email,String senha){
        Usuario usuarioCarregado = buscaUsuarioPorEmailService.buscar(email);

        if(!BCrypt.checkpw(senha,usuarioCarregado.getSenha())){
            throw new IllegalArgumentException("Usuario e senha invalido");
        }

        return usuarioCarregado.getSenha();
    }
}
