package br.com.itau.grupo3.service;

import br.com.itau.grupo3.client.BacenClient;
import br.com.itau.grupo3.client.dto.ChavePixBacen;
import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.factory.Factory;
import br.com.itau.grupo3.mapper.ChavePixMapper;
import br.com.itau.grupo3.model.ChavePix;
import br.com.itau.grupo3.model.Conta;
import br.com.itau.grupo3.repository.ChavePixRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class ChavePixServiceTest {
    @InjectMocks
    ChavePixService chavePixService;
    @Mock
    ChavePixRepository chavePixRepository;
    @Mock
    ChavePixBacenClient chavePixBacenClient;

    @Mock
    ContaService contaService;
    @Mock
    ChavePixMapper chavePixMapper;

    static Conta conta;
    static ChavePixRequest chavePixRequest;
    static ChavePix chavePix;
    static ChavePixBacenDTO chavePixBacenDTO;

    @BeforeEach
    void setup() {
        conta = Factory.createConta();
        chavePixRequest = Factory.createChavePixRequest();
        chavePix = Factory.createChavePix();
        chavePixBacenDTO = Factory.createChavePixBacenDTO();
    }
    @Test
    void testSalvar() {
        //when
        Mockito.when(contaService.buscarPorId(anyLong())).thenReturn(conta);
        Mockito.when(chavePixMapper.requestToBacen(any(), any())).thenReturn(new ChavePixBacenDTO());
        Mockito.when(chavePixBacenClient.cadastrarChavePix(any(ChavePixBacenDTO.class))).thenReturn(ResponseEntity.created(URI.create("")).body(chavePixBacenDTO));
        Mockito.when(chavePixMapper.requestToModel(any(ChavePixRequest.class), any(Conta.class))).thenReturn(chavePix);
        Mockito.when(chavePixMapper.modelToResponse(chavePix)).thenReturn(new ChavePixResponse("teste@email.com"));
        Mockito.when(chavePixRepository.save(any(ChavePix.class))).thenReturn(chavePix);
        ChavePixResponse chavePixResponseRetornada = chavePixService.salvar(chavePixRequest);

        //then
        Assertions.assertEquals(chavePixResponseRetornada.getChave(), chavePixRequest.getChave());
        Assertions.assertNotNull(chavePixResponseRetornada.getChave());
        Mockito.verify(contaService, Mockito.times(1)).buscarPorId(anyLong());
        Mockito.verify(chavePixMapper, Mockito.times(1)).requestToBacen(any(), any());
        Mockito.verify(chavePixBacenClient, Mockito.times(1)).cadastrarChavePix(any());
        Mockito.verify(chavePixMapper, Mockito.times(1)).requestToModel(any(), any());
        Mockito.verify(chavePixMapper, Mockito.times(1)).modelToResponse(any());
        Mockito.verify(chavePixRepository, Mockito.times(1)).save(any());
    }
    @Test
    void testDetalharChavePix() {

        chavePixBacenDTO.setChave(chavePixRequest.getChave());

        Mockito.when(chavePixBacenClient.detalharChavePix(any(String.class))).thenReturn(chavePixBacenDTO);
        ChavePixBacenDTO responsePixClientRetornado = chavePixService.detalharChavePix(chavePixRequest.getChave());

        Assertions.assertEquals(responsePixClientRetornado.getChave(), chavePixRequest.getChave());
    }
}
