package br.com.itau.grupo3.mapper;

import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.model.ChavePix;
import org.springframework.stereotype.Component;

@Component
public class ChavePixMapper {

    public ChavePix requestToModel(ChavePixRequest request){
        ChavePix chavePix = new ChavePix();

        chavePix.setChave(request.getChave());
        chavePix.setConta(request.getAgencia()+"#"+request.getNumeroConta());
        chavePix.setTipo(request.getTipo());
        chavePix.setTipoConta(request.getTipoConta());
        chavePix.setInstituicaoFinanceira(request.getInstituicaoFinanceira());
        chavePix.setTitular(request.getTitular());
        chavePix.setCpfCnpj(request.getCpfCnpj());

        return chavePix;
    }

    public ChavePixResponse modelToResponse(ChavePix chavePix){
        ChavePixResponse response = new ChavePixResponse();

        response.setChave(chavePix.getChave());
        response.setAgencia(chavePix.getConta().split("#")[0]);
        response.setNumeroConta(chavePix.getConta().split("#")[1]);
        response.setTipo(chavePix.getTipo());
        response.setTipoConta(chavePix.getTipoConta());
        response.setInstituicaoFinanceira(chavePix.getInstituicaoFinanceira());
        response.setTitular(chavePix.getTitular());
        response.setCpfCnpj(chavePix.getCpfCnpj());

        return response;
    }
}
