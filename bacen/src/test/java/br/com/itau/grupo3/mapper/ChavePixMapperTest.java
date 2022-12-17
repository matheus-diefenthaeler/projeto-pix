package br.com.itau.grupo3.mapper;

import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.factory.Factory;
import br.com.itau.grupo3.model.ChavePix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ChavePixMapperTest {

    static ChavePix chavePix;
    static ChavePixMapper chavePixMapper;
    static ChavePixRequest chavePixRequest;

    @BeforeEach
    void setup() {
        chavePixMapper = new ChavePixMapper();
        chavePix = new ChavePix();
        chavePixRequest = Factory.createChavePixRequest();
    }


    @Test
    void requestToModelTest() {
        ChavePix chavePix = chavePixMapper.requestToModel(chavePixRequest);

        assertEquals(ChavePix.class, chavePix.getClass());
        assertEquals(ChavePixRequest.class, chavePixRequest.getClass());
        assertNotEquals(chavePixRequest.getClass(), chavePix.getClass());
    }

    @Test
    void modelToResponseTest() {
        ChavePixResponse chavePixResponse = chavePixMapper.modelToResponse(chavePix);

        assertEquals(ChavePixResponse.class, chavePixResponse.getClass());
        assertEquals(ChavePix.class, chavePix.getClass());
    }
}