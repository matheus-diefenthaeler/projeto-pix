package br.com.itau.grupo3.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter

public class AgenciaEContaRequest {
    private String agencia;
    private String numeroConta;

}
