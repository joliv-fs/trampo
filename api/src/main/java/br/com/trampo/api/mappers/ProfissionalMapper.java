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

        return new ProfissionalResponseDTO(
                profissional.getId(),
                profissional.getNome(),
                profissional.getContato(),
                profissional.getNomeExibicao(),
                profissional.getResumoProfissional(),
                profissional.getProfissao(),
                profissional.getProfissao().getDescricao(),
                profissional.getDisponibilidade(),
                profissional.getDisponibilidade().getDescricao());
    }

    public void copyToEntity(ProfissionalRequestDTO dto, Profissional profissional) {
        if (dto == null || profissional == null)
            return;

        profissional.setNome(dto.nome());
        profissional.setContato(dto.contato());
        profissional.setNomeExibicao(dto.nomeExibicao());
        profissional.setResumoProfissional(dto.resumoProfissional());
        profissional.setProfissao(dto.profissao());
        profissional.setDisponibilidade(dto.disponibilidade());

    }

}
