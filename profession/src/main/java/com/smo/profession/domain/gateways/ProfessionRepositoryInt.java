package com.smo.profession.domain.gateways;

import com.smo.profession.infrastructure.persistencia.entity.ProfessionEntity;

public interface ProfessionRepositoryInt {

    void createProfession(ProfessionEntity professionEntity);

}
