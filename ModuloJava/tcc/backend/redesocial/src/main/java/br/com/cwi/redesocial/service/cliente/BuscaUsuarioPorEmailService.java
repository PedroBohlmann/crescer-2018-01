package br.com.cwi.redesocial.service.cliente;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class BuscaUsuarioPorEmailService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public Usuario buscar(String email){
        if(Objects.isNull(email)||email.equals("")){
            throw new IllegalArgumentException("Email está nulo");
        }

        return usuarioRepository.findByEmail(email).orElse(null);
    }
}
