package com.smo.person.domain.gateways;

import com.smo.person.infrastructure.persistencia.entity.PersonEntity;

import java.util.ArrayList;

public interface PersonRepositoryInt {
    PersonEntity savePerson(PersonEntity personEntity);

    ArrayList<PersonEntity> findAll();

    void deletePerson(String personNumDoc);
}
