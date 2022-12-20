package br.com.bacen.grupo3.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;

@Configuration
@RequiredArgsConstructor
public class DynamoDBTable {
    private final AmazonDynamoDB client;

    public void createTableChavePix() {
        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "chave_pix";

        CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(tableName);

        //ProvisionedThroughput
        ProvisionedThroughput pt = new ProvisionedThroughput().withReadCapacityUnits((long) 1).withWriteCapacityUnits((long) 1);
        createTableRequest.setProvisionedThroughput(pt);

        //AttributeDefinitions
        ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
        attributeDefinitions.add(new AttributeDefinition().withAttributeName("chave").withAttributeType("S"));
        attributeDefinitions.add(new AttributeDefinition().withAttributeName("conta").withAttributeType("S"));
        attributeDefinitions.add(new AttributeDefinition().withAttributeName("tipo").withAttributeType("S"));

        createTableRequest.setAttributeDefinitions(attributeDefinitions);

        //KeySchema
        ArrayList<KeySchemaElement> tableKeySchema = new ArrayList<KeySchemaElement>();
        tableKeySchema.add(new KeySchemaElement().withAttributeName("chave").withKeyType(KeyType.HASH));  //Partition key

        createTableRequest.setKeySchema(tableKeySchema);

//        ArrayList<KeySchemaElement> indexKeySchema = new ArrayList<KeySchemaElement>();
//        indexKeySchema.add(new KeySchemaElement().withAttributeName("conta").withKeyType(KeyType.HASH));  //Partition key
//        indexKeySchema.add(new KeySchemaElement().withAttributeName("tipo").withKeyType(KeyType.RANGE));  //Sort key
//
//        Projection projection = new Projection().withProjectionType(ProjectionType.INCLUDE);
//        ArrayList<String> nonKeyAttributes = new ArrayList<String>();
//        nonKeyAttributes.add("chave");
//        projection.setNonKeyAttributes(nonKeyAttributes);
//
//        LocalSecondaryIndex localSecondaryIndex = new LocalSecondaryIndex()
//                .withIndexName("ContaTipoIndex").withKeySchema(indexKeySchema).withProjection(projection);
//
//        ArrayList<LocalSecondaryIndex> localSecondaryIndexes = new ArrayList<LocalSecondaryIndex>();
//        localSecondaryIndexes.add(localSecondaryIndex);
//        createTableRequest.setLocalSecondaryIndexes(localSecondaryIndexes);


        GlobalSecondaryIndex contaTipoIndex = new GlobalSecondaryIndex().withIndexName("ContaTipoIndex")
                .withProvisionedThroughput(pt)
                .withKeySchema(new KeySchemaElement().withAttributeName("conta").withKeyType(KeyType.HASH), // Partition
                        // key
                        new KeySchemaElement().withAttributeName("tipo").withKeyType(KeyType.RANGE)) // Sort
                // key
                .withProjection(
                        new Projection().withProjectionType("INCLUDE").withNonKeyAttributes("chave"));

        createTableRequest.withProvisionedThroughput(
                        new ProvisionedThroughput().withReadCapacityUnits((long) 1).withWriteCapacityUnits((long) 1))
                .withAttributeDefinitions(attributeDefinitions).withKeySchema(tableKeySchema)
                .withGlobalSecondaryIndexes(contaTipoIndex);


        Table table = dynamoDB.createTable(createTableRequest);
        System.out.println(table.getDescription());
    }

    public void createTableTransferencia() {
        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "transferencia";

        CreateTableRequest createTableRequest = new CreateTableRequest().withTableName(tableName);

        //ProvisionedThroughput
        createTableRequest.setProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits((long) 1).withWriteCapacityUnits((long) 1));

        //AttributeDefinitions
        ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
        attributeDefinitions.add(new AttributeDefinition().withAttributeName("transacaoId").withAttributeType("S"));

        createTableRequest.setAttributeDefinitions(attributeDefinitions);

        //KeySchema
        ArrayList<KeySchemaElement> tableKeySchema = new ArrayList<KeySchemaElement>();
        tableKeySchema.add(new KeySchemaElement().withAttributeName("transacaoId").withKeyType(KeyType.HASH));  //Partition key

        createTableRequest.setKeySchema(tableKeySchema);

        Table table = dynamoDB.createTable(createTableRequest);
        System.out.println(table.getDescription());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setupDB(ApplicationReadyEvent event) {
        AmazonDynamoDB amazonDynamoDB = event.getApplicationContext().getBean(AmazonDynamoDB.class);

        if (!amazonDynamoDB.listTables().getTableNames().contains("chave_pix")) {
            createTableChavePix();
        }

        if (!amazonDynamoDB.listTables().getTableNames().contains("transferencia")) {
            createTableTransferencia();
        }
    }
}
