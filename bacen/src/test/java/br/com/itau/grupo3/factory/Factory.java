package br.com.itau.grupo3.factory;

import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.model.TipoChavePix;


public class Factory {

    public static ChavePixRequest createChavePixRequest() {
        ChavePixRequest chavePixRequest = new ChavePixRequest();
        chavePixRequest.setChave("teste@email.com");
        chavePixRequest.setTipo(TipoChavePix.EMAIL);
        chavePixRequest.setAgencia("1234");
        chavePixRequest.setConta("12345");
        chavePixRequest.setInstituicaoFinanceira("Itau");
        chavePixRequest.setTitular("User Test");
        chavePixRequest.setCpfCnpj("12345678901");
        return chavePixRequest;
    }

    public static ChavePixResponse createChavePixResponse() {
        ChavePixResponse chavePixResponse = new ChavePixResponse();
        chavePixResponse.getChave();
        chavePixResponse.getTipo();
        chavePixResponse.getTipo();
        chavePixResponse.getAgencia();
        chavePixResponse.getConta();
        chavePixResponse.getInstituicaoFinanceira();
        chavePixResponse.getTitular();
        chavePixResponse.getCpfCnpj();
        return chavePixResponse;
    }

}
