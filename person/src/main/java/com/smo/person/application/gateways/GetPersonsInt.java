package com.smo.person.application.gateways;

import com.smo.person.domain.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface GetPersonsInt {
    ArrayList<Person> getPersons();
}
