package com.smo.person.application.gateways;

import com.smo.person.application.request.PersonRequest;
import com.smo.person.domain.model.Person;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLException;

@Service
public interface CreatePersonInt {

    Person createPerson(PersonRequest personRequest) throws SSLException;

}
