package br.com.itau.grupo3.service;

import br.com.itau.grupo3.client.BacenClient;
import br.com.itau.grupo3.client.dto.ChavePixBacen;
import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.exception.CadastroChavePixException;
import br.com.itau.grupo3.exception.ChaveNaoEncontradaException;
import br.com.itau.grupo3.mapper.ChavePixMapper;
import br.com.itau.grupo3.model.ChavePix;
import br.com.itau.grupo3.model.Conta;
import br.com.itau.grupo3.model.TipoChavePix;
import br.com.itau.grupo3.repository.ChavePixRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChavePixService {

    private final BacenClient chavePixBacenClient;
    private final ChavePixRepository chavePixRepository;
    private final ChavePixMapper chavePixMapper;
    private final ContaService contaService;

    public ChavePixResponse salvar(ChavePixRequest chavePixRequest) {
        try {
            if(isChavePixCadastrada(chavePixRequest.getChave())){
                throw new CadastroChavePixException();
            }
            Conta conta = contaService.buscarPorId(chavePixRequest.getContaId());
            ChavePixBacen chavePixBacenDTO = chavePixMapper.requestToBacen(chavePixRequest, conta);
            chavePixBacenClient.cadastrarChavePix(chavePixBacenDTO);
            ChavePix chavePix = chavePixMapper.requestToModel(chavePixRequest, conta);
            return chavePixMapper.modelToResponse(chavePixRepository.save(chavePix));
        } catch (FeignException.BadRequest e) {
            throw new CadastroChavePixException();
        }
    }
    public ChavePixBacen detalharChavePix(String chavePix) {
        try {
            return chavePixBacenClient.detalharChavePix(chavePix);
        } catch (FeignException.NotFound e) {
            throw new ChaveNaoEncontradaException();
        }
    }

    public ChavePix buscarChavePix(String chavePix) {
        return chavePixRepository.findById(chavePix).orElseThrow(() -> {
            throw new ChaveNaoEncontradaException();
        });
    }

    public Boolean validarChavePix(Conta conta, String chavePix) {
        ChavePix chavePixSalva = buscarChavePix(chavePix);
        return chavePixSalva.getConta() == conta;
    }

    public Boolean isChavePixCadastrada(String chavePix){
        return chavePixRepository.findByChave(chavePix).isPresent();
    }

}
