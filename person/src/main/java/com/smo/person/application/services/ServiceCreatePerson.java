package com.smo.person.application.services;

import com.smo.person.application.gateways.CreatePersonInt;
import com.smo.person.application.request.PersonRequest;
import com.smo.person.application.util.PersonRepositoryBuild;
import com.smo.person.domain.model.Person;
import com.smo.person.domain.usecase.PersonUseCase;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServiceCreatePerson implements CreatePersonInt {

    private final PersonRepositoryBuild personRepositoryBuild;
    private final PersonUseCase personUseCase;

    @Override
    public Person createPerson(PersonRequest personRequest) {
        PersonEntity personEntity = personRepositoryBuild.buildPersonEntity(personRequest);
        PersonEntity personEntityCreate = personUseCase.createPerson(personEntity);
        return personRepositoryBuild.buildPersonComplete(personEntityCreate, personRequest.getPersonProfession());
    }
}
