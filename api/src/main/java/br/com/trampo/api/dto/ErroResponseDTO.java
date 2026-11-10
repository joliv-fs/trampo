package br.com.trampo.api.dto;

import java.util.Map;

public record ErroResponseDTO(int status, String mensagem, Map<String, String> campos) {

}
