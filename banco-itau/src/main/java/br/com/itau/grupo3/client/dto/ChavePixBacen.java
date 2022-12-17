package br.com.itau.grupo3.client.dto;

import br.com.itau.grupo3.model.TipoChavePix;
import br.com.itau.grupo3.model.TipoConta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChavePixBacen {

    private String chave;
    private TipoChavePix tipo;
    private TipoConta tipoConta;
    private String agencia;
    private String numeroConta;
    private String instituicaoFinanceira;
    private String titular;
    private String cpfCnpj;
}
