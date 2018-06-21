package br.com.cwi.crescer.oldflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNaoCadastrado extends RuntimeException {
    public ClienteNaoCadastrado(long id) {
        super("Sem cliente com id="+id);
    }
}
