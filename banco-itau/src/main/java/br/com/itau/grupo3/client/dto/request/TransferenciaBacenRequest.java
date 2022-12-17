package br.com.itau.grupo3.client.dto.request;

import br.com.itau.grupo3.model.TipoTransferencia;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransferenciaBacenRequest {
    private LocalDateTime dataHora;
    private BigDecimal valor;
    private TipoTransferencia tipoTransferencia;
    private String chavePix;

    private String nomeOrigem;
    private String instituicaoFinanceiraOrigem;
    private String agenciaOrigem;
    private String contaOrigem;

    private String nomeDestino;
    private String cpfCnpjDestino;
    private String instituicaoFinanceiraDestino;
    private String agenciaDestino;
    private String contaDestino;
    private String tipoContaDestino;
}
