package br.com.ada.grupo3.dto.request;

import br.com.ada.grupo3.model.TipoChavePix;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChavePixRequest {
    private String chave;
    private TipoChavePix tipo;
    private Long contaId;
}
