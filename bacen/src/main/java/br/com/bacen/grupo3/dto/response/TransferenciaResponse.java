package br.com.bacen.grupo3.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransferenciaResponse {
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
