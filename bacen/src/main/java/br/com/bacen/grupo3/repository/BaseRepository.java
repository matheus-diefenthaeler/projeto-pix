package br.com.bacen.grupo3.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseRepository<T> {

    protected final DynamoDBMapper mapper;

    protected abstract Class<T> getClassType();

    public T save(T entity) {
        mapper.save(entity);
        return entity;
    }

    public Iterable<T> findAll() {
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        return mapper.scan(getClassType(), scanExpression);
    }

    public Optional<T> findById(String partitionKey, String rangeKey) {
        return Optional.ofNullable(mapper.load(getClassType(), partitionKey, rangeKey));
    }

    public Optional<T> findById(String partitionKey) {
        return Optional.ofNullable(mapper.load(getClassType(), partitionKey));
    }

    public void delete(T entity) {
        mapper.delete(entity);
    }
}