package br.com.itau.grupo3.client;

import br.com.itau.grupo3.client.dto.request.ContaParaCreditarRequest;
import br.com.itau.grupo3.client.dto.request.ContaRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "banco-itau", url = "http://localhost:8081")
public interface ItauClient {

    @PostMapping("/conta/validar")
    ResponseEntity<Boolean> validarConta(@RequestBody ContaRequest conta);

    @PostMapping("/conta/creditar")
    ResponseEntity<Void> creditarNaConta(@RequestBody ContaParaCreditarRequest contaParaCreditarRequest);
}
