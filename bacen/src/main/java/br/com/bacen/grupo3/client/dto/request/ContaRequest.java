package br.com.bacen.grupo3.client.dto.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContaRequest {
    private String agencia;
    private String numeroConta;
    private String tipo;

    private String instituicaoFinanceira;
    private String titular;
    private String cpfCnpj;

    private String chavePix;
}
