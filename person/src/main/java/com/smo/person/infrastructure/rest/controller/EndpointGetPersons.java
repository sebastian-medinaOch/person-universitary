package com.smo.person.infrastructure.rest.controller;

import com.smo.person.application.gateways.GetPersonsInt;
import com.smo.person.application.request.PersonRequest;
import com.smo.person.domain.answer.AnswerData;
import com.smo.person.domain.answer.DataResponse;
import com.smo.person.domain.model.Person;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointGetPersons {

    private final GetPersonsInt getPersonsInt;

    @GetMapping(value = "/getPersons")
    public ResponseEntity<AnswerData> getPersons(){
        ArrayList<Person> persons = getPersonsInt.getPersons();

        DataResponse dataResponse = DataResponse.builder()
                .message("Sastifactorio")
                .data(Optional.of(persons))
                .build();
        AnswerData answerData = new AnswerData(HttpStatus.OK,dataResponse);
        return new ResponseEntity<>(answerData, answerData.getStatus());
    }

}
