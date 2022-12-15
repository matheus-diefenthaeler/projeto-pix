package br.com.itau.grupo3.repository;

import br.com.itau.grupo3.model.ChavePix;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ChavePixRepository extends BaseRepository<ChavePix> {

    public ChavePixRepository(DynamoDBMapper mapper) {
        super(mapper);
    }
    @Override
    protected Class<ChavePix> getClassType() {
        return ChavePix.class;
    }
}
