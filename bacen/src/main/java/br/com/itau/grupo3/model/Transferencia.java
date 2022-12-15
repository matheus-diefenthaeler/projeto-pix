package br.com.itau.grupo3.model;

import br.com.itau.grupo3.util.converter.LocalDateTimeToStringConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@DynamoDBTable(tableName = "transferencia")
public class Transferencia {
    @DynamoDBHashKey
    private String transacaoId;

    @DynamoDBTypeConverted(converter = LocalDateTimeToStringConverter.class)
    private LocalDateTime dataHora;

    private BigDecimal valor;
    private String tipoTransferencia;
    private String chavePix;

    private String nomeOrigem;
    private String instituicaoFinanceiraOrigem;
    private String agenciaOrigem;
    private String contaOrigem;

    private String nomeDestino;
    private String cpfCnpjDestino;
    private String instituicaoFinanceiraDestino;
    private String agenciaDestino;
    private String contaDestino;
    private String tipoContaDestino;
}
