package br.com.itau.grupo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BancoItauApplication {
    public static void main(String[] args) {
        SpringApplication.run(BancoItauApplication.class, args);
    }
}