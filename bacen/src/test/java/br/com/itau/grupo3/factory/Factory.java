package br.com.itau.grupo3.factory;

import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.model.ChavePix;
import br.com.itau.grupo3.model.TipoChavePix;
import br.com.itau.grupo3.model.TipoConta;


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

    public static ChavePix createChavePix() {
        ChavePix chavePix = new ChavePix();

        chavePix.setChave("123321122370");
        chavePix.setTipo(TipoChavePix.CPFOUCNPJ);
        chavePix.setTipoConta(TipoConta.CORRENTE);
        chavePix.setAgencia("1234");
        chavePix.setConta("321");
        chavePix.setInstituicaoFinanceira("Itau");
        chavePix.setTitular("Teste");
        chavePix.setCpfCnpj("123321123");

        return chavePix;
    }

}
