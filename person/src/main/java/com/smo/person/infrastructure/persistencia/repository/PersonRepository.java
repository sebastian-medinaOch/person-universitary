package com.smo.person.infrastructure.persistencia.repository;

import com.smo.person.domain.gateways.PersonRepositoryInt;
import com.smo.person.infrastructure.persistencia.dao.gateways.PersonDaoInt;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class PersonRepository implements PersonRepositoryInt {

    private final PersonDaoInt personDaoInt;
    @Override
    public PersonEntity savePerson(PersonEntity personEntity) {
        return personDaoInt.save(personEntity);
    }

    @Override
    public ArrayList<PersonEntity> findAll() {
        return personDaoInt.findAll();
    }

    @Override
    public void deletePerson(String personNumDoc) {
        personDaoInt.deleteByPersonNumDoc(personNumDoc);
    }
}
