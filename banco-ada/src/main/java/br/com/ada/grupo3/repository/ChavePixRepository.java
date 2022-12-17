package br.com.ada.grupo3.repository;

import br.com.ada.grupo3.model.ChavePix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChavePixRepository extends JpaRepository<ChavePix, String> {
}