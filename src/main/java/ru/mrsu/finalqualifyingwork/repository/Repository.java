package ru.mrsu.finalqualifyingwork.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public abstract class Repository<E, ID> {

    @Autowired
    public MongoTemplate mongoTemplate;
    private final Class<E> entityClass;
    private final String collectionName;
    private final String idFieldName = "_id";

    public Class<E> getEntityClass() {
        return entityClass;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public String getIdFieldName() {
        return idFieldName;
    }

    protected Repository(Class<E> entityClass) {
        this.entityClass = entityClass;
        collectionName = entityClass.getSimpleName().toLowerCase();
    }

    public E save(E e) {
        return mongoTemplate.save(e);
    }

    public E findById(ID id) {
        return mongoTemplate.findById(id, entityClass, collectionName);
    }

    public List<E> findAll() {
        return mongoTemplate.findAll(entityClass, collectionName);
    }

    public void deleteById(ID id) {
        mongoTemplate.remove(getIdQuery(id), entityClass, collectionName);
    }

    private Query getIdQuery(ID id) {
        return new Query(getIdCriteria(id));
    }

    private Criteria getIdCriteria(ID id) {
        return where(idFieldName).is(id);
    }

}
