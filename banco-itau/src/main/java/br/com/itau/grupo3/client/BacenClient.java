package br.com.itau.grupo3.client;

import br.com.itau.grupo3.client.dto.ChavePixBacen;
import br.com.itau.grupo3.client.dto.request.TransferenciaBacenRequest;
import br.com.itau.grupo3.client.dto.response.TransferenciaBacenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("bacen")
public interface BacenClient {

    @GetMapping("/chave-pix/{chavePix}")
    ChavePixBacen detalharChavePix(@RequestParam String chavePix);

    @PostMapping("/chave-pix")
    ResponseEntity<ChavePixBacen> cadastrarChavePix(@RequestBody ChavePixBacen chavePixBacenDTO);

    @PostMapping("/transferencia")
    ResponseEntity<TransferenciaBacenResponse> transferenciaPix(@RequestBody TransferenciaBacenRequest transferenciaPixRequest);

}
