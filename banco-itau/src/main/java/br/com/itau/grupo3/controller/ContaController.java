package br.com.itau.grupo3.controller;


import br.com.itau.grupo3.client.dto.request.ContaBacenRequest;
import br.com.itau.grupo3.client.dto.request.ContaParaCreditarBacenRequest;
import br.com.itau.grupo3.dto.request.AgenciaEContaRequest;
import br.com.itau.grupo3.dto.request.ContaRequest;
import br.com.itau.grupo3.dto.response.ContaResponse;
import br.com.itau.grupo3.model.ContaValida;
import br.com.itau.grupo3.service.ChavePixService;
import br.com.itau.grupo3.service.ContaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaController {

    private final ContaService contaService;
    private final ChavePixService chavePixService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ContaResponse> cadastrar(@Valid @RequestBody ContaRequest contaRequest, UriComponentsBuilder uriComponenteBuilder) {
        ContaResponse contaResponse = contaService.adicionar(contaRequest);
        URI uri = uriComponenteBuilder.path("/conta/{id}").buildAndExpand(contaResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(contaResponse);
    }

    @GetMapping
    public ResponseEntity<List<ContaResponse>> listagem() {
        return ResponseEntity.ok(contaService.listar());
    }

    @GetMapping("/agencia-conta")
    public ResponseEntity<ContaResponse> buscarAgenciaEConta(@RequestBody AgenciaEContaRequest agenciaEContaRequest) {
        ContaResponse contaResponse = contaService.buscarPorAgenciaEConta(agenciaEContaRequest);
        return ResponseEntity.ok(contaResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        contaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/validar")
    public ResponseEntity<Boolean> validar(@RequestBody ContaBacenRequest contaBacenRequest) {
        ContaValida contaValida = contaService.validarConta(contaBacenRequest);
        Boolean isChavePixValida = chavePixService.validarChavePix(contaValida.getConta(), contaBacenRequest.getChavePix());
        return ResponseEntity.ok(isChavePixValida && contaValida.getIsValida());
    }

    @PostMapping("/creditar")
    public ResponseEntity<Void> creditar(@RequestBody ContaParaCreditarBacenRequest contaParaCreditarBacenRequest) {
        contaService.creditar(contaParaCreditarBacenRequest);
        return ResponseEntity.noContent().build();
    }
}
