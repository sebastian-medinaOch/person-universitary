package com.smo.profession.application.util;

import com.smo.profession.application.request.ProfessionRequest;
import com.smo.profession.infrastructure.persistencia.entity.ProfessionEntity;

public class ProfessionRepositoryBuild {

    public ProfessionEntity buildProfessionEntity(ProfessionRequest professionRequest){
        ProfessionEntity professionEntity = new ProfessionEntity();
        professionEntity.setNameProfession(professionRequest.getNameProfession());
        professionEntity.setNumberDNI(professionRequest.getNumberDNI());
        return professionEntity;
    }

}
