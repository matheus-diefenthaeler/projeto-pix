package br.com.bacen.grupo3.repository;

import br.com.bacen.grupo3.model.ChavePix;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

@Repository
public class ChavePixRepository extends BaseRepository<ChavePix> {

    private final AmazonDynamoDB client;
    public ChavePixRepository(DynamoDBMapper mapper, AmazonDynamoDB client) {
        super(mapper);
        this.client = client;
    }
    @Override
    protected Class<ChavePix> getClassType() {
        return ChavePix.class;
    }


    public Boolean findByIndex(String conta, String tipoChavePix) {
        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "chave_pix";

        Table table = dynamoDB.getTable(tableName);
        Index index = table.getIndex("ContaTipoIndex");

        QuerySpec spec = new QuerySpec()
                .withKeyConditionExpression("conta = :v_conta and tipo = :v_tipo")
                .withValueMap(new ValueMap()
                        .withString(":v_conta", conta)
                        .withString(":v_tipo", tipoChavePix));

        ItemCollection<QueryOutcome> items = index.query(spec);

        Iterator<Item> itemsIter = items.iterator();
        return itemsIter.hasNext();
    }
}
