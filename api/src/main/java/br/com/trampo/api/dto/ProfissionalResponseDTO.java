package br.com.trampo.api.dto;

import br.com.trampo.api.model.Profissional;

// import br.com.trampo.api.model.Disponibilidade;
// import br.com.trampo.api.model.Profissao;

public record ProfissionalResponseDTO(Long id,
        String nome,
        String contato,
        String nomeExibicao,
        String descricao,
        String profissao,
        String disponibilidade) {

    public static ProfissionalResponseDTO from(Profissional profissional) {
        return new ProfissionalResponseDTO(profissional.getId(),
                profissional.getNome(),
                profissional.getContato(),
                profissional.getNomeExibicao(),
                profissional.getDescricao(),
                profissional.getProfissao().getDescricao(),
                profissional.getDisponibilidade().getDescricao());
    }
}
