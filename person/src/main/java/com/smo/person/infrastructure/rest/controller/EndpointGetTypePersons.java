package com.smo.person.infrastructure.rest.controller;

import com.smo.person.application.gateways.GetTypePersonInt;
import com.smo.person.domain.answer.AnswerData;
import com.smo.person.domain.answer.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointGetTypePersons {

    private final GetTypePersonInt getTypePersonInt;

    @GetMapping(value = "/getTypePerson")
    public ResponseEntity<AnswerData> getTypePerson(@RequestParam(value = "typePerson") String typePerson) {
        DataResponse dataResponse = DataResponse.builder()
                .message("Sastifactorio")
                .data(Optional.of("Personas con la edad par " +
                        getTypePersonInt.processPersonYearPar(typePerson)
                ))
                .build();
        AnswerData answerData = new AnswerData(HttpStatus.OK, dataResponse);
        return new ResponseEntity<>(answerData, answerData.getStatus());
    }

}
