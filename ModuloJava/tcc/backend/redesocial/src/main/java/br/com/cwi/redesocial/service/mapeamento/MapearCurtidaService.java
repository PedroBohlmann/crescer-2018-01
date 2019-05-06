package br.com.cwi.redesocial.service.mapeamento;

import br.com.cwi.redesocial.dominio.Curtida;
import br.com.cwi.redesocial.web.model.response.CurtidaResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MapearCurtidaService {

    public CurtidaResponse mapearCurtidaParaResponse(Curtida curtida){
        if(Objects.isNull(curtida)){
            throw new IllegalArgumentException("Curtida nula");
        }
        CurtidaResponse response = new CurtidaResponse();
        response.setIdCurtida(curtida.getId());

        return response;
    }
}
