package br.com.itau.grupo3.service;

import br.com.itau.grupo3.dto.ChavePixBacenDTO;
import br.com.itau.grupo3.dto.request.AgenciaEContaRequest;
import br.com.itau.grupo3.dto.request.ContaRequest;
import br.com.itau.grupo3.dto.response.ContaResponse;
import br.com.itau.grupo3.exception.BancoNaoExistenteException;
import br.com.itau.grupo3.factory.Factory;
import br.com.itau.grupo3.mapper.ContaMapper;
import br.com.itau.grupo3.model.Banco;
import br.com.itau.grupo3.model.Conta;
import br.com.itau.grupo3.repository.BancoRepository;
import br.com.itau.grupo3.repository.ContaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static javax.swing.text.html.parser.DTDConstants.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {
    @InjectMocks
    ContaService contaService;

    @Mock
    ContaRepository contaRepository;

    @Mock
    BancoRepository bancoRepository;

    @Mock
    ContaMapper contaMapper;

    static Conta conta;
    static Banco banco;
    static List<Banco> bancoList;

    static ContaRequest contaRequest;

    static ContaResponse contaResponse;
    static AgenciaEContaRequest agenciaEContaRequest;

    @BeforeEach
    void setup() {
        conta = Factory.createConta();
        banco = Factory.createBanco();
        bancoList = Factory.createBancoList();
        contaRequest = Factory.createContaRequest();
        contaResponse = Factory.createContaResponse();
        agenciaEContaRequest = Factory.createAgenciaEContaRequest();
    }

    @Test
    @DisplayName("Testa adicao da conta na base")
    public void adicionarTest() {

    }

    @Test
    @DisplayName("Testando Captura de Exception no Adicionar")
    void TestThrowsAdcionarContaService() {
        when(bancoRepository.findById(anyLong())).thenThrow(new BancoNaoExistenteException());

        try {
            contaService.adicionar(new ContaRequest());
        } catch (BancoNaoExistenteException ex) {
            assertEquals(BancoNaoExistenteException.class, ex.getClass());
        }
    }

    @Test
    @DisplayName("Testa lista de conta")
    public void listarTest() {
        when(contaRepository.findAll()).thenReturn(List.of(conta));
        List<ContaResponse> response = contaService.listar();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(ContaResponse.class, response.get(0).getClass());
    }

    @Test
    public void buscaPorAgenciaAndContaTest() {

         when(contaRepository.findByAgenciaAndNumeroConta(agenciaEContaRequest.getAgencia(), agenciaEContaRequest.getNumeroConta())).thenReturn(Optional.of(conta));
         when(contaMapper.modelToResponse(any(Conta.class))).thenReturn(contaResponse);

        List<ContaResponse> contaResponseSalva = (List<ContaResponse>) contaService.buscarPorAgenciaEConta(agenciaEContaRequest);

        assertNotNull(contaResponseSalva);
        assertEquals(1, contaResponseSalva.size());
        assertEquals(ContaResponse.class, contaResponseSalva.get(0).getClass());

        Mockito.verify(contaRepository, Mockito.times(1)).findByAgenciaAndNumeroConta(agenciaEContaRequest.getAgencia(), agenciaEContaRequest.getNumeroConta());
        Mockito.verify(contaMapper, Mockito.times(1)).modelToResponse(any(Conta.class));


    }

    @Test
    public void removerTest() {
        when(contaRepository.findById(anyLong())).thenReturn(Optional.of(conta));
        doNothing().when(contaRepository).deleteById(anyLong());

        contaService.remover(conta.getId());

        verify(contaRepository, times(1)).deleteById(anyLong());
    }
}