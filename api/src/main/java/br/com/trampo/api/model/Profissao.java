package br.com.trampo.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Profissao {
    AR_CONDICIONADO("Técnico de Ar-Condicionado"),
    AUTOMACAO_RESIDENCIAL("Automação Residencial"),
    CARPINTEIRO("Carpinteiro"),
    DESENTUPIDOR("Desentupidor"),
    DRYWALL("Drywall"),
    ELETRICISTA("Eletricista"),
    ENCANADOR("Encanador"),
    GESSEIRO("Gesseiro"),
    INSTALADOR("Instalador"),
    INSTALADOR_ELETRICO("Instalador Elétrico"),
    INSTALADOR_HIDRAULICO("Instalador Hidráulico"),
    JARDINEIRO("Jardineiro"),
    MANUTENCAO_RESIDENCIAL("Manutenção Residencial"),
    MONTADOR_DE_MOVEIS("Montador de Móveis"),
    PEDREIRO("Pedreiro"),
    PINTOR("Pintor"),
    PISOS_E_REVESTIMENTOS("Pisos e Revestimentos"),
    REFRIGERACAO("Refrigeração"),
    REPAROS_EM_GERAL("Reparos em Geral"),
    SERRALHEIRO("Serralheiro"),
    OUTROS("Outros");

    private final String profissao;

}
