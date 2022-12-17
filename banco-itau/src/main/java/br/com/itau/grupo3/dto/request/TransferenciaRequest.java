package br.com.itau.grupo3.dto.request;

import br.com.itau.grupo3.model.TipoTransferencia;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class TransferenciaRequest {
    private BigDecimal valor;
    private TipoTransferencia tipoTransferencia;
    private Long contaId;

    private String chavePix;
    private String nomeDestino;
    private String cpfCnpjDestino;
    private String instituicaoFinanceiraDestino;
    private String agenciaDestino;
    private String contaDestino;
    private String tipoContaDestino;
}
