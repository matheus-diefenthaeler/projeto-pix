package br.com.itau.grupo3.service;

import br.com.itau.grupo3.factory.Factory;
import br.com.itau.grupo3.mapper.ContaMapper;
import br.com.itau.grupo3.model.Banco;
import br.com.itau.grupo3.model.Conta;
import br.com.itau.grupo3.repository.BancoRepository;
import br.com.itau.grupo3.repository.ContaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {
    @InjectMocks
    ContaService contaService;

    @Mock
    ContaRepository contaRepository;

    @Mock
    BancoRepository bancoRepository;

    @Mock
    ContaMapper contaMapper;

    static Conta conta;
    static Banco banco;
     static List<Banco> bancoList;

    @BeforeEach
    void setup(){
        conta = Factory.createConta();
        banco = Factory.createBanco();
        bancoList = Factory.createBancoList();
    }

    @Test
    public void adicionar(){


//       Mockito.when(contaRepository.findAll()).thenReturn(bancoList);
    }
}
