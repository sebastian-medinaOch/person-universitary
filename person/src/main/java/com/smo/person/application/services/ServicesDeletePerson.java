package com.smo.person.application.services;

import com.smo.person.application.gateways.DeletePersonInt;
import com.smo.person.domain.usecase.PersonUseCase;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicesDeletePerson implements DeletePersonInt {

    private final PersonUseCase personUseCase;
    @Override
    public void deletePerson(String personNumDoc) {
        personUseCase.deletePerson(personNumDoc);
    }
}
