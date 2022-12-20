package br.com.itau.grupo3.dto.request;

import br.com.itau.grupo3.model.TipoTransferencia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class TransferenciaRequest {
    @NotNull
    private BigDecimal valor;
    @NotNull
    private TipoTransferencia tipoTransferencia;
    @NotNull
    private Long contaId;
    @NotBlank
    private String chavePix;
    @NotBlank
    private String nomeDestino;
    @NotBlank
    private String cpfCnpjDestino;
    @NotBlank
    private String instituicaoFinanceiraDestino;
    @NotBlank
    private String agenciaDestino;
    @NotBlank
    private String contaDestino;
    @NotBlank
    private String tipoContaDestino;
}
