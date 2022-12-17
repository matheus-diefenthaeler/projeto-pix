package br.com.bacen.grupo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BacenApplication {
    public static void main(String[] args) {
        SpringApplication.run(BacenApplication.class, args);
    }
}
