package br.com.itau.grupo3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE conta SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String agencia;
    private String numeroConta;
    private TipoConta tipo;

    @ManyToOne
    private Banco banco;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Titular titular;
    private BigDecimal saldo;
    private BigDecimal saldoBloqueado = new BigDecimal("0.0");
    private boolean contaBloqueada = false;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

}

