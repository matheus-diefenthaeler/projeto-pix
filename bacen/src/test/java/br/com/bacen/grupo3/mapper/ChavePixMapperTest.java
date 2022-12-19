package br.com.bacen.grupo3.mapper;

import br.com.bacen.grupo3.dto.request.ChavePixRequest;
import br.com.bacen.grupo3.dto.response.ChavePixResponse;
import br.com.bacen.grupo3.factory.Factory;
import br.com.bacen.grupo3.model.ChavePix;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

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
    }
    @Test
    void modelToResponseTest() {
        ChavePixResponse chavePixResponse = chavePixMapper.modelToResponse(chavePix);

        assertEquals(ChavePixResponse.class, chavePixResponse.getClass());
        assertEquals(ChavePix.class, chavePix.getClass());
    }
}