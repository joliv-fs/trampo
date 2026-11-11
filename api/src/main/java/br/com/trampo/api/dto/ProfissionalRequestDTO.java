package br.com.trampo.api.dto;

import br.com.trampo.api.model.Disponibilidade;
import br.com.trampo.api.model.Profissao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ProfissionalRequestDTO(
                @NotBlank(message = "Nome pessoal é um campo obrigatório.") @Size(max = 100, message = "Nome pessoal deve ter no máximo 100 caracteres.") String nome,

                @NotBlank(message = "Número para contato é um campo obrigatório.") @Size(max = 15, message = "Número para contato deve ter no máximo 15 caracteres.") @Pattern(regexp = "^[0-9()\\-\\s+]{10,15}$", message = "Número para contato inválido.") String contato,

                @NotBlank(message = "Nome profissional é um campo obrigatório.") @Size(max = 55, message = "Nome profissional deve ter no máximo 55 caracteres.") String nomeExibicao,

                @NotBlank(message = "Resumo profissional é um campo obrigatório.") @Size(max = 254, message = "O resumo deve ter no máximo 254 caracteres.") String resumoProfissional,

                @NotNull(message = "Profissão é um campo obrigatório") Profissao profissao,
                @NotNull(message = "Disponibilidade é um campo obrigatório") Disponibilidade disponibilidade) {

}
