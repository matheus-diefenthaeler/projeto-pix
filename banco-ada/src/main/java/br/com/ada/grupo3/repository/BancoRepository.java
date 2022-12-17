package br.com.ada.grupo3.repository;


import br.com.ada.grupo3.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BancoRepository  extends JpaRepository<Banco, Long> {
    boolean existsByCodigoBacen(long l);
}
