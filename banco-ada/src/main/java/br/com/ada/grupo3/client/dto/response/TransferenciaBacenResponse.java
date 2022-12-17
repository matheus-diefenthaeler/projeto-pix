package br.com.ada.grupo3.client.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransferenciaBacenResponse {
    private String transacaoId;
    private LocalDateTime dataHora;
    private BigDecimal valor;
    private String tipoTransferencia;
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
