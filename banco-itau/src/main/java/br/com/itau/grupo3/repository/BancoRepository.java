package br.com.itau.grupo3.repository;


import br.com.itau.grupo3.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository  extends JpaRepository<Banco, Long> {
    boolean existsByCodigoBacen(long l);
}
