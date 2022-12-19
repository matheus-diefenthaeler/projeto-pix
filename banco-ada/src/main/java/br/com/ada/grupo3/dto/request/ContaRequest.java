package br.com.ada.grupo3.dto.request;

import br.com.ada.grupo3.model.TipoConta;
import br.com.ada.grupo3.model.Titular;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaRequest {

    @NotBlank
    private String agencia;
    @NotBlank
    private String numeroConta;
    @NotNull
    private TipoConta tipo;
    @NotNull
    private Titular titular;

}

