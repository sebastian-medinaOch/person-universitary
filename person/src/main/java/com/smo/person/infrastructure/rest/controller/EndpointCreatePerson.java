package com.smo.person.infrastructure.rest.controller;

import com.smo.person.application.gateways.CreatePersonInt;
import com.smo.person.application.gateways.GetTypePersonInt;
import com.smo.person.application.request.PersonRequest;
import com.smo.person.domain.answer.AnswerData;
import com.smo.person.domain.answer.DataResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLException;
import java.util.Optional;


@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class EndpointCreatePerson {

    private final CreatePersonInt createPersonInt;

    @PostMapping(value = "/createPerson")
    public ResponseEntity<AnswerData> createPerson(@Valid @RequestBody PersonRequest personRequest) throws SSLException {
        createPersonInt.createPerson(personRequest);
        DataResponse dataResponse = DataResponse.builder()
                .message("Sastifactorio")
                .data(Optional.of("Usuario creado sastifactoriamente"))
                .build();
        AnswerData answerData = new AnswerData(HttpStatus.OK, dataResponse);
        return new ResponseEntity<>(answerData, answerData.getStatus());
    }


}
