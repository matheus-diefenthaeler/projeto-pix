package br.com.itau.grupo3.dto.request;

import br.com.itau.grupo3.model.TipoChavePix;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChavePixRequest {
    @NotBlank
    private String chave;
    @NotNull
    private TipoChavePix tipo;
    @NotNull
    private Long contaId;
}
