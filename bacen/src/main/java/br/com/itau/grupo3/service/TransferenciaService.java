package br.com.itau.grupo3.service;

import br.com.itau.grupo3.client.AdaClient;
import br.com.itau.grupo3.client.ItauClient;
import br.com.itau.grupo3.client.dto.request.ContaRequest;
import br.com.itau.grupo3.dto.request.TransferenciaRequest;
import br.com.itau.grupo3.dto.response.TransferenciaResponse;
import br.com.itau.grupo3.exception.ContaInvalidaException;
import br.com.itau.grupo3.mapper.TransferenciaMapper;
import br.com.itau.grupo3.model.Transferencia;
import br.com.itau.grupo3.repository.TransferenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransferenciaService {

    private final TransferenciaRepository transferenciaRepository;
    private final ItauClient itauClient;
    private final AdaClient adaClient;
    private final TransferenciaMapper mapper;

    public TransferenciaResponse transferir(TransferenciaRequest transferenciaRequest) {
        validarConta(transferenciaRequest);

        Transferencia transferencia = mapper.requestToModel(transferenciaRequest);
        transferencia.setTransacaoId(gerarTransacaoId(transferenciaRequest));

        transferenciaRepository.save(transferencia);

        creditarNaConta(transferenciaRequest);
        return mapper.modelToResponse(transferencia);
    }

    private void validarConta(TransferenciaRequest transferenciaRequest) {
        ContaRequest contaRequest = mapper.requestToContaRequest(transferenciaRequest);
        Boolean isContaValida = true;

        // usar pattern para client
        if (transferenciaRequest.getInstituicaoFinanceiraDestino().equals("ITAÚ UNIBANCO S.A.")) {
            isContaValida = itauClient.validarConta(contaRequest).getBody();
        }

        if (transferenciaRequest.getInstituicaoFinanceiraDestino().equals("ADA BANK")) {
            isContaValida = adaClient.validarConta(contaRequest).getBody();
        }

        if (!isContaValida) {
            throw new ContaInvalidaException();
        }
    }

    private void creditarNaConta(TransferenciaRequest transferenciaRequest) {
        if (transferenciaRequest.getInstituicaoFinanceiraDestino().equals("ITAÚ UNIBANCO S.A.")) {
            itauClient.creditarNaConta(mapper.requestToContaParaCreditarRequest(transferenciaRequest));
        }

        if (transferenciaRequest.getInstituicaoFinanceiraDestino().equals("ADA BANK")) {
            adaClient.creditarNaConta(mapper.requestToContaParaCreditarRequest(transferenciaRequest));
        }
    }

    private String gerarTransacaoId(TransferenciaRequest transferenciaRequest) {
        StringBuilder transacaoId = new StringBuilder("E");
        transacaoId.append(transferenciaRequest.getAgenciaOrigem());
        transacaoId.append(transferenciaRequest.getContaOrigem());
        transacaoId.append(transferenciaRequest.getDataHora());
        transacaoId.append(transferenciaRequest.getValor());
        transacaoId.append(transferenciaRequest.getAgenciaDestino());
        transacaoId.append(transferenciaRequest.getContaDestino());
        return transacaoId.toString();
    }
}
