package com.smo.profession.infrastructure.persistencia.repository;

import com.smo.profession.domain.gateways.ProfessionRepositoryInt;
import com.smo.profession.infrastructure.persistencia.dao.gateways.ProfessionDaoInt;
import com.smo.profession.infrastructure.persistencia.entity.ProfessionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProfessionRepository implements ProfessionRepositoryInt {

    private final ProfessionDaoInt professionDaoInt;

    @Override
    public void createProfession(ProfessionEntity professionEntity) {
        professionDaoInt.save(professionEntity);
    }
}
