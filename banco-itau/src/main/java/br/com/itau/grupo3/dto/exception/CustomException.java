package br.com.itau.grupo3.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomException {
    private List<String> errors;
    private Integer statusCode;
}
