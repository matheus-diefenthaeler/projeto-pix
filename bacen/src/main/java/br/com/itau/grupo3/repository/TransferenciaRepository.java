package br.com.itau.grupo3.repository;

import br.com.itau.grupo3.model.Transferencia;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TransferenciaRepository extends BaseRepository<Transferencia>{

    public TransferenciaRepository(DynamoDBMapper mapper) {
        super(mapper);
    }

    @Override
    protected Class<Transferencia> getClassType() {
        return Transferencia.class;
    }
}
