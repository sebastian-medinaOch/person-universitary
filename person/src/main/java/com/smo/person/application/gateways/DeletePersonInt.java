package com.smo.person.application.gateways;

import org.springframework.stereotype.Service;

@Service
public interface DeletePersonInt {
    void deletePerson(String personNumDoc);
}
