package com.smo.person.application.util;

import com.smo.person.application.request.PersonRequest;
import com.smo.person.domain.model.Person;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;

import java.util.ArrayList;

public class PersonRepositoryBuild {


    public PersonEntity buildPersonEntity(PersonRequest personRequest) {

        PersonEntity personEntity = new PersonEntity();
        personEntity.setPersonName(personRequest.getPersonName());
        personEntity.setPersonLastName(personRequest.getPersonLastName());
        personEntity.setPersonYear(personRequest.getPersonYear());
        personEntity.setPersonNumDoc(personRequest.getPersonNumDoc());
        return personEntity;

    }

    public Person buildPersonComplete(PersonEntity personEntityCreate, String profession) {
        return Person.builder()
                .personId(personEntityCreate.getPersonId())
                .personName(personEntityCreate.getPersonName())
                .personLastName(personEntityCreate.getPersonLastName())
                .personYear(personEntityCreate.getPersonYear())
                .personNumDoc(personEntityCreate.getPersonNumDoc())
                .personProfession(profession)
                .build();
    }

    public ArrayList<Person> buildAllPersons(ArrayList<PersonEntity> personEntities) {
        ArrayList<Person> personArrayList = new ArrayList<>();
        for (PersonEntity personEntity: personEntities) {
            Person person = buildPerson(personEntity);
            personArrayList.add(person);
        }
        return personArrayList;
    }

    private Person buildPerson(PersonEntity personEntity) {
        return Person.builder()
                .personId(personEntity.getPersonId())
                .personName(personEntity.getPersonName())
                .personLastName(personEntity.getPersonLastName())
                .personYear(personEntity.getPersonYear())
                .personNumDoc(personEntity.getPersonNumDoc())
                .build();
    }
}
