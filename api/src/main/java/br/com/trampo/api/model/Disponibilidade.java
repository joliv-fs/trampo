package br.com.trampo.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Disponibilidade {
    IMEDIATA("Atendimento rápido"),
    AGENDAMENTO("Atendimento por agendamento"),
    INDISPONIVEL("Atendimento indisponível no momento");

    private final String descricao;

}
