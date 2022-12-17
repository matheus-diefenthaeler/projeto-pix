package br.com.ada.grupo3.mapper;


import br.com.ada.grupo3.client.dto.ChavePixBacen;
import br.com.ada.grupo3.dto.request.ChavePixRequest;
import br.com.ada.grupo3.dto.response.ChavePixResponse;
import br.com.ada.grupo3.model.ChavePix;
import br.com.ada.grupo3.model.Conta;
import org.springframework.stereotype.Component;

@Component
public class ChavePixMapper {

    public ChavePixBacen requestToBacen(ChavePixRequest chavePixRequest, Conta conta) {
        ChavePixBacen chavePixBacenDTO = new ChavePixBacen();

        chavePixBacenDTO.setChave(chavePixRequest.getChave());
        chavePixBacenDTO.setTipo(chavePixRequest.getTipo());
        chavePixBacenDTO.setTipoConta(conta.getTipo());
        chavePixBacenDTO.setAgencia(conta.getAgencia());
        chavePixBacenDTO.setNumeroConta(conta.getNumeroConta());
        chavePixBacenDTO.setInstituicaoFinanceira(conta.getBanco().getNome());
        chavePixBacenDTO.setChave(chavePixRequest.getChave());
        chavePixBacenDTO.setTitular(conta.getTitular().getNome());
        chavePixBacenDTO.setCpfCnpj(conta.getTitular().getCpfCnpj());

        return chavePixBacenDTO;
    }

    public ChavePix requestToModel(ChavePixRequest chavePixRequest, Conta conta) {
        ChavePix chave = new ChavePix();

        chave.setChave(chavePixRequest.getChave());
        chave.setConta(conta);
        chave.setTipo(chavePixRequest.getTipo());
        return chave;
    }

    public ChavePixResponse modelToResponse(ChavePix chavePix) {
        ChavePixResponse chavePixResponse = new ChavePixResponse();
        chavePixResponse.setChave(chavePix.getChave());

        return chavePixResponse;
    }
}
