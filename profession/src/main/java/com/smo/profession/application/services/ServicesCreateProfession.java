package com.smo.profession.application.services;

import com.smo.profession.application.gateways.CreateProfessionInt;
import com.smo.profession.application.request.ProfessionRequest;
import com.smo.profession.application.util.ProfessionRepositoryBuild;
import com.smo.profession.domain.usecase.ProfessionUseCase;
import com.smo.profession.infrastructure.persistencia.entity.ProfessionEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicesCreateProfession implements CreateProfessionInt {

    private final ProfessionRepositoryBuild professionRepositoryBuild;
    private final ProfessionUseCase professionUseCase;

    public void createProfession(ProfessionRequest professionRequest){
        ProfessionEntity professionEntity = professionRepositoryBuild.buildProfessionEntity(professionRequest);
        professionUseCase.createProfession(professionEntity);
    }

}
