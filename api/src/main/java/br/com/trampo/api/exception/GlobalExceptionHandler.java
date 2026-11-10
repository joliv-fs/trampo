package br.com.trampo.api.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.trampo.api.dto.ErroResponseDTO;

public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResponseDTO> tratarNaoEncontrado(RecursoNaoEncontradoException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ErroResponseDTO erro = new ErroResponseDTO(status.value(), ex.getMessage(), Map.of());

        return ResponseEntity.status(status).body(erro);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponseDTO> tratarValidacao(MethodArgumentNotValidException ex) {
        Map<String, String> campos = new LinkedHashMap<>();

        for (FieldError erroCampo : ex.getBindingResult().getFieldErrors()) {
            campos.put(erroCampo.getField(), erroCampo.getDefaultMessage());
        }

        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroResponseDTO erro = new ErroResponseDTO(status.value(), "Dados inválidos", campos);

        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponseDTO> tratarJsonInvalido(HttpMessageNotReadableException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErroResponseDTO erro = new ErroResponseDTO(status.value(), "JSON inválido ou mal formatado", Map.of());
        return ResponseEntity.status(status).body(erro);
    }

}
