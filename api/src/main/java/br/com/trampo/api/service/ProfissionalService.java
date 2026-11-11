package br.com.trampo.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.trampo.api.dto.PageResponse;
import br.com.trampo.api.dto.ProfissionalRequestDTO;
import br.com.trampo.api.dto.ProfissionalResponseDTO;
import br.com.trampo.api.exception.ConflictException;
import br.com.trampo.api.exception.RecursoNaoEncontradoException;
import br.com.trampo.api.mappers.ProfissionalMapper;
import br.com.trampo.api.model.Disponibilidade;
import br.com.trampo.api.model.Profissao;
import br.com.trampo.api.model.Profissional;
import br.com.trampo.api.repository.ProfissionalRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfissionalService {

    private final ProfissionalRepository repository;
    private final ProfissionalMapper mapper;

    private String vazioParaNulo(String valor) {
        return (valor == null || valor.isBlank() ? null : valor.trim());
    }

    private Profissional buscarEntidade(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException(
                "Não foi possível encontrar o profissional associado ao ID: " + id));
    }

    @Transactional
    public ProfissionalResponseDTO cadastrarProfissional(ProfissionalRequestDTO dto) {
        if (repository.existsByNomeExibicao(dto.nomeExibicao())) {
            throw new ConflictException("Nome de exibição já está em uso.");
        }

        Profissional novoProfissional = mapper.toEntity(dto);
        Profissional salvo = repository.save(novoProfissional);

        return mapper.toResponse(salvo);
    }

    @Transactional(readOnly = true)
    public PageResponse<ProfissionalResponseDTO> listarTodosProfissionais(String nome, String nomeExibicao,
            Profissao profissao, Disponibilidade disponibilidade, Pageable pageable) {

        Page<Profissional> pagina = repository.buscarComFiltros(vazioParaNulo(nome), vazioParaNulo(nomeExibicao),
                profissao, disponibilidade, pageable);

        List<ProfissionalResponseDTO> conteudo = pagina.getContent().stream().map(mapper::toResponse).toList();

        return PageResponse.de(pagina, conteudo);

    }

    @Transactional(readOnly = true)
    public ProfissionalResponseDTO buscarPorId(Long id) {
        return mapper.toResponse(buscarEntidade(id));
    }

    @Transactional
    public ProfissionalResponseDTO atualizarProfissional(Long id, ProfissionalRequestDTO dto) {
        Profissional profissional = buscarEntidade(id);

        if (repository.existsByNomeExibicaoAndIdNot(dto.nomeExibicao(), id)) {
            throw new ConflictException("Nome profissional já está em uso.");
        }

        mapper.copyToEntity(dto, profissional);

        return mapper.toResponse(repository.save(profissional));

    }

    @Transactional
    public void deletarProfissional(Long id) {
        Profissional profissional = buscarEntidade(id);

        repository.delete(profissional);
    }

    @Transactional
    public void alterarDisponibilidade(Long id, Disponibilidade novaDisponibilidade) {
        Profissional profissional = buscarEntidade(id);

        profissional.setDisponibilidade(novaDisponibilidade);
    }

    public Page<Profissional> buscarComFiltros(
            String nome,
            String nomeExibicao,
            Profissao profissao,
            Disponibilidade disponibilidade,
            Pageable pageable) {
        return repository.buscarComFiltros(nome, nomeExibicao, profissao, disponibilidade, pageable);
    }

}
