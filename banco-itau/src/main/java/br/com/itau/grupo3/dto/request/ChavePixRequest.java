package br.com.itau.grupo3.dto.request;

import br.com.itau.grupo3.model.TipoChavePix;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChavePixRequest {
    private String chave;
    private TipoChavePix tipo;
    private Long contaId;
}
