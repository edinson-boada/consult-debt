package com.unmsm.sistemas.microservice.consultdebt.repository;

import com.unmsm.sistemas.microservice.consultdebt.model.DebtEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DebtRepository extends MongoRepository<DebtEntity, String> {

}