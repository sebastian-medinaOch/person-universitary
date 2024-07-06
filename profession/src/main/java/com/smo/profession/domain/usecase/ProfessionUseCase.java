package com.smo.profession.domain.usecase;

import com.smo.profession.domain.gateways.ProfessionRepositoryInt;
import com.smo.profession.infrastructure.persistencia.entity.ProfessionEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProfessionUseCase {

    private final ProfessionRepositoryInt professionRepositoryInt;

    public void createProfession(ProfessionEntity professionEntity){
        professionRepositoryInt.createProfession(professionEntity);
    }

}
