package br.com.itau.grupo3.mapper;

import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.model.ChavePix;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ChavePixMapper {

    public ChavePix requestToModel(ChavePixRequest request){
        ChavePix chavePix = new ChavePix();
        BeanUtils.copyProperties(request, chavePix);
        return chavePix;
    }

    public ChavePixResponse modelToResponse(ChavePix chavePix){
        ChavePixResponse response = new ChavePixResponse();
        BeanUtils.copyProperties(chavePix, response);
        return response;
    }
}
