package br.com.itau.grupo3.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class AgenciaEContaRequest {
    @NotBlank
    private String agencia;
    @NotBlank
    private String numeroConta;

}
