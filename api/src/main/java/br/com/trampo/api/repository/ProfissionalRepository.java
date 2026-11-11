package br.com.trampo.api.repository;

// import java.util.List;
// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.trampo.api.model.Disponibilidade;
// import br.com.trampo.api.model.Disponibilidade;
import br.com.trampo.api.model.Profissao;
import br.com.trampo.api.model.Profissional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

        boolean existsByNomeExibicao(String nomeExibicao);

        boolean existsByNomeExibicaoAndIdNot(String nomeExibicao, Long id);

        @Query(value = """
                                SELECT p FROM Profissional p
                                WHERE (:nome IS NULL OR LOWER(p.nome) LIKE LOWER (CONCAT('%', :nome, '%')))
                                AND (:nomeExibicao IS NULL OR LOWER(p.nomeExibicao) LIKE LOWER (CONCAT('%', :nomeExibicao, '%')))
                                AND (:profissao IS NULL OR p.profissao = :profissao)
                                AND (:disponibilidade IS NULL OR p.disponibilidade <> br.com.trampo.api.model.Disponibilidade.INDISPONIVEL OR (p.disponibilidade = :disponibilidade)
                                )
                        """)
        Page<Profissional> buscarComFiltros(
                        @Param("nome") String nome,
                        @Param("nomeExibicao") String nomeExibicao,
                        @Param("profissao") Profissao profissao,
                        @Param("disponibilidade") Disponibilidade disponibilidade,
                        Pageable pageable);

        // VERSÕES ANTIGAS
        // List<Profissional> findByProfissao(Profissao profissao);
        // Page<Profissional> findByProfissao(Profissao profissao, Pageable pageable);

        // List<Profissional> findByDisponibilidade(Disponibilidade disponibilidade);
        // Page<Profissional> findByDisponibilidade(Disponibilidade disponibilidade,
        // Pageable pageable);

        // List<Profissional> findByProfissaoAndDisponibilidade(Profissao profissao,
        // Disponibilidade disponibilidade);
        // Page<Profissional> findByProfissaoAndDisponibilidade(Profissao profissao,
        // Disponibilidade disponibilidade, Pageable pageable);

        // Optional<Profissional> findByNomeExibicao(String nomeExibicao);

}
