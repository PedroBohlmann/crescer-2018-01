package br.com.cwi.redesocial.dominio.repository;

import br.com.cwi.redesocial.dominio.Contato;
import br.com.cwi.redesocial.dominio.Post;
import br.com.cwi.redesocial.dominio.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContatoRepository extends Repository<Contato,Long> {

    void save(Contato contato);

    Contato findByUsuarioAndUsuarioConvidado(Usuario usuario,Usuario usuarioConvidado);

    List<Contato> findByUsuario(Usuario usuario);

    void delete(Contato contato);
}
