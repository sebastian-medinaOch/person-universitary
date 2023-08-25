package com.smo.person.infrastructure.rest.controller;

import com.smo.person.application.gateways.DeletePersonInt;
import com.smo.person.domain.answer.AnswerData;
import com.smo.person.domain.answer.DataResponse;
import com.smo.person.domain.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
public class EndpointDeletePersonByNumDoc {

    private final DeletePersonInt deletePersonInt;

    @DeleteMapping(value = "/deletePerson")
    public ResponseEntity<AnswerData> deletePerson(@RequestParam("personNumDoc") String personNumDoc){
        deletePersonInt.deletePerson(personNumDoc);
        DataResponse dataResponse = DataResponse.builder()
                .message("Sastifactorio")
                .data(Optional.of("Se eliminó correctamente el usuario con el numero de documento de identidad:"
                + personNumDoc))
                .build();
        AnswerData answerData = new AnswerData(HttpStatus.OK,dataResponse);
        return new ResponseEntity<>(answerData, answerData.getStatus());
    }

}
