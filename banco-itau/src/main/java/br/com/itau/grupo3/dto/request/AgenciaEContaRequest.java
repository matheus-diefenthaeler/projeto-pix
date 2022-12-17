package br.com.itau.grupo3.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AgenciaEContaRequest {
    private String agencia;
    private String numeroConta;

}
