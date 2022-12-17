package br.com.ada.grupo3.controller;

import br.com.ada.grupo3.client.dto.response.TransferenciaBacenResponse;
import br.com.ada.grupo3.dto.request.TransferenciaRequest;
import br.com.ada.grupo3.service.TransferenciaService;
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
    public ResponseEntity<TransferenciaBacenResponse> transferir(@RequestBody TransferenciaRequest transferenciaRequest) {
        TransferenciaBacenResponse transferenciaBacenResponse = transferenciaService.transferir(transferenciaRequest);
        return ResponseEntity.ok().body(transferenciaBacenResponse);
    }
}
