package br.com.bacen.grupo3.controller;

import br.com.bacen.grupo3.dto.request.ChavePixRequest;
import br.com.bacen.grupo3.dto.response.ChavePixResponse;
import br.com.bacen.grupo3.repository.ChavePixRepository;
import br.com.bacen.grupo3.service.ChavePixService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/chave-pix")
@RequiredArgsConstructor
public class ChavePixController {

    private final ChavePixService chavePixService;
    private final ChavePixRepository repository;

    @PostMapping
    public ResponseEntity<ChavePixResponse> cadastrar(@RequestBody ChavePixRequest chavePixRequest, UriComponentsBuilder uriComponentsBuilder) {
        ChavePixResponse chavePixResponse = chavePixService.salvar(chavePixRequest);
        URI uri = uriComponentsBuilder.path("/chave-píx/detalhes/{chavePix}").buildAndExpand(chavePixResponse.getChave()).toUri();
        return ResponseEntity.created(uri).body(chavePixResponse);
    }

    @GetMapping("{chavePix}")
    public ResponseEntity<ChavePixResponse> detalhar(@PathVariable String chavePix){
        return ResponseEntity.ok(chavePixService.buscarPorChave(chavePix));
    }

    @GetMapping("/t")
    public ResponseEntity<Boolean> t() {
        Boolean result =  repository.findByIndex("1234#54321-6", "TELEFONE");
        return ResponseEntity.ok(result);
    }
}
