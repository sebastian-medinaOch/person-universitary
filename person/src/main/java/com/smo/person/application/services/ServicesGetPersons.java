package com.smo.person.application.services;

import com.smo.person.application.gateways.GetPersonsInt;
import com.smo.person.application.util.PersonRepositoryBuild;
import com.smo.person.domain.model.Person;
import com.smo.person.domain.usecase.PersonUseCase;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class ServicesGetPersons implements GetPersonsInt {

    private final PersonUseCase personUseCase;
    private final PersonRepositoryBuild personRepositoryBuild;
    @Override
    public ArrayList<Person> getPersons() {
        ArrayList<PersonEntity> personEntities = personUseCase.getPersons();
        return personRepositoryBuild.buildAllPersons(personEntities);
    }
}
