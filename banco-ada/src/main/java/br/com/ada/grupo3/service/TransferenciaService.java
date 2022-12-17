package br.com.ada.grupo3.service;

import br.com.ada.grupo3.client.BacenClient;
import br.com.ada.grupo3.client.dto.request.TransferenciaBacenRequest;
import br.com.ada.grupo3.client.dto.response.TransferenciaBacenResponse;
import br.com.ada.grupo3.dto.request.TransferenciaRequest;
import br.com.ada.grupo3.exception.ConexaoComAplicacaoExternaException;
import br.com.ada.grupo3.exception.ContaInvalidaException;
import br.com.ada.grupo3.exception.SaldoInsuficienteException;
import br.com.ada.grupo3.mapper.TransferenciaPixMapper;
import br.com.ada.grupo3.model.Conta;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferenciaService {

    private final ContaService contaService;
    private final BacenClient client;
    private final TransferenciaPixMapper mapper;

    public TransferenciaBacenResponse transferir(TransferenciaRequest transferenciaRequest) {
        Conta conta = contaService.buscarPorId(transferenciaRequest.getContaId());
        if (isSaldoInsuficiente(conta.getSaldo(), transferenciaRequest.getValor())) {
            throw new SaldoInsuficienteException();
        }
        contaService.bloquearValor(conta, transferenciaRequest.getValor());

        TransferenciaBacenRequest transferenciaBacenRequest = mapper.requestToBacen(conta, transferenciaRequest);

        try {
            TransferenciaBacenResponse transferenciaBacenResponse = client.transferenciaPix(transferenciaBacenRequest).getBody();
            contaService.debitarValorBloquedo(conta, transferenciaRequest.getValor());
            return transferenciaBacenResponse;
        } catch (FeignException.Conflict e) {
            contaService.desbloquearValor(conta, transferenciaRequest.getValor());
            throw new ContaInvalidaException();
        } catch (FeignException.InternalServerError e) {
            contaService.desbloquearValor(conta, transferenciaRequest.getValor());
            throw new ConexaoComAplicacaoExternaException();
        }
    }

    private Boolean isSaldoInsuficiente(BigDecimal saldoConta, BigDecimal valorParaDebitar) {
        return saldoConta.compareTo(valorParaDebitar) < 0;
    }
}
