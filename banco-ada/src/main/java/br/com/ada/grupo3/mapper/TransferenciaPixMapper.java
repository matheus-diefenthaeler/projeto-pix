package br.com.ada.grupo3.mapper;

import br.com.ada.grupo3.client.dto.request.TransferenciaBacenRequest;
import br.com.ada.grupo3.dto.request.TransferenciaRequest;
import br.com.ada.grupo3.model.Conta;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransferenciaPixMapper {

    public TransferenciaBacenRequest requestToBacen(Conta conta, TransferenciaRequest request) {
        TransferenciaBacenRequest transferenciaPixBacenRequest = new TransferenciaBacenRequest();

        transferenciaPixBacenRequest.setDataHora(LocalDateTime.now());
        transferenciaPixBacenRequest.setValor(request.getValor());
        transferenciaPixBacenRequest.setTipoTransferencia(request.getTipoTransferencia());
        transferenciaPixBacenRequest.setChavePix(request.getChavePix());

        transferenciaPixBacenRequest.setNomeOrigem(conta.getTitular().getNome());
        transferenciaPixBacenRequest.setInstituicaoFinanceiraOrigem(conta.getBanco().getNome());
        transferenciaPixBacenRequest.setAgenciaOrigem(conta.getAgencia());
        transferenciaPixBacenRequest.setContaOrigem(conta.getNumeroConta());

        transferenciaPixBacenRequest.setNomeDestino(request.getNomeDestino());
        transferenciaPixBacenRequest.setCpfCnpjDestino(request.getCpfCnpjDestino());
        transferenciaPixBacenRequest.setInstituicaoFinanceiraDestino(request.getInstituicaoFinanceiraDestino());
        transferenciaPixBacenRequest.setAgenciaDestino(request.getAgenciaDestino());
        transferenciaPixBacenRequest.setContaDestino((request.getContaDestino()));
        transferenciaPixBacenRequest.setTipoContaDestino(request.getTipoContaDestino());

        return transferenciaPixBacenRequest;
    }
}
