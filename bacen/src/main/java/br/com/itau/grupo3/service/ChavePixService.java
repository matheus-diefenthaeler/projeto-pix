package br.com.itau.grupo3.service;

import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.exception.ChavePixJaCadastradaException;
import br.com.itau.grupo3.exception.ChavePixNaoEncontradaException;
import br.com.itau.grupo3.mapper.ChavePixMapper;
import br.com.itau.grupo3.model.ChavePix;
import br.com.itau.grupo3.repository.ChavePixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChavePixService {
    private final ChavePixRepository chavePixRepository;
    private final ChavePixMapper mapper;

    public ChavePixResponse salvar(ChavePixRequest chavePixRequest) {
        if (isChaveCadastrada(chavePixRequest.getChave())) {
            throw new ChavePixJaCadastradaException();
        }
        ChavePix chavePix = mapper.requestToModel(chavePixRequest);
        ChavePix save = chavePixRepository.save(chavePix);
        return mapper.modelToResponse(save);
    }

    public ChavePixResponse buscarPorChave(String chave) {
        ChavePix chavePix = chavePixRepository.findById(chave).orElseThrow(ChavePixNaoEncontradaException::new);
        return mapper.modelToResponse(chavePix);
    }

    private boolean isChaveCadastrada(String chave) {
        return chavePixRepository.findById(chave).isPresent();
    }
}
