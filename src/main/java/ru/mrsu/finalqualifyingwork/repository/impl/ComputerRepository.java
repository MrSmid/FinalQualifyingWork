package ru.mrsu.finalqualifyingwork.repository.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import ru.mrsu.finalqualifyingwork.entity.computers.Computer;
import ru.mrsu.finalqualifyingwork.enums.ComputerTypes;
import ru.mrsu.finalqualifyingwork.repository.Repository;

import java.util.List;

@Component
public class ComputerRepository extends Repository<Computer, String> {

    ComputerRepository() {
        super(Computer.class);
    }

    public List<Computer> findComputerByType(ComputerTypes computerType) {
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(computerType));
        return mongoTemplate.find(query, getEntityClass(), getCollectionName());
    }

    public List<Computer> findComputerByRamBetween(Double gte, Double lte) {
        Query query = new Query();
        query.addCriteria(Criteria.where("specifications.RAM").gte(gte).lte(lte));
        return mongoTemplate.find(query, getEntityClass(), getCollectionName());
    }
}
