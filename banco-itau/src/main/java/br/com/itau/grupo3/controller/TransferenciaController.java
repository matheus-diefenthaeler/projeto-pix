package br.com.itau.grupo3.controller;

import br.com.itau.grupo3.client.dto.response.TransferenciaBacenResponse;
import br.com.itau.grupo3.dto.request.TransferenciaRequest;
import br.com.itau.grupo3.service.TransferenciaService;
import jakarta.validation.Valid;
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
    public ResponseEntity<TransferenciaBacenResponse> transferir(@RequestBody @Valid TransferenciaRequest transferenciaRequest) {
        TransferenciaBacenResponse transferenciaBacenResponse = transferenciaService.transferir(transferenciaRequest);
        return ResponseEntity.ok().body(transferenciaBacenResponse);
    }
}
