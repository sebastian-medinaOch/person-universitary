package com.smo.person.domain.usecase;

import com.smo.person.domain.gateways.PersonRepositoryInt;
import com.smo.person.infrastructure.persistencia.entity.PersonEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PersonUseCase {

    private static final Logger logger = LoggerFactory.getLogger(PersonUseCase.class);
    private static final Map<String, Integer> MAP_OF_PERSONS_YEARS = Map.of("Sebastian Medina Ochoa",
            24, "Isabella Bastidas", 18, "Andres Gomez", 23, "Sofia Peralta", 17,
            "Camilo Sofu", 13, "Fernando Perez", 8);
    private final PersonRepositoryInt personRepositoryInt;

    public PersonEntity createPerson(PersonEntity personEntity) {
        return personRepositoryInt.savePerson(personEntity);
    }

    public ArrayList<PersonEntity> getPersons() {
        return personRepositoryInt.findAll();
    }

    public void deletePerson(String personNumDoc) {
        personRepositoryInt.deletePerson(personNumDoc);
    }

    public Map<String, Integer> getTypePerson(String typePerson) {
        return processMapPersons(typePerson);
    }

    public Map<String, Integer> processMapPersons(String typePerson) {

        if (typePerson.equals("par")) {
            return MAP_OF_PERSONS_YEARS.entrySet().stream()
                    .filter(entry -> (entry.getValue() % 2 == 0))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        } else {
            return MAP_OF_PERSONS_YEARS.entrySet().stream()
                    .filter(entry -> (entry.getValue() % 2 != 0))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }

    }
}
