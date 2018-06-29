package br.com.cwi.redesocial.dominio.repository;

import br.com.cwi.redesocial.dominio.Comentario;
import org.springframework.data.repository.Repository;

public interface IComentarioRepository extends Repository<Comentario,Long> {

    void save(Comentario comentario);
}
