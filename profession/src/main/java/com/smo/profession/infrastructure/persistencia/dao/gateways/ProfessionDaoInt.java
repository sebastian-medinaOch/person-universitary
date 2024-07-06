package com.smo.profession.infrastructure.persistencia.dao.gateways;

import com.smo.profession.infrastructure.persistencia.entity.ProfessionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionDaoInt extends MongoRepository<ProfessionEntity, String> {

}
