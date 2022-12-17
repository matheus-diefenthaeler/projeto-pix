package br.com.ada.grupo3.client.dto.request;

import lombok.Getter;

@Getter
public class ContaBacenRequest {
    private String agencia;
    private String numeroConta;
    private String tipo;

    private String instituicaoFinanceira;
    private String titular;
    private String cpfCnpj;

    private String chavePix;
}
