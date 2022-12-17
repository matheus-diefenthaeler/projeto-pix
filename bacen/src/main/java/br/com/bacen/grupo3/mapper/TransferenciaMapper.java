package br.com.bacen.grupo3.mapper;

import br.com.bacen.grupo3.client.dto.request.ContaParaCreditarRequest;
import br.com.bacen.grupo3.client.dto.request.ContaRequest;
import br.com.bacen.grupo3.dto.request.TransferenciaRequest;
import br.com.bacen.grupo3.dto.response.TransferenciaResponse;
import br.com.bacen.grupo3.model.Transferencia;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TransferenciaMapper {

    public Transferencia requestToModel(TransferenciaRequest request) {
        Transferencia transferencia = new Transferencia();

        transferencia.setDataHora(request.getDataHora());
        transferencia.setValor(request.getValor());
        transferencia.setTipoTransferencia(request.getTipoTransferencia());
        transferencia.setChavePix(request.getChavePix());
        transferencia.setNomeOrigem(request.getNomeOrigem());
        transferencia.setInstituicaoFinanceiraOrigem(request.getInstituicaoFinanceiraOrigem());
        transferencia.setAgenciaOrigem(request.getAgenciaOrigem());
        transferencia.setContaOrigem(request.getContaOrigem());
        transferencia.setNomeDestino(request.getNomeDestino());
        transferencia.setCpfCnpjDestino(request.getCpfCnpjDestino());
        transferencia.setInstituicaoFinanceiraDestino(request.getInstituicaoFinanceiraDestino());
        transferencia.setAgenciaDestino(request.getAgenciaDestino());
        transferencia.setContaDestino(request.getContaDestino());
        transferencia.setTipoContaDestino(request.getTipoContaDestino());

        return transferencia;
    }

    public TransferenciaResponse modelToResponse(Transferencia transferencia) {
        TransferenciaResponse transferenciaResponse = new TransferenciaResponse();
        BeanUtils.copyProperties(transferencia, transferenciaResponse);
        return transferenciaResponse;
    }

    public ContaRequest requestToContaRequest(TransferenciaRequest transferenciaRequest) {
        ContaRequest contaRequest = new ContaRequest();

        contaRequest.setAgencia(transferenciaRequest.getAgenciaDestino());
        contaRequest.setNumeroConta(transferenciaRequest.getContaDestino());
        contaRequest.setTipo(transferenciaRequest.getTipoContaDestino());
        contaRequest.setInstituicaoFinanceira(transferenciaRequest.getInstituicaoFinanceiraDestino());
        contaRequest.setTitular(transferenciaRequest.getNomeDestino());
        contaRequest.setCpfCnpj(transferenciaRequest.getCpfCnpjDestino());
        contaRequest.setChavePix(transferenciaRequest.getChavePix());

        return contaRequest;
    }

    public ContaParaCreditarRequest requestToContaParaCreditarRequest(TransferenciaRequest transferenciaRequest) {
        ContaParaCreditarRequest contaParaCreditarRequest = new ContaParaCreditarRequest();

        contaParaCreditarRequest.setAgencia(transferenciaRequest.getAgenciaDestino());
        contaParaCreditarRequest.setNumeroConta(transferenciaRequest.getContaDestino());
        contaParaCreditarRequest.setValorParaCreditar(transferenciaRequest.getValor());

        return  contaParaCreditarRequest;
    }

}
