package br.com.itau.grupo3.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ChavePix {

    @Id
    private String chave;
    @ManyToOne(cascade = CascadeType.ALL)
    private Conta conta;
    private TipoChavePix tipo;

}
