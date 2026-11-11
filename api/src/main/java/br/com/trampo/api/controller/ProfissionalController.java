package br.com.trampo.api.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.trampo.api.dto.PageResponse;
import br.com.trampo.api.dto.ProfissionalRequestDTO;
import br.com.trampo.api.dto.ProfissionalResponseDTO;
import br.com.trampo.api.model.Disponibilidade;
import br.com.trampo.api.model.Profissao;
import br.com.trampo.api.service.ProfissionalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/profissionais")
@RequiredArgsConstructor
public class ProfissionalController {

    private final ProfissionalService service;

    @PostMapping
    public ResponseEntity<ProfissionalResponseDTO> cadastrarProfissional(
            @Valid @RequestBody ProfissionalRequestDTO request) {
        ProfissionalResponseDTO response = service.cadastrarProfissional(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<PageResponse<ProfissionalResponseDTO>> listarProfissionais(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String nomeExibicao,
            @RequestParam(required = false) Profissao profissao,
            @RequestParam(required = false) Disponibilidade disponibilidade,
            @PageableDefault(size = 9, sort = "nomeExibicao", direction = Sort.Direction.DESC) Pageable pageable) {

        PageResponse<ProfissionalResponseDTO> response = service.listarTodosProfissionais(nome, nomeExibicao, profissao,
                disponibilidade, pageable);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponseDTO> atualizarProfissional(@PathVariable Long id,
            @Valid @RequestBody ProfissionalRequestDTO request) {
        return ResponseEntity.ok(service.atualizarProfissional(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfissional(@PathVariable Long id) {
        service.deletarProfissional(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/disponibilidade")
    public ResponseEntity<Void> alterarDisponibilidade(@PathVariable Long id,
            @RequestParam Disponibilidade novaDisponibilidade) {
        service.alterarDisponibilidade(id, novaDisponibilidade);

        return ResponseEntity.noContent().build();
    }

}
