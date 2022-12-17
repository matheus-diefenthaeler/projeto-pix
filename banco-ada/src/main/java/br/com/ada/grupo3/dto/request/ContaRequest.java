package br.com.ada.grupo3.dto.request;

import br.com.ada.grupo3.model.TipoConta;
import br.com.ada.grupo3.model.Titular;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaRequest {

    private String agencia;
    private String numeroConta;
    private TipoConta tipo;
    private Titular titular;

}

