package br.com.ada.grupo3.dto.response;

import br.com.ada.grupo3.model.Conta;
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

    public ContaResponse(Conta conta) {
        id = conta.getId();
        agencia = conta.getAgencia();
        numeroConta = conta.getNumeroConta();
        tipo = conta.getTipo().toString();
        banco = conta.getBanco().getNome();
        titular = conta.getTitular().getNome();
    }
}
