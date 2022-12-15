package br.com.itau.grupo3.client;

import br.com.itau.grupo3.dto.ChavePixBacenDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "chavePix", url = "http://localhost:8080")
public interface ChavePixBacenClient {

    @GetMapping("/chave-pix/{chavePix}")
    ChavePixBacenDTO detalharChavePix(@RequestParam String chavePix);

    @PostMapping("/chave-pix")
    ResponseEntity<ChavePixBacenDTO> cadastrarChavePix(@RequestBody ChavePixBacenDTO chavePixBacenDTO);

}
