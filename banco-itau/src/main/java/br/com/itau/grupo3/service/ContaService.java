package br.com.itau.grupo3.service;

import br.com.itau.grupo3.dto.request.AgenciaEContaRequest;
import br.com.itau.grupo3.dto.request.ContaRequest;
import br.com.itau.grupo3.dto.response.ContaResponse;
import br.com.itau.grupo3.exception.BancoNaoExistenteException;
import br.com.itau.grupo3.exception.ContaNaoEncontradaException;
import br.com.itau.grupo3.mapper.ContaMapper;
import br.com.itau.grupo3.model.Banco;
import br.com.itau.grupo3.model.Conta;
import br.com.itau.grupo3.repository.BancoRepository;
import br.com.itau.grupo3.repository.ContaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository contaRepository;
    private final BancoRepository bancoRepository;
    private final ContaMapper contaMapper;

    @Transactional
    public ContaResponse adicionar(ContaRequest contaRequest) {
        Banco banco = bancoRepository.findById(1L).orElseThrow(() -> {
            throw new BancoNaoExistenteException();
        });

        Conta conta = contaMapper.requestToModel(contaRequest);
        conta.setBanco(banco);
         return contaMapper.modelToResponse(contaRepository.save(conta));
    }

    public List<ContaResponse> listar() {
        List<Conta> contas = contaRepository.findAll();
        return contas.stream().map(contaMapper::modelToResponse)
                .collect(Collectors.toList());
    }

    public Conta buscarPorId(Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new ContaNaoEncontradaException("Conta nao encontrada!"));
    }

    public void remover(Long id) {
        this.buscarPorId(id);
        contaRepository.deleteById(id);
    }

    public ContaResponse buscarPorAgenciaEConta(AgenciaEContaRequest agenciaEContaRequest) {
        Conta conta = contaRepository.findByAgenciaAndNumeroConta(agenciaEContaRequest.getAgencia(), agenciaEContaRequest.getNumeroConta())
                .orElseThrow(() -> new ContaNaoEncontradaException("Conta nao encontrada!"));
       return contaMapper.modelToResponse(conta);

    }
}

