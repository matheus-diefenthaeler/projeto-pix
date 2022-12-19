package br.com.itau.grupo3.dto.request;

import br.com.itau.grupo3.model.TipoChavePix;
import br.com.itau.grupo3.model.TipoConta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChavePixRequest {

    private String chave;
    private TipoChavePix tipo;
    private TipoConta tipoConta;
    private String agencia;
    private String conta;
    private String instituicaoFinanceira;
    private String titular;
    private String cpfCnpj;
}