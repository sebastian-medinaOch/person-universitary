package com.smo.person.application.services;

import com.smo.person.application.gateways.CreatePersonInt;
import com.smo.person.application.request.PersonRequest;
import com.smo.person.application.util.PersonRepositoryBuild;
import com.smo.person.domain.model.Person;
import com.smo.person.domain.usecase.PersonUseCase;
import com.smo.person.domain.usecase.ProfessionUseCase;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;

import javax.net.ssl.SSLException;

@RequiredArgsConstructor
public class ServiceCreatePerson implements CreatePersonInt {

    private final PersonRepositoryBuild personRepositoryBuild;
    private final PersonUseCase personUseCase;
    private final ProfessionUseCase professionUseCase;

    @Override
    public Person createPerson(PersonRequest personRequest) throws SSLException {
        PersonEntity personEntity = personRepositoryBuild.buildPersonEntity(personRequest);
        PersonEntity personEntityCreate = personUseCase.createPerson(personEntity);
        professionUseCase.createProfession(personRequest);
        return personRepositoryBuild.buildPersonComplete(personEntityCreate, personRequest.getPersonProfession());
    }
}
