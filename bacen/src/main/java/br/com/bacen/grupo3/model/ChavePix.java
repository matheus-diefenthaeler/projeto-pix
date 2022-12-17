package br.com.bacen.grupo3.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import lombok.Data;

@Data
@DynamoDBTable(tableName = "chave_pix")
public class ChavePix {

    @DynamoDBHashKey
    private String chave;

    private String conta;

    @DynamoDBTypeConvertedEnum
    private TipoChavePix tipo;

    @DynamoDBTypeConvertedEnum
    private TipoConta tipoConta;

    private String instituicaoFinanceira;
    private String titular;
    private String cpfCnpj;
}
