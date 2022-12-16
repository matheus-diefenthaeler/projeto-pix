package br.com.itau.grupo3.service;

import br.com.itau.grupo3.client.ChavePixBacenClient;
import br.com.itau.grupo3.dto.ChavePixBacenDTO;
import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.request.ContaRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.mapper.ChavePixMapper;
import br.com.itau.grupo3.mapper.ContaMapper;
import br.com.itau.grupo3.model.ChavePix;
import br.com.itau.grupo3.model.Conta;
import br.com.itau.grupo3.model.TipoChavePix;
import br.com.itau.grupo3.model.TipoConta;
import br.com.itau.grupo3.repository.ChavePixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChavePixServiceIntegrationTest {

    private final ChavePixService chavePixService;
    private final ChavePixBacenClient chavePixBacenClient;
    private final ChavePixRepository chavePixRepository;
    private final ChavePixMapper chavePixMapper;
    private final ContaService contaService;
    private final ContaMapper contaMapper;

    @Autowired
    public ChavePixServiceIntegrationTest(ChavePixService chavePixService, ChavePixBacenClient chavePixBacenClient, ChavePixRepository chavePixRepository, ChavePixMapper chavePixMapper, ContaService contaService, ContaMapper contaMapper) {
        this.chavePixService = chavePixService;
        this.chavePixBacenClient = chavePixBacenClient;
        this.chavePixRepository = chavePixRepository;
        this.chavePixMapper = chavePixMapper;
        this.contaService = contaService;
        this.contaMapper = contaMapper;
    }

    void testSalvar(){
        ChavePixRequest chavePixRequest = new ChavePixRequest();
        chavePixRequest.setChave("chave teste");
        chavePixRequest.setContaId(1L);
        chavePixRequest.setTipo(TipoChavePix.EMAIL);

        ContaRequest contaRequest = new ContaRequest();
        contaRequest.setTipo(TipoConta.CORRENTE);
        contaRequest.setAgencia("1000");
        contaRequest.setNumeroConta("2022");

        contaService.adicionar(contaRequest);
//        ContaResponse contaResponse = contaService.buscarPorAgenciaEConta();

        Conta conta = new Conta();
        conta.setId(conta.getId());


        ChavePixBacenDTO chavePixBacenDTO = chavePixMapper.requestToBacen(chavePixRequest, conta);
        ChavePixResponse chavePixResponse = new ChavePixResponse();
        ChavePix chavePix = new ChavePix();


    }

    void testDetalharChavePix(){}
}
