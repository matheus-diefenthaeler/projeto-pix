package br.com.itau.grupo3.mapper;

import br.com.itau.grupo3.dto.request.ContaRequest;
import br.com.itau.grupo3.dto.response.ContaResponse;
import br.com.itau.grupo3.model.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaMapper {
    public Conta requestToModel(ContaRequest contaRequest) {
        Conta conta = new Conta();
        conta.setAgencia(contaRequest.getAgencia());
        conta.setNumeroConta(contaRequest.getNumeroConta());
        conta.setTipo(contaRequest.getTipo());
        conta.setTitular(contaRequest.getTitular());

        return conta;
    }

    public ContaResponse modelToResponse(Conta conta) {
        ContaResponse contaResponse = new ContaResponse();
        contaResponse.setId(conta.getId());
        contaResponse.setAgencia(conta.getAgencia());
        contaResponse.setNumeroConta(conta.getNumeroConta());
        contaResponse.setTipo(conta.getTipo().toString());
        contaResponse.setBanco(conta.getBanco().getNome());
        contaResponse.setTitular(conta.getTitular().getNome());

        return contaResponse;
    }
}
