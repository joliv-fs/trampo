package br.com.trampo.api.mappers;

import org.springframework.stereotype.Component;

import br.com.trampo.api.dto.ProfissionalRequestDTO;
import br.com.trampo.api.dto.ProfissionalResponseDTO;
import br.com.trampo.api.model.Profissional;

@Component
public class ProfissionalMapper {

    public Profissional toEntity(ProfissionalRequestDTO dto) {
        if (dto == null)
            return null;

        Profissional profissional = new Profissional();

        profissional.setNome(dto.nome());
        profissional.setContato(dto.contato());
        profissional.setNomeExibicao(dto.nomeExibicao());
        profissional.setResumoProfissional(dto.resumoProfissional());
        profissional.setProfissao(dto.profissao());
        profissional.setDisponibilidade(dto.disponibilidade());
        return profissional;
    }

    public ProfissionalResponseDTO toResponse(Profissional profissional) {
        if (profissional == null)
            return null;

        String profissaoDescricao = profissional.getProfissao() != null ? profissional.getProfissao().getDescricao()
                : null;
        String disponibilidadeDescricao = profissional.getDisponibilidade() != null
                ? profissional.getDisponibilidade().getDescricao()
                : null;

        return new ProfissionalResponseDTO(
                profissional.getId(),
                profissional.getNome(),
                profissional.getContato(),
                profissional.getNomeExibicao(),
                profissional.getResumoProfissional(),
                profissional.getProfissao(),
                profissaoDescricao,
                profissional.getDisponibilidade(),
                disponibilidadeDescricao);
    }

    public void copyToEntity(ProfissionalRequestDTO dto, Profissional profissional) {
        if (dto == null || profissional == null)
            return;

        if (dto.nome() != null && !dto.nome().isBlank()) {
            profissional.setNome(dto.nome().trim());
        }
        if (dto.contato() != null && !dto.contato().isBlank()) {
            profissional.setContato(dto.contato().trim());
        }
        if (dto.nomeExibicao() != null && !dto.nomeExibicao().isBlank()) {
            profissional.setNomeExibicao(dto.nomeExibicao().trim());
        }
        if (dto.resumoProfissional() != null && !dto.resumoProfissional().isBlank()) {
            profissional.setResumoProfissional(dto.resumoProfissional().trim());
        }
        if (dto.profissao() != null) {
            profissional.setProfissao(dto.profissao());
        }
        if (dto.disponibilidade() != null) {
            profissional.setDisponibilidade(dto.disponibilidade());
        }

    }

}
