package br.com.trampo.api.repository;

import java.util.List;
import java.util.Optional;

// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;

import br.com.trampo.api.model.Disponibilidade;
import br.com.trampo.api.model.Profissao;
import br.com.trampo.api.model.Profissional;

public interface ProfissionalRepository {

    List<Profissional> findByProfissao(Profissao profissao);
    // Page<Profissional> findByProfissao(Profissao profissao, Pageable pageable);

    List<Profissional> findByDisponibilidade(Disponibilidade disponibilidade);
    // Page<Profissional> findByDisponibilidade(Disponibilidade disponibilidade,
    // Pageable pageable);

    Optional<Profissional> findByNomeExibicao(String nomeExibicao);

}
