package br.com.itau.grupo3.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaResponse {

    private Long id;
    private String agencia;
    private String numeroConta;
    private String tipo;
    private String banco;
    private String titular;


}
