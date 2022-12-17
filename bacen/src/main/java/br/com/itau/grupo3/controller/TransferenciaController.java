package br.com.itau.grupo3.controller;

import br.com.itau.grupo3.dto.request.TransferenciaRequest;
import br.com.itau.grupo3.dto.response.TransferenciaResponse;
import br.com.itau.grupo3.service.TransferenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transferencia")
@RequiredArgsConstructor
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    @PostMapping
    public ResponseEntity<TransferenciaResponse> transferir(@RequestBody TransferenciaRequest transferenciaRequest) {
        TransferenciaResponse transferenciaResponse = transferenciaService.transferir(transferenciaRequest);
        return ResponseEntity.ok().body(transferenciaResponse);
    }

}
