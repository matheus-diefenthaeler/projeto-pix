package br.com.itau.grupo3.config;

import br.com.itau.grupo3.model.Banco;
import br.com.itau.grupo3.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SeederConfig implements CommandLineRunner {

    private final BancoRepository bancoRepository;

    @Value("${banco.nome}")
    private String nomeBanco;

    @Value("${banco.codigobacen:}")
    private String codigobacen;

    @Override
    public void run(String... args) throws Exception {
        Banco banco = new Banco(1L, codigobacen, nomeBanco);

        if (bancoRepository.count() == 0) {
            bancoRepository.save(banco);
        }
    }
}
