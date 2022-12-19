package br.com.itau.grupo3.service;

import br.com.itau.grupo3.client.dto.request.ContaBacenRequest;
import br.com.itau.grupo3.client.dto.request.ContaParaCreditarBacenRequest;
import br.com.itau.grupo3.dto.request.AgenciaEContaRequest;
import br.com.itau.grupo3.dto.request.ContaRequest;
import br.com.itau.grupo3.dto.response.ContaResponse;
import br.com.itau.grupo3.exception.BancoNaoExistenteException;
import br.com.itau.grupo3.exception.ContaNaoEncontradaException;
import br.com.itau.grupo3.mapper.ContaMapper;
import br.com.itau.grupo3.model.Banco;
import br.com.itau.grupo3.model.Conta;
import br.com.itau.grupo3.model.ContaValida;
import br.com.itau.grupo3.repository.BancoRepository;
import br.com.itau.grupo3.repository.ContaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public ContaValida validarConta(ContaBacenRequest contaBacenRequest) {
        Conta conta = buscarPorAgenciaEConta(contaBacenRequest.getAgencia(), contaBacenRequest.getNumeroConta());
        boolean isValida =  conta.getTitular().getNome().equals(contaBacenRequest.getTitular()) &&
                conta.getTitular().getCpfCnpj().equals(contaBacenRequest.getCpfCnpj());

        return new ContaValida(conta, isValida);
    }

    public ContaResponse buscarPorAgenciaEConta(AgenciaEContaRequest agenciaEContaRequest) {
        Conta conta = buscarPorAgenciaEConta(agenciaEContaRequest.getAgencia(), agenciaEContaRequest.getNumeroConta());
        return contaMapper.modelToResponse(conta);
    }

    private Conta buscarPorAgenciaEConta(String agencia, String numeroConta) {
        return contaRepository.findByAgenciaAndNumeroConta(agencia, numeroConta)
                .orElseThrow(() -> new ContaNaoEncontradaException("Conta nao encontrada!"));
    }

    public void bloquearValor(Conta conta, BigDecimal valorParaDebitar) {
        conta.setSaldoBloqueado(conta.getSaldoBloqueado().add(valorParaDebitar));
        conta.setSaldo(conta.getSaldo().subtract(valorParaDebitar));

        contaRepository.save(conta);
    }

    public void desbloquearValor(Conta conta, BigDecimal valorParaDebitar) {
        conta.setSaldoBloqueado(conta.getSaldoBloqueado().subtract(valorParaDebitar));
        conta.setSaldo(conta.getSaldo().add(valorParaDebitar));

        contaRepository.save(conta);
    }

    public void debitarValorBloquedo(Conta conta, BigDecimal valorParaDebitar) {
        conta.setSaldoBloqueado(conta.getSaldoBloqueado().subtract(valorParaDebitar));

        contaRepository.save(conta);
    }


    public void creditar(ContaParaCreditarBacenRequest contaParaCreditarBacenRequest) {
        Conta conta = buscarPorAgenciaEConta(contaParaCreditarBacenRequest.getAgencia(), contaParaCreditarBacenRequest.getNumeroConta());
        conta.setSaldo(conta.getSaldo().add(contaParaCreditarBacenRequest.getValorParaCreditar()));
        contaRepository.save(conta);
    }
}

