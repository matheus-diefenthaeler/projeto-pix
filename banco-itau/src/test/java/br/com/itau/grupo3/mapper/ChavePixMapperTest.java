package br.com.itau.grupo3.mapper;

import br.com.itau.grupo3.client.dto.ChavePixBacen;
import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.factory.Factory;
import br.com.itau.grupo3.model.ChavePix;
import br.com.itau.grupo3.model.Conta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChavePixMapperTest {

    static ChavePixMapper chavePixMapper;
    static ChavePixRequest chavePixRequest;
    static Conta conta;

    @BeforeEach
    void setup() {
        chavePixMapper = new ChavePixMapper();
        chavePixRequest = Factory.createChavePixRequest();
        conta = Factory.createConta();
    }

    @Test
    public void requestToBacenTest() {
        ChavePixBacen chavePixBacenDTO = chavePixMapper.requestToBacen(chavePixRequest, conta);

        assertEquals(ChavePixBacen.class, chavePixBacenDTO.getClass());
        assertEquals(chavePixRequest.getChave(), chavePixBacenDTO.getChave());
    }

    @Test
    public void requestToModelTest() {
        ChavePix chavePix = chavePixMapper.requestToModel(chavePixRequest, conta);

        assertEquals(ChavePix.class, chavePix.getClass());
        assertEquals(chavePixRequest.getChave(), chavePix.getChave());
        assertEquals(conta, chavePix.getConta());
        assertEquals(chavePixRequest.getTipo(), chavePix.getTipo());
    }
}
