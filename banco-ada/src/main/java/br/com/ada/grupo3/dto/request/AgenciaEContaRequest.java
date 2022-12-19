package br.com.ada.grupo3.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AgenciaEContaRequest {
    @NotBlank
    private String agencia;
    @NotBlank
    private String numeroConta;

}
