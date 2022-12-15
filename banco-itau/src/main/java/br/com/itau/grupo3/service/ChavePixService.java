package br.com.itau.grupo3.service;

import br.com.itau.grupo3.client.ChavePixBacenClient;
import br.com.itau.grupo3.dto.ChavePixBacenDTO;
import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.exception.ChaveJaCadastradaBacenException;
import br.com.itau.grupo3.mapper.ChavePixMapper;
import br.com.itau.grupo3.model.ChavePix;
import br.com.itau.grupo3.model.Conta;
import br.com.itau.grupo3.repository.ChavePixRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChavePixService {

    private final ChavePixBacenClient chavePixBacenClient;
    private final ChavePixRepository chavePixRepository;
    private final ChavePixMapper chavePixMapper;
    private final ContaService contaService;

    public ChavePixResponse salvar(ChavePixRequest chavePixRequest) {
        try {
            Conta conta = contaService.buscarPorId(chavePixRequest.getContaId());
            ChavePixBacenDTO chavePixBacenDTO = chavePixMapper.requestToBacen(chavePixRequest, conta);
            chavePixBacenClient.cadastrarChavePix(chavePixBacenDTO);
            ChavePix chavePix = chavePixMapper.requestToModel(chavePixRequest, conta);
            return chavePixMapper.modelToResponse(chavePixRepository.save(chavePix));
        } catch (FeignException.Conflict e) {
            throw new ChaveJaCadastradaBacenException();
        }
    }
    public ChavePixBacenDTO detalharChavePix(String chavePix) {
        return chavePixBacenClient.detalharChavePix(chavePix);
    }
}
