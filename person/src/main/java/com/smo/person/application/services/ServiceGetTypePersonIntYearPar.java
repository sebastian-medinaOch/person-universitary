package com.smo.person.application.services;

import com.smo.person.application.gateways.GetTypePersonInt;
import com.smo.person.domain.usecase.PersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ServiceGetTypePersonIntYearPar implements GetTypePersonInt {

    private final PersonUseCase personUseCase;


    @Override
    public Map<String, Integer> processPersonYearPar(String typePerson) {
        return personUseCase.getTypePerson(typePerson);
    }
}
