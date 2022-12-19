package br.com.ada.grupo3.controller;


import br.com.ada.grupo3.client.dto.ChavePixBacen;
import br.com.ada.grupo3.dto.request.ChavePixRequest;
import br.com.ada.grupo3.dto.response.ChavePixResponse;
import br.com.ada.grupo3.service.ChavePixService;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<ChavePixResponse> salvar(@RequestBody @Valid ChavePixRequest chavePixRequest, UriComponentsBuilder uriComponentsBuilder) {
        ChavePixResponse chavePixResponse = chavePixService.salvar(chavePixRequest);
        URI uri = uriComponentsBuilder.path("/chave-píx/{chavePix}").buildAndExpand(chavePixResponse.getChave()).toUri();
        return ResponseEntity.created(uri).body(chavePixResponse);
    }

    @GetMapping("/{chavePix}")
    public ResponseEntity<ChavePixBacen> detalharChavePix(@PathVariable String chavePix){
        return ResponseEntity.ok(chavePixService.detalharChavePix(chavePix));
    }
}
