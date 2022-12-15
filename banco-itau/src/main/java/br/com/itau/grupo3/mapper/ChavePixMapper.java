package br.com.itau.grupo3.mapper;


import br.com.itau.grupo3.dto.ChavePixBacenDTO;
import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.response.ChavePixResponse;
import br.com.itau.grupo3.model.ChavePix;
import br.com.itau.grupo3.model.Conta;
import org.springframework.stereotype.Component;

@Component
public class ChavePixMapper {

    public ChavePixBacenDTO requestToBacen(ChavePixRequest chavePixRequest, Conta conta) {
        ChavePixBacenDTO chavePixBacenDTO = new ChavePixBacenDTO();

        chavePixBacenDTO.setChave(chavePixRequest.getChave());
        chavePixBacenDTO.setTipo(chavePixRequest.getTipo());
        chavePixBacenDTO.setTipoConta(conta.getTipo());
        chavePixBacenDTO.setAgencia(conta.getAgencia());
        chavePixBacenDTO.setConta(conta.getNumeroConta());
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
