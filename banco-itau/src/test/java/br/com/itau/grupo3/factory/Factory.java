package br.com.itau.grupo3.factory;

import br.com.itau.grupo3.dto.ChavePixBacenDTO;
import br.com.itau.grupo3.dto.request.ChavePixRequest;
import br.com.itau.grupo3.dto.request.ContaRequest;
import br.com.itau.grupo3.model.*;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Factory {
    public static Conta createConta() {
        return new Conta(1L, "123", "321", TipoConta.CORRENTE,
                new Banco(1L, "123", "Itau"),
                new Titular(1L, "João", "43504726067", TipoPessoa.PF),
                new BigDecimal(100),
                new BigDecimal(0),
                false,
                false);
    }

    public static ContaRequest createContaRequest() {
        return new ContaRequest(
                "123",
                "54321-6",
                TipoConta.CORRENTE,
                new Titular(1L, "João", "43504726067", TipoPessoa.PF)
        );
    }

    public static ChavePixRequest createChavePixRequest() {
        ChavePixRequest chavePixRequest = new ChavePixRequest();
        chavePixRequest.setChave("teste@email.com");
        chavePixRequest.setTipo(TipoChavePix.EMAIL);
        chavePixRequest.setContaId(2L);
        return chavePixRequest;
    }

    public static ChavePix createChavePix() {
        return new ChavePix("123", createConta(), TipoChavePix.CPFOUCNPJ);
    }


    public static ChavePixBacenDTO createChavePixBacenDTO() {
        ChavePixBacenDTO chavePixBacenDTO = new ChavePixBacenDTO();
        chavePixBacenDTO.setChave("123321122370");
        chavePixBacenDTO.setTipo(TipoChavePix.CPFOUCNPJ);
        chavePixBacenDTO.setTipoConta(TipoConta.CORRENTE);
        chavePixBacenDTO.setAgencia("1234");
        chavePixBacenDTO.setConta("321");
        chavePixBacenDTO.setInstituicaoFinanceira("Itau");
        chavePixBacenDTO.setTitular("Teste");
        chavePixBacenDTO.setCpfCnpj("123321123");
        return chavePixBacenDTO;

    }

    public static Banco createBanco() {
        return new Banco(2L, "123", "Itau");
    }

    public static List<Banco> createBancoList(){
        List<Banco> bancoList = new ArrayList<>();
        bancoList.add(createBanco());
        return bancoList;
    }
}
