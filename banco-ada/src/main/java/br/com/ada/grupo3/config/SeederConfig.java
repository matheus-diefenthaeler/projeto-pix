package br.com.ada.grupo3.config;

import br.com.ada.grupo3.model.Banco;
import br.com.ada.grupo3.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SeederConfig implements CommandLineRunner {

    private final BancoRepository bancoRepository;

    @Override
    public void run(String... args) throws Exception {
        String nomeBanco = "ADA LETS CODE S.A.";
        String codigobacen = "987";

        Banco banco = new Banco(1L, codigobacen, nomeBanco);

        if (!bancoRepository.existsById(1l)) {
            bancoRepository.save(banco);
        }
    }
}
