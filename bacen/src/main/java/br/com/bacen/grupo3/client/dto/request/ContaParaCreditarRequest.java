package br.com.bacen.grupo3.client.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ContaParaCreditarRequest {
    private String agencia;
    private String numeroConta;
    private BigDecimal valorParaCreditar;
}
