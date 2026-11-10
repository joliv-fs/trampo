package br.com.trampo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
// @Table(name = "profissionais")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, length = 100)
    private String nome;

    @Setter
    @Column(nullable = false, length = 15)
    private String contato;

    @Setter
    @Column(nullable = false, unique = true, length = 55)
    private String nomeExibicao;

    @Setter
    @Column(nullable = false, length = 254)
    private String descricao;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Profissao profissao;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Profissao disponibilidade;

}
