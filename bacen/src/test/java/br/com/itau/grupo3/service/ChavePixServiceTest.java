package br.com.itau.grupo3.service;


import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.factory.Factory;
import br.com.itau.grupo3.mapper.ChavePixMapper;
import br.com.itau.grupo3.model.ChavePix;
import br.com.itau.grupo3.repository.ChavePixRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
class ChavePixServiceTest {

    @InjectMocks
    ChavePixService chavePixService;

    @Mock
    ChavePixRepository chavePixRepository;
    @Mock
    ChavePixMapper chavePixMapper;

    static ChavePixRequest chavePixRequest;
    static ChavePix chavePix;
    static ChavePixResponse chavePixResponse;

    @BeforeEach
    void setup() {
        chavePixRequest = Factory.createChavePixRequest();
        chavePixResponse = Factory.createChavePixResponse();
        chavePix = Factory.createChavePix();
    }
    @Test
    public void salvarTest() {

        Mockito.when(chavePixMapper.requestToModel(any())).thenReturn(chavePix);
        Mockito.when(chavePixRepository.save(any())).thenReturn(chavePix);

        ChavePixResponse chavePixResponse1 = chavePixService.salvar(chavePixRequest);

        Mockito.verify(chavePixMapper, Mockito.times(1)).modelToResponse(any());
        Mockito.verify(chavePixRepository, Mockito.times(1)).save(any());
    }
    @Test
    void buscarPorChave() {
        Mockito.when(chavePixRepository.findById(any())).thenReturn(Optional.of(chavePix));
        Mockito.when(chavePixMapper.modelToResponse(any())).thenReturn(chavePixResponse);

        ChavePixResponse chavePixResultado = chavePixService.buscarPorChave(chavePix.getChave());

        assertEquals(chavePixResultado, chavePixResponse);
        Mockito.verify(chavePixRepository, Mockito.times(1)).findById(any());
    }
}

