package br.com.cwi.redesocial.service.usuario;

import br.com.cwi.redesocial.dominio.Usuario;
import br.com.cwi.redesocial.dominio.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BuscarUsuarioPorIdService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public Usuario buscar(Long id){
        if(Objects.isNull(id)){
            throw new IllegalArgumentException("Id está nulo");
        }

        return usuarioRepository.findById(id).orElse(null);
    }
}
