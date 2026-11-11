package br.com.trampo.api.dto;

import br.com.trampo.api.model.Profissional;

import br.com.trampo.api.model.Disponibilidade;
import br.com.trampo.api.model.Profissao;

public record ProfissionalResponseDTO(Long id,
        String nome,
        String contato,
        String nomeExibicao,
        String resumoProfissional,
        Profissao profissao,
        String profissaoDescricao,
        Disponibilidade disponibilidade,
        String disponibilidadeDescricao) {

    public static ProfissionalResponseDTO from(Profissional profissional) {
        return new ProfissionalResponseDTO(profissional.getId(),
                profissional.getNome(),
                profissional.getContato(),
                profissional.getNomeExibicao(),
                profissional.getResumoProfissional(),
                profissional.getProfissao(),
                profissional.getProfissao().getDescricao(),
                profissional.getDisponibilidade(),
                profissional.getDisponibilidade().getDescricao());
    }
}
