package br.com.ada.grupo3.repository;

import br.com.ada.grupo3.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByAgenciaAndNumeroConta(String agencia, String numeroConta);
    Optional<Conta> findByNumeroConta(String numeroConta);
}
