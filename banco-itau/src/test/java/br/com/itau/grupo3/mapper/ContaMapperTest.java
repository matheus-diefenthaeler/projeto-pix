package br.com.itau.grupo3.mapper;

import br.com.itau.grupo3.dto.request.ContaRequest;
import br.com.itau.grupo3.factory.Factory;
import br.com.itau.grupo3.model.Conta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaMapperTest {


    @Test
    public void requestToModelTest() {
        ContaMapper contaMapper = new ContaMapper();

        ContaRequest contaRequest = Factory.createContaRequest();
        Conta conta = contaMapper.requestToModel(contaRequest);

        assertEquals(Conta.class, conta.getClass());
        assertEquals(contaRequest.getAgencia(), conta.getAgencia());
        assertEquals(contaRequest.getNumeroConta(), conta.getNumeroConta());
        assertEquals(contaRequest.getTipo(), conta.getTipo());
        assertEquals(contaRequest.getTitular(), conta.getTitular());
    }
}
